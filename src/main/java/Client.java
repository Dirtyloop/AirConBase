import java.util.ArrayList;
import java.util.regex.Pattern;

public class Client {
    private int id;
    private String name;
    private String lastName;
    private Address address;
    private String phoneNumber;
    private ArrayList<Installation> installations;
    private boolean isCompany;
    private String nip;
    private static int clientCounter = 0;

    private Client(String name, String lastName, Address address, String phoneNumber, boolean isCompany, String nip) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.isCompany = isCompany;
        this.nip = nip;
        this.id = clientCounter;
        clientCounter += 1;
    }

    public static Client createClient(String name, String lastname, Address address, String phoneNumber, boolean isCompany, String nip) {
        return new Client(name, lastname, address, phoneNumber, isCompany, nip);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", installations=" + installations +
                ", isCompany=" + isCompany +
                ", nip=" + nip +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static int getClientCounter() {
        return clientCounter;
    }

    public static boolean validateName(String name) {
        if(name.isBlank() || name.length()<3) return false;
        return true;
    }

    public static boolean validateLastName(String lastName) {
        if(lastName.isBlank() || lastName.length()<3) return false;
        return true;
    }

    public static boolean validatePhoneNumber(String phoneNumber) {
        if(phoneNumber.isBlank() || !Pattern.matches("[0-9]{9}", phoneNumber)) return false;
        return true;
    }
    public static boolean validateNIP(String nip) {
        if(nip.isBlank() || !Pattern.matches("[0-9]{10}", nip)) return false;
        return true;
    }
}
