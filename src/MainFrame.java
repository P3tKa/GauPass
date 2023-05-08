import javax.swing.*;

import com.ui.gauPass.UIconstants;

import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
 
public class MainFrame extends JFrame {
    JFrame frame;
    // final private Font labelFont = new Font("Gill Sans Ultra Bold", Font.ITALIC, 24);


    public void initialize() {
        setUndecorated(true);

        setSize(1150, 400);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(300, 400));

        // setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        setVisible(true);
        
        getContentPane().setBackground(UIconstants.FOG);
    }
}
