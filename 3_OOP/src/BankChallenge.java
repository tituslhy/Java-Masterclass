public class BankChallenge {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountNumber("123456");
        bankAccount.setCustomerName("Bob");
        bankAccount.setEmail("abc@123.com");
        bankAccount.setPhoneNumber("9876");
        bankAccount.setAccountBalance(10_000);
        bankAccount.deposit(1);
        System.out.println(bankAccount.getAccountBalance());
        bankAccount.withdraw(5_000);
        bankAccount.withdraw(20_000);
    }
}
