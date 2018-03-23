package patternpractise.behaviour.momento;

public interface NotePad {
    void write(String text);
    String view();
    NotePad save();
    void restore(NotePad notePad);
}
