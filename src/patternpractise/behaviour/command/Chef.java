package patternpractise.behaviour.command;

public class Chef {

    private Fridge fridge;

    public Chef(Fridge fridge) {
        this.fridge = fridge;
    }

    public void submit(Command command) {
        System.out.println("Cooking: " + command.getClass().getName());
        if(command.cook(this.fridge)) {
            System.out.println(command.getClass().getName() + " cooked!");
        } else {
            System.out.println("Missing " + command.getClass().getName() + " ingredients");
        }
    }
}
