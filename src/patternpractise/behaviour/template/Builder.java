package patternpractise.behaviour.template;

public abstract class Builder {
    abstract String test();
    abstract String lint();
    abstract String assemble();
    abstract String deploy();
    
    public void build() {
        System.out.println(this.test());
        System.out.println(this.lint());
        System.out.println(this.assemble());
        System.out.println(this.deploy());
    }

    public static void main(String[] args) {
        AndroidBuilder ab = new AndroidBuilder();
        ab.build();

        IosBuilder ib = new IosBuilder();
        ib.build();
    }
}
