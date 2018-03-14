package innerclass;

public class Parcel8 {

    private int no;

    public Parcel8(int no) {
        this.no = no;
    }

    public Wrapping wrapping(int x) {
        // Base constructor call:
        return new Wrapping(x) { // Pass constructor argument.
            public int value() {
                return super.value() * 47;
            }
        }; // Semicolon required
    }

    class JK {
        private String dest;
        private int noi;

        public JK(String dest) {
            this.dest = dest;
            this.noi = Parcel8.this.no;
        }

        public int getNoi() {
            return noi;
        }

        public String readLabel() {
            return dest;
        }
    }

    public JK jk(String dest) {
        return new JK(dest);
    }

    public Destination destination (String dest) {
        return new Destination() {
            private String label = dest;
            @Override
            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel8 p = new Parcel8(2);
        Wrapping w = p.wrapping(10);
        System.out.println(p.jk("tomorrowland").readLabel());
        System.out.println(p.jk("tomorrowland").getNoi());
        JK jk = p.new JK("hell");

        System.out.println(jk.readLabel());
        System.out.println(jk.getNoi());

        System.out.println(p.destination("tomorrowland").readLabel());


    }
}