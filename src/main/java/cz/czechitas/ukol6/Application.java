package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Application extends JFrame {
    private JLabel geeseLabel;
    private JLabel rabbitsLabel;
    private JLabel numberOfHeadsLabel;
    private JLabel numberOfLegsLabel;
    private JSpinner geeseSpinner;
    private JSpinner rabbitsSpinner;
    private JTextField numberOfHeadsField;
    private JTextField numberOfLegsField;
    private JButton calculateButton;

    public static void main(String[] args) {
        FlatLightLaf.setup();
        new Application().start();
    }

    public Application() throws HeadlessException {
        super("Farmer 1.0");
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Application.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 2", "[right]rel[50:120:150,grow,fill]"));
        setMinimumSize(new Dimension(250, 200));

        geeseLabel = new JLabel("Geese");
        geeseSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 200, 1));
        geeseLabel.setDisplayedMnemonic('G');
        geeseLabel.setLabelFor(geeseSpinner);
        add(geeseLabel);
        add(geeseSpinner);

        rabbitsLabel = new JLabel("Rabbits");
        rabbitsSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 200, 1));
        rabbitsLabel.setDisplayedMnemonic('R');
        rabbitsLabel.setLabelFor(rabbitsSpinner);
        add(rabbitsLabel);
        add(rabbitsSpinner);

        add(createButtonCalculator(), "span 2");

        numberOfHeadsLabel = new JLabel("Number of Heads");
        numberOfHeadsField = new JTextField();
        numberOfHeadsLabel.setDisplayedMnemonic('H');
        numberOfHeadsLabel.setLabelFor(numberOfHeadsField);
        numberOfHeadsField.setHorizontalAlignment(JTextField.TRAILING);
        numberOfHeadsField.setEditable(false);
        add(numberOfHeadsLabel);
        add(numberOfHeadsField);

        numberOfLegsLabel = new JLabel("Number of Legs");
        numberOfLegsField = new JTextField();
        numberOfLegsLabel.setDisplayedMnemonic('L');
        numberOfLegsLabel.setLabelFor(numberOfLegsField);
        numberOfLegsField.setHorizontalAlignment(JTextField.TRAILING);
        numberOfLegsField.setEditable(false);
        add(numberOfLegsLabel);
        add(numberOfLegsField);

        pack();

        getRootPane().setDefaultButton(calculateButton);
        calculateButton.addActionListener(this::takeActionCalculate);
    }

    public JPanel createButtonCalculator() {
        calculateButton = new JButton("Calculate");
        calculateButton.setMnemonic('C');

        JPanel buttonCalculator = new JPanel();
        buttonCalculator.add(calculateButton);
        return buttonCalculator;
    }

    private void takeActionCalculate(ActionEvent actionEvent) {
        int numberOfGeese = (Integer) geeseSpinner.getValue();
        int numberOfRabbits = (Integer) rabbitsSpinner.getValue();
        int numberOfHeads = numberOfGeese + numberOfRabbits;
        int numberOfLegs = (numberOfGeese * 2) + (numberOfRabbits * 4);

        String headsOfGeeseAndRabbits = Integer.toString(numberOfHeads);
        String legsOfGeeseAndRabbits = Integer.toString(numberOfLegs);

        numberOfHeadsField.setText(headsOfGeeseAndRabbits);
        numberOfLegsField.setText(legsOfGeeseAndRabbits);

        System.out.println("Calculator:");
        System.out.printf("Number of geese: %d", numberOfGeese).println();
        System.out.printf("Number of rabbits: %d", numberOfRabbits).println();
        System.out.printf("Number of heads: %d", numberOfHeads).println();
        System.out.printf("Number of legs: %d", numberOfLegs).println();
    }
}
