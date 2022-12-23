package day11;

import java.math.BigInteger;

public class MultiplyOperation implements MonkeyOperation {
    private final int multiplier;

    public MultiplyOperation(int multiplier) {
        this.multiplier = multiplier;
    }

    @Override
    public BigInteger execute(BigInteger input) {
        return input.multiply(BigInteger.valueOf(multiplier));
    }
}
