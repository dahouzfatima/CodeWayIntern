package Task2;

import Task2.Service;

import java.util.ArrayList;
import java.util.List;

public class ServiceImp implements Service {
    public static List<Account> accounts =new ArrayList<>();

    @Override
    public void add(Account acc) {
        accounts.add(acc);
    }

    @Override
    public List<Account> getAll() {
        return accounts;
    }

    @Override
    public Account getAccById(String id) throws AccountNotFoundException {
        for(Account acc:accounts){
            if(acc.getId().equals(id)){return acc;};
        }
        throw new AccountNotFoundException("account not found");
    }

    @Override
    public double checkBalance(String id) throws AccountNotFoundException {
        Account account=getAccById(id);
        return account.getBalance();
    }

    @Override
    public void widthdraw(String id, double montant) throws AccountNotFoundException, BalanceNotSuffisantException {
        Account account=getAccById(id);
        if(montant>account.getBalance()){throw new BalanceNotSuffisantException("balance not suffisant");}
        account.setBalance(account.getBalance()-montant);

    }

    @Override
    public void deposite(String id, double montant) throws AccountNotFoundException {
        Account account=getAccById(id);
        account.setBalance(account.getBalance()+montant);
    }
    @Override
    public void addRandomData(int size) {
        for(int i=0;i<size;i++){
            Account acc;
            acc=new Account();
            accounts.add(acc);
        }
    }



}
