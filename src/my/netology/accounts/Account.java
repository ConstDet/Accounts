package my.netology.accounts;

import my.netology.MoneyTarget;

public abstract class Account implements MoneyTarget {
    protected String name; //имя счета
    protected long balance;
    protected static int accountNumber;//сквозная нумерация счетов
    //конструктор
    public Account(String name, long balance) {
        this.name = name;
        this.balance = balance;
        accountNumber++;
    }

    //геттеры/сеттеры
    public String getName() {
        return name;
    }

    public long getBalance(){
        return balance;
    }
    //покупка balance -= purchaseAmount;
    public abstract boolean pay(long purchaseAmount); //вернулись к абстрактным методам

    //пополнение
    public abstract boolean add(long replenishmentAmount);

    public boolean transfer(Account accountTo, long amount) {
        if (this.pay(amount)) {
            if (accountTo.add(amount)) {
                return true;//если можно снять и пополнить
            }
            this.add(amount);//если где-то отказ, вернем бабки
        }
        return false;//перевести нельзя
    }
    @Override
    public boolean accept(long money) {
        if (this.add(money)) { //проверили на возможность пополнения
            this.pay(money);//если возможно, то вернули бабки обратно
            return true;//сообщили пользователю, что все ок
        }
        return false;//счет пополнить нельзя
    }
    @Override
    public String toString() {
        return "Наименование счета: " + name + "|" + "Баланс: " + balance + " руб.";
    }
}
