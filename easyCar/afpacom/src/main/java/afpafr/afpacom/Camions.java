package afpafr.afpacom;

import java.time.LocalDate;

public class Camions extends Vehicle {

    private double cargoCapacity;

    public Camions(double cargoCapacity, String brand, String modele, String color, LocalDate acquisition,
            int pricePerDay) {

        super(brand, modele, color, acquisition, pricePerDay);
        this.cargoCapacity = cargoCapacity;
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(double cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public String toString() {

        return "Capacité du camion : " + getCargoCapacity();
    }
}
