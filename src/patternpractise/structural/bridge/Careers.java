package patternpractise.structural.bridge;

public class Careers extends WebPage {
    public Careers(Theme theme) {
        super(theme);
    }

    @Override
    String getContent() {
        return "Career Page";
    }
}
