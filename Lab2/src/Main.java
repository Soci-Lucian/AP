public class Main {
    public static void main(String[] args) {
        Client client = new Client("Soci Lucian", ClientType.PREMIUM);
        Vehicle masina1 = new Vehicle("Tesla", "Negru", 2019);
        Vehicle masina2 = new Vehicle("Dacia", "Bostan", 2007);
        Depot deposit1 = new Depot("Iasi");

        deposit1.addVehicle(masina1);
        deposit1.addVehicle(masina2);

        System.out.println("Client: " + client);
        System.out.println("Deposit: " + deposit1);
    }
}