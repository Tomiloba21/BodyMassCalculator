import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class CalculatorUI extends JFrame {

    JLabel header, labelA, labelB, resultLabel;
    JTextField weightInput, heightInput;
    JButton calculate,reset;


    public CalculatorUI() {
        setTitle("Body Mass Index Calculator");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        getContentPane().setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 20, 20, 20);

        Font headerFont = new Font("Arial", Font.BOLD, 28);
        header = new JLabel("Body mass Index Calculator");
        header.setHorizontalAlignment(SwingConstants.CENTER);
        header.setFont(headerFont);
        add(header, gbc);

        gbc.gridy++;
        Font labelFont = new Font("Arial", Font.PLAIN, 18);
        labelA = new JLabel("Enter value for weight:");
        labelA.setFont(labelFont);
        add(labelA, gbc);

        gbc.gridy++;
        weightInput = new JTextField(10);
        weightInput.setFont(labelFont);
        add(weightInput, gbc);

        gbc.gridy++;
        labelB = new JLabel("Enter value for height:");
        labelB.setFont(labelFont);
        add(labelB, gbc);

        gbc.gridy++;
        heightInput = new JTextField(10);
        heightInput.setFont(labelFont);
        add(heightInput, gbc);

        gbc.gridy++;
        calculate = new JButton("Calculate");
        calculate.setFont(labelFont);
        add(calculate, gbc);

        gbc.gridy++;
        reset = new JButton("Reset");
        reset.setFont(labelFont);
        add(reset, gbc);

        gbc.gridy++;
        resultLabel = new JLabel();
        resultLabel.setFont(labelFont);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(resultLabel, gbc);

        calculate.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                calculateBMI();
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetFields();
            }
        });

        setVisible(true);
    }

    private void resetFields() {
        weightInput.setText("");
        heightInput.setText("");
        resultLabel.setText("");
    }
    private void calculateBMI() {
        try {
            int  weighth = (int) Double.parseDouble(weightInput.getText());
            double heigh = Double.parseDouble(heightInput.getText());
            BMI  bmi = new BMI(weighth,heigh);
            resultLabel.setText(bmi.BMI());
        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter valid numbers for a and b.");
        }
    }


}
