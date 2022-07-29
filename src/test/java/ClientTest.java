import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @Test
    @DisplayName("Should return false if name length is less than 3 characters")
    void shouldReturnFalseIfNameLengthIsLessThan3Characters() {
        String name = "Mi";
        assertFalse(Client.validateName(name));
    }

    @Test
    @DisplayName("Should return false if name consist of 5 spaces")
    void shouldReturnFalseIfNameConsistOf5Spaces() {
        String name = "     ";
        assertFalse(Client.validateName(name));
    }

    @Test
    @DisplayName("Should return true if lastName consist of 5 characters")
    void shouldReturnFalseIfLastNameConsistOf5Characters() {
        String lastName = "Nowak";
        assertTrue(Client.validateLastName(lastName));
    }

    @Test
    @DisplayName("Should return false if phoneNumber consist of 5 digits")
    void shouldReturnFalseIfPhoneNumberConsistOf5Digits() {
        String phoneNumber = "12345";
        assertFalse(Client.validatePhoneNumber(phoneNumber));
    }

    @Test
    @DisplayName("Should return true if phoneNumber consist of 9 digits")
    void shouldReturnTrueIfPhoneNumberConsistOf9Digits() {
        String phoneNumber = "123456789";
        assertTrue(Client.validatePhoneNumber(phoneNumber));
    }

    @Test
    @DisplayName("Should return false if nip consist of 5 digits")
    void shouldReturnFalseIfNIPConsistOf5Digits() {
        String nip = "12345";
        assertFalse(Client.validateNIP(nip));
    }

    @Test
    @DisplayName("Should return true if nip consist of 10 digits")
    void shouldReturnTrueIfNIPConsistOf10Digits() {
        String nip = "1234567890";
        assertTrue(Client.validateNIP(nip));
    }
}