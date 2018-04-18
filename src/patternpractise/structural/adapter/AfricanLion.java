package patternpractise.structural.adapter;

public class AfricanLion implements Lion {
    @Override
    public String roar() {
        final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        return this.toString()+ste[ste.length-2].getMethodName(); // -2 because getStackTrace is also a method
    }

    @Override
    public String toString() {
        return "AfricanLion{}";
    }
}
