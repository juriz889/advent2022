package day11;

import java.math.BigInteger;

public class ThrowAction {
    private final Monkey receiver;

    public ThrowAction(Monkey receiver) {
        this.receiver = receiver;
    }

    public void execute(BigInteger item) {
        // System.out.println("Throwing " + item + " to " + receiver.getName());
        receiver.receiveItem(item);
    }
}
