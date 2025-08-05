package com.example.DesignPatterns;

// Các lớp phức tạp trong hệ thống
class FlightBooking {
    void bookFlight(String from, String to) {
        System.out.println("Flight booked from " + from + " to " + to);
    }
}

class PaymentService {
    void makePayment(double amount) {
        System.out.println("Payment of $" + amount + " successful");
    }
}

class EmailNotification {
    void sendEmail(String email) {
        System.out.println("Email sent to " + email);
    }
}

// Facade: Cung cấp giao diện đơn giản
class TravelFacade {
    private FlightBooking flightBooking = new FlightBooking();
    private PaymentService paymentService = new PaymentService();
    private EmailNotification emailNotification = new EmailNotification();

    void bookTrip(String from, String to, double amount, String email) {
        flightBooking.bookFlight(from, to);
        paymentService.makePayment(amount);
        emailNotification.sendEmail(email);
        System.out.println("Trip booked successfully!");
    }

}
public class Facade {
    public static void main(String[] args) {
        TravelFacade travelFacade = new TravelFacade();
        travelFacade.bookTrip("New York", "Los Angeles", 500.0, "user@example.com");
    }
}

