package my.netology.clients;

import my.netology.MoneyTarget;
import my.netology.accounts.Account;

public class Client implements MoneyTarget {
    private String clientString;
    private String name;//имя клиента
    private int replenisAccount;//номер пополненного счета в массиве
    private Account[] accounts;
    //конструктор
    public Client(String name, int numAccounts) {
        this.name = name;
        accounts = new Account[numAccounts];
    }
    //добовляем новый счет
    public void addAccount(Account account) {
        for (int i = 0; i < accounts.length; i++){
            if (accounts[i] == null) {
                accounts[i] = account;
                return;
            }
        }
        System.out.println("Превышен лимит счетов. Новый счет создать не возможно.");
    }
    //оплата клиентом
    public boolean pay(long consumption) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null && accounts[i].pay(consumption)) {
                clientString = accounts[i].toString();
                return true;
            }
        }
        return false;
    }
    //пополняем счета клиента
    public boolean add(long admission) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null && accounts[i].add(admission)) {
                replenisAccount = i;//запомним порядковый номер счета в массиве
                clientString = accounts[i].toString();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean accept(long money) {
        if (this.add(money)) {//сняли деньги
            accounts[replenisAccount].pay(money);//...и вернули деньги по порядковому номеру в массиве
            return true;//сообщили, что пополнение возможно.
        }
        return false;
    }

    public String assembleString() {
        return "Имя клиента: " + name +"|"+ clientString;
    }
}
