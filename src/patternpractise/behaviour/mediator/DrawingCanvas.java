package patternpractise.behaviour.mediator;

public class DrawingCanvas implements Canvas {
    @Override
    public void print(Graphics graphics) {
        System.out.println("Drawing...");
        System.out.println(graphics.generate());
    }
}
