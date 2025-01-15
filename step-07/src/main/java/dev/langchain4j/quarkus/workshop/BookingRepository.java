package dev.langchain4j.quarkus.workshop;

import static dev.langchain4j.quarkus.workshop.Exceptions.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.logging.Log;
import dev.langchain4j.agent.tool.Tool;

@ApplicationScoped
public class BookingRepository implements PanacheRepository<Booking> {

  @Tool("Get how many days are between two dates")
  public long dateDiff(String date1, String date2) {
      Log.info("Calculating date difference");
      return  ChronoUnit.DAYS.between(LocalDate.parse(date1), LocalDate.parse(date2));
  }

    @Tool("Cancel a booking and return true if successful")
    @Transactional
    public boolean cancelBooking(long bookingId, String customerFirstName, String customerLastName) {
        var booking = getBookingDetails(bookingId, customerFirstName, customerLastName);
        // too late to cancel
        if (booking.dateFrom.minusDays(11).isBefore(LocalDate.now())) {
            throw new BookingCannotBeCancelledException(bookingId, "booking from date is 11 days before today");
        }
        // too short to cancel
        if (booking.dateTo.minusDays(4).isBefore(booking.dateFrom)) {
            throw new BookingCannotBeCancelledException(bookingId, "booking period is less than four days");
        }
        delete(booking);
        Log.info("Booking " + bookingId + "  cancelled successfully");
        return true;
    }

    @Tool("List booking for a customer")
    public List<Booking> listBookingsForCustomer(String customerFirstName, String customerLastName) {
        var found = Customer.findByFirstAndLastName(customerFirstName, customerLastName);

        return found
          .map(customer -> list("customer", customer))
          .orElseThrow(() -> new CustomerNotFoundException(customerFirstName, customerLastName));
    }


    @Tool("Get booking details")
    public Booking getBookingDetails(long bookingId, String customerFirstName, String customerLastName) {
        var found = findByIdOptional(bookingId)
          .orElseThrow(() -> new BookingNotFoundException(bookingId));

        if (!found.customer.firstName.equals(customerFirstName) || !found.customer.lastName.equals(customerLastName)) {
            throw new BookingNotFoundException(bookingId);
        }
        return found;
    }
}
