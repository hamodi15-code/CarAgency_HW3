package graphic;

import utils.BDStateListener;
import utils.Callback;
import vehicle.Vehicle;

import javax.swing.*;
import java.util.*;

public class Repository {

    private static Repository instance;
    public static Repository getInstance(){
        if(instance == null) {
            instance = new Repository();
        }
        return instance;
    }
    private List<BDStateListener> listeners = new ArrayList<>();



    private Repository() {}

    private List<Vehicle> vehicles = new ArrayList<>();
    private Map<Vehicle, ImageIcon> images = new HashMap<>();


    public Callback addVehicle(Vehicle vehicle, ImageIcon image){
        Callback callback = new Callback();
        new Thread(){
            @Override
            public void run() {
                yieldToListener();
                callback.notifyOnStart();
                processing();
                vehicles.add(vehicle);
                images.put(vehicle, image);
                callback.notifyOnFinish(true);
                notifyChanges();
            }
        }.start();

        return callback;
    }

    public Callback updatedInventoryReport(){
        Callback callback = new Callback();
        new Thread(){
            @Override
            public void run() {
                yieldToListener();
                callback.notifyOnStart();
                processing();
                callback.notifyOnFinish(true);
                notifyChanges();
            }
        }.start();

        return callback;
    }

    private void yieldToListener(){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Callback removeVehicle(Vehicle vehicle){
        Callback callback = new Callback();
        new Thread(){
            @Override
            public void run() {
                yieldToListener();
                callback.notifyOnStart();
                processing();
                boolean remove = vehicles.remove(vehicle);
                images.remove(vehicle);
                callback.notifyOnFinish(remove);
                notifyChanges();
            }
        }.start();
        return callback;
    }

//    public boolean attachImage(Vehicle vehicle, ImageIcon icon){
//        if (!vehicles.contains(vehicle)) {
//            return false;
//        }
//        processing();
//        return images.put(vehicle, icon) == null;
//    }

    public Callback updateAll(boolean processing){
        Callback callback = new Callback();
        new Thread() {
            @Override
            public void run() {
                yieldToListener();
                callback.notifyOnStart();
                if(processing) processing();
                notifyChanges();
                callback.notifyOnFinish(true);
            }
        }.start();
        return callback;
    }


    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addOnRepChangeListener(BDStateListener listener){
        listeners.add(listener);
    }

    public void notifyChanges(){
        for (BDStateListener listener : listeners) {
            listener.onStateChange(vehicles);
        }
    }

    public Map<Vehicle, ImageIcon> getImages() {
        return images;
    }


    private void processing(){
        int time = (int) (Math.random() * 5 * 1000 + 3 * 1000);
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
