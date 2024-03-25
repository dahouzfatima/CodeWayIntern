package Task2;

import java.util.List;
public interface Service {
    Account getAccById(String id) throws AccountNotFoundException;
    double checkBalance(String id) throws AccountNotFoundException;
    void widthdraw(String id,double montant) throws AccountNotFoundException, BalanceNotSuffisantException;
    void deposite(String id,double montant) throws AccountNotFoundException;
    void addRandomData(int size);
    List<Account> getAll();
    void add(Account acc);
}
