package patternpractise.behaviour.command;

public class Client {

    public static void main(String[] vargs) throws Exception {
        Fridge fridge = new Fridge();

        MakeChineseFood cf = new MakeChineseFood();
        MakeItalianFood itf = new MakeItalianFood();

        for(String ing: cf.getIngredientsList()) {
            fridge.map.put(ing, 1);
        }

        for(String ing: itf.getIngredientsList()) {
            fridge.map.put(ing, 1);
        }

        Chef chef = new Chef(fridge);

        chef.submit(cf);
        chef.submit(itf);

        System.out.println(fridge.map);
    }
}
