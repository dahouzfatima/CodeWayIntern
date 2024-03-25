package Task2;

import java.util.UUID;
import java.util.UUID;
public class Account {
    private String id;
    private double balance;
    public Account(){
        id= UUID.randomUUID().toString();
    }
    public Account(double balance){
        this();
        this.balance=balance;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
}
