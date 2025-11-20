// Interface = 100% abstraction
interface PaymentGateway {
    void pay(double amount);

    void refund(double amount);
}

// Implementation 1
class CreditCardPayment implements PaymentGateway {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunded " + amount + " to Credit Card");
    }
}

// Implementation 2
class PayPalPayment implements PaymentGateway {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunded " + amount + " using PayPal");
    }
}

 class Main {
    public static void main(String[] args) {
        PaymentGateway pg1 = new CreditCardPayment();
        PaymentGateway pg2 = new PayPalPayment();

        pg1.pay(1000);
        pg2.refund(500);
    }
}
