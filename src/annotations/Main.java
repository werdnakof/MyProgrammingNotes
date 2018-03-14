package annotations;

import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/**
 * To retrieve and sort (by priority)
 * all classes with annotation 'RunAtStartUp'
 * within package of this class i.e. Main.class
 */
public class Main {

    private static class RunAtStartupData {
        Object object;
        Method method;
        int priority;

        public RunAtStartupData(
                Object object, Method method, int priority) {
            this.object = object;
            this.method = method;
            this.priority = priority;
        }

        public void callMethod() throws Exception {
            method.invoke(object);
        }
    }

    public static void main(String[] args) throws Exception {
        List<Class<?>> packageClasses =
                getAllClassesInPackageContaining(Main.class);

        List<RunAtStartupData> registrations = new ArrayList<>();

        for (Class<?> cls : packageClasses) {

            // get to retrieve for every class because annotation field could be different.
            RunAtStartup runAtStartup = Objects.requireNonNull(cls.getAnnotation(RunAtStartup.class));

            Object instance = cls.newInstance();

            Method method = cls.getMethod(runAtStartup.method());

            registrations.add(new RunAtStartupData(
                    instance, method, runAtStartup.priority()));
        }

        registrations.sort(Comparator.<RunAtStartupData>comparingInt(x -> x.priority).reversed());

        for (RunAtStartupData registration : registrations) {
            registration.callMethod();
        }
    }

    static List<Class<?>> getAllClassesInPackageContaining(Class<?> cls)
            throws IOException
    {
        String PackageName = cls
                .getPackage()
                .getName();

        String path = cls
                .getResource(".")
                .getPath();

        Path packagePath = Paths.get(path);

        return getPackageClasses(PackageName, packagePath);
    }

    static List<Class<?>> getPackageClasses(String clazzPackageName,
                                            Path packagePath)
            throws IOException {

        final List<Class<?>> packageClasses = new ArrayList<>();

        Files.walkFileTree(packagePath, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file,
                                             BasicFileAttributes attrs)
                    throws IOException {

                String filename = file.getName(file.getNameCount()-1).toString();

                if (filename.endsWith(".class")) {

                    String className = clazzPackageName + "." +
                            filename.replace(".class", "");

                    try {

                        Class<?> loadedClass = Class.forName(className);

                        packageClasses.add(loadedClass);

                    } catch(ClassNotFoundException e) {
                        System.err.println("class not found: " + e.getMessage());
                    }
                }

                return super.visitFile(file, attrs);
            }
        });

        return packageClasses;
    }
}
