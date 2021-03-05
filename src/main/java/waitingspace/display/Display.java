package waitingspace.display;

public class Display {

    private int idCurrentVehicle;
    private int idNextVehicle;

    public Display() {
        idCurrentVehicle = 0;
        idNextVehicle = 0;
    }

    public int getIdCurrentVehicle() {
        return idCurrentVehicle;
    }

    public int getIdNextVehicle() {
        return idNextVehicle;
    }

    public void displayCurrentVehicle(int id) {
        this.idCurrentVehicle = id;
    }

    public void displayNextVehicle(int id) {
        this.idNextVehicle = id;
    }

    public void printHeadline() {
        System.out.println("______________");
    }

    public void printUnderline() {
        System.out.println("______________");
    }
}
