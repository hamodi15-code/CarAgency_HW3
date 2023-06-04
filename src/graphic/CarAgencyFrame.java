package graphic;

import javax.swing.*;

public class CarAgencyFrame extends JFrame {
    public CarAgencyFrame() {
        setTitle("Car Agency");
        setSize(1300, 650);
        add(new CarAgencyPanel());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }

    public static void main(String[] args) {
        ImageIcon logo = new ImageIcon("logo.png");
        CarAgencyFrame carAgencyFrame = new CarAgencyFrame();
        carAgencyFrame.setVisible(true);
        carAgencyFrame.setIconImage(logo.getImage());

    }



    private void openAlert(String message){
        System.out.println(message);
        JOptionPane.showMessageDialog(this,
                message,
                "Warning",
                JOptionPane.INFORMATION_MESSAGE);
    }
}

