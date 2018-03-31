package binaryoperations;

public class BitOperations {

    /**
     * true -> 1
     * false -> 0
     *
     * @param number
     * @param i
     * @return
     */
    static boolean getBit(int number, int i) {
//        System.out.println("getBit: " + Integer.toBinaryString(number));
        return ((number & (1 << i)) != 0);
    }

    static int setBit(int number, int i) {
//        System.out.println("setBit: " + Integer.toBinaryString(number));
        return (number | (1 << i));
    }

    static int clearBit(int number, int i) {
//        System.out.println("setBit: " + Integer.toBinaryString(number));
        return (number & ~(1 << i));
    }

    static int updateBit(int number, int i, boolean isOne) {
        int value = isOne ? 1 : 0;

        // keep every bit as they are except 0 for the ith bit
        int mask = ~(1 << i);

        return (number & mask) | (value << i);
    }

    static int countBitsLength(int i) {
        int count = 0;
        while (i > 0) {
            count++;
            i = i >> 1;
        }
        return count;
    }

    static int genOnesBit(int length) {
        int value = 0;
        length -= 1;
        while (length >= 0) {
            value += 2 ^ length;
            length -= 1;
        }
        return value;
    }

    static int reverseBits(int num) {
        for(int i = 0; i <= 15; i++) {

            boolean front = (num & 1 << i) != 0;

            boolean back = (num & 1 << (31-i)) != 0;

            num = front ? (num | 1 << (31-i)) : (num & ~(1 << (31-i)));

            num = back ? (num | 1 << i) : (num & ~(1 << i));
        }
        return num;
    }

    public int reverseBitsBetter(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n >>>= 1;   // CATCH: must do unsigned shift
            if (i < 31) // CATCH: for last digit, don't shift!
                result <<= 1;
        }
        return result;
    }

    public static void main(String[] vars) {
//        int num = 0;
//        int j = num | (1 << 31);
//        int j = updateBit(num, 32, true);
//        System.out.println(Integer.toBinaryString(reverseBits(6)));
//        System.out.println(Integer.toBinaryString(reverseBits(6)).length());
        System.out.println(countBitsLength(8));
    }
}
