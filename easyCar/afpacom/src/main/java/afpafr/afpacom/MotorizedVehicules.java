package afpafr.afpacom;

import java.time.LocalDate;

public abstract class MotorizedVehicules extends Vehicle {

    private String fuel;
    private String consumption;
    private boolean gps;

    public MotorizedVehicules(String brand, String modele, String color, LocalDate acquisition, int pricePerDay,
            String fuel, String consumption, boolean gps) {
        super(brand, modele, color, acquisition, pricePerDay);
        this.fuel = fuel;
        this.consumption = consumption;
        this.gps = gps;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getConsumption() {
        return consumption;
    }

    public void setConsumption(String consumption) {
        this.consumption = consumption;
    }

    public boolean getGps() {
        return gps;
    }

    public void setGps(boolean gps) {
        this.gps = gps;
    }

    // -------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    @Override
    public String toString() {

        return "Détails du véhicule loué : "
                + "\n Type de carburant consommé : " + getFuel()
                + "\n Consommation aux 100 KM : " + getConsumption()
                + "\n Option GPS " + getGps()
                + "\n";
    }
}