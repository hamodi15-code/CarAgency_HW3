package graphic;

import vehicle.Vehicle;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MyThreads {
    private static MyThreads myThreads = null;
    private final Repository repository;
    private List<ChangeListener> listenerList;
    private List<Vehicle> inTestDrive = new ArrayList<>();

    private MyThreads() {
        listenerList = new ArrayList<>();
        repository = Repository.getInstance();
    }

    public static MyThreads getInstance() {
        if (myThreads == null) {
            myThreads = new MyThreads();
        }
        return myThreads;
    }

    synchronized void setDistance(Vehicle vehicle, double distance, double sleepTime) {
        inTestDrive.add(vehicle);
        new Thread(() -> {
            try {
                Thread.sleep((long) sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            vehicle.move(distance);
            repository.updateAll(false);
        }).start();
    }



    public void purchase(Vehicle vehicle) {
        new Thread(() -> {
            try {
                JOptionPane.showMessageDialog(null, "wait...");
                int delay = ThreadLocalRandom.current().nextInt(5000, 10001);
                Thread.sleep(delay);
            } catch (InterruptedException e) {}
            new PurchaseDialog(vehicle);

        }).start();
    }




}

