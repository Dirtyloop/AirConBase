import java.io.Serial;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static ClientManager clientManager = new ClientManager("ContactBase");
    public static InstallationManager installationManager = new InstallationManager();

    public static Scanner scan = new Scanner(System.in);
    static int choice = -1;

    public static void main(String[] args) {

        while (choice != 0) {
            System.out.println("");
            System.out.println("Welcome to our " + clientManager.getName() + " application. Please choose your option:");
            System.out.println("");
            System.out.println("0. Quit");
            System.out.println("1. Print clients");
            System.out.println("2. Add new client");
            System.out.println("3. Print installations");
            System.out.println("4. Add new installation");
            System.out.println("5. Print client info");
            try {
                choice = scan.nextInt();
            }
            catch (InputMismatchException ex) {
                System.out.print("Only numbers are allowed. ");
            }
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
                    printInstallations();
                    break;
                }
                case 4: {
                    System.out.println("Add new installation");
                    addNewInstallation();
                    break;
                }
                case 5: {
                    System.out.println("Print client info");
                    printClient();
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
        String name;
        String lastName;
        String phoneNumber;
        String nip;
        String city;
        String street;
        String houseNumber;
        String postalCode;
        String province;
        do {
            System.out.print("Enter the name of the new client: (min 3 chars) ");
            name = scan.nextLine();

        } while (!Client.validateName(name));
        do {
            System.out.print("Enter the lastname of the new client: (min 3 chars) ");
            lastName = scan.nextLine();

        } while (!Client.validateLastName(lastName));
        do {
            System.out.print("Enter the phone number of the new client: (exactly 9 digits) ");
            phoneNumber = scan.nextLine();
        } while (!Client.validatePhoneNumber(phoneNumber));
        do {
            System.out.print("Enter the NIP number of the new client: (exactly 10 digits) ");
            nip = scan.nextLine();
        } while (!Client.validateNIP(nip));
        do {
            System.out.print("Enter city: (min 3 chars) ");
            city = scan.nextLine();
        } while (!Address.validateCity(city));
        do {
            System.out.print("Enter street: (min 3 chars) ");
            street = scan.nextLine();
        } while (!Address.validateStreet(street));
        do {
            System.out.print("Enter house number: ");
            houseNumber = scan.nextLine();
        } while (!Address.validateHouseNumber(houseNumber));
        do {
            System.out.print("Enter postal code: (dd-ddd or leave empty) ");
            postalCode = scan.nextLine();
        } while (!Address.validatePostalCode(postalCode));
        do {
            System.out.print("Enter province: (not required) ");
            province = scan.nextLine();
        } while (!Address.validateProvince(province));

        Address address = new Address.Builder(city, street, houseNumber).postalCode(postalCode).province(province).build();
        boolean isCompany = true;
        Client newClient = Client.createClient(name, lastName, address, phoneNumber, isCompany, nip);
        if(clientManager.addNewClient(newClient)) {
            System.out.println(newClient.getName() + " " + newClient.getLastName() + " added to client base.");
        } else {
            System.out.println("Cannot add " + newClient.getName() + " " + newClient.getLastName() + " to client base.");
        }
    }

    private static void printInstallations(){
        System.out.println("Enter phone number of client to print installations from: ");
        String phoneNumber = scan.nextLine();
        Client clientToPrint = clientManager.queryClientByPhoneNumber(phoneNumber);
        if(clientToPrint == null) {
            System.out.println("Client not found.");
            return;
        }
        clientToPrint.installationManager.printInstallations();
    }

    private static void printClient(){
        System.out.println("Enter phone number of client to print: ");
        String phoneNumber = scan.nextLine();
        int clientNumberToPrint = clientManager.findClientByPhoneNumber(phoneNumber);
        if(clientNumberToPrint == -1) {
            System.out.println("Client not found.");
        } else {
            clientManager.printClientInfo(clientNumberToPrint);
        }
    }

    private static void addNewInstallation() {
        String date;
        LocalDate localDate;
        String model;
        double power;
        long serialNumber;
        String serial;

        System.out.println("Enter phone number of client to add installation: ");
        String phoneNumber = scan.nextLine();
        Client clientToAddInstallation = clientManager.queryClientByPhoneNumber(phoneNumber);
        if(clientToAddInstallation == null) {
            System.out.println("Client not found.");
            return;
        }

        do {
            System.out.print("Enter the date of the new installation: (yyyy-mm-dd) ");
            date = scan.nextLine();
        } while (!Installation.validateDate(date));
        localDate = LocalDate.parse(date);
        do {
            System.out.print("Enter the model of the new installation: (min 3 chars) ");
            model = scan.nextLine();

        } while (!Installation.validateModel(model));
        do {
            System.out.print("Enter the power of the new installation: ");
            power = scan.nextDouble();
            scan.nextLine();
        } while (!Installation.validatePower(power));
        do {
            System.out.print("Enter the serial number of the new installation: (exactly 8 digits) ");
            serial = scan.nextLine();
        } while (!Installation.validateSerialNumber(serial));
        serialNumber = Long.valueOf(serial);

        Installation newInstallation = Installation.createInstallation(localDate, model, power, serialNumber);

        if(clientToAddInstallation.installationManager.addNewInstallation(newInstallation)) {
            System.out.println(newInstallation.getModel() + " installed on " + newInstallation.getDate() + " added to installation base.");
        } else {
            System.out.println("Cannot add " + newInstallation.getModel() + " installed on " + newInstallation.getDate() + " to installation base.");
        }
    }

}