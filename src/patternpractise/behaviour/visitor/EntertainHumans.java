package patternpractise.behaviour.visitor;

public class EntertainHumans implements AnimalOperation {
    @Override
    public void visit(Monkey monkey) {
        System.out.println(monkey.beingABrat());
    }

    @Override
    public void visit(Lion lion) {
        System.out.println(lion.sing());
    }

    @Override
    public void visit(Dolphin dolphin) {
        System.out.println(dolphin.leap());
    }

    public static void main(String[] args) {
        Lion lion =new Lion();
        Dolphin dolphin = new Dolphin();
        Monkey monkey = new Monkey();
        EntertainHumans en = new EntertainHumans();

        en.visit(lion);
        en.visit(dolphin);

        monkey.accept(en);
    }
}
