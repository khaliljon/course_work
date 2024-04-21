package kstu.fit.sib.kalandarov.autobase.utilities;

import java.io.File;
import java.sql.SQLOutput;
import java.util.*;

import kstu.fit.sib.kalandarov.autobase.entities.*;

public class Menu {

    private static final Scanner scanner = new Scanner(System.in);

    public static void start() {
        Dispatcher disp = new Dispatcher();
        CarComparator comparator = new CarComparator();

        List<Car> cars = new ArrayList<>();
        List<Driver> drivers = new ArrayList<>();
        List<Request> requests = new ArrayList<>();
        List<Trip> completedTrips = new ArrayList<>();

        boolean exit = false;
        while (!exit) {
            clearConsole();
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить водителей");
            System.out.println("2. Добавить заявки");
            System.out.println("3. Просмотреть список водителей");
            System.out.println("4. Просмотреть список автомобилей");
            System.out.println("5. Просмотреть список заявок");
            System.out.println("6. Просмотреть отчет о выполненных поездках");
            System.out.println("7. Совершить поездки");
            System.out.println("8. Отсортировать машины");
            System.out.println("9. Удалить привязку машины к водителю");
            System.out.println("10. Работа с бинарным файлом");
            System.out.println("11. Работа с текстовым файлом");
            System.out.println("12. Выход");

            int choice = scanner.nextInt();
            clearConsole();
            switch (choice) {
                case 1:
                    System.out.println("Введите количество водителей: ");
                    int driversAmount = scanner.nextInt();
                    Generator.generateDrivers(drivers, driversAmount, cars);
                    break;
                case 2:
                    System.out.println("Введите количество заявок: ");
                    int requestsAmount = scanner.nextInt();
                    Generator.generateRequests(requests, requestsAmount);
                    break;
                case 3:
                    Reporter.print(drivers);
                    break;
                case 4:
                    Reporter.print(cars);
                    break;
                case 5:
                    Reporter.print(requests);
                    break;
                case 6:
                    Reporter.tripReport(completedTrips);
                    break;
                case 7:
                    disp.dispatchRequests(requests, drivers, completedTrips);
                    break;
                case 8:
                    clearConsole();
                    System.out.println("Выберите действие: ");
                    System.out.println("1. Отсортировать по моделям");
                    System.out.println("2. Отсортировать по габаритам");
                    int compareChoice = scanner.nextInt();
                    switch(compareChoice) {
                        case 1 -> Collections.sort(cars);
                        case 2 -> cars.sort(comparator);
                        default -> System.out.println("Некорректное значение. Выберите цифру из меню");
                    }
                    break;
                case 9:
                    clearConsole();
                    System.out.println("Введите порядковый номер водителя: ");
                    try {
                        int driverNumber = scanner.nextInt() - 1;
                        System.out.println("Введите лицензионный номер машины: "); // TODO: Сделать поиск по licensePlate
                        String plate = scanner.next();
                        drivers.get(driverNumber).removeAssignedCar(disp.findCarByLicensePlate(plate, cars));
                    }
                    catch (IndexOutOfBoundsException e) {
                        System.err.println("Такого водителя/машины не существует");
                    }
                    catch (InputMismatchException e) {
                        System.err.println("Неверно указано значение");
                    }
                    break;
                case 10: // Bin
                    clearConsole();
                    System.out.println("Выберите действие:");
                    System.out.println("1. Сохранить файл");
                    System.out.println("2. Загрузить файл");
                    int binFileChoice = scanner.nextInt();
                    switch (binFileChoice) {
                        case 1 -> FileManager.saveDataToFile(drivers, cars, requests, completedTrips);
                        case 2 -> {
                            File loadFile = new File(FileManager.getDataFile());
                            if (loadFile.exists()) {
                                FileManager.loadStateFromFile(drivers, cars, requests, completedTrips);
                            } else {
                                System.out.println("Файл не существует.");
                            }
                        }
                    }
                    break;
                case 11: // Text
                    clearConsole();
                    System.out.println("Выберите действие:");
                    System.out.println("1. Сохранить файлы");
                    System.out.println("2. Прочитать файл водителей");
                    System.out.println("3. Прочитать файл поездок");
                    int textFileChoice = scanner.nextInt();
                    switch (textFileChoice) {
                        case 1 -> {
                            FileManager.saveDriversToStringFile(drivers);
                            FileManager.saveTripsToStringFile(completedTrips);
                        }
                        case 2 -> {
                            File loadDriverTextFile = new File(FileManager.getDriversFile());
                            if (loadDriverTextFile.exists()) {
                                FileManager.printDriversFromFile();
                            } else {
                                System.out.println("Файл не существует.");
                            }
                        }
                        case 3 -> {
                            File loadTripTextFile = new File(FileManager.getTripsFile());
                            if (loadTripTextFile.exists()) {
                                FileManager.printTripsFromFile();
                            } else {
                                System.out.println("Файл не существует.");
                            }
                        }
                    }
                    break;
                case 12:
                    exit = true;
                    break;
                default:
                    System.out.println("Некорректный ввод. Пожалуйста, введите число от 1 до 9.");
                    break;
            }
            if (!exit) {
                System.out.print("Нажмите Enter для продолжения...");
                scanner.nextLine();
                scanner.nextLine();
            }
        }
        clearConsole();
        scanner.close();
        System.out.println("Программа завершена");
    }
    private static void clearConsole() {
        for (int i = 0; i < 100; i++)
            System.out.println();
    }
}