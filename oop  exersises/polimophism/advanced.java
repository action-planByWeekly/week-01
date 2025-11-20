abstract class Payment {
    public abstract void pay(double amount);
}

class CardPayment extends Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Card");
    }
}

class BankTransferPayment extends Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " via Bank Transfer");
    }
}

class CryptoPayment extends Payment {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Crypto wallet");
    }
}

class CheckoutService {
    public void processPayment(Payment payment, double amount) {
        payment.pay(amount); // REAL polymorphism
    }
}

class Main {
    public static void main(String[] args) {
        CheckoutService service = new CheckoutService();

        service.processPayment(new CardPayment(), 1000);
        service.processPayment(new BankTransferPayment(), 2000);
        service.processPayment(new CryptoPayment(), 5000);
    }
}
