import multiplication.Alg1;
import multiplication.Alg2;

public class Multiply {

    public static void main(String[] args) {
        String algorythm = args[0];
        String firstBigNumber = args[1];
        String secondBigNumber = args[2];
        switch (algorythm) {
            case "--alg1":
                System.out.println(Alg1.multiply(firstBigNumber, secondBigNumber));
                break;
            case "--alg2":
                System.out.println(Alg2.multiply(firstBigNumber, secondBigNumber));
                break;
            default:
                throw new IllegalArgumentException("Not a valid argument: " + algorythm);
        }
    }
}
