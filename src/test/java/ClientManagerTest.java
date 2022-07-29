import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientManagerTest {

    @Test
    @DisplayName("Should create a new client")
    public void shouldCreateANewClient() {
        Address address = new Address.Builder("3city", "Długa", "69").postalCode("80-555").province("Pomorskie").build();
        Client client = Client.createClient("Jan", "Kowalski", address, "500501502", true, "12345");
        ClientManager clientManager = new ClientManager("manager");
        clientManager.addNewClient(client);
        assertFalse(clientManager.getAllClients().isEmpty());
        assertEquals(1, clientManager.getAllClients().size());
    }

    @Test
    @DisplayName("After adding 3 clients clientCounter should equals 3")
    public void clientCounterShouleEquals3() {
        Address address = new Address.Builder("Gdańsk", "Maryli", "10").postalCode("80-123").province("Pomorskie").build();
        Client client1 = Client.createClient("Jan", "Kowalski", address, "500501501", true, "12345");
        Client client2 = Client.createClient("Pan", "Kowalski", address, "500501502", true, "12345");
        Client client3 = Client.createClient("Ban", "Kowalski", address, "500501503", true, "12345");
//        ClientManager clientManager = new ClientManager("manager");
//        clientManager.addNewClient(client);
//        assertFalse(clientManager.getAllClients().isEmpty());
        assertEquals(3, Client.getClientCounter());
    }

}