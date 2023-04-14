package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Application extends JFrame {
    private JLabel geeseLabel;
    private JLabel rabbitsLabel;
    private JLabel headsLabel;
    private JLabel legsLabel;
    private JSpinner geeseSpinner;
    private JSpinner rabbitsSpinner;
    private JSpinner headsSpinner;
    private JSpinner legsSpinner;
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

        headsLabel = new JLabel("Number of Heads");
        headsSpinner = new JSpinner();
        headsLabel.setDisplayedMnemonic('H');
        headsLabel.setLabelFor(headsSpinner);
        JFormattedTextField headsGeeseAndRabbits = ((JSpinner.DefaultEditor)headsSpinner.getEditor()).getTextField();
        headsGeeseAndRabbits.setEditable(false);
        add(headsLabel);
        add(headsSpinner);

        legsLabel = new JLabel("Number of Legs");
        legsSpinner = new JSpinner();
        legsLabel.setDisplayedMnemonic('L');
        legsLabel.setLabelFor(legsSpinner);
        add(legsLabel);
        add(legsSpinner);

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
        int numberGeese = (Integer) geeseSpinner.getValue();
        int numberRabbits = (Integer) rabbitsSpinner.getValue();
        int numberHeads = numberGeese + numberRabbits;
        int numberLegs = (numberGeese * 2) + (numberRabbits * 4);
        headsSpinner.setValue(numberHeads);
        legsSpinner.setValue(numberLegs);

        System.out.println("Calculator:");
        System.out.printf("Number of geese: %d", numberGeese).println();
        System.out.printf("Number of rabbits: %d", numberRabbits).println();
        System.out.printf("Number of heads: %d", numberHeads).println();
        System.out.printf("Number of legs: %d", numberLegs).println();
    }
}
