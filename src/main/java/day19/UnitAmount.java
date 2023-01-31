package day19;

public class UnitAmount {
    private final Unit unit;
    private final int amount;

    public UnitAmount(Unit unit, int amount) {
        this.unit = unit;
        this.amount = amount;
    }

    public Unit getUnit() {
        return unit;
    }

    public int getAmount() {
        return amount;
    }
}
