package patternpractise.behaviour.visitor;

public interface AnimalOperation {
    void visit(Monkey monkey);
    void visit(Lion lion);
    void visit(Dolphin dolphin);
}
