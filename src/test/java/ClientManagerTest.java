import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientManagerTest {

    @BeforeEach
    void beforeEach() {
        Client.setClientCounter(0);
    }

    @Test
    @DisplayName("Should create a new client")
    public void shouldCreateANewClient() {
        Address address = new Address.Builder("3city", "Długa", "69").postalCode("80-555").province("Pomorskie").build();
        Client client = Client.createClient("Jan", "Kowalski", address, "500501502", true, "1234567890");
        ClientManager clientManager = new ClientManager("manager");
        clientManager.addNewClient(client);
        assertFalse(clientManager.getAllClients().isEmpty());
        assertEquals(1, clientManager.getAllClients().size());
    }

    @Test
    @DisplayName("After adding 3 clients clientCounter should equals 3")
    public void clientCounterShouleEquals3() {
        Address address = new Address.Builder("3city", "Długa", "69").postalCode("80-555").province("Pomorskie").build();
        Client client1 = Client.createClient("Jan", "Kowalski", address, "500501501", true, "1234567890");
        Client client2 = Client.createClient("Pan", "Kowalski", address, "500501502", true, "1234567890");
        Client client3 = Client.createClient("Ban", "Kowalski", address, "500501503", true, "1234567890");
        assertEquals(3, Client.getClientCounter());
    }

    @Test
    @DisplayName("FindClient should find client by phoneNumber")
    public void shouldFindClientByPhoneNumber() {
        Address address = new Address.Builder("3city", "Długa", "69").postalCode("80-555").province("Pomorskie").build();
        Client client1 = Client.createClient("Jan", "Kowalski", address, "500501501", true, "1234567890");
        Client client2 = Client.createClient("Pan", "Kowalski", address, "500501502", true, "1234567890");
        Client client3 = Client.createClient("Ban", "Kowalski", address, "500501503", true, "1234567890");
        ClientManager clientManager = new ClientManager("manager");
        clientManager.addNewClient(client1);
        clientManager.addNewClient(client2);
        clientManager.addNewClient(client3);
        String phoneNumber = "500501502";
        assertEquals(1, clientManager.findClientByPhoneNumber(phoneNumber));
    }



}