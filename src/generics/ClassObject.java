package generics;

public class ClassObject {
    public static <T> T getInstance(Class<T> theClass) throws
            IllegalAccessException, InstantiationException {
        return theClass.newInstance();
    }

    public static void main(String[] vars) throws
            InstantiationException, IllegalAccessException {
        String s = ClassObject.getInstance(String.class);
        s += "2";
    }
}
