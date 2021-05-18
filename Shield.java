public class Shield {
    private String type;
    private int resistance;

    public Shield(String type, int resistance) {
        this.type = type;
        this.resistance = resistance;
    }

    public Shield(Shield shield) {
        this.type = shield.type;
        this.resistance = shield.resistance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }
}
