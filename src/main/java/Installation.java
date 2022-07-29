import java.time.LocalDate;

public class Installation {
    private int id;
    private LocalDate date;
    private String model;
    private double power;
    private long serialNumber;
    private static int installationCounter;

    private Installation(LocalDate date, String model, double power, long serialNumber) {
        this.date = date;
        this.model = model;
        this.power = power;
        this.serialNumber = serialNumber;
    }

    public static Installation createInstallation(LocalDate date, String model, double power, long serialNumber) {
        return new Installation(date, model, power, serialNumber);
    }

}
