package patternpractise.structural.adapter;

public class AlienLionAdapter implements Lion {
    protected Alien alien;

    public AlienLionAdapter(Alien alien) {
        this.alien = alien;
    }

    @Override
    public String roar() {
        return alien.scream();
    }
}
