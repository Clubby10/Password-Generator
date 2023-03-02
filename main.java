import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Random;

public class Main extends JFrame implements ActionListener, ChangeListener {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_-+={}[]|\\:;\"'<>,.?/~`";
    private int length = 12;

    private JTextField passwordField;
    private JSlider lengthSlider;

    public Main() {
        setTitle("Password Generator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 1));

        passwordField = new JTextField();
        passwordField.setEditable(false);
        passwordField.setHorizontalAlignment(JTextField.CENTER);
        panel.add(passwordField);

        lengthSlider = new JSlider(JSlider.HORIZONTAL, 6, 24, 12);
        lengthSlider.setMajorTickSpacing(6);
        lengthSlider.setMinorTickSpacing(1);
        lengthSlider.setPaintTicks(true);
        lengthSlider.setPaintLabels(true);
        lengthSlider.addChangeListener(this);
        panel.add(lengthSlider);

        JButton generateButton = new JButton("Generate");
        generateButton.addActionListener(this);
        panel.add(generateButton);

        add(panel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Generate")) {
            StringBuilder password = new StringBuilder();
            Random random = new Random();

            for (int i = 0; i < length; i++) {
                int index = random.nextInt(CHARACTERS.length());
                password.append(CHARACTERS.charAt(index));
            }

            passwordField.setText(password.toString());
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        length = lengthSlider.getValue();
    }

    public static void main(String[] args) {
        new Main();
    }
}
