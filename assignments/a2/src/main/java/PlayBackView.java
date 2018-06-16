import javax.swing.*;
import java.awt.*;
import java.util.Observer;
import java.util.Observable;

public class PlayBackView extends JPanel implements Observer {

    private JButton play = new JButton("Play");
    private JSlider slider = new JSlider(0, 100, 50);
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
        this.add(slider, gc);
        this.add(start, gc);
        this.add(end, gc);
    }

    //Update with data from the model.
    @Override
    public void update(Observable arg0, Object arg1) {
        System.out.println("PlayBackView: Model changed!");
    }
}
