package binaryoperations;

public class powerset {

    public static int binaryStrToInt(String binary) {
        int sum = 0;
        for(int i = binary.length()-1; i >= 0; i--) {
            char c = binary.charAt(i);
            sum += c == '1' ? 1 << i : 0;
        }
        return sum;
    }

    public static void main(String[] args) {

        System.out.println("\n<< operator");
        System.out.println(1 << 1);
        System.out.println(1 << 2);
        System.out.println(1 << 3);
        System.out.println(1 << 4);

        System.out.println("\n>> operator (signed right shift)");
        System.out.println("Even though you can use shifting of byte, short or char, they are promoted to 32-bit integer before the shifting");
        System.out.println("Bit-shift operators never throw an exception");
        System.out.println("The right operand (the number of positions to shift) is reduced to modulo 32.");
        System.out.println("That is 5 >> 35 is equivalent to 5 >> 3.");
        System.out.println(16 >> 1);
        System.out.println(16 >> 2);
        System.out.println(-16 >> 3);
        System.out.println(-16 >> 4);

        System.out.println("\n>>> operator (unsigned right shift)");
        System.out.println(16 >>> 1);
        System.out.println(16 >>> 2);
        System.out.println(-16 >>> 3);
        System.out.println(-16 >>> 4);

        System.out.println("\n& operator");
        System.out.println("0110 & 1100 would result in 0100");
        System.out.println(Integer.toBinaryString(6 & 12));

        System.out.println("\n| operator");
        System.out.println("0110 & 1100 would result in 1110");
        System.out.println(Integer.toBinaryString(6 | 12));

        System.out.println("\n^ operator");
        System.out.println("0110 & 1100 would result in 1010");
        System.out.println(Integer.toBinaryString(6 ^ 12));

        System.out.println(Integer.toBinaryString(~42));
        System.out.println("\n~ Unary operator");
        System.out.println("~0110 would result in 1001");
        System.out.println(Integer.toBinaryString(6));
        System.out.println(Integer.toBinaryString(~6));

        for(int k = 4; k > 0; k >>= 1) System.out.println(k);



        System.out.println(Integer.toBinaryString(~0 << 5 | ((1 << 2)-1)));
//        System.out.println(Integer.toBinaryString());
    }
}
