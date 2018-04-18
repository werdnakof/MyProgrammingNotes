package patternpractise.structural.bridge;

public abstract class WebPage {

    abstract String getContent();

    private Theme theme;

    public WebPage(Theme theme) {
        this.theme = theme;
    }
}
