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
    void validatePower() {
    }

    @Test
    void validateSerialNumber() {
    }
}