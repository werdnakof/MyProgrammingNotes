package patternpractise.structural.adapter;

public class Client {
    public static void main(String[] args) {
        AfricanLion a = new AfricanLion();
        System.out.println(a.roar());

        AsianLion asianLion = new AsianLion();
        System.out.println(asianLion.roar());

        AlienLionAdapter ala = new AlienLionAdapter(new Alien());
        System.out.println(ala.roar());
    }
}
