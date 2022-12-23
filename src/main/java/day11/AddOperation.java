package day11;

import java.math.BigInteger;

public class AddOperation implements MonkeyOperation {
    private final int adding;

    public AddOperation(int adding) {
        this.adding = adding;
    }

    @Override
    public BigInteger execute(BigInteger input) {
        return input.add(BigInteger.valueOf(adding));
    }
}
