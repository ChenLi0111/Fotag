import javax.swing.*;
import java.awt.*;
import java.util.Observer;
import java.util.Observable;
import javax.swing.JButton;

public class ColorLineView extends JPanel implements Observer {

    private Model model;

    JButton red_button = new JButton("Red");

    //Create a new View.
    ColorLineView(Model model) {
        // Hook up this observer so that it will be notified when the model
        // changes.
        this.model = model;

        this.setLayout(new FlowLayout());

        red_button.setBackground(Color.red);

        red_button.setOpaque(true);
        red_button.setBorderPainted(false);
        this.add(red_button);
    }

    //Update with data from the model.i
    @Override
    public void update(Observable arg0, Object arg1) {
        if (model.temp == 1) {
            System.out.println("ColorLineView: Model changed!");
        }
    }
}
