package my.netology.accounts;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
class CheckingAccountTest {
    CheckingAccount check = new CheckingAccount("Кредитный", 100);
    Account account = new SavingsAccount("Накопительный", 100, 10);
    @Test
    void pay() {
        long consumption = 10;
        boolean res = check.pay(consumption);

        long bigConsumption = 110;
        boolean resBig = check.pay(bigConsumption);

        Assertions.assertTrue(res);
        Assertions.assertFalse(resBig);
    }

    @Test
    void add() {
        long admission = 10;

        boolean res = check.add(admission);

        Assertions.assertTrue(res);
    }

    @Test
    void transfer() {
        long amount = 10;

        boolean res = check.transfer(account, amount);

        Assertions.assertTrue(res);
    }
}