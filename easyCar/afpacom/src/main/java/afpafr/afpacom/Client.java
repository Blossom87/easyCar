package afpafr.afpacom;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Client implements Comparable<Client>, Serializable {

    private static Logger logger = LogManager.getLogger(Client.class);

    private String firstName;
    private String lastName;
    private String adress;
    private String city;
    private String postalCode;
    private ArrayList<Reservation> reservations = new ArrayList<Reservation>();

    public Client(String firstName, String lastName, String adress, String city, String postalCode) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.adress = adress;
        this.city = city;
        this.postalCode = postalCode;

    }

    public ArrayList<Reservation> getReservations() {
        return this.reservations;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    // Reservation reservation1 = new Reservation(firstName, city, adress)

    // -------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    @Override
    public String toString() {

        return "Profil client : "
                + "\n Nom : " + getLastName()
                + "\n Prénom : " + getFirstName()
                + "\n Adresse : " + getAdress()
                + "\n Ville : " + getCity()
                + "\n Code Postal : " + getPostalCode()
                + "\n Reservation : " + getReservations()
                + "\n Argent dépensé : " + totalSpent();
    }

    public double totalSpent() {

        double total = 0.0;

        for (Reservation reservation : reservations) {
            total += reservation.totalPrice();
        }
        // System.out.println("Total dépensé : " + total);
        return total;
    }

    public void addReservation(Reservation reservation) {

        this.reservations.add(reservation);
    }

    public boolean removeReservation(Reservation reservation) {

        // Boucle if en relation avec l'implémentation de vérification de la date de
        // réservation.

        return this.reservations.remove(reservation);
    }

    @Override
    public int compareTo(Client client) {

        // test if pour comparer la methode totalSpent entre le this et un client à un
        // instant T.
        // La méthode s'occupe du reste.

        if (this.totalSpent() > client.totalSpent()) {
            return 1;
        }

        if (this.totalSpent() < client.totalSpent()) {

            return -1;
        }
        return 0;
    }

    public static void serialize(Client client) {

        // Sauvegarder dans un fichier externe et charger a partir du fichier créer
        try {
            // .ser (serial) convention / Zone de dépôt
            File newFile = new File("customer.ser");
            // FileOutputStream > Class pour écrire un fichier (general) / Pointe vers la zone de dépôt créer.
            FileOutputStream fos = new FileOutputStream(newFile);
            // ObjectOutputStream > Class propre a la serialization / Transformation des données en binaire puis connecte a fos pour données les infos binaires
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            // Ecrit l'objet, envoie le binaire
            oos.writeObject(client);
            // Fermeture.
            oos.close();
            //
        } catch (IOException exception) {
            System.out.println("Error");
        }
    }

    public static Client deserialize() {

        Client deserializeClient = null;

        File fichier = new File("customer.ser");

        try {
            FileInputStream fis = new FileInputStream(fichier);

            ObjectInputStream ois = new ObjectInputStream(fis);

            Client m = (Client) ois.readObject();
            ois.close();

            System.out.println(m);
            // Input Ouput exception pour les erreurs sur les échanges avec le nouveau fichier.
        } catch (IOException | ClassNotFoundException exception) {
            logger.error(exception.getMessage());
        }

        return deserializeClient;
    }
}
