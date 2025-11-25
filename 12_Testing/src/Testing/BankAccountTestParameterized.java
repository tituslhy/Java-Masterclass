package Testing;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * You have to create a class for each parameterized tests
 * you want to run
 */
public class BankAccountTestParameterized {
    private BankAccount account;
    private double amount;
    private boolean branch;
    private double expected;

    /**
     * The data source method must be static if used with @MethodSource
     * @return test cases as arrays
     */
    public static Collection<Object[]> testConditions(){
        return Arrays.asList(new Object[][] {
                {100.00, true, 1100.00},
                {200.00, true, 1200.00},
                {325.14, true, 1325.14},
                {489.33, true, 1489.33},
                {1000.00, true, 2000.00}
        });
    }

    @org.junit.jupiter.api.BeforeEach
    public void setup(){
        account = new BankAccount("Tim", "Buchalka", 1000.00, BankAccount.CHECKING);
    }

    /**
     * Parameters setup must be injected into tests in method argument
     */
    @ParameterizedTest
    @MethodSource("testConditions") //refers to the name of the method
    void getBalance_deposit(double amount, boolean branch, double expected) {
        account.deposit(amount, branch);
        assertEquals(expected, account.getBalance(), 0.01);
    }
}
