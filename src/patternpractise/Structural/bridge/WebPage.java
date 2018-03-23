package patternpractise.Structural.bridge;

public abstract class WebPage {

    abstract String getContent();

    private Theme theme;

    public WebPage(Theme theme) {
        this.theme = theme;
    }
}
