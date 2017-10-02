package Car;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Создала динамические масссивы, для добавления обьектов
        ArrayList<CarDoor> doors = new ArrayList<>();
        ArrayList<CarWheel> wheels = new ArrayList<>();
        ArrayList<Car> cars = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        choiceClass(in, doors, wheels, cars);
    }

    public static void choiceClass(Scanner in, ArrayList<CarDoor> doors, ArrayList<CarWheel> wheels,  ArrayList<Car> cars) {
        System.out.println("Укажите клас с которым хотите работать (введите соответствующий ему номер).");
        System.out.println("1. CarDoor" + "\n" + "2. CarWheel" + "\n" + "3. Car");
        if (!in.hasNextInt()) System.out.println("Вы ввели не число!");
        int taskNumber = in.nextInt();
        if ((taskNumber < 1) || (taskNumber > 3)) {
            System.out.println("Не допустимый номер!");
            return;
        }
        if (taskNumber == 1){
            System.out.println("Если желаете передать параметры в конструктор, введите \"yes\": ");
            boolean confirm = in.next().equals("yes");
            if (confirm) {
                System.out.println("Введите состояние двери(открыта - true/закрыта - false)");
                boolean isDoorOpen = in.nextBoolean();
                System.out.println("Введите состояние окна(открыто - true/закрыто - false)");
                boolean isWindowOpen = in.nextBoolean();
                boolean added = doors.add(new CarDoor(isDoorOpen, isWindowOpen));  // Добавили обьект в конец списка
                if (added) {
                    CarDoor door = doors.get(doors.size()-1);   // Если обьект добавлен присваеваем ссылку на него
                    methodsCarDoor(door, in);
                }
            }else {                                         // Если параметры не переданы вызываем пустой конструтор
                boolean added = doors.add(new CarDoor());
                if (added) {
                    CarDoor door = doors.get(doors.size()-1);
                    methodsCarDoor(door, in);
                }
            }
        }
        if(taskNumber == 2){
            System.out.println("Если желаете передать параметры в конструктор, введите \"yes\": ");
            boolean confirm = in.next().equals("yes");
            if (confirm) {
                System.out.println("Введите состояние целосности шины (дробное число от 0-стерта до 1-новая)");
                double conditionWheel = in.nextDouble();
                if ((conditionWheel < 0) || (conditionWheel > 1)) {
                    System.out.println("Число не входит в диапазон [0;1]");
                } else {
                    boolean added = wheels.add(new CarWheel(conditionWheel));
                    if (added) {
                        CarWheel wheel = wheels.get(wheels.size()-1);
                        methodsCarWheel(wheel, in);
                    }
                }
            }else {
                boolean added = wheels.add(new CarWheel());
                if (added) {
                    CarWheel wheel = wheels.get(wheels.size()-1);
                    methodsCarWheel(wheel, in);
                }
            }
        }
        if (taskNumber == 3){
            System.out.println("Если желаете передать все параметры в конструктор, введите \"yes\": ");
            boolean confirm = in.next().equals("yes");
            if (confirm) {
                System.out.print("Введите дату производства: ");
                String dateManufacture = in.next().trim();
                System.out.print("Введите тип двигателя: ");
                String engineType = in.next().trim();
                System.out.print("Введите максимальную скорость: ");
                int fullSpeed = in.nextInt();
                System.out.print("Введите время разгона до 100км/ч: ");
                double acceleration = in.nextDouble();
                System.out.print("Введите пассажировместимость: ");
                int numbersPassengers = in.nextInt();
                System.out.print("Введите кол-во пассажиров внутри в данный момент: ");
                int numbersCurrently = in.nextInt();
                System.out.print("Введите текущую скорость: ");
                int currentSpeed = in.nextInt();
                boolean added = cars.add(new Car(dateManufacture, engineType, fullSpeed, acceleration,
                                numbersPassengers, numbersCurrently, currentSpeed ));
                if (added) {
                    Car car = cars.get(cars.size() - 1);
                    methodsCar(car, in);
                }
            }else {
                System.out.print("Введите дату производства: ");
                String dateManufacture = in.nextLine().trim();
                boolean added = cars.add(new Car(dateManufacture));
                if (added) {
                    Car car = cars.get(cars.size() - 1);
                    methodsCar(car, in);
                }
            }
        }
    }

    public static void methodsCarDoor(CarDoor door, Scanner in) {
        System.out.println("Укажите метод с которым хотите работать (введите соответствующий ему номер).");
        System.out.println("1. Открыть дверь" + "\n" + "2. Закрыть дверь" + "\n" + "3. Открыть/закрыть дверь");
        System.out.println("4. Открыть окно" + "\n" + "5. Закрыть окно" + "\n" + "6. Открыть/закрыть окно");
        System.out.println("7. Вывести данные об объекте");
        if (!in.hasNextInt()) System.out.println("Вы ввели не число!");
        int taskNumber = in.nextInt();
        if ((taskNumber < 1) || (taskNumber > 7)) {
            System.out.println("Не допустимый номер!");
            return;
        }
        // Вызов методов
        if (taskNumber == 1) door.openDoor();
        if (taskNumber == 2) door.closeDoor();
        if (taskNumber == 3) door.openAndCloseDoor();
        if (taskNumber == 4) door.openWindow();
        if (taskNumber == 5) door.closeWindow();
        if (taskNumber == 6) door.openAndCloseWindow();
        if (taskNumber == 7) door.show();

        System.out.println("Если хотите продолжить выполнение методов, введите \"yes\": ");
        boolean confirm = in.next().equals("yes");
        if (confirm) {
            methodsCarDoor(door, in);
        }
    }

    public static void methodsCarWheel(CarWheel wheel, Scanner in) {
        System.out.println("Укажите метод с которым хотите работать (введите соответствующий ему номер).");
        System.out.println("1. Сменить шину на новую" + "\n" + "2. Стереть шину на X%" + "\n" + "3. Получить состояние");
        System.out.println("4. Вывести данные об объекте");
        if (!in.hasNextInt()) System.out.println("Вы ввели не число!");
        int taskNumber = in.nextInt();
        if ((taskNumber < 1) || (taskNumber > 4)) {
            System.out.println("Не допустимый номер!");
            return;
        }
        // Вызов методов
        if (taskNumber == 1) wheel.changeWheel();
        if (taskNumber == 2) {
            System.out.print("Введите X (к-во процентов):");
            wheel.eraseWheel(in.nextInt());
        }
        if (taskNumber == 3) wheel.condition();
        if (taskNumber == 4) wheel.show();

        System.out.println("Если хотите продолжить выполнение методов, введите \"yes\": ");
        boolean confirm = in.next().equals("yes");
        if (confirm) {
            methodsCarWheel(wheel, in);
        }
    }

    public static void methodsCar(Car car, Scanner in) {
        System.out.println("Укажите метод с которым хотите работать (введите соответствующий ему номер).");
        System.out.println("1. Изменить текущую скорость" + "\n" + "2. Посадить 1 пассажира в машину" + "\n"
                            + "3. Высадить 1 пассажира");
        System.out.println("4. Высадить всех пассажиров" + "\n" + "5. Получить дверь по индексу" + "\n"
                            + "6. Получить колесо по индексу");
        System.out.println("7. Снять все колеса с машины" + "\n" + "8. Установить на машину X новых колес" + "\n"
                            + "9. Вычислить текущую возможную максимальную скорость");
        System.out.println("10. Добавить дверь" + "\n" + "11. Добавить колесо");
        System.out.println("12. Вывести данные об объекте");
        if (!in.hasNextInt()) System.out.println("Вы ввели не число!");
        int taskNumber = in.nextInt();
        if ((taskNumber < 1) || (taskNumber > 12)) {
            System.out.println("Не допустимый номер!");
            return;
        }
        // Вызов методов
        if (taskNumber == 1) {
            System.out.print("Введите текущую скорость:");
            car.changeSpeed(in.nextInt());
        }
        if (taskNumber == 2) car.addPassenger();
        if (taskNumber == 3) car.disembarkPassenger();
        if (taskNumber == 4) car.disembarkAll();
        if (taskNumber == 5) {
            int countDoors = car.returnCountDoors();
            if (countDoors == 0) {
                System.out.println("Массив дверей пустой!");
            }else {
                System.out.print("Введите идекс:");
                car.returnDoor(in.nextInt());
            }
        }
        if (taskNumber == 6) {
            int countWheels = car.returnCountWheels();
            if (countWheels == 0) {
                System.out.println("Массив колес пустой!");
            }else {
                System.out.print("Введите идекс:");
                car.returnWheel(in.nextInt());
            }
        }
        if (taskNumber == 7) car.removeWheels();
        if (taskNumber == 8) {
            System.out.print("Введите к-во колес:");
            car.addWheels(in.nextInt());
        }
        if (taskNumber == 9) car.maxSpeed();
        if (taskNumber == 10) car.addDoor();    // Создала методы по добавлению дверей и колес
        if (taskNumber == 11) car.addWheel();
        if (taskNumber == 12) car.show();

        System.out.println("Если хотите продолжить выполнение методов, введите \"yes\": ");
        boolean confirm = in.next().equals("yes");
        if (confirm) {
            methodsCar(car, in);
        }
    }

}
