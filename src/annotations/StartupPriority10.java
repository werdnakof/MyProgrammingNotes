package annotations;

@RunAtStartup(priority = 10)
public class StartupPriority10 {
    public void run() {
        System.out.println("Class StartupPriority10 initialized!");
    }
}
