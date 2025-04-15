import java.util.Scanner;

public class ATMWithdrawal {
    private static final int VALID_PIN = 1234;
    private static int balance = 3000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter PIN: ");
        int pin = scanner.nextInt();
        System.out.print("Withdraw Amount: ");
        int amount = scanner.nextInt();

        try {
            if (pin != VALID_PIN) {
                throw new SecurityException("Invalid PIN");
            }
            if (amount > balance) {
                throw new IllegalArgumentException("Insufficient balance.");
            }

            balance -= amount;
            System.out.println("Withdrawal successful! Remaining Balance: " + balance);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Current Balance: " + balance);
        }
    }
}
