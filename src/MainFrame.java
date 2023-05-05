import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    final private Font mainFont = new Font("Segoe print", Font.BOLD, 18);
    JTextField tfPasswordLength;
    JLabel lbOutput;

    public void initialize() {
        /* Settings Panel */
        JLabel lbPasswordLength = new JLabel("Password length");
        lbPasswordLength.setFont(mainFont);

        tfPasswordLength = new JTextField();
        tfPasswordLength.setFont(mainFont);

        JPanel settingsPanel = new JPanel();
        settingsPanel.setLayout(new GridLayout(1, 1, 5, 5));
        settingsPanel.add(lbPasswordLength);
        settingsPanel.add(tfPasswordLength);

        /* Output Label */
        lbOutput = new JLabel();
        lbOutput.setFont(mainFont);

        /* Button Panel */
        JButton btnGenerate = new JButton("GENERATE");
        btnGenerate.setFont(mainFont);
        btnGenerate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int passwordLength = Integer.parseInt(tfPasswordLength.getText());

                PasswordGenerator passwordGenerator = (new PasswordGenerator());
                lbOutput.setText("Your secure password is " + passwordGenerator.generate(passwordLength));
            }

        });

        JButton btnClear = new JButton("Clear");
        btnClear.setFont(mainFont);
        btnClear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                lbOutput.setText("");
            }
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2, 5, 5));
        buttonsPanel.add(btnGenerate);
        buttonsPanel.add(btnClear);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(new Color(182, 73, 245));
        mainPanel.add(settingsPanel, BorderLayout.NORTH);
        mainPanel.add(lbOutput, BorderLayout.CENTER);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setTitle("GauPass - Secure password generator");
        setSize(500, 600);
        setMinimumSize(new Dimension(300, 400));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
