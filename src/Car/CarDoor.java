package Car;

public class CarDoor {
    private boolean isDoorOpen;
    private boolean isWindowOpen;

    public CarDoor(){
        this(false, false);
    }

    public CarDoor(boolean isDoorOpen, boolean isWindowOpen){
        this.isDoorOpen = isDoorOpen;
        this.isWindowOpen = isWindowOpen;
    }

    public void openDoor(){
       isDoorOpen = true;
    }

    public void closeDoor(){
        isDoorOpen = false;
    }

    public void openAndCloseDoor(){
        isDoorOpen = !isDoorOpen;
    }

    public void openWindow(){
        isWindowOpen = true;
    }

    public void closeWindow(){
        isWindowOpen = false;
    }

    public void openAndCloseWindow(){
        isWindowOpen = !isWindowOpen;
    }

    public void show(){
        System.out.println("Состояние двери: " + (isDoorOpen ? "открыта" : "закрыта"));
        System.out.println("Состояние окна: " + (isWindowOpen ? "открыто" : "закрыто"));
    }

    public void setDoorCondition(boolean isDoorOpen) {
        this.isDoorOpen = isDoorOpen;
    }

    public boolean getDoorCondition() {
        return isDoorOpen;
    }

    public void setWinCondition(boolean isWindowOpen) {
        this.isWindowOpen = isWindowOpen;
    }

    public boolean getWinCondition() {
        return isWindowOpen;
    }

}
