package dev.langchain4j.quarkus.workshop;

public class Exceptions {
    public static class CustomerNotFoundException extends RuntimeException {
        public CustomerNotFoundException(String customerFirstName, String customerLastName) {
            super("Customer not found: " + customerFirstName + " " + customerLastName);
        }
    }

    public static class BookingCannotBeCancelledException extends RuntimeException {
        public BookingCannotBeCancelledException(long bookingId) {
            super("Booking " + bookingId + " cannot be cancelled - see terms of use");
        }
    }

    public static class BookingNotFoundException extends RuntimeException {
        public BookingNotFoundException(long bookingId) {
            super("Booking " + bookingId + " not found");
        }
    }
}
