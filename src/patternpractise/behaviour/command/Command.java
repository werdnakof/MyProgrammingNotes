package patternpractise.behaviour.command;
import java.util.List;

public interface Command {
    List<String> getIngredientsList();
    boolean cook(Fridge fridge);
}
