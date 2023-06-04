package graphic;

import utils.Call;
import utils.Callback;
import vehicle.Amphibious;
import vehicle.HybridPlane;
import vehicle.MarineVehicle;
import vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;

/**

 The CarAgencyPanel class represents a panel for a car agency application.

 It provides a user interface with various buttons and functionalities

 related to managing vehicles in the agency.
 */
public class CarAgencyPanel extends JPanel {
    private final Repository repository;
    public String chosenType;
    private JButton resetKmButton, resetFlagButton, addVehicleButton,chooseVehicleButton, currentInventoryButton, exitButton;

    /**

     Constructs a CarAgencyPanel object.
     Sets the layout of the panel and initializes the repository.
     Creates the main menu bar for the car agency application.
     */
    public CarAgencyPanel() {
        this.setLayout(new BorderLayout());
        repository = Repository.getInstance();
        createMenuBar();
    }

    /**

     Creates the main menu bar for the car agency application.

     Adds a background image, buttons for different operations,

     and sets up event listeners for these buttons.
     */
    private void createMenuBar() {
        JLabel label = new JLabel();
        ImageIcon image = new ImageIcon("back1.png");
        label.setIcon(image);
        this.add(label);
        JPanel mainMenu = new JPanel();
        mainMenu.setLayout(new GridLayout(1, 6, 8, 0));
        addVehicleButton = new JButton("Add vehicle");
        chooseVehicleButton = new JButton("Choose exist vehicle");
        resetKmButton = new JButton("Reset KM for all vehicles");
        resetFlagButton = new JButton("Reset flag for all vehicles");
        currentInventoryButton = new JButton("Current inventory report");
        exitButton = new JButton("Exit");
        addVehicleButton.setForeground(new Color(161, 109, 63));
        chooseVehicleButton.setForeground(new Color(161, 109, 63));
        resetKmButton.setForeground(new Color(161, 109, 63));
        resetFlagButton.setForeground(new Color(161, 109, 63));
        exitButton.setForeground(new Color(161, 109, 63));
        currentInventoryButton.setForeground(new Color(161, 109, 63));

        //activate the main menu
        mainMenu.add(addVehicleButton);
        addVehicleButton.addActionListener(e -> connectToAddVehicleDialog());
        mainMenu.add(chooseVehicleButton);
        chooseVehicleButton.addActionListener(e -> connectToChooseVehicleDialog());
        mainMenu.add(resetKmButton);
        resetKmButton.addActionListener(e -> ResetKMFunction());
        mainMenu.add(resetFlagButton);
        resetFlagButton.addActionListener(e -> connectToFlagChangeDialog());
        currentInventoryButton.addActionListener(e -> connectToInventoryDialog());
        mainMenu.add(currentInventoryButton);
        mainMenu.add(exitButton);
        exitButton.addActionListener(e -> System.exit(0));
        this.add(mainMenu, BorderLayout.NORTH);
    }

    /**

     Opens a dialog box showing the current inventory report
     if there are vehicles registered in the car agency.
     */
    public void connectToInventoryDialog() {
        if (repository.getVehicles().size() == 0) {
            JOptionPane.showMessageDialog(null, "No Vehicles Registered In Car Agency !");
            return;
        }
        ReportDialog report = new ReportDialog("Current inventory report");
        report.setVisible(true);

    }

    /**

     Resets the kilometer reading for all vehicles in the car agency.
     Updates the database asynchronously and displays appropriate messages.
     */
    public void ResetKMFunction() {
        if (repository.getVehicles().size() == 0) {
            JOptionPane.showMessageDialog(null, "No Vehicles Registered In Car Agency !");
            return;
        }
        // Go through the  list of vehicles and reset the kilometer.
        for (Vehicle vehicle : repository.getVehicles()) {
            vehicle.resetKilometrage();
        }
        Callback callback = repository.updateAll(true);
        callback.observe(new Call() {
            @Override
            public void onFinishProcess(boolean state) {
                JOptionPane.showMessageDialog(null, "Reset KM for All Vehicles successfully !");
                resetKmButton.setEnabled(true);
            }
            @Override
            public void onStartProcess() {
                resetKmButton.setEnabled(false);
                JOptionPane.showMessageDialog(null, "DataBase is updating now...");
            }
        });
    }

    /**

     Opens a dialog box for changing the flag of marine vehicles.

     Updates the database asynchronously and displays appropriate messages.
     */
    public void connectToFlagChangeDialog() {
        boolean doesMarineExist=false;
        if (repository.getVehicles().size() == 0) {
            JOptionPane.showMessageDialog(null, "No Vehicles Registered In Car Agency !");
            return;
        }

        for (Vehicle vehicle : repository.getVehicles()) {
            if(vehicle instanceof MarineVehicle || vehicle instanceof Amphibious || vehicle instanceof HybridPlane) {
                doesMarineExist = true;
            }
        }
        if(doesMarineExist==false)
        {
            JOptionPane.showMessageDialog(null, "No marine vehicles registered in car agency !");
            return;
        }

        FlagChangeDialog flagChange = new FlagChangeDialog(this, "Flag Changing ");
        flagChange.setVisible(true);
        Callback callback = repository.updateAll(true);
        callback.observe(new Call() {
            @Override
            public void onFinishProcess(boolean state) {
                JOptionPane.showMessageDialog(null, "Reset flag for all MarineVehicles successfully !");
                resetFlagButton.setEnabled(true);
            }
            @Override
            public void onStartProcess() {
                resetFlagButton.setEnabled(false);
                JOptionPane.showMessageDialog(null, "DataBase is updating now...");
            }
        });


    }

    /**

     Opens a dialog box for choosing a vehicle from the existing vehicles in the car agency.
     */
    public void connectToChooseVehicleDialog() {
        if (repository.getVehicles().size() == 0) {
            JOptionPane.showMessageDialog(null, "No Vehicles Registered In Car Agency !");
            return;
        }
        ChooseVehicleDialog chooseVehicle = new ChooseVehicleDialog(this, "Choose Vehicle");
        chooseVehicle.setVisible(true);

    }
    /**

     Opens a dialog box for adding a new vehicle type.
     */
    public void connectToAddVehicleDialog() {
        AddVehicleTypeDialog CarType = new AddVehicleTypeDialog(this, "Choose car type:");
        CarType.setVisible(true);
        CarType.dispose();

    }

}
