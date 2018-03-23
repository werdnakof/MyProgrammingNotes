package patternpractise.behaviour.iterator;

public class Client {

    public static void main(String[] vars) throws Exception {
        FavouriteChannels fc = new FavouriteChannels();
        fc.add(new BBC());
        fc.add(new Four());

        for(RadioChannel rc: fc.new ChannelIterator()) {
            System.out.println(rc.getFrequency());
        }
    }
}
