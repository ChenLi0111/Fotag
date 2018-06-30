import javax.swing.*;
import java.util.ArrayList;
import java.util.Observer;
import java.util.Observable;

public class ImageCollectionView extends JPanel implements Observer {
    private ImageCollectionModel imagecollectionmodel;
    private ArrayList<ImageView> imageview_list = new ArrayList<ImageView>();

    ImageCollectionView(ImageCollectionModel imagecollectionmodel) {
        this.imagecollectionmodel = imagecollectionmodel;
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        System.out.println("ImageCollectionView: update");
    }
}