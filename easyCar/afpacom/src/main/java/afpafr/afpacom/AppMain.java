package afpafr.afpacom;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class AppMain {    
        private static Logger logger = LogManager.getLogger(AppMain.class);
        public static void main(String[] args) {

        ArrayList<MotorizedVehicules> motorized1 = new ArrayList<MotorizedVehicules>();
        ArrayList<Reservation> Contrat1 = new ArrayList<Reservation>();
        ArrayList<Client> clients = new ArrayList<Client>();

        Vehicle vehicule1 = new Voiture("Opel", "Astra", "Grise", LocalDate.parse("2020-07-12"), 25, "Gazol", "5L",
                true, 5);
        Reservation reservation1 = new Reservation(LocalDate.parse("2023-06-01"), LocalDate.parse("2023-06-12"), true,
                vehicule1);
        Client client1 = new Client("Test2", "omega", "Rue bidon", "Ville bidon", "87000");

        Vehicle vehicule2 = new Voiture("Citreon", "City Car", "Rouge", LocalDate.parse("2019-11-25"), 15,
                "Sans Plomb 95", "3", true, 5);
        Reservation reservation2 = new Reservation(LocalDate.parse("2024-07-12"), LocalDate.parse("2024-07-15"), true,
                vehicule2);
        Client client2 = new Client("Test3", "Alpha", "Omega Protocol", "Alphascape", "15647");

        Vehicle vehicule3 = new Voiture("Mazda", "Mazda CX-60", "Blanche", LocalDate.parse("2024-01-12"), 45, "Diesel",
                "6", true, 5);
        Reservation reservation3 = new Reservation(LocalDate.parse("2024-03-15"), LocalDate.parse("2024-03-20"), true,
                vehicule3);
        Client client3 = new Client("Test1", "Ferdinand", "La Rue du Monde", "Paris", "93000");

        client1.addReservation(reservation1);
        client1.totalSpent();
        //System.out.println(client1.toString());

        client2.addReservation(reservation2);
        client2.totalSpent();
        //System.out.println(client2.toString());

        client3.addReservation(reservation3);
        client3.totalSpent();
        //System.out.println(client3.toString());

        
        clients.add(client1);
        clients.add(client2);
        clients.add(client3);
        // System.out.println("Avant tri : " + clients);
        
        Collections.sort(clients);
        
        for (Client client : clients){
                System.out.println("Apres tri " + client);
        }

        // Code permettant de tester la sérialization
        Client.serialize(client1);

        // Code permettabt de rester la déserialization
        Client client = Client.deserialize();

        System.out.println("TEST DESERIALISE" + client.toString());
    }

}