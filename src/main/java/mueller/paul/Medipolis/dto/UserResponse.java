package mueller.paul.Medipolis.dto;

import mueller.paul.Medipolis.model.User;

public class UserResponse {
    private String username;
    private float balance;

    public UserResponse(User user) {
        this.username = user.getUsername();
        this.balance = user.getReversePiggybank().getBalance();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
