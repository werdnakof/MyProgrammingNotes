package patternpractise.structural.bridge;

public class Client {
    public static void main(String[] vargs) {
        DarkTheme dt = new DarkTheme();

        WebPage about = new About(dt);
        WebPage career = new Careers(dt);
    }
}
