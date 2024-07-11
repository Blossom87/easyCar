package afpafr.afpacom;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Vehicle implements Serializable {

    private String brand;
    private String modele;
    private String color;
    private LocalDate acquisition;
    private int pricePerDay;
    private transient ArrayList<Reservation> reservations = new ArrayList<Reservation>();

    public Vehicle(String brand, String modele, String color, LocalDate acquisition, int pricePerDay) {

        this.brand = brand;
        this.modele = modele;
        this.color = color;
        this.acquisition = acquisition;
        this.pricePerDay = pricePerDay;
    }

    // -------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public String getBrand() {
        return brand;
    }

    public String getModele() {
        return modele;
    }

    public String getColor() {
        return color;
    }

    public LocalDate getAcquisition() {
        return acquisition;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    // -------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setAcquisition(LocalDate acquisition) {
        this.acquisition = acquisition;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    @Override
    public String toString() {

        return "easyApp! Location facile pour professionnel et particulier!"
                + "{\nMarque du Véhicule : " + getBrand()
                + "\nModèle  :" + getModele()
                + "\nCouleur : " + getColor()
                + "\nDate d'entré du Véhicule dans nos locaux : " + getAcquisition()
                + "Coût du véhicule en location à la journée : " + getPricePerDay()
                + '}';
    }

    public void addReservation(Reservation reservation) {

        this.reservations.add(reservation);
    }

    public boolean removeReservation(Reservation reservation) {

        // Boucle if en relation avec l'implémentation de vérification de la date de
        // réservation.
        return this.reservations.remove(reservation);
    }
}