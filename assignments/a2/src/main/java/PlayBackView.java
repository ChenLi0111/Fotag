import javax.swing.*;
import java.awt.*;
import java.util.Observer;
import java.util.Observable;

public class PlayBackView extends JPanel implements Observer {
    private int max_stroke = 200;
    private int min_stroke = 0;

    private JButton play = new JButton("Play");
    private JSlider slider = new JSlider(min_stroke, max_stroke, 0);
    private JButton start = new JButton("Start");
    private JButton end = new JButton("End");

    private Model model;

    private void config_slider() {
        slider.setPaintTicks(true);
    }

    //Create a new View.
    PlayBackView(Model model) {
        this.model = model;

        this.setLayout(new GridLayout());
        // create a constraints object
        GridBagConstraints gc = new GridBagConstraints();
        this.add(play, gc);
        config_slider();
        this.add(slider, gc);
        this.add(start, gc);
        this.add(end, gc);
    }

    private void update_slider() {
        int number_stroke = model.get_shape_collection().size();
        if (number_stroke > 0) {
            float space = (max_stroke - min_stroke) / number_stroke;
            slider.setMajorTickSpacing((int) space);
        }
    }

    //Update with data from the model.
    @Override
    public void update(Observable arg0, Object arg1) {
        update_slider();
        System.out.println("PlayBackView: Model changed!");

    }
}
