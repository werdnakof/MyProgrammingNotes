package generics;

public class GenericArray<T> {

    private T[] array;

    @SuppressWarnings("unchecked")
    public GenericArray(int sz) {
        array = (T[]) new Object[sz];
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) { return array[index]; }

    // Method that exposes the underlying representation:
    public T[] rep() { return array; }

    public static void main(String[] args) {
        GenericArray<Integer> gai = new GenericArray<Integer>(10);

        // This causes a ClassCastException:
        // Integer[] ia = gai.rep();
        // This is OK:
        Object[] oa = gai.rep();

        GenericArray<Integer> ga = new GenericArray<Integer>(10);

        for(int i = 0; i < 10; i ++)
            ga.put(i, i);
        for(int i = 0; i < 10; i ++)
            System.out.print(ga.get(i) + " ");
            System.out.println();
        try {
            Integer[] ia = ga.rep();
        } catch(Exception e) { System.out.println(e); }
    }
}
