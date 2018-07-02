import javax.swing.*;
import java.util.ArrayList;
import java.util.Observer;
import java.util.Observable;

public class ImageCollectionView extends JPanel implements Observer {
    private ImageCollectionModel imagecollectionmodel;
    private ArrayList<ImageView> imageview_list = new ArrayList<ImageView>();

    public void add_imageview_list(ImageView i) {
        imageview_list.add(i);
    }

    public ArrayList<ImageView> get_imageview_list() {
        return imageview_list;
    }

    ImageCollectionView(ImageCollectionModel imagecollectionmodel) {
        this.imagecollectionmodel = imagecollectionmodel;
        imagecollectionmodel.set_imagecollectionview(this);
    }

    public void grid_mode() {
        removeAll();
        for (ImageView j: imageview_list) {
            if (j.get_imagemodel().get_user_rating() >= imagecollectionmodel.get_star_number()) {
                this.add(j);
            }
        }
    }

    public void list_mode() {
        removeAll();
        for (ImageView j: imageview_list) {
            if (j.get_imagemodel().get_user_rating() >= imagecollectionmodel.get_star_number()) {
                this.add(j);
            }
        }
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        System.out.println("ImageCollectionView: update");
        if (imagecollectionmodel.get_view_mode() == 0) {
            grid_mode();
        } else if (imagecollectionmodel.get_view_mode() == 1) {
            list_mode();
        }
        revalidate();
        repaint();
    }
}