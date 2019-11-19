package hkr;

public class Hotel {
    private int availableRooms;
    private boolean booking;
    private int bookingCounter;

    public Hotel(int availableRooms, boolean booking,int bookingCounter) {
        this.availableRooms = availableRooms;
        this.booking = booking;
        this.bookingCounter = bookingCounter;
    }

    public int getAvailableRooms() {
        return availableRooms;
    }

    public void setAvailableRooms(int availableRooms) {
        this.availableRooms = availableRooms;
    }

    public boolean getBooking() {
        return booking;
    }

    public void setBooking(boolean booking) {
        booking = booking;
    }

    public int getBookingCounter() {
        return bookingCounter;
    }

    public void setBookingCounter(int bookingCounter) {
        this.bookingCounter = bookingCounter;
    }

    @Override
    public String toString() {
        return "Hotel Rooms=" + availableRooms +
                ", Booking=" + booking ;
    }
}
