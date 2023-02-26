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

    @Test@DisplayName("Should return false if power is less than 2.0")
    void shouldReturnFalseIfPowerIsLessThan2() {
        double power = 1.99;
        assertFalse(Installation.validatePower(power));
    }

    @Test
    void validateSerialNumber() {
    }
}