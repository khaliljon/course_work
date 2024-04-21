package kstu.fit.sib.kalandarov.autobase.utilities;

import kstu.fit.sib.kalandarov.autobase.entities.Car;
import kstu.fit.sib.kalandarov.autobase.entities.CarPassenger;
import kstu.fit.sib.kalandarov.autobase.entities.CarTruck;
import kstu.fit.sib.kalandarov.autobase.entities.Driver;
import kstu.fit.sib.kalandarov.autobase.entities.Request;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class Generator {

    private static final Random random = new Random();

    private static final String[] driverNames = {"John Doe", "Jane Smith", "Bob Johnson", "Alice Brown", "David White"};
    private static final String[] carModels = {"Toyota Camry", "Honda Accord", "Ford Focus", "Chevrolet Malibu", "Nissan Altima"};
    // TODO: enum для машин
////////////////////////////////
    // Основные методы
////////////////////////////////

    public static void generateDrivers(List<Driver> drivers, int amount, List <Car> cars) {
        for (int i = 0; i < amount; i++) {
            Driver driver = new Driver(generateRandomDriverName());
            int carAmount = random.nextInt(5)+1;
            driver.addAssignedCars(generateCars(carAmount, cars));
            drivers.add(driver);
        }
    }

    public static List<Car> generateCars(int amount, List <Car> commonCars) {
        List <Car> assignedCars = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            if (Math.random() < 0.5) {
                int seats = 1 + random.nextInt(3)+1;
                Car car = new CarPassenger(generateRandomModel(), generateRandomLicensePlate(), generateRandomBoolean(), seats);
                commonCars.add(car);
                assignedCars.add(car);
            } else {
                double liftingCapacity = (double) 1.0d + random.nextInt(999) + 1;
                Car car = new CarTruck(generateRandomModel(), generateRandomLicensePlate(), generateRandomBoolean(), liftingCapacity);
                commonCars.add(car);
                assignedCars.add(car);
            }
        }
        return assignedCars;
    }

    public static void generateRequests(List<Request> reqs, int amount) {
        for(int i = 0 ; i < amount ; i++) {
            if(Math.random() > 0.5)
                reqs.add(new Request(generateRandomModel(), generateRandomDescription(), 1 + random.nextInt(4)));
            else
                reqs.add(new Request(generateRandomModel(), generateRandomDescription(), (double) 1.0d + random.nextInt(1000)));
        }
    }

////////////////////////////////
    // Вспомогательные методы
////////////////////////////////

    public static String generateRandomModel() { // Случайная модель
        return carModels[random.nextInt(carModels.length)];
    }

    public static String generateRandomLicensePlate() {
        return String.format("%s-%d%d%d", generateRandomLetters(3), random.nextInt(10), random.nextInt(10), random.nextInt(10));
    }

    public static String generateRandomDriverName() { // Случайное имя
        return driverNames[random.nextInt(driverNames.length)];
    }

    private static String generateRandomDescription() { // Случайное описание
        String[] descriptions = {"Short trip", "Long trip", "Business trip", "Family vacation"};
        return descriptions[random.nextInt(descriptions.length)];
    }

    private static boolean generateRandomBoolean() { // Булевое значение 0/1
        return random.nextBoolean();
    }

    private static String generateRandomLetters(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char randomChar = (char) ('A' + random.nextInt(26));
            sb.append(randomChar);
        }
        return sb.toString();
    }
}
