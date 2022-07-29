import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ClientManager {
    private String name;
    private ArrayList<Client> clients;

    public ClientManager(String name){
        this.name = name;
        System.out.printf("%s base created.\n", name);
        this.clients = new ArrayList<>();
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

    public String getName() {
        return name;
    }

    public boolean addNewClient(Client client) {
        if(findClient(client.getPhoneNumber()) >= 0) {
            System.out.println("Client " + client.getName() + " " + client.getLastName() + " already exist in your database!");
            return false;
        }
        clients.add(client);
        return true;
    }

    private int findClient(String clientPhoneNumber){
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


}
