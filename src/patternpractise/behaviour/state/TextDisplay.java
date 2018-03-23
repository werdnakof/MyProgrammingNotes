package patternpractise.behaviour.state;

public class TextDisplay {
    private WritingState state = new DefaultText();

    public void setState(WritingState state) {
        this.state = state;
    }

    public void display(String words) {
        this.state.write(words);
    }

    public static void main(String[] args) {
        TextDisplay typer = new TextDisplay();
        typer.display("Hello Worlds");

        typer.setState(new UpperCase());
        typer.display("Hello Worlds");

        typer.setState(new LowerCase());
        typer.display("Hello Worlds");
    }
}
