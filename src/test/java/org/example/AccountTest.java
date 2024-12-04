package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    @Before
    public void setUp() {
    }

    @Test
    public void Testing(){
        Account account = new Account();

        assertEquals(0, account.getId());
        account.setBalance(100);
        account.setId(1234);
        assertEquals(100, account.getBalance());
        assertNotEquals(0, account.getId());
        assertTrue(account.getBalance() > 0);
        assertFalse(account.getDateCreated() == new java.util.Date());
        assertNotEquals(2.5,account.getAnnualInterestRate());
        Account.setAnnualInterestRate(2.5);
        assertEquals(2.5, account.getAnnualInterestRate());

        Account account2 = new Account(1235,100);
        assertEquals(account2.getBalance()*(Account.getAnnualInterestRate()/1200), account2.getMonthlyInterest());
        assertNotEquals(0, account2.getBalance());
        account2.withdraw(100);
        assertEquals(0, account2.getBalance());
        account2.deposit(1000);
        assertTrue(account2.getBalance() == 1000);
    }

}