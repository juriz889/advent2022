package day11;

import java.math.BigInteger;
import java.util.function.Predicate;

public class DivisiblePredicate implements Predicate<BigInteger> {
    private final long divisor;

    public DivisiblePredicate(long divisor) {
        this.divisor = divisor;
    }

    public long getDivisor() {
        return divisor;
    }

    @Override
    public boolean test(BigInteger aLong) {
        //System.out.println("Testing if " + aLong + " is divideable by " + divisor);
        return aLong.mod(BigInteger.valueOf(divisor)).equals(BigInteger.ZERO);
    }
}
