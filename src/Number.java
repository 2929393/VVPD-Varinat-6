public class Number {
    private String value;
    private int numberSystem;

    public Number(String value, int numberSystem) {
        this.value = value;
        this.numberSystem = numberSystem;
    }

    public int getNumberSystem() {
        return numberSystem;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    public void setNumberSystem(int numberSystem) {
        this.numberSystem = numberSystem;
    }

    @Override
    public String toString() {
        return value + " в " + numberSystem + "-ной системе счисления";
    }
}
