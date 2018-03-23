package patternpractise.behaviour.mediator;

import patternpractise.behaviour.iterator.BBC;
import patternpractise.behaviour.iterator.FavouriteChannels;
import patternpractise.behaviour.iterator.Four;
import patternpractise.behaviour.iterator.RadioChannel;

public class Client {

    public static void main(String[] vars) throws Exception {
        DrawingCanvas dc = new DrawingCanvas();

        Circle c = new Circle();
        c.printToCanvas(dc);

        Triangle t = new Triangle();
        t.printToCanvas(dc);
    }
}
