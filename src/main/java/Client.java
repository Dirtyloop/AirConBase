import java.util.ArrayList;

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
}
