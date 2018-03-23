package patternpractise.behaviour.command;

import java.util.Arrays;
import java.util.List;

public class MakeChineseFood implements Command {

    @Override
    public List<String> getIngredientsList() {
        return Arrays.asList("Rice", "Chicken", "Soy Sauce");
    }

    @Override
    public boolean cook(Fridge fridge) {
        for(String ing: getIngredientsList()) {
            if(!fridge.map.containsKey(ing)) return false;
            int quantity = fridge.map.getOrDefault(ing, 0);
            if(quantity == 0) return false;
            fridge.map.put(ing, quantity-1);
        }
        return true;
    }
}
