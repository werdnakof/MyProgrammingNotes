package innerclass;

public class Parcel7 {
    public Content content() {
        return new Content() {
            @Override
            public int value() {
                return 0;
            }
        };
    }

    public static void main(String[] args) {
        Parcel7 p = new Parcel7();
        Content c =  p.content();
        System.out.println(c.value());
    }
}
