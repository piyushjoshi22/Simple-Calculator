import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {
    private JTextField display;
    private String num1 = "", num2 = "", operator = "";
    
    public Calculator() {
        setTitle("Basic Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 5, 5));
        
        String[] buttons = { "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", "=", "+" };
        
        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(this);
            panel.add(button);
        }
        
        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        if (command.matches("[0-9]") && operator.isEmpty()) {
            num1 += command;
            display.setText(num1);
        } else if (command.matches("[0-9]") && !operator.isEmpty()) {
            num2 += command;
            display.setText(num2);
        } else if (command.matches("[+\\-*/]") && !num1.isEmpty()) {
            operator = command;
        } else if (command.equals("=") && !num1.isEmpty() && !num2.isEmpty()) {
            double result = calculate(Double.parseDouble(num1), Double.parseDouble(num2), operator);
            display.setText(String.valueOf(result));
            num1 = String.valueOf(result);
            num2 = "";
            operator = "";
        }
    }
    
    private double calculate(double a, double b, String op) {
        return switch (op) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> b != 0 ? a / b : 0;
            default -> 0;
        };
    }
    
    public static void main(String[] args) {
        new Calculator();
    }
}

