interface PaymentGateway {
    void pay(double amount);

    void refund(double amount);
}

interface Discountable {
    double applyDiscount(double amount);
}

class CreditCardPayment implements PaymentGateway, Discountable {
    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card");
    }

    @Override
    public void refund(double amount) {
        System.out.println("Refunded " + amount + " to Credit Card");
    }

    @Override
    public double applyDiscount(double amount) {
        return amount * 0.9; // 10% discount
    }
}

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
        Discountable d1 = new CreditCardPayment();
        PaymentGateway pg2 = new PayPalPayment();

        double discounted = d1.applyDiscount(1000);
        pg1.pay(discounted);
        pg2.pay(500);
    }
}
