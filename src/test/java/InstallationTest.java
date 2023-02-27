import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstallationTest {

    @Test
    void validateDate() {
    }

    @Test
    @DisplayName("Should return false if model is less than 3 characters")
    void shouldReturnFalseIfModelIsLessThan3Characters() {
        String model = "3D";
        assertFalse(Installation.validateModel(model));
    }

    @Test
    @DisplayName("Should return false if model consist of 3 spaces")
    void shouldReturnFalseIfModelConsistOf3Spaces() {
        String model = "   ";
        assertFalse(Installation.validateModel(model));
    }

    @Test
    @DisplayName("Should return true if power is beetwen 2.0 and 8.0")
    void shouldReturnTrueIfPowerIsBeetwen2And8() {
        double power = 2.0;
        assertTrue(Installation.validatePower(power));
    }

    @Test@DisplayName("Should return false if power is 1.99 (less than 2.0)")
    void shouldReturnFalseIfPowerIsLessThan2() {
        double power = 1.99;
        assertFalse(Installation.validatePower(power));
    }

    @Test@DisplayName("Should return false if power is 8.1 (over 8.0)")
    void shouldReturnFalseIfPowerIsOver8() {
        double power = 8.1;
        assertFalse(Installation.validatePower(power));
    }

    @Test
    @DisplayName("Should return false if serial number consist of 7 digits")
    void shouldReturnFalseIfSerianNumberConsistOf7Digits() {
        String serialNumber = "7654321";
        assertFalse(Installation.validateSerialNumber(serialNumber));
    }

    @Test
    @DisplayName("Should return false if serial number consist of digits and characters")
    void shouldReturnFalseIfSerialNumberConsistOfDigitsAndCharacters() {
        String serialNumber = "SN1234";
        assertFalse(Installation.validateSerialNumber(serialNumber));
    }

    @Test
    @DisplayName("Should return false if serial number consist of 9 digits")
    void shouldReturnFalseIfSerialNumberConsistOf9Digits() {
        String serialNumber = "987654321";
        assertFalse(Installation.validateSerialNumber(serialNumber));
    }

    @Test
    @DisplayName("Sould return true if serial number consist of 8 digits")
    void shouldReturnTrueIfSerialNumberConsistOf9Digits() {
        String serialNumber = "12345678";
        assertTrue(Installation.validateSerialNumber(serialNumber));
    }
}