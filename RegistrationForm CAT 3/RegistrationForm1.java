import javax.swing.*;

public class RegistrationForm1 extends JFrame {
    JTextField nameField, contactField, addressField;
    JRadioButton male, female;
    JComboBox<String> day, month, year;
    JCheckBox terms;
    JButton submit, reset;

    public RegistrationForm1() {
        setTitle("Registration Form");
        setSize(400, 400);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30, 30, 100, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(150, 30, 200, 25);
        add(nameField);

        JLabel contactLabel = new JLabel("Mobile:");
        contactLabel.setBounds(30, 70, 100, 25);
        add(contactLabel);

        contactField = new JTextField();
        contactField.setBounds(150, 70, 200, 25);
        add(contactField);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(30, 110, 100, 25);
        add(genderLabel);

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        ButtonGroup bg = new ButtonGroup();
        bg.add(male); bg.add(female);
        male.setBounds(150, 110, 70, 25);
        female.setBounds(220, 110, 80, 25);
        add(male); add(female);

        JLabel dobLabel = new JLabel("DOB:");
        dobLabel.setBounds(30, 150, 100, 25);
        add(dobLabel);

        String[] days = new String[31];
        for (int i = 0; i < 31; i++) days[i] = String.valueOf(i + 1);
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May"};
        String[] years = {"2000", "2001", "2002", "2003"};

        day = new JComboBox<>(days);
        month = new JComboBox<>(months);
        year = new JComboBox<>(years);
        day.setBounds(150, 150, 50, 25);
        month.setBounds(210, 150, 70, 25);
        year.setBounds(290, 150, 70, 25);
        add(day); add(month); add(year);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(30, 190, 100, 25);
        add(addressLabel);

        addressField = new JTextField();
        addressField.setBounds(150, 190, 200, 25);
        add(addressField);

        terms = new JCheckBox("Accept Terms And Conditions");
        terms.setBounds(150, 230, 250, 25);
        add(terms);

        submit = new JButton("Submit");
        submit.setBounds(150, 270, 80, 30);
        reset = new JButton("Reset");
        reset.setBounds(240, 270, 80, 30);
        add(submit); add(reset);

        submit.addActionListener(e -> {
            if (!terms.isSelected()) {
                JOptionPane.showMessageDialog(this, "Please accept terms and conditions.");
                return;
            }
            String name = nameField.getText();
            String contact = contactField.getText();
            String gender = male.isSelected() ? "Male" : "Female";
            String dob = day.getSelectedItem() + "-" + month.getSelectedItem() + "-" + year.getSelectedItem();
            String address = addressField.getText();

            Database.insert("ID_" + name.hashCode(), name, contact, gender, dob, address);
            JOptionPane.showMessageDialog(this, "Data saved!");
        });

        reset.addActionListener(e -> {
            nameField.setText("");
            contactField.setText("");
            addressField.setText("");
            terms.setSelected(false);
            bg.clearSelection();
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new RegistrationForm1();
    }
}