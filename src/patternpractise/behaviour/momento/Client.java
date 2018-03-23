package patternpractise.behaviour.momento;

import patternpractise.behaviour.mediator.Circle;
import patternpractise.behaviour.mediator.DrawingCanvas;
import patternpractise.behaviour.mediator.Triangle;

public class Client {

    public static void main(String[] vars) {
        SmileyNotePad snp = new SmileyNotePad();
        snp.write("\"Hahahahaha\"\n");
        snp.write("said The Joker\n");

        System.out.println("Before Save:");
        System.out.println(snp.view());

        NotePad save = snp.save();

        System.out.println("Modify:");
        snp.write("Batman didn't like him\n");
        System.out.println(snp.view());

        System.out.println("Restore:");
        snp.restore(save);
        System.out.println(snp.view());
    }
}
