package mueller.paul.Medipolis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "Penalty")
public class Penalty {
    private static final long serialVersionUID = -2134234563453673430L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @Column(unique = true)
    private String name;

    private float value;

    public Penalty(String name, float value) {
        this.name = name;
        this.value = value;
    }

    public Penalty() {
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
