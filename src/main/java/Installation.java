import java.time.LocalDate;
import java.util.regex.Pattern;

public class Installation {
    private int id;
    private LocalDate date;
    private String model;
    private double power;
    private long serialNumber;
    private static int installationCounter = 0;

    private Installation(LocalDate date, String model, double power, long serialNumber) {
        this.date = date;
        this.model = model;
        this.power = power;
        this.serialNumber = serialNumber;
        this.id = installationCounter;
        installationCounter += 1;
    }

    @Override
    public String toString() {
        return "Installation{" +
                "id=" + id +
                ", date=" + date +
                ", model='" + model + '\'' +
                ", power=" + power +
                ", serialNumber=" + serialNumber +
                '}';
    }

    public static Installation createInstallation(LocalDate date, String model, double power, long serialNumber) {
        return new Installation(date, model, power, serialNumber);
    }

    public LocalDate getDate() {
        return date;
    }

    public String getModel() {
        return model;
    }

    public static boolean validateDate(String date) {
        if(date.isBlank() || !Pattern.matches("[2]{1}[0]{1}[0-2]{1}[0-9]{1}-[0-9]{2}-[0-9]{2}", date)) return false;
        return true;
    }

    public static boolean validateModel(String model) {
        if(model.isBlank() || model.length()<3) return false;
        return true;
    }

    public static boolean validatePower(double power) {
        if(power < 2.0 || power > 8.0) return false;
        return true;
    }

    public static boolean validateSerialNumber(String serialNumber) {
        if(serialNumber.isBlank() || !Pattern.matches("[0-9]{8}", serialNumber)) return false;
        return true;
    }
}
