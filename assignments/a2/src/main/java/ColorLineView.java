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
        red_button.setIcon(new ImageIcon("images/red.png"));
        blue_button.setIcon(new ImageIcon("images/blue.png"));
        green_button.setIcon(new ImageIcon("images/green.png"));
        orange_button.setIcon(new ImageIcon("images/orange.png"));
        yellow_button.setIcon(new ImageIcon("images/yellow.png"));
        pink_button.setIcon(new ImageIcon("images/pink.png"));
        cyan_button.setIcon(new ImageIcon("images/cyan.png"));
    }

    private void button_thick() {
        thick_3.setIcon(new ImageIcon("images/3.png"));
        thick_5.setIcon(new ImageIcon("images/5.png"));
        thick_7.setIcon(new ImageIcon("images/7.png"));
        thick_9.setIcon(new ImageIcon("images/9.png"));
        thick_11.setIcon(new ImageIcon("images/11.png"));
        thick_13.setIcon(new ImageIcon("images/13.png"));
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
        this.add(Box.createRigidArea(new Dimension(0,3)));
        this.add(blue_button);
        this.add(Box.createRigidArea(new Dimension(0,3)));
        this.add(green_button);
        this.add(Box.createRigidArea(new Dimension(0,3)));
        this.add(orange_button);
        this.add(Box.createRigidArea(new Dimension(0,3)));
        this.add(yellow_button);
        this.add(Box.createRigidArea(new Dimension(0,3)));
        this.add(pink_button);
        this.add(Box.createRigidArea(new Dimension(0,3)));
        this.add(cyan_button);
        this.add(Box.createRigidArea(new Dimension(0,3)));

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
