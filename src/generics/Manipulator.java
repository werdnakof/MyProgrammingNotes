package generics;

public class Manipulator<T extends HasF> {
    private T obj;
    public Manipulator(T x) { obj = x; }
    public void manipulate() { obj.f(); }
}
