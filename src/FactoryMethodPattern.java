
public class FactoryMethodPattern {

    //   create an abstract product interface
    interface Notification {
        void notifyUser();
    }

    //  Implement concrete products
    static class EmailNotification implements Notification {
        @Override
        public void notifyUser() {
            System.out.println("Sending an email notification.");
        }
    }

    static class SMSNotification implements Notification {
        @Override
        public void notifyUser() {
            System.out.println("Sending an SMS notification.");
        }
    }

    //  Create an abstract creator class, which is actual implementation of factory method
    abstract static class NotificationFactory {
        public abstract Notification createNotification();

        public void sendNotification() {
            // Step to send notification
            Notification notification = createNotification();
            notification.notifyUser();
        }
    }

    // Implement concrete creators
    static class EmailNotificationFactory extends NotificationFactory {
        @Override
        public Notification createNotification() {
            return new EmailNotification();
        }
    }

    static class SMSNotificationFactory extends NotificationFactory {
        @Override
        public Notification createNotification() {
            return new SMSNotification();
        }
    }


    // Use the factory method
    public static void main(String[] args) {
        NotificationFactory factory1;
        NotificationFactory factory2;

        // Use EmailNotificationFactory for email notifications
        factory1 = new EmailNotificationFactory();
        factory1.sendNotification();  // Output: Sending an email notification.

        // Use SMSNotificationFactory for SMS notifications
        factory2 = new SMSNotificationFactory();
        factory2.sendNotification();  // Output: Sending an SMS notification.



    }
}
