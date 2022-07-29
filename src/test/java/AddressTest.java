import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @Test
    @DisplayName("Should return false if city length is less than 3 characters")
    void shouldReturnFalseIfCityLengthIsLessThan3Characters() {
        String city = "Ci";
        assertFalse(Address.validateCity(city));
    }

    @Test
    @DisplayName("Should return false if city consist of 5 spaces")
    void shouldReturnFalseIfCityConsistOf5Spaces() {
        String city = "     ";
        assertFalse(Address.validateCity(city));
    }

    @Test
    @DisplayName("Should return true if city is 'Gdansk'")
    void shouldReturnTrueIfCityIsGdansk() {
        String city = "Gdansk";
        assertTrue(Address.validateCity(city));
    }

    @Test
    @DisplayName("Should return false if street is empty")
    void shouldReturnFalseIfStreetIsEmpty() {
        String street = "";
        assertFalse(Address.validateStreet(street));
    }

    @Test
    @DisplayName("Should return true if postalCode is empty")
    void shouldReturnTrueIfPostalCodeIsEmpty() {
        String postalCode = "";
        assertTrue(Address.validatePostalCode(postalCode));
    }

    @Test
    @DisplayName("Should return true if postalCode is '80-123'")
    void shouldReturnTrueIfPostalCodeIsCorrect() {
        String postalCode = "80-123";
        assertTrue(Address.validatePostalCode(postalCode));
    }
    @Test
    @DisplayName("Should return false if postalCode is '800-123'")
    void shouldReturnFalseIfPostalCodeIsIncorrect() {
        String postalCode = "800-123";
        assertFalse(Address.validatePostalCode(postalCode));
    }
}