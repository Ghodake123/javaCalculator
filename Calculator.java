import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    private JTextField displayField;
    private JButton[] numberButtons;
    private JButton[] functionButtons;
    private JButton addButton, subButton, mulButton, divButton;
    private JButton decButton, equButton, delButton, clrButton;
    private JPanel panel;

    private Font font = new Font("Arial", Font.PLAIN, 18);

    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    public Calculator() {
        this.setTitle("Calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(420, 550);
        this.setLayout(null);

        displayField = new JTextField();
        displayField.setBounds(50, 25, 300, 50);
        displayField.setFont(font);
        displayField.setEditable(false);
        this.add(displayField);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");

        functionButtons = new JButton[8];
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        for (int i = 0; i < 8; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(font);
            functionButtons[i].setFocusable(false);
        }

        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(font);
            numberButtons[i].setFocusable(false);
        }

        delButton.setBounds(50, 430, 145, 50);
        clrButton.setBounds(205, 430, 145, 50);

        this.add(delButton);
        this.add(clrButton);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        this.add(panel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                displayField.setText(displayField.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == decButton) {
            displayField.setText(displayField.getText().concat("."));
        }
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(displayField.getText());
            operator = '+';
            displayField.setText("");
        }
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(displayField.getText());
            operator = '-';
            displayField.setText("");
        }
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(displayField.getText());
            operator = '*';
            displayField.setText("");
        }
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(displayField.getText());
            operator = '/';
            displayField.setText("");
        }
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(displayField.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            displayField.setText(String.valueOf(result));
            num1 = result;
        }
        if (e.getSource() == clrButton) {
            displayField.setText("");
        }
        if (e.getSource() == delButton) {
            String string = displayField.getText();
            displayField.setText("");
            for (int i = 0; i < string.length() - 1; i++) {
                displayField.setText(displayField.getText() + string.charAt(i));
            }
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
