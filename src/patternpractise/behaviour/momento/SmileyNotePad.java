package patternpractise.behaviour.momento;

public class SmileyNotePad implements NotePad {

    StringBuilder sb = new StringBuilder();

    public SmileyNotePad() {}

    public SmileyNotePad(StringBuilder sb) {
        this.sb = sb;
    }

    @Override
    public void write(String text) {
        sb.append(text);
    }

    @Override
    public String view() {
        return sb.toString();
    }

    @Override
    public NotePad save() {
        return new SmileyNotePad(new StringBuilder(sb));
    }

    @Override
    public void restore(NotePad notePad) {
        sb = new StringBuilder(notePad.view());
    }
}
