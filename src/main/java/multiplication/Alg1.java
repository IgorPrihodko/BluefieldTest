package multiplication;

import javafx.util.converter.BigIntegerStringConverter;

public class Alg1 {

    public static String multiply(String firstNumber, String secondNumber) {
        BigIntegerStringConverter converter = new BigIntegerStringConverter();
        return converter.fromString(firstNumber).multiply(converter.fromString(secondNumber)).toString();
    }
}
