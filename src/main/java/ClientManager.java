import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ClientManager {
    private String name;
    private ArrayList<Client> clients;

    public ClientManager(String name){
        this.name = name;
        System.out.printf("%s base created.\n", name);
        clients = new ArrayList<>();
    }

    public void printClients() {
        if(clients.isEmpty()) {
            System.out.println("Client database is empty.");
        } else {
            for (int i = 0; i < clients.size(); i++) {
                System.out.println(clients.get(i).toString());
            }
        }
    }

    public void printClientInfo(int clientNumberToPrint) {
        System.out.println(clients.get(clientNumberToPrint).toString());
    }

    public String getName() {
        return name;
    }

    public boolean addNewClient(Client client) {
        if(findClientByPhoneNumber(client.getPhoneNumber()) >= 0) {
            System.out.println("Client " + client.getName() + " " + client.getLastName() + " already exist in your database!");
            return false;
        }
        clients.add(client);
        return true;
    }

    public int findClientByPhoneNumber(String clientPhoneNumber){
        for(int i=0; i< clients.size(); i++){
            if (clients.get(i).getPhoneNumber().equals(clientPhoneNumber)){
                return i;
            }
        }
        return -1;
    }

    public List<Client> getAllClients() {
        return clients.stream().toList();
    }

    public Client queryClientByPhoneNumber(String phoneNumber) {
        int position = findClientByPhoneNumber(phoneNumber);
        if(position >= 0) {
            return this.clients.get(position);
        }
        return null;
    }
}
