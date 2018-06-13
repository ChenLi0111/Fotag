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

    private JButton thick_3 = new JButton();
    private JButton thick_5 = new JButton();
    private JButton thick_7 = new JButton();
    private JButton thick_9 = new JButton();
    private JButton thick_11 = new JButton();
    private JButton thick_13 = new JButton();

    private JLabel current_color = new JLabel("Color");
    private ImageIcon temp_1 = new ImageIcon("images/red.png");
    private JLabel now_color = new JLabel(temp_1, JLabel.CENTER);
    private JLabel current_thickness = new JLabel("Thickness");
    private ImageIcon temp_2 = new ImageIcon("images/3.png");
    private JLabel now_thickness = new JLabel(temp_2, JLabel.CENTER);

    private void button_color() {
        red_button.setIcon(new ImageIcon("images/red.png"));
        blue_button.setIcon(new ImageIcon("images/blue.png"));
        green_button.setIcon(new ImageIcon("images/green.png"));
        orange_button.setIcon(new ImageIcon("images/orange.png"));
        yellow_button.setIcon(new ImageIcon("images/yellow.png"));
        pink_button.setIcon(new ImageIcon("images/pink.png"));
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

        // use BoxLayout
        this.setLayout(new GridLayout(8,2));

        // Add the components
        button_color();
        this.add(red_button);
        this.add(blue_button);
        this.add(green_button);
        this.add(orange_button);
        this.add(yellow_button);
        this.add(pink_button);
        button_thick();
        this.add(thick_3);
        this.add(thick_5);
        this.add(thick_7);
        this.add(thick_9);
        this.add(thick_11);
        this.add(thick_13);
        this.add(current_color);
        this.add(now_color);
        this.add(current_thickness);
        this.add(now_thickness);
    }

    //Update with data from the model.i
    @Override
    public void update(Observable arg0, Object arg1) {
        if (model.temp == 1) {
            System.out.println("ColorLineView: Model changed!");
        }
    }
}
