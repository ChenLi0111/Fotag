import java.io.File;
import java.util.Observable;

public class ImageModel extends Observable {
    private ImageCollectionModel imagecollectionmodel;

    private String path = "";
    private String creation_date = "";
    private int user_rating = 0;

    public int get_view_mode() {
        return this.imagecollectionmodel.get_view_mode();
    }

    public void set_path(String s) {
        path = s;
        tell_2();
    }

    public String get_path() {
        return path;
    }

    public void set_creation_date(String s) {
        creation_date = s;
        tell_2();
    }

    public String get_creation_date() {
        return creation_date;
    }

    public void set_user_rating(int i) {
        user_rating = i;
        //System.out.println("set_user_rating = " + user_rating);
        tell_2();
    }

    public int get_user_rating() {
        return user_rating;
    }

    public void tell_2() {
        setChanged();
        notifyObservers();
    }

    ImageModel(ImageCollectionModel imagecollectionmodel, File f) {
        this.imagecollectionmodel = imagecollectionmodel;
        this.path = f.getAbsolutePath();
        System.out.println("file path: " + this.path);
        setChanged();
    }
}