abstract class Notification {
    private String recipient;

    public Notification(String recipient) {
        this.recipient = recipient;
    }

    public String getRecipient() {
        return recipient;
    }

    public abstract void send(String message);
}

class EmailNotification extends Notification {

    public EmailNotification(String recipient) {
        super(recipient);
    }

    @Override
    public void send(String message) {
        System.out.println("Email sent to " + getRecipient() + ": " + message);
    }
}

class SMSNotification extends Notification {

    public SMSNotification(String recipient) {
        super(recipient);
    }

    @Override
    public void send(String message) {
        System.out.println("SMS sent to " + getRecipient() + ": " + message);
    }
}

class PushNotification extends Notification {

    public PushNotification(String recipient) {
        super(recipient);
    }

    @Override
    public void send(String message) {
        System.out.println("Push notification sent to " + getRecipient() + ": " + message);
    }
}

class NotificationService {
    public void notifyUser(Notification notification, String msg) {
        notification.send(msg); // POLYMORPHISM here
    }
}

 class Main {
    public static void main(String[] args) {
        NotificationService service = new NotificationService();

        service.notifyUser(new EmailNotification("abc@mail.com"), "Welcome!");
        service.notifyUser(new SMSNotification("0771234567"), "Your OTP is 1234");
        service.notifyUser(new PushNotification("user123"), "You have a new message");
    }
}
