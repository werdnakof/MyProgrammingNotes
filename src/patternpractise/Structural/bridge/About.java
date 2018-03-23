package patternpractise.Structural.bridge;

public class About extends WebPage {

    public About(Theme theme) {
        super(theme);
    }

    @Override
    public String getContent() {
        return "About Page";
    }
}
