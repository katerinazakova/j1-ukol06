package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Application extends JFrame {
    private JLabel geeseLabel;
    private JLabel rabbitsLabel;
    private JLabel numberHeadsLabel;
    private JLabel numberLegsLabel;
    private JSpinner geeseSpinner;
    private JSpinner rabbitsSpinner;
    private JSpinner numberHeadsSpinner;
    private JSpinner numberLegsSpinner;
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
        geeseSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        geeseLabel.setDisplayedMnemonic('G');
        geeseLabel.setLabelFor(geeseSpinner);
        add(geeseLabel);
        add(geeseSpinner);

        rabbitsLabel = new JLabel("Rabbits");
        rabbitsSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
        rabbitsLabel.setDisplayedMnemonic('R');
        rabbitsLabel.setLabelFor(rabbitsSpinner);
        add(rabbitsLabel);
        add(rabbitsSpinner);

        add(createButtonCalculator(), "span 2");

        numberHeadsLabel = new JLabel("Number of Heads");
        numberHeadsSpinner = new JSpinner();
        numberHeadsLabel.setDisplayedMnemonic('H');
        numberHeadsLabel.setLabelFor(numberHeadsSpinner);

        add(numberHeadsLabel);
        add(numberHeadsSpinner);

        numberLegsLabel = new JLabel("Number of Legs");
        numberLegsSpinner = new JSpinner();
        numberLegsLabel.setDisplayedMnemonic('L');
        numberLegsLabel.setLabelFor(numberLegsSpinner);
        add(numberLegsLabel);
        add(numberLegsSpinner);

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
        numberHeadsSpinner.setValue(numberHeads);
        numberLegsSpinner.setValue(numberLegs);
    }
}
