package mueller.paul.Medipolis.dto;

public class PenaltyRequest {
    private String name;
    private float value;

    public PenaltyRequest(String name, float value) {
        this.name = name;
        this.value = value;
    }

    public PenaltyRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
