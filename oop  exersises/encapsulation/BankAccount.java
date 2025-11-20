public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if(initialBalance >= 0) {
            this.balance = initialBalance;
        }
    }

    // Add money
    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
        }
    }

    // Remove money safely
    public void withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Invalid withdraw!");
        }
    }

    public double getBalance() {
        return balance;
    }
}

class Main {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount(1000);

        acc.deposit(500);
        acc.withdraw(200);
        acc.withdraw(2000); // will show invalid

        System.out.println(acc.getBalance());
    }
}
