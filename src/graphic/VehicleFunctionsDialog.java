package graphic;

import vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;

public class VehicleFunctionsDialog extends JDialog{
    private ChooseVehicleDialog tempChooseVehicleDialog;
    private Vehicle tempVehicle ;
    public VehicleFunctionsDialog(ChooseVehicleDialog chooseVehicleDialog, Vehicle vehicle){
        tempChooseVehicleDialog=chooseVehicleDialog;
        tempVehicle = vehicle;
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(1, 3, 8, 0));
        JButton testDriveButton = new JButton("Test Drive");
        JButton purchaseVehicleButton = new JButton("Purchase Vehicle");
        menuPanel.add(testDriveButton);
        menuPanel.add(purchaseVehicleButton);
        testDriveButton.addActionListener(e -> testDriveFunction());
        purchaseVehicleButton.addActionListener(e -> purchaseFunction());
        tempChooseVehicleDialog.add(menuPanel, BorderLayout.SOUTH);
        tempChooseVehicleDialog.setVisible(true);
        pack();
        //setVisible(true);
        repaint();
    }
    public void purchaseFunction() {
        MyThreads.getInstance().purchase(tempVehicle);
        dispose();
        setVisible(false);
    }

    public void testDriveFunction() {
        TestDriveDialog testDriveDialog = new TestDriveDialog(tempVehicle);
        setVisible(false);

    }

}
