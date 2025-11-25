package Testing;

import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test methods must include the `Test` annotation
 * and return void
 */
class BankAccountTest {
    private BankAccount account;
    private static int count;

    /**
     * This executes only once before any tests are run
     * Must be a static void method. Normally used for loading
     * data from DB
     */
    @org.junit.jupiter.api.BeforeAll
    public static void beforeClass(){
        System.out.println("This executes before any test cases. Count = " + count++);
    }

    /**
     * This executes before each test case is run
     */
    @org.junit.jupiter.api.BeforeEach
    public void setup(){
        account = new BankAccount("Titus", "Lim", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test");
    }

    @org.junit.jupiter.api.Test
    void getBalance_deposit() {
        double balance = account.deposit(200.00, true);
        assertEquals(1200, balance, 0);
    }

    @org.junit.jupiter.api.Test
    void getBalance_withdraw() {
        double balance = account.withdraw(200.00, true);
        assertEquals(800, balance, 0);
    }

    @org.junit.jupiter.api.Test
    public void withdraw_branch() throws Exception{
        double balance = account.withdraw(600, true);
        assertEquals(400, balance, 0);
    }

    @org.junit.jupiter.api.Test
    public void withdraw_not_branch() throws Exception{
        Assertions.assertThrows(
                IllegalArgumentException.class, () -> {
                    double balance = account.withdraw(600, false);
                }
        );
    }

    @org.junit.jupiter.api.Test
    void getBalance() {
        double balance = account.getBalance();
        assertEquals(1000, balance, 0);
    }

    @org.junit.jupiter.api.Test
    void isChecking(){
        assertTrue(account.isChecking());
    }

    /**
     * This executes only once after all the tests are run
     */
    @org.junit.jupiter.api.AfterAll
    public static void afterClass(){
        System.out.println("This executes after any test cases. Count = " + count++);
    }

    @org.junit.jupiter.api.AfterEach
    public void teardown(){
        System.out.println("Count = " + count++);
    }
}