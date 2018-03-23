package patternpractise.behaviour.mediator;

public class Triangle implements Graphics{
    @Override
    public String generate() {
        return "               XX\n" +
                "              XXXX\n" +
                "             XX  XX\n" +
                "           XX     XX\n" +
                "          XX       XX\n" +
                "         X          XX\n" +
                "        XX            XXX\n" +
                "       X                XXXXX\n" +
                "      X                     XX\n" +
                "     X                        X\n" +
                "    X                          X\n" +
                "   XX                          X\n" +
                "  XX                            XX\n" +
                " XX                               X\n" +
                "XXXXXXXXXXX XX XXX                XX\n" +
                "           X     XXXXXXXXXXXXXXXXXXXX";
    }

    @Override
    public void printToCanvas(Canvas canvas) {
        canvas.print(this);
    }
}
