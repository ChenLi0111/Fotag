import java.util.ArrayList;
import java.util.Observable;

public class ImageCollectionModel extends Observable {
    private ArrayList<ImageModel> imagemodel_list = new ArrayList<ImageModel>();
    private int view_mode = 1;
    private int star_number = 0;

    public void set_view_mode(int s) {
        view_mode = s;
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