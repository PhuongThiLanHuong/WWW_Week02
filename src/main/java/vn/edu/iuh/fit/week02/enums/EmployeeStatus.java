package vn.edu.iuh.fit.week02.enums;

public enum EmployeeStatus {
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
    EmployeeStatus(int value)
    {
        this.value=value;
    }

}
