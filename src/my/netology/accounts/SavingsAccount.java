package my.netology.accounts;

public class SavingsAccount extends Account{
    private static int numSave = 0;//номер конкретного накопительного счета
    private long minBalance = 0;
    //конструктор
    public SavingsAccount(String name, long balance, long minBalance) {
        super(name, balance);
        this.minBalance = minBalance;
        numSave = accountNumber;
    }
    //расход
    @Override
    public boolean pay(long consumption) {
        if (balance >= consumption + minBalance) {
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
        return "Счет №"+numSave +
                "-Save|" + super.toString() +
                "|Минимальный баланс: " + minBalance;
    }
}
