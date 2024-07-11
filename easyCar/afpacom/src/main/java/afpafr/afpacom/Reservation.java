package afpafr.afpacom;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Reservation implements Serializable {

    private LocalDate reservationStart;
    private LocalDate reservationEnd;
    private boolean paymentStatus;
    private Vehicle vehicle;

    public Reservation(LocalDate reservationStart, LocalDate reservationEnd, boolean paymentStatus, Vehicle vehicle) {

        this.vehicle = vehicle;
        this.reservationStart = reservationStart;
        this.reservationEnd = reservationEnd;
        this.paymentStatus = paymentStatus;
        this.vehicle.addReservation(this);
    }

    public LocalDate getReservationStart() {
        return reservationStart;
    }

    public void setReservationStart(LocalDate reservationStart) {
        this.reservationStart = reservationStart;
    }

    public LocalDate getReservationEnd() {
        return reservationEnd;
    }

    public void setReservationEnd(LocalDate reservationEnd) {
        this.reservationEnd = reservationEnd;
    }

    public boolean getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(boolean paymentStatus) {

        if (paymentStatus = true) {
            this.paymentStatus = paymentStatus;
            System.out.println("Payé.");
        } else {
            if (paymentStatus = false) {
                this.paymentStatus = paymentStatus;
                System.out.println("Impayé.");
            }
        }

    }

    public double totalPrice() {

        long daysInBetween = 0;

        if (reservationStart.equals(reservationEnd)) {

            daysInBetween = 1;
        } else {
            daysInBetween = ChronoUnit.DAYS.between(this.reservationStart, this.reservationEnd);
        }
        return daysInBetween * this.vehicle.getPricePerDay();

    }

    // --------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    @Override

    public String toString() {

        return "\nDébut de réservation : " + getReservationStart()
                + "\nFin de réservation : " + getReservationEnd()
                + "\nStatus de paiement de la réservation : " + getPaymentStatus()
                + "\nVoiture en location : " + vehicle
                + "\nPrix de la location : " + totalPrice()
                + "\n";
    }

}