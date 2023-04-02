import my.netology.accounts.Account;
import my.netology.accounts.CheckingAccount;
import my.netology.accounts.CreditAccount;
import my.netology.accounts.SavingsAccount;
import my.netology.clients.Client;

public class Main {
    public static void main(String[] args) {
        Account[] account;
        //создали счета
        account = new Account[] {
                new SavingsAccount("Накопительный", 100, 10),
                new CreditAccount("Кредитный", -50),//теперь отрицательный
                new CheckingAccount("Расчетный", 100),
        };
        //клиент
        Client client = new Client("Константин", account.length);//создали клиента, разрешили 3 счета
        //передали счета клиенту
        for (int i = 0; i < account.length; i++) {
            client.addAccount(account[i]);
        }
        //оплата
        if (client.pay(40)) {//пробем платить
            System.out.println("Успешно: " + client.assembleString());
        } else {
            System.out.println("Недостаточно средств!");
        }
        //пополним счет
        /*0 - Накопительный
          1 - Кредитный
          2 - Расчетный*/

        int acc = 0;// от 0 до 2
        System.out.println(account[acc].add(40) + " " + account[acc].toString());//вернули Накопительному 40 р.
        //перевод
        System.out.println(account[0].toString());
        System.out.println(account[1].toString());
        //с накопительного на кредитный
        if (account[0].transfer(account[1], 90)) { //было 100_000
            System.out.println("Перевод со счета " +
                    account[0].getName() + " на счет " +
                    account[1].getName() + " завершен");
        } else {
            System.out.println("Запрещен перевод со счета " +
                    account[0].getName() + " на счет " +
                    account[1].getName());
        }
        System.out.println(account[0].toString());
        System.out.println(account[1].toString());
        //проверили, можно ли положить деньги на первый счет, имеющий возможность принять деньги
        if (client.accept(10)) {
            System.out.println("Есть возможность пополнить счет");
        } else {
            System.out.println("Не смогли пополнить счет");
        }
        //проверилм, можно ли положить деньги на накопительный счет
        if (account[0].accept(10)) {
            System.out.println(account[0].toString());//только проверка, счет остался без изменений
        } else {
            System.out.println("Не смогли пополнить счет");
        }
    }
}