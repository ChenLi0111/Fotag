import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Observable;

public class ImageModel extends Observable {
    private ImageCollectionModel imagecollectionmodel;

    private String path = "";
    private String creation_date = "";
    private int user_rating = 0;
    private String name = "";
    private File f;

    private int view_mode = 0;

    public File get_file() {
        return f;
    }

    public void set_view_mode(int i) {
        view_mode = i;
        tell_2();
    }

    public int get_view_mode() {
        return this.imagecollectionmodel.get_view_mode();
    }

    public String get_path() {
        return path;
    }

    public String get_creation_date() {
        return creation_date;
    }

    public String get_name() {
        return name;
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
        this.f = f;
        this.path = f.getAbsolutePath();
        this.name = f.getName();

        BasicFileAttributes a = null;
        try {
            a = Files.readAttributes(f.toPath(), BasicFileAttributes.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.creation_date = a.creationTime().toString();

        //System.out.println("file path: " + this.path);
        setChanged();
    }
}