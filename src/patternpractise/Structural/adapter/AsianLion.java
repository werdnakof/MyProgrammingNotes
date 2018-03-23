package patternpractise.Structural.adapter;

public class AsianLion implements Lion {
    @Override
    public String roar() {
        StackTraceElement[] stes = Thread.currentThread().getStackTrace();
        return this.toString() + stes[stes.length-2].getMethodName();
    }

    @Override
    public String toString() {
        return "AsianLion{}";
    }
}
