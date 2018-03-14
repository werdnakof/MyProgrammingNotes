package generics;

import java.util.Iterator;

public class ImplementIterable<T extends Comparable<T>> implements Iterable<T> {

    private T[] privateArray;

    private class ArrayIterator implements Iterator<T> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < privateArray.length - 1;
        }

        @Override
        public T next() {
            return privateArray[index++];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }
}
