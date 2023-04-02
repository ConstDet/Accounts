package my.netology.accounts;

public class CreditAccount extends Account {
    private static int numCredit = 0;//номер конкретного кредитного счета
    private long creditBalance = 0;
    //конструктор
    public CreditAccount(String name, long balance) {
        super(name, balance);
        creditBalance = balance;//запомним сумму кредита
        numCredit = accountNumber;
    }
    //расход с кредитного счета
    @Override
    public boolean pay(long consumption) {
        if (balance <= -consumption) {
            balance += consumption;
            return true; //разрешили сделку
        } else {
            return false;//запретили сделку
        }
    }
    //поступление сумма на счету не может быть больше нуля
    @Override
    public boolean add(long admission) {
        if (creditBalance <= getBalance() - admission) {
            balance -= admission;
            return true;
        } else {
            return false;
        }
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
        return "Счет №"+numCredit +
                "-Credit|" + super.toString() +
                "|Сумма кредита: " + creditBalance;
    }
}
