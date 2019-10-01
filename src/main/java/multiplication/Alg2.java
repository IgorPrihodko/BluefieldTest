package multiplication;

import java.util.Arrays;

public class Alg2 {

    private static int[] baseMultiply(int[] baseMultiple, int base) {
        for (int i = 0; i < baseMultiple.length; i++) {
            baseMultiple[i] *= base;
        }
        return carryForward(baseMultiple);
    }

    private static int[] basePowerMultiply(int[] basePowerMultiple, int base, int power) {
        int basePowerMultipleTemp[] = baseMultiply(basePowerMultiple, base);
        int basePowerMultipleResult[] = new int[basePowerMultipleTemp.length + (power - 1)];
        System.arraycopy(basePowerMultipleTemp, 0, basePowerMultipleResult, 0, basePowerMultipleTemp.length);
        if (power > 1){
            for (int i = 0; i < (power - 1); i++)
                basePowerMultipleResult[basePowerMultipleTemp.length + i] = 0;
        }
        return basePowerMultipleResult;
    }

    private static int[] addBigNumber(int[] finalNumberInArray, int[] finalNumberInArrayTemp) {
        int n = finalNumberInArray.length;
        for (int i = (finalNumberInArrayTemp.length - 1); i >= 0; i--){
            finalNumberInArray[n - 1] += finalNumberInArrayTemp[i];
            n--;
        }
        return carryForward(finalNumberInArray);
    }

    private static int[] carryForward(int[] arrayWithoutCarryForward) {
        int[] arrayWithCarryForward = null;
        for (int i = arrayWithoutCarryForward.length - 1; i > 0; i--) {
            if (arrayWithoutCarryForward[i] >= 10) {
                int firstDigit = arrayWithoutCarryForward[i] % 10;
                int secondDigit = arrayWithoutCarryForward[i] / 10;
                arrayWithoutCarryForward[i] = firstDigit;
                arrayWithoutCarryForward[i - 1] += secondDigit;
            }
        }

        if (arrayWithoutCarryForward[0] >= 10) {
            arrayWithCarryForward = new int[arrayWithoutCarryForward.length + 1];
            arrayWithCarryForward[0] = arrayWithoutCarryForward[0] / 10;
            arrayWithCarryForward[1] = arrayWithoutCarryForward[0] % 10;
            System.arraycopy(arrayWithoutCarryForward, 1, arrayWithCarryForward,
                    2, arrayWithoutCarryForward.length - 1);
        }
        else {
            arrayWithCarryForward = arrayWithoutCarryForward;
        }
        return arrayWithCarryForward;
    }

    public static String multiply(String firstNumber, String secondNumber) {
        int[] firstBigNumber = bigNumberToArray(firstNumber);
        int[] secondBigNumber = bigNumberToArray(secondNumber);
        int[] finalNumberInArray = null;
        for (int i = 0; i < secondBigNumber.length; i++){
            if (secondBigNumber[i] != 0) {
                int[] finalNumberInArrayTemp =
                        basePowerMultiply(Arrays.copyOf(firstBigNumber, firstBigNumber.length),
                                secondBigNumber[i], secondBigNumber.length - i);
                if (finalNumberInArray == null) {
                    finalNumberInArray = finalNumberInArrayTemp;
                } else {
                    finalNumberInArray = addBigNumber(finalNumberInArray, finalNumberInArrayTemp);
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (finalNumberInArray != null) {
            for (int aFinalNumberInArray : finalNumberInArray) {
                stringBuilder.append(aFinalNumberInArray);
            }
        }
        return stringBuilder.toString();
    }

    public static int [] bigNumberToArray(String bigNumber) {
        char[] chars = bigNumber.toCharArray();
        int [] digits = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            digits[i] = Character.getNumericValue(chars[i]);
        }
        return digits;
    }
}
