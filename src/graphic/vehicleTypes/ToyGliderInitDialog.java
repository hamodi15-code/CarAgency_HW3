package graphic.vehicleTypes;

import graphic.Repository;
import utils.Call;
import utils.Callback;
import vehicle.ToyGlider;
import vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ToyGliderInitDialog extends JDialog {
    private JLabel label1,label2;
    private  JTextField powerSourceText;
    private ImageIcon image1, image2;
    private JButton okDetailsButton, imageUploadButton;
    private ImageIcon selectedImage = null;
    public ToyGliderInitDialog(){
        JPanel ImagePanel = new JPanel();
        ImagePanel.setLayout(new GridLayout(2,2,0,0));
        label1 = new JLabel();
        label2 = new JLabel();
        image1 = new ImageIcon("toyglider1.jpg");
        image2 = new ImageIcon("toyglider2.jpg");
        label1.setIcon(image1);
        label2.setIcon(image2);
        MouseListener listener = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                selectedImage = (ImageIcon) ((JLabel) e.getSource()).getIcon();
                JOptionPane.showMessageDialog(null,"Image chosen successfully !");
            }
        };
        label1.addMouseListener(listener);
        label2.addMouseListener(listener);
        ImagePanel.add(label1);
        ImagePanel.add(label2);
        // default details for this type
        JPanel okPlace = new JPanel();
        okDetailsButton = new JButton("OK");
        okDetailsButton.addActionListener(e -> btnApply());
        okPlace.add(okDetailsButton);
        imageUploadButton = new JButton("Upload image..");
        imageUploadButton.addActionListener(e ->uploadImage());
        ImagePanel.add(imageUploadButton);
        add(okPlace,BorderLayout.SOUTH);
        add(ImagePanel,BorderLayout.CENTER);
        pack();
    }

    private void uploadImage() {

    }

    private void btnApply() {
        if(selectedImage == null){
            JOptionPane.showMessageDialog(null,"Select image first!");
            return;
        }
        Vehicle vehicle=new ToyGlider();

        Repository repository = Repository.getInstance();
        Callback callback = repository.addVehicle(vehicle, selectedImage);
        callback.observe(new Call() {
            @Override
            public void onFinishProcess(boolean state) {
                JOptionPane.showMessageDialog(null,"ToyGlider was added successfully !");
                setVisible(false);
            }

            @Override
            public void onStartProcess() {
                okDetailsButton.setEnabled(false);
            }
        });
    }
}
