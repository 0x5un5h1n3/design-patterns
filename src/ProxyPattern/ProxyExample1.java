package ProxyPattern;

import java.util.Scanner;

interface AbstractBank {

    void getMoney();

    void depositMoney();

    void getBalance();
}

class Bank implements AbstractBank {

    public int accNo = 0;
    double balance = 0;
    String name = "";

    public Bank(int accNo, String name) {
        this.accNo = accNo;
        this.name = name;
    }

    @Override
    public void getMoney() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter GetMoney Id as 'g' or DepositMoney Id as 'd'");
        String tranceType = sc.next();
        if (tranceType.equalsIgnoreCase("0")) {
            System.out.println("Enter the amount : ");
            balance -= Double.parseDouble(sc.next());
            System.out.println("Transaction Completed: Your Balance is : " + balance);
        } else {
            System.out.println("Enter Deposit amount : ");
            balance += Double.parseDouble(sc.next());
            System.out.println("Transaction Completed: Your Balance is : " + balance);
        }
    }

    @Override
    public void depositMoney() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getBalance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

class BankATM implements AbstractBank {

    Bank myBank;
    public int accNo = 0;
    double balance = 0;
    String name = "";

    public BankATM(int accNo, String name) {
        this.accNo = accNo;
        this.name = name;
        check();
    }

    void check() {
        if (accNo == 001 & name.equalsIgnoreCase("user")) {
            myBank = new Bank(accNo, name);
        }
    }

    @Override
    public void getMoney() {
        myBank.getMoney();
    }

    @Override
    public void depositMoney() {
        myBank.depositMoney();
    }

    @Override
    public void getBalance() {
        myBank.depositMoney();
    }
}

class client{
    public static void main(String[] args) {
        AbstractBank bank = new BankATM(001, "user");
        bank.getMoney();
    }
}