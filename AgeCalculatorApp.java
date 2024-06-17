import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AgeCalculatorApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AgeInputWindow());
        
    }
}

class AgeInputWindow extends JFrame {
    private JTextField yearField = new JTextField(4);
    private JTextField monthField = new JTextField(2);
    private JTextField dayField = new JTextField(2);
    private JButton calculateButton = new JButton("Calculate");

    public AgeInputWindow() {
        setTitle("Age Calculator");
        setSize(500,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(10, 5, 10, 5));
        
        JLabel heading = new JLabel("Age Calculator", SwingConstants.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        
 

        add(heading);
        add(new JLabel("Year:"));
        add(yearField);
        add(new JLabel("Month:"));
        add(monthField);
        add(new JLabel("Day:"));
        add(dayField);
        add(new JLabel());
        add(calculateButton);
        

        calculateButton.addActionListener(e -> calculateAge());

        setVisible(true);
    }

    private void calculateAge() {
        try {
            int year = Integer.parseInt(yearField.getText());
            int month = Integer.parseInt(monthField.getText());
            int day = Integer.parseInt(dayField.getText());

            LocalDate today = LocalDate.now();
            LocalDate birthDate = LocalDate.of(year, month, day);

            if (birthDate.isAfter(today)) {
                JOptionPane.showMessageDialog(this,"Invalid Input","Please input valid year.", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            long totalDays = ChronoUnit.DAYS.between(birthDate, today);
            int years = (int) (totalDays / 365);
            int months = (int) ((totalDays % 365) / 30);
            int days = (int) ((totalDays % 365) % 30);

            new AgeDisplayWindow(years, months, days);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Please enter valid date fields.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    class AgeDisplayWindow extends JFrame {
    public AgeDisplayWindow(int years, int months, int days) {
        setTitle("Age Display");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(10, 5, 10, 5));
        setFont(new Font("",4,20));  
        
        JLabel heading = new JLabel("Age Calculator", SwingConstants.CENTER);
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        
        
        
        add(heading);
        add(new JLabel());
        add(new JLabel("Age"));
        add(new JLabel("Year:"+years));
        add(new JLabel("Month:"+ months));
        add(new JLabel("Day:"+ days));
        
 
        setVisible(true);

    }
}
}
