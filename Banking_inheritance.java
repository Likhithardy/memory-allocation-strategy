 
 class BankAccount {

    int acc_num;
    String holder_name;
    float balance;

    BankAccount(int acc_num, String holder_name, float balance) {
        this.acc_num = acc_num;
        this.holder_name = holder_name;
        this.balance = balance;
    }

    void deposit(int x) {
        balance += x;
        System.out.println("deposited:  " + x + "   Balance:    " + balance);
    }

    void withdrawl(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn Amount:" + amount + "\nBalance:" + balance);
        } else {
            System.out.println("Insufficient Funds!");
        }

    }

    double CalculateIntrest() {
        return 0.0;
    }

    void DisplayDetails() {
        System.out.println("Account Number:" + acc_num);
        System.out.println("Holder Name" + holder_name);
        System.out.println("Balance" + balance);
    }
}

class SavingsAcc extends BankAccount {

    private int intrestRate;

    SavingsAcc(int intrestRate, int acc_num, String holder_name, float balance) {
        super(acc_num, holder_name, balance);
        this.intrestRate = intrestRate;
    }

    @Override
    double CalculateIntrest() {
        return balance * intrestRate / 100;
    }

}

class CurrentAcc extends BankAccount {

    double overDraftLimit;

    public CurrentAcc(double overDraftLimit, int acc_num, String holder_name, float balance) {
        super(acc_num, holder_name, balance);
        this.overDraftLimit = overDraftLimit;
    }

    void withdrawl(double amount) {
        if (amount <= balance + overDraftLimit) {
            balance -= amount;
            System.out.println("Withdrawn:  " + amount + "  Balance:  " + balance);
        } else {
            System.out.println("Insufficient funds");
        }

    }
}

class FixedAcc extends BankAccount {

    int durationPeriod;
    double intrestRate;

    public FixedAcc(double intrestRate, int durationPeriod, int acc_num, String holder_name, float balance) {
        super(acc_num, holder_name, balance);
        this.durationPeriod = durationPeriod;
        this.intrestRate = intrestRate;
    }

    @Override
    double CalculateIntrest() {
        return balance * Math.pow((1 + intrestRate / 100), durationPeriod) - balance;
    }
}

class Banking_inheritance {

    public static void main(String[] args) {
        SavingsAcc s = new SavingsAcc(8, 7109, "Pavan", 10000);
        CurrentAcc c = new CurrentAcc(2000, 9, "sai", 5000);
        s.deposit(5000);
        s.withdrawl(1000);
        System.out.println("------------------");
        c.deposit(100);
        c.withdrawl(50);
        s.DisplayDetails();
        c.DisplayDetails();
    }
}
