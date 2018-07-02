import java.util.ArrayList;
import java.util.Observable;

public class ImageCollectionModel extends Observable {
    private ImageCollectionView imagecollectionview;

    private ArrayList<ImageModel> imagemodel_list = new ArrayList<ImageModel>();
    private int view_mode = 0;
    private int star_number = 0;

    private int frame_width = 0;

    public int get_frame_width() {
        return frame_width;
    }

    public void set_frame_width(int i) {
        frame_width = i;
        System.out.println("frame width = " + frame_width);
        tell();
    }

    public void set_imagecollectionview(ImageCollectionView i) {
        imagecollectionview = i;
        tell();
    }

    public void add_view_to_collection(ImageView i) {
        imagecollectionview.add_imageview_list(i);
        tell();
    }

    public ArrayList<ImageModel> get_imagemodel_list() {
        return imagemodel_list;
    }

    public void add_to_imagemodel_list(ImageModel i) {
        imagemodel_list.add(i);
        tell();
    }

    public void set_view_mode(int s) {
        view_mode = s;
        for (ImageModel i: imagemodel_list) {
            i.set_view_mode(view_mode);
        }
        tell();
    }

    public int get_view_mode() {
        return view_mode;
    }

    public void set_star_number(int s) {
        star_number = s;
        tell();
    }

    public int get_star_number() {
        return star_number;
    }

    public void tell() {
        setChanged();
        notifyObservers();
    }

    ImageCollectionModel() {
        setChanged();
    }
}