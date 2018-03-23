package patternpractise.behaviour.observer;

import java.util.Observable;
import java.util.Observer;

class Student implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Message board changed: " + arg);
    }
}
