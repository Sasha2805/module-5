package Car;

public class CarWheel {
    private double conditionWheel;

    public CarWheel(){
        conditionWheel = 1;
    }

    public CarWheel(double conditionWheel){
        this.conditionWheel = conditionWheel;
    }

    public void changeWheel(){
        conditionWheel = 1;
    }

    public void eraseWheel(double x){
        conditionWheel %= x / 100;
    }

    public double condition(){
        return conditionWheel;
    }

    public void show() {
        System.out.println("Состояние целосности шины: " + conditionWheel);
    }

    public void setWheelCondition(double conditionWheel) {
        this.conditionWheel = conditionWheel;
    }

    public double getWheelCondition() {
        return conditionWheel;
    }

}
