package Car;
import java.util.ArrayList;

public class Car{
    private final String DATE_MANUFACTURE;
    private String engineType;
    private int fullSpeed;
    private double acceleration;
    private int numbersPassengers;
    private int numbersCurrently;
    private int currentSpeed;

    // Создание динамических массивов для обьектов
    private ArrayList<CarWheel> wheels = new ArrayList<>();
    private ArrayList<CarDoor> doors = new ArrayList<>();

    public Car(String DATE_MANUFACTURE){
        this.DATE_MANUFACTURE = DATE_MANUFACTURE;
    }

    public Car(String DATE_MANUFACTURE, String engineType, int fullSpeed, double acceleration,
               int numbersPassengers, int numbersCurrently, int currentSpeed){
        this.DATE_MANUFACTURE = DATE_MANUFACTURE;
        this.engineType = engineType;
        this.fullSpeed = fullSpeed;
        this.acceleration = acceleration;
        this.numbersPassengers = numbersPassengers;
        this.numbersCurrently = numbersCurrently;
        this.currentSpeed = currentSpeed;
    }

    public void changeSpeed(int currentSpeed){
        this.currentSpeed =  currentSpeed;
    }

    public void addPassenger(){
        numbersCurrently++;
    }

    public void disembarkPassenger(){
        if (numbersCurrently > 0) numbersCurrently--;
    }

    public void disembarkAll(){
        numbersCurrently = 0;
    }

    public void addWheel(){             // Метод для добавления обьекта CarWheel в массив wheels
        wheels.add(new CarWheel());     // для конструктора по умолчанию
    }

    public void addWheel(double conditionWheel){    // Перегрузка метода
        wheels.add(new CarWheel(conditionWheel));
    }

    public void addDoor(){          // Метод для добавления обьекта CarDoor в массив doors
        doors.add(new CarDoor());   // для конструктора по умолчанию
    }

    public void addDoor(boolean isDoorOpen, boolean isWindowOpen){  // Перегрузка метода
        doors.add(new CarDoor(isDoorOpen, isWindowOpen));
    }

    public int returnCountDoors(){   //Возвращаем количество дверей в масиве,
        return doors.size();         // для дальнейшей проверки массива на пустоту
    }

    public int returnCountWheels(){   //Возвращаем количество колес в масиве,
        return wheels.size();         // для дальнейшей проверки массива на пустоту
    }

    public CarDoor returnDoor(int index){   //Возвращаем CarDoor по индексу
        return doors.get(index);
    }

    public CarWheel returnWheel(int index){ //Возвращаем CarWheel по индексу
        return wheels.get(index);
    }

    public void removeWheels(){  // Очистка массива Wheels(сняли все колеса с машины)
        wheels.clear();
    }

    public void addWheels(int numberWheels){    // Устанавливаем X новых колес
        for (int i = 0; i < numberWheels; i++){
            addWheel();
        }
    }

    public double maxSpeed(){
        if (numbersCurrently == 0) return 0;
        double maxWornWheel = wheels.get(0).getWheelCondition();
        for (int i = 1; i < wheels.size(); i++){
            double temp = wheels.get(i).getWheelCondition();
            if (temp < maxWornWheel) maxWornWheel = temp;
        }
        return fullSpeed * maxWornWheel;
    }

    public void show(){
        double maxSpeed = maxSpeed();
        System.out.println("Дата производства: " + DATE_MANUFACTURE);
        System.out.println("Тип двигателя: " + engineType);
        System.out.println("Максимальная скорость машины: " + fullSpeed);
        System.out.println("Время разгона до 100км/ч: " + acceleration);
        System.out.println("Пассажировместимость: " + numbersPassengers);
        System.out.println("Количество пасажиров внутри в данный момент: " + numbersCurrently);
        System.out.println("Текущая скорость: " + currentSpeed);
        System.out.println("Возможная максимальная скорость: " + maxSpeed);
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setFullSpeed(int fullSpeed) {
        this.fullSpeed = fullSpeed;
    }

    public int getFullSpeed() {
        return fullSpeed;
    }

    public void setAcceleration(double acceleration) {
        this.acceleration = acceleration;
    }

    public double getAcceleration() {
        return acceleration;
    }

    public void setNumbersPassengers(int numbersPassengers) {
        this.numbersPassengers = numbersPassengers;
    }

    public int getNumbersPassengers() {
        return numbersPassengers;
    }

    public void setNumbersCurrently(int numbersCurrently) {
        this.numbersCurrently = numbersCurrently;
    }

    public int getNumbersCurrently() {
        return  numbersCurrently;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public int getCurrentSpeed() {
        return  currentSpeed;
    }

}
