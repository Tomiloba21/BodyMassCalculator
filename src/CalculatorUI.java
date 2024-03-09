import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class represents the user interface for a Body Mass Index (BMI) calculator.
 * It extends the JFrame class to create a window for the calculator UI.
 */
public class CalculatorUI extends JFrame {

    // Components for the UI
    JLabel header, labelA, labelB, resultLabel; // Labels for headers and input/output fields
    JTextField weightInput, heightInput; // Text fields for weight and height input
    JButton calculate, reset; // Buttons for calculation and resetting

    /**
     * Constructor for creating the BMI calculator UI.
     * Sets up the layout, initializes components, and adds them to the UI.
     */
    public CalculatorUI() {
        setTitle("Body Mass Index Calculator"); // Set the title of the window
        setSize(500, 600); // Set the size of the window
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close operation when window is closed
        setLayout(new GridBagLayout()); // Set layout manager to GridBagLayout
        getContentPane().setBackground(Color.WHITE); // Set background color of the content pane

        GridBagConstraints gbc = new GridBagConstraints(); // Create GridBagConstraints for layout

        // Add header label
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 20, 20, 20); // Set insets
        Font headerFont = new Font("Arial", Font.BOLD, 28); // Create font for header
        header = new JLabel("Body Mass Index Calculator"); // Create header label
        header.setHorizontalAlignment(SwingConstants.CENTER); // Center align header
        header.setFont(headerFont); // Set font for header
        add(header, gbc); // Add header label to UI

        // Add label and text field for weight input
        gbc.gridy++;
        Font labelFont = new Font("Arial", Font.PLAIN, 18); // Create font for labels
        labelA = new JLabel("Enter value for weight:"); // Create label for weight input
        labelA.setFont(labelFont); // Set font for label
        add(labelA, gbc); // Add label to UI

        gbc.gridy++;
        weightInput = new JTextField(10); // Create text field for weight input
        weightInput.setFont(labelFont); // Set font for text field
        add(weightInput, gbc); // Add text field to UI

        // Add label and text field for height input
        gbc.gridy++;
        labelB = new JLabel("Enter value for height:"); // Create label for height input
        labelB.setFont(labelFont); // Set font for label
        add(labelB, gbc); // Add label to UI

        gbc.gridy++;
        heightInput = new JTextField(10); // Create text field for height input
        heightInput.setFont(labelFont); // Set font for text field
        add(heightInput, gbc); // Add text field to UI

        // Add button for calculation
        gbc.gridy++;
        calculate = new JButton("Calculate"); // Create button for calculation
        calculate.setFont(labelFont); // Set font for button
        add(calculate, gbc); // Add button to UI

        // Add button for resetting fields
        gbc.gridy++;
        reset = new JButton("Reset"); // Create button for resetting
        reset.setFont(labelFont); // Set font for button
        add(reset, gbc); // Add button to UI

        // Add label for displaying result
        gbc.gridy++;
        resultLabel = new JLabel(); // Create label for displaying result
        resultLabel.setFont(labelFont); // Set font for label
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center align result label
        add(resultLabel, gbc); // Add label to UI

        // Add action listener for calculation button
        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateBMI(); // Call method to calculate BMI when button is clicked
            }
        });

        // Add action listener for reset button
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetFields(); // Call method to reset fields when button is clicked
            }
        });

        setVisible(true); // Make UI visible
    }

    /**
     * Method to reset input fields and result label.
     */
    private void resetFields() {
        weightInput.setText(""); // Clear weight input field
        heightInput.setText(""); // Clear height input field
        resultLabel.setText(""); // Clear result label
    }

    /**
     * Method to calculate BMI and display result.
     */
    private void calculateBMI() {
        try {
            // Parse input values and create BMI object
            int weight = (int) Double.parseDouble(weightInput.getText());
            double height = Double.parseDouble(heightInput.getText());
            BMI bmi = new BMI(weight, height);
            // Display calculated BMI
            resultLabel.setText(bmi.BMI());
        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter valid numbers for weight and height."); // Display error message for invalid input
        }
    }
}

