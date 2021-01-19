package mueller.paul.Medipolis.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.IndexColumn;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "ReversePiggybank")
public class ReversePiggybank implements Serializable {
    private static final long serialVersionUID = -1231321234531626430L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @OneToOne
    @JsonIgnore
    private User user;

    @ManyToMany
    private List<Penalty> penalties;

    private float balance = 0;

    public ReversePiggybank() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(){
        balance = 0;
        for(Penalty p: penalties){
            balance += p.getValue();
        }
    }

    public void removeBalance(float minusBalance){
        this.balance -=minusBalance;
    }

    public void removeAllBalance(){
        this.balance = 0;
    }

    public List<Penalty> getPenalties() {
        return penalties;
    }

    public void setPenalties(List<Penalty> penalties) {
        this.penalties = penalties;
    }

    public void clearPenalties(){
        penalties.clear();
    }

    public void addPenalty(Penalty penalty){
        penalties.add(penalty);
    }
}
