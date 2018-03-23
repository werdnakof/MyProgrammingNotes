package patternpractise.behaviour.observer;


import java.util.Observable;

class MessageBoard  extends Observable {
    public void changeMessage(String message) {
        setChanged();
        notifyObservers(message);
    }
}
