package patternpractise.behaviour.observer;

public class MessageBoardTest {
    public static void main(String[] args) {
        MessageBoard board = new MessageBoard();
        Student bob = new Student();
        Student joe = new Student();
        board.addObserver(bob);
        board.addObserver(joe);
        board.changeMessage("More Homework!");
    }
}
