package day11;

import java.math.BigInteger;

public class MultiplyItselfOperation implements MonkeyOperation {
    @Override
    public BigInteger execute(BigInteger input) {
        return input.multiply(input);
    }
}
