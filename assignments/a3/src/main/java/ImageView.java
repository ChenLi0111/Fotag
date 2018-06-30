import javax.swing.*;
import java.util.Observer;
import java.util.Observable;

public class ImageView extends JPanel implements Observer {
    private ImageModel imagemodel;

    ImageView(ImageModel imagemodel) {
        this.imagemodel = imagemodel;
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        System.out.println("ImageView: update");
    }
}