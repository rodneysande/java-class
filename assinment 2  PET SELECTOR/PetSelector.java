import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PetSelector extends JFrame implements ActionListener {
    JRadioButton birdBtn, catBtn, dogBtn, rabbitBtn, pigBtn;
    JLabel imageLabel;
    ButtonGroup petGroup;

    public PetSelector() {
        setTitle("Pet Selector");
        setSize(400, 300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        birdBtn = new JRadioButton("Bird");
        catBtn = new JRadioButton("Cat");
        dogBtn = new JRadioButton("Dog");
        rabbitBtn = new JRadioButton("Rabbit");
        pigBtn = new JRadioButton("Pig");

        petGroup = new ButtonGroup();
        petGroup.add(birdBtn);
        petGroup.add(catBtn);
        petGroup.add(dogBtn);
        petGroup.add(rabbitBtn);
        petGroup.add(pigBtn);

        add(birdBtn);
        add(catBtn);
        add(dogBtn);
        add(rabbitBtn);
        add(pigBtn);

        imageLabel = new JLabel("🐾 Select a pet");
        imageLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        add(imageLabel);

        // Add listeners
        birdBtn.addActionListener(this);
        catBtn.addActionListener(this);
        dogBtn.addActionListener(this);
        rabbitBtn.addActionListener(this);
        pigBtn.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String pet = "";
        if (e.getSource() == birdBtn) pet = "Bird 🐦";
        else if (e.getSource() == catBtn) pet = "Cat 🐱";
        else if (e.getSource() == dogBtn) pet = "Dog 🐶";
        else if (e.getSource() == rabbitBtn) pet = "Rabbit 🐰";
        else if (e.getSource() == pigBtn) pet = "Pig 🐷";

        imageLabel.setText("You selected: " + pet);
        JOptionPane.showMessageDialog(this, "You selected: " + pet);
    }

    public static void main(String[] args) {
        new PetSelector();
    }
}
