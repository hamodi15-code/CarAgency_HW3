package graphic;

import utils.BDStateListener;
import vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ChooseVehicleDialog extends JDialog implements MouseListener {

    private final Repository repository;
    private CarAgencyPanel panel;
    private JButton Ok;
    private int index;
    private JTextField Text1;
    private JFrame frame;
    private int imageNum = 0;
    private JPanel imagePanel;
    private List<JLabel> labelList;

    public ChooseVehicleDialog(CarAgencyPanel panel, String Title) {
        super(new JFrame(), Title, true);
        this.panel = panel;
        repository = Repository.getInstance();
        setSize(900, 800);
        setLayout(new BorderLayout());
        imagePanel = new JPanel();
        int rows = imageNum / 2;
        imagePanel.setLayout(new GridLayout(rows, 3, 15, 20));
        add(imagePanel, BorderLayout.NORTH);
        setImageList();
        setModal(false);

        repository.addOnRepChangeListener(new BDStateListener() {
            @Override
            public void onStateChange(List<Vehicle> updatedBD) {
                imagePanel.removeAll();
                setImageList();
                repaint();
                revalidate();
            }
        });
    }

    public void setImageList() {
        Map<Vehicle, ImageIcon> images = repository.getImages();
        labelList = new ArrayList<>();
        System.out.println(images.size());

        for (Map.Entry<Vehicle, ImageIcon> entry : images.entrySet()) {
            JLabel label = new JLabel();
            label.setIcon(entry.getValue());
            label.addMouseListener(this);
            label.setToolTipText(entry.getKey().toString());
            labelList.add(label);
            imagePanel.add(label);
        }
    }

    /*
    public void OperationPanel() {
        JPanel Menu = new JPanel();
        Menu.setLayout(new GridLayout(1, 3, 8, 0));
        JButton TestDrive = new JButton("Test Drive");
        JButton PurchaseVehicle = new JButton("Purchase Vehicle");
        Menu.add(TestDrive);
        Menu.add(PurchaseVehicle);
        TestDrive.addActionListener(e -> TestPanel());
        PurchaseVehicle.addActionListener(e -> BuyFunction());
        add(Menu, BorderLayout.SOUTH);
        setVisible(true);
        repaint();
    }

    public void BuyFunction() {
        MyThreads.getInstance().purchase(index);
        dispose();
        setVisible(false);
    }

    public void TestPanel() {
        TestDriveDialog testDriveDialog = new TestDriveDialog(index);
        setVisible(false);

    }
    */


    @Override
    public void mouseClicked(MouseEvent e) {
        int i = labelList.indexOf(e.getSource());
        Vehicle vehicle = repository.getVehicles().get(i);
        new VehicleFunctionsDialog(this,vehicle);
    }


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
