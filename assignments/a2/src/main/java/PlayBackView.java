import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Observer;
import java.util.Observable;

public class PlayBackView extends JPanel implements Observer {
    private int max_stroke = 100;
    private int min_stroke = 0;

    private JButton play = new JButton("Play");
    private JSlider slider = new JSlider(min_stroke, max_stroke, max_stroke);
    private JButton start = new JButton("Start");
    private JButton end = new JButton("End");

    private Model model;

    private void config_slider() {
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                JSlider s = (JSlider)e.getSource();
                //System.out.println(s.getValue());
                model.set_play_prentage(s.getValue());
            }
        });
        slider.setPaintTicks(true);
    }

    //Create a new View.
    PlayBackView(Model model) {
        this.model = model;

        this.setLayout(new GridBagLayout());
        // create a constraints object
        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.weightx = 0.1; // the proportion of space to give this column
        this.add(play, gc);
        config_slider();
        gc.weightx = 0.7; // the proportion of space to give this column
        this.add(slider, gc);
        gc.weightx = 0.1; // the proportion of space to give this column
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
