package patternpractise.structural.bridge;

public class About extends WebPage {

    public About(Theme theme) {
        super(theme);
    }

    @Override
    public String getContent() {
        return "About Page";
    }
}
