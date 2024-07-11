package afpafr.afpacom;

import java.time.LocalDate;

public class Voiture extends MotorizedVehicules {

    private int seats;

    public Voiture(String brand, String modele, String color, LocalDate acquisition, int pricePerDay, String fuel,
            String consumption, boolean gps, int seats) {
        super(brand, modele, color, acquisition, pricePerDay, fuel, consumption, gps);
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "\nNombre de place=" + seats
                + "\n Type de Fuel=" + getFuel()
                + "\n Consommation du Véchile=" + getConsumption()
                + "\n Modèle du Véhicule=" + getBrand()
                + "\n GPS équipé=" + getGps()
                + "\n Modèle du Véhicule=" + getModele()
                + "\n Couleur du Véhicule=" + getColor()
                + "\n Date d'entrée du Véhicule=" + getAcquisition()
                + "\n Prix Location à la journée()=" + getPricePerDay()
                + "\n]";
    }

}