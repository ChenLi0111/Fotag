import java.util.Observable;

public class ImageModel extends Observable {
    private ImageCollectionModel imagecollectionmodel;

    private String path = "";
    private String creation_date = "";
    private int user_rating = 0;

    public void set_path(String s) {
        path = s;
    }

    public String get_path() {
        return path;
    }

    public void set_creation_date(String s) {
        creation_date = s;
    }

    public String get_creation_date() {
        return creation_date;
    }

    public void set_user_rating(int i) {
        user_rating = i;
    }

    public int get_user_rating() {
        return user_rating;
    }

    public void tell_2() {
        setChanged();
        notifyObservers();
    }

    ImageModel(ImageCollectionModel imagecollectionmodel, String path) {
        this.imagecollectionmodel = imagecollectionmodel;
        this.path = path;

        setChanged();
    }
}