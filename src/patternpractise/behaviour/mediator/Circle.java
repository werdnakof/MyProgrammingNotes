package patternpractise.behaviour.mediator;

public class Circle implements Graphics {
    @Override
    public String generate() {
        return "              XXX\n" +
                "        XXXXXX   XXXXXXXX\n" +
                "     XXX                XXXX\n" +
                "   XX                      XX\n" +
                "  XX                         XX\n" +
                " XX                           XX\n" +
                " X                             XX\n" +
                "XX                              X\n" +
                "X                               XX\n" +
                "X                                X\n" +
                "XX                              XX\n" +
                " XX                            XX\n" +
                "  XX                         XX\n" +
                "   XXX                     XX\n" +
                "      XXX                 XX\n" +
                "        XXX             XX\n" +
                "           XXX        XX\n" +
                "              XXXXXXXX\n";
    }

    @Override
    public void printToCanvas(Canvas canvas) {
        canvas.print(this);
    }
}
