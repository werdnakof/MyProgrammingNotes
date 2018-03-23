package patternpractise.behaviour.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FavouriteChannels {

    private List<RadioChannel> list = new ArrayList<>();

    public boolean add(RadioChannel radioChannel) {
        return list.add(radioChannel);
    }

    public Iterator<RadioChannel> iterator() {
        return new ChannelIterator();
    }

    public class ChannelIterator implements Iterator<RadioChannel>, Iterable<RadioChannel> {

        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < list.size();
        }

        @Override
        public RadioChannel next() {
            return list.get(cursor++);
        }

        @Override
        public Iterator iterator() {
            return new ChannelIterator();
        }
    }
}
