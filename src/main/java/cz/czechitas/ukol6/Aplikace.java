package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLOutput;

public class Aplikace extends JFrame {
private JLabel geeseLabel;
private JLabel rabbitsLabel;
private JLabel numberHeadsLabel;
private JLabel numberLegsLabel;
private JTextField geeseField;
private JTextField rabbitsField;
private JTextField numberHeadsField;
private JTextField numberLegsField;
private JButton calculateButton;

    public static void main(String[] args) {
        FlatLightLaf.setup();
        new Aplikace().start();
    }

    public Aplikace() throws HeadlessException {
        super("Farmářka 1.0");
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 2", "[right]rel[50:120:150,grow,fill]"));
        setMinimumSize(new Dimension(250, 200));

        geeseLabel = new JLabel("Geese");
        geeseField = new JTextField();
        geeseLabel.setDisplayedMnemonic('G');
        geeseLabel.setLabelFor(geeseField);
        geeseField.setHorizontalAlignment(JTextField.TRAILING);
        add(geeseLabel);
        add(geeseField);

        rabbitsLabel = new JLabel("Rabbits");
        rabbitsField = new JTextField();
        rabbitsLabel.setDisplayedMnemonic('R');
        rabbitsLabel.setLabelFor(rabbitsField);
        rabbitsField.setHorizontalAlignment(JTextField.TRAILING);
        add(rabbitsLabel);
        add(rabbitsField);

        add(createButtonCalculator(), "span 2");

        numberHeadsLabel = new JLabel("Number of Heads");
        numberHeadsField = new JTextField();
        numberHeadsLabel.setDisplayedMnemonic('H');
        numberHeadsLabel.setLabelFor(numberHeadsField);
        numberHeadsField.setHorizontalAlignment(JTextField.TRAILING);
        add(numberHeadsLabel);
        add(numberHeadsField);

        numberLegsLabel = new JLabel("Number of Legs");
        numberLegsField = new JTextField();
        numberLegsLabel.setDisplayedMnemonic('L');
        numberLegsLabel.setLabelFor(numberLegsField);
        numberLegsField.setHorizontalAlignment(JTextField.TRAILING);
        add(numberLegsLabel);
        add(numberLegsField);

        pack();

        getRootPane().setDefaultButton(calculateButton);
        calculateButton.addActionListener(this::handleCalculate);
    }

    public JPanel createButtonCalculator(){
        calculateButton = new JButton("Calculate");
        calculateButton.setMnemonic('C');

        JPanel buttonCalculator = new JPanel();
        buttonCalculator.add(calculateButton);
        return buttonCalculator;
    }
    private void handleCalculate(ActionEvent actionEvent){
        String geese = geeseField.getText();
        int numberGeese = Integer.parseInt(geese);

        String rabbits = rabbitsField.getText();
        int numberRabbits = Integer.parseInt(rabbits);

        int heads = numberGeese + numberRabbits;
        String headsGeeseAndRabbits = Integer.toString(heads);

        int legs = (numberGeese * 2) + (numberRabbits * 4);
        String legsGeeseAndRabbits = Integer.toString(legs);

        numberHeadsField.setText(headsGeeseAndRabbits);
        numberLegsField.setText(legsGeeseAndRabbits);
    }
}
