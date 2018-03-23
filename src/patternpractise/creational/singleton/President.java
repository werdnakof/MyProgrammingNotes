package patternpractise.creational.singleton;

public class President {

    //create an object of SingleObject
    private static President instance = new President();

    //make the constructor private so that this class cannot be
    //instantiated
    private President(){}

    //Get the only object available
    public static President getInstance(){
        return instance;
    }
}