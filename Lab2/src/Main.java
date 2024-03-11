public class Main {
    public static void main(String[] args) {
        Client client = new Client("Soci Lucian", ClientType.PREMIUM);
       Vehicle masina1 = new Truck("Tesla", "Negru", 2019, 70);
       Vehicle masina2 = new Truck("Dacia", "Rosu", 2007, 50);
       Vehicle drona1 = new Drone("Tesla", "Alb", 2022, 2);
        Depot deposit1 = new Depot("Iasi");

        deposit1.addVehicle(masina1);
        deposit1.addVehicle(masina2);

        System.out.println("Client: " + client);
        System.out.println("Deposit: " + deposit1);
    }
}