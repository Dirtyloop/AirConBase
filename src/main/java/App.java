import java.util.Scanner;

public class App {
    public static ClientManager clientManager = new ClientManager("ContactBase");
    public static Scanner scan = new Scanner(System.in);
    static int choice = -1;

    public static void main(String[] args) {

        while (choice != 0) {
            System.out.println("Welcome to our " + clientManager.getName() + " application.");
            System.out.println("");
            System.out.println("0. Quit");
            System.out.println("1. Print clients");
            System.out.println("2. Add new client");
            System.out.println("3. Print installations");
            System.out.println("4. Add new installation");
            System.out.println("5. Find customer");
            choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 0: {
                    System.out.println("Quit");
                    break;
                }
                case 1: {
                    System.out.println("Print clients");
                    clientManager.printClients();
                    break;
                }
                case 2: {
                    System.out.println("Add new client");
                    addNewClient();
                    break;
                }
                case 3: {
                    System.out.println("Print installations");
                    //printCustomers();
                    break;
                }
                case 4: {
                    System.out.println("Add new installation");
                    //addNewCustomer();
                    break;
                }
                case 5: {
                    System.out.println("Find customer");
                    //checkContact();
                    break;
                }
                default: {
                    System.out.println("Choose from 0 to 5!");
                    break;
                }
            }
        }
    }
    private static void addNewClient() {
        System.out.println("Enter name of new client: ");
        String name = scan.nextLine();
        System.out.println("Enter lastname of new client: ");
        String lastname = scan.nextLine();
        System.out.println("Enter phone number of new client: ");
        String phoneNumber = scan.nextLine();
        System.out.println("Enter NIP of new client: ");
        String nip = scan.nextLine();
        boolean isCompany = true;
        Address address = new Address.Builder("3city", "Długa", "69").postalCode("80-555").province("Pomorskie").build();
        Client newClient = Client.createClient(name, lastname, address, phoneNumber, isCompany, nip);
        if(clientManager.addNewClient(newClient)) {
            System.out.println(newClient.getName() + " " + newClient.getLastName() + " added to client base.");
        } else {
            System.out.println("Cannot add " + newClient.getName() + " " + newClient.getLastName() + " to client base.");
        }
    }
}
