import javax.swing.*;
import java.awt.*;

import com.GauPass.utils.ScreenSizeCalculator;
import com.GauPass.components.*;
import com.GauPass.constants.*;

public class MainFrame extends JFrame {

    public void initialize() {
        setUndecorated(true);

        setScreenSize(UI_size.APP_WIDTH_PERCENTAGE, UI_size.APP_HEIGHT_PERCENTAGE);
        setLocationRelativeTo(null);

        JPanel contentPane = createContentPane();
        setContentPane(contentPane);

        setVisible(true);
    }

    public void setScreenSize(double widthPercentage, double heightPercentage) {
        Dimension screenSize = ScreenSizeCalculator.calculateScreenSize(widthPercentage, heightPercentage);
        setSize(screenSize);
    }

    private JPanel createContentPane() {
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(BorderFactory.createLineBorder(UI_color.BLACK, UI_size.APP_BORDER_THICKNESS));

        fillContentPane(contentPane);

        return contentPane;
    }

    private void fillContentPane(JPanel contentPane) {
        JPanel titleBar = new TitleBar().createTitleBar(this);
        contentPane.add(titleBar, BorderLayout.NORTH);

        JPanel contentGrid = new ContentGrid().createContentGrid();
        contentPane.add(contentGrid);

    }

}