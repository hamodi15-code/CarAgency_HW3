package graphic.vehicleTypes;

import graphic.Repository;
import utils.Call;
import utils.Callback;
import vehicle.SpyGlider;
import vehicle.Vehicle;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

public class SpyGliderInitDialog extends JDialog {
    private JLabel label1,label2;
    private  JTextField powerSourceText;
    private ImageIcon image1, image2;
    private JButton okDetailsButton, imageUploadButton;
    private ImageIcon selectedImage = null;

    public SpyGliderInitDialog(){
        JPanel ImagePanel = new JPanel();
        ImagePanel.setLayout(new GridLayout(2,1,30,30));
        label1 = new JLabel();
        label2 = new JLabel();
        image1= new ImageIcon("spyglider1.jpg");
        image2 = new ImageIcon("spyglider2.jpg");
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
        add(ImagePanel,BorderLayout.EAST);
        JPanel SpyGliderPanel = new JPanel();
        SpyGliderPanel.setLayout(new GridLayout(2,2,0,0));
        powerSourceText = new JTextField();
        SpyGliderPanel.add(new JLabel("Power Source Information:"));
        SpyGliderPanel.add(powerSourceText);
        JPanel okPlace = new JPanel();
        okDetailsButton = new JButton("OK");


        okDetailsButton.addActionListener(e -> btnApply());
        okPlace.add(okDetailsButton);

        imageUploadButton = new JButton("Upload image...");
        imageUploadButton.addActionListener(e -> uploadImage());
        SpyGliderPanel.add(imageUploadButton);
        add(okPlace,BorderLayout.SOUTH);
        add(SpyGliderPanel,BorderLayout.WEST);
        pack();
    }

    private void uploadImage() {
        FileDialog fd = new FileDialog((Frame) null, "Please choose an image:", FileDialog.LOAD);
        fd.setVisible(true);
        if (fd.getFile() == null) {
            JOptionPane.showMessageDialog(null, "No image loaded");
        }
        else {
            File f = new File(fd.getDirectory(), fd.getFile());
            try {
                Image img1 = ImageIO.read(f);
                selectedImage = new ImageIcon(img1);
//                imageUploadButton.setVisible(false);
//                label1.setVisible(false);
//                label2.setVisible(false);
                JOptionPane.showMessageDialog(null,"Image chosen successfully !");
            } catch (IOException ex) {
                System.out.println("Cannot load image");
            }
        }
    }

    private void btnApply() {
        if(selectedImage == null){
            JOptionPane.showMessageDialog(null,"Select image first!");
            return;
        }
        String chosenPowerSourceInformation =powerSourceText.getText();
        Vehicle vehicle = new SpyGlider(chosenPowerSourceInformation);
        Repository repository = Repository.getInstance();
        Callback callback = repository.addVehicle(vehicle, selectedImage);
        callback.observe(new Call() {
            @Override
            public void onFinishProcess(boolean state) {
                JOptionPane.showMessageDialog(null,"SpyGlider was added successfully !");
                setVisible(false);
            }

            @Override
            public void onStartProcess() {
                okDetailsButton.setEnabled(false);
            }
        });
    }
}
