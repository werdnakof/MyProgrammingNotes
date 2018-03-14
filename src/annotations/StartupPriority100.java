package annotations;

@RunAtStartup(priority = 100, method = "initialize")
public class StartupPriority100 {
    public void run() {
        throw new IllegalStateException("This method should not be called");
    }

    public void initialize() {
        System.out.println("class StartupPriority100 initialized!");
    }
}
