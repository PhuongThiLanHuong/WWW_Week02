package vn.edu.iuh.fit.week02.enums;

public enum ProductStatus {
    ACTIVE(1),
    IN_ACTIVE(0),
    TERMINATED(-1);
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    ProductStatus(int value)
    {
        this.value=value;
    }
}
