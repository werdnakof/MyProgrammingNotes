package accesscontrol.girlname;

public class May {
    private May() {}

    @Override
    public String toString() {
        return "May is an average girl name";
    }

    public static May makeMay() {
        return new May();
    }

    static May makeMay2() {
        return new May();
    }
}
