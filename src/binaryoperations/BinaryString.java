package binaryoperations;

public class BinaryString {
    static String getBinary(Integer num) {

        if(num == 0) return "0";

        StringBuilder sb = new StringBuilder();

        while(num != 1) {
            String tmp = (num % 2 == 0) ? "0" : "1";
            sb.append(tmp);
            num /= 2;
        }

        sb.append("1");

        return sb.reverse().toString();
    }

    static String getBinary(double num) {
        Integer i = (int) num;
        double f = num - i;

        StringBuilder sb = new StringBuilder();
        while(f != 1.00) {
            f *= 2;
            sb.append( f >= 1 ? "1" : "0");
            f = f > 1 ? f - 1 : f;
        }

        return getBinary(i) + sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getBinary(34.890625));
    }
}
