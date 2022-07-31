import java.util.ArrayList;

public class InstallationManager {
    private ArrayList<Installation> installations;

    public InstallationManager(){
        this.installations = new ArrayList<>();
    }
    public void printInstallations() {
        if(installations.isEmpty()) {
            System.out.println("Installations database is empty.");
        } else {
            for (int i = 0; i < installations.size(); i++) {
                System.out.println(installations.get(i).toString());
            }
        }
    }

}
