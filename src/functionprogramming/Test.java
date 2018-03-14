package functionprogramming;

import java.util.Arrays;
import java.util.List;

public class Test {

    public interface F<A, B> {
        B f(A a);
    }

    public static <T> T firstMatch(final List<T> ts, final F<T, Boolean> f, T z) {
        for (T t : ts)
            if (f.f(t)) return t;
        return z;
    }

    public static void main (String[] vars) {
        Test.F greaterThanTen = (F<Integer, Boolean>) integer -> integer > 10;

        Integer[] l = new Integer[] {0, 1, 2};
        System.out.println(Test.firstMatch(Arrays.asList(l), greaterThanTen, 0));
    }
}
