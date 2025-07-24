import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class RegistrationForm2 extends JFrame {
    JTextField idField, nameField, contactField, addressField;
    JRadioButton male, female;
    JTable table;
    DefaultTableModel model;

    public RegistrationForm2() {
        setTitle("Registration Form");
        setSize(700, 400);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(30, 30, 80, 25);
        add(idLabel);

        idField = new JTextField();
        idField.setBounds(120, 30, 150, 25);
        add(idField);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(30, 70, 80, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(120, 70, 150, 25);
        add(nameField);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(30, 110, 80, 25);
        add(genderLabel);

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        ButtonGroup bg = new ButtonGroup();
        bg.add(male); bg.add(female);
        male.setBounds(120, 110, 70, 25);
        female.setBounds(190, 110, 80, 25);
        add(male); add(female);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(30, 150, 80, 25);
        add(addressLabel);

        addressField = new JTextField();
        addressField.setBounds(120, 150, 150, 25);
        add(addressField);

        JLabel contactLabel = new JLabel("Contact:");
        contactLabel.setBounds(30, 190, 80, 25);
        add(contactLabel);

        contactField = new JTextField();
        contactField.setBounds(120, 190, 150, 25);
        add(contactField);

        JButton register = new JButton("Register");
        register.setBounds(120, 240, 100, 30);
        JButton exit = new JButton("Exit");
        exit.setBounds(30, 240, 80, 30);
        add(register); add(exit);

        model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"ID", "Name", "Gender", "Address", "Contact"});
        table = new JTable(model);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(300, 30, 360, 250);
        add(sp);

        register.addActionListener(e -> {
            String id = idField.getText();
            String name = nameField.getText();
            String contact = contactField.getText();
            String gender = male.isSelected() ? "Male" : "Female";
            String dob = "";
            String address = addressField.getText();

            Database.insert(id, name, contact, gender, dob, address);
            model.addRow(new String[]{id, name, gender, address, contact});
            JOptionPane.showMessageDialog(this, "Data saved!");
        });

        exit.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    public static void main(String[] args) {
        new RegistrationForm2();
    }
}