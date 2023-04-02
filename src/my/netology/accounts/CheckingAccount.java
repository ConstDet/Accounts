package my.netology.accounts;

public class CheckingAccount extends Account {
    private static int numChecking = 0;//номер конкретного расчетного счета
    //конструктор
    public CheckingAccount(String name, long balance) {
        super(name, balance);
        numChecking = accountNumber;
    }
    //расход
    @Override
    public boolean pay(long consumption) {
        if (balance >= consumption) {
            balance -= consumption;
            return true; //разрешили сделку
        } else {
            return false;//запретили сделку
        }
    }
    //поступление
    @Override
    public boolean add(long admission) {
        balance += admission;
        return true;//деньги мы всегда примем, если счет не кредитный
    }
    //перевод со счета на счет
    @Override
    public boolean transfer(Account accountTo, long amount) {
        return super.transfer(accountTo, amount);
    }
    @Override
    public boolean accept(long money) {
        return super.accept(money);
    }
    @Override
    public String toString() {
        return "Счет №"+numChecking +
                "-Check|" + super.toString();
    }
}
