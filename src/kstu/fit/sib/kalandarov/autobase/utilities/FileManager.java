package kstu.fit.sib.kalandarov.autobase.utilities;

import java.io.*;
import java.util.List;


import kstu.fit.sib.kalandarov.autobase.entities.Car;
import kstu.fit.sib.kalandarov.autobase.entities.Driver;
import kstu.fit.sib.kalandarov.autobase.entities.Request;
import kstu.fit.sib.kalandarov.autobase.entities.Trip;
@SuppressWarnings("unchecked")

public class FileManager {

    private static String DATA_FOLDER = "src" + File.separator + "kstu" + File.separator + "fit" + File.separator
            + "sib" + File.separator + "kalandarov" + File.separator + "autobase" + File.separator + "data" + File.separator;
    private static String DATA_FILE = DATA_FOLDER + "save.dat";
    private static String DRIVERS_FILE = DATA_FOLDER + "drivers.txt";
    private static String TRIPS_FILE = DATA_FOLDER + "trips.txt";

    public static String getDataFile() {
        return DATA_FILE;
    }
    public static String getDriversFile() {
        return DRIVERS_FILE;
    }
    public static String getTripsFile() {
        return TRIPS_FILE;
    }

    public static void saveDataToFile(List<Driver> drivers, List<Car> cars, List<Request> requests, List<Trip> completedTrips) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            outputStream.writeObject(cars);
            outputStream.writeObject(drivers);
            outputStream.writeObject(requests);
            outputStream.writeObject(completedTrips);
            System.out.println("Информация сохранена в файл " + DATA_FILE);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении состояния: " + e.getMessage());
        }
    }

    public static void loadStateFromFile(List<Driver> drivers, List<Car> cars, List<Request> requests, List<Trip> completedTrips) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            cars.clear();
            drivers.clear();
            requests.clear();
            completedTrips.clear();
            cars.addAll((List<Car>) inputStream.readObject());
            drivers.addAll((List<Driver>) inputStream.readObject());
            requests.addAll((List<Request>) inputStream.readObject());
            completedTrips.addAll((List<Trip>) inputStream.readObject());
            System.out.println("Состояние загружено из файла " + DATA_FILE);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке состояния: " + e.getMessage());
        }
    }
    public static void saveDriversToStringFile(List<Driver> drivers) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(DRIVERS_FILE))) {
            for (Driver driver : drivers)
                writer.println(drivers.toString());
            System.out.println("Водители сохранены в файл " + DRIVERS_FILE);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении водителей: " + e.getMessage());
        }
    }
    public static void saveTripsToStringFile(List<Trip> trips) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(TRIPS_FILE))) {
            for (Trip trip : trips)
                writer.println(trip.toString());
            System.out.println("Поездки сохранены в файл " + TRIPS_FILE);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении поездок: " + e.getMessage());
        }
    }
    public static void printDriversFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(DRIVERS_FILE))) {
            String line;
            System.out.println("Информация о водителях из файла " + DRIVERS_FILE + ":");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении информации о водителях из файла: " + e.getMessage());
        }
    }
    public static void printTripsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(TRIPS_FILE))) {
            String line;
            System.out.println("Информация о поездках из файла " + TRIPS_FILE + ":");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении информации о поездках из файла: " + e.getMessage());
        }
    }
}
