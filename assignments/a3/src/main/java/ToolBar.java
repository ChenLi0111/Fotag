import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class ToolBar extends JPanel implements Observer {
    private ImageCollectionModel imagecollectionmodel;

    ToolBar(ImageCollectionModel imagecollectionmodel) {
        this.imagecollectionmodel = imagecollectionmodel;
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        System.out.println("ToolBar: update");
    }
}