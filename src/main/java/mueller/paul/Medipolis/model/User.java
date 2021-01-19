package mueller.paul.Medipolis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "User")
public class User implements Serializable {
    private static final long serialVersionUID = -2134234524235226430L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @OneToOne
    private ReversePiggybank reversePiggybank;

    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public ReversePiggybank getReversePiggybank() {
        return reversePiggybank;
    }

    public void setReversePiggybank(ReversePiggybank reversePiggybank) {
        this.reversePiggybank = reversePiggybank;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
