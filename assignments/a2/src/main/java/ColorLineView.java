import javax.swing.*;
import java.awt.*;
import java.util.Observer;
import java.util.Observable;
import javax.swing.JButton;

public class ColorLineView extends JPanel implements Observer {

    private Model model;

    private JButton red_button = new JButton("");
    private JButton blue_button = new JButton("");
    private JButton green_button = new JButton("");
    private JButton orange_button = new JButton("");
    private JButton yellow_button = new JButton("");
    private JButton pink_button = new JButton("");
    private JButton cyan_button = new JButton("");

    private JButton thick_3 = new JButton();
    private JButton thick_5 = new JButton();
    private JButton thick_7 = new JButton();
    private JButton thick_9 = new JButton();
    private JButton thick_11 = new JButton();
    private JButton thick_13 = new JButton();

    private void button_color() {
        red_button.setBackground(Color.red);
        red_button.setOpaque(true);
        red_button.setBorderPainted(false);

        blue_button.setBackground(Color.blue);
        blue_button.setOpaque(true);
        blue_button.setForeground(Color.blue);
        blue_button.setBorderPainted(false);

        green_button.setBackground(Color.green);
        green_button.setOpaque(true);
        green_button.setBorderPainted(false);

        orange_button.setBackground(Color.orange);
        orange_button.setOpaque(true);
        orange_button.setBorderPainted(false);

        yellow_button.setBackground(Color.yellow);
        yellow_button.setOpaque(true);
        yellow_button.setBorderPainted(false);

        pink_button.setBackground(Color.pink);
        pink_button.setOpaque(true);
        pink_button.setBorderPainted(false);

        cyan_button.setBackground(Color.cyan);
        cyan_button.setOpaque(true);
        cyan_button.setBorderPainted(false);
    }

    private void button_thick() {
        thick_3.setIcon(new ImageIcon(getClass().getResource("3.png")));
        thick_5.setIcon(new ImageIcon(getClass().getResource("5.png")));
        thick_7.setIcon(new ImageIcon(getClass().getResource("7.png")));
        thick_9.setIcon(new ImageIcon(getClass().getResource("9.png")));
        thick_11.setIcon(new ImageIcon(getClass().getResource("11.png")));
        thick_13.setIcon(new ImageIcon(getClass().getResource("13.png")));
    }

    //Create a new View.
    ColorLineView(Model model) {
        // Hook up this observer so that it will be notified when the model
        // changes.
        this.model = model;

        button_color();

        // use BoxLayout
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Add the components
        this.add(red_button);
        this.add(Box.createRigidArea(new Dimension(0,5)));
        this.add(blue_button);
        this.add(Box.createRigidArea(new Dimension(0,5)));
        this.add(green_button);
        this.add(Box.createRigidArea(new Dimension(0,5)));
        this.add(orange_button);
        this.add(Box.createRigidArea(new Dimension(0,5)));
        this.add(yellow_button);
        this.add(Box.createRigidArea(new Dimension(0,5)));
        this.add(pink_button);
        this.add(Box.createRigidArea(new Dimension(0,5)));
        this.add(cyan_button);
        this.add(Box.createRigidArea(new Dimension(0,5)));

        button_thick();
        this.add(thick_3);
        this.add(Box.createRigidArea(new Dimension(0,3)));
        this.add(thick_5);
        this.add(Box.createRigidArea(new Dimension(0,3)));
        this.add(thick_7);
        this.add(Box.createRigidArea(new Dimension(0,3)));
        this.add(thick_9);
        this.add(Box.createRigidArea(new Dimension(0,3)));
        this.add(thick_11);
        this.add(Box.createRigidArea(new Dimension(0,3)));
        this.add(thick_13);
    }

    //Update with data from the model.i
    @Override
    public void update(Observable arg0, Object arg1) {
        if (model.temp == 1) {
            System.out.println("ColorLineView: Model changed!");
        }
    }
}
