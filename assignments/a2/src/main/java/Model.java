import java.awt.*;
import java.io.Serializable;
import java.util.Observable;
import java.util.ArrayList;

public class Model extends Observable implements Serializable {
    private  ArrayList<Shape> shape_collection = new ArrayList<Shape>();
    private Color select_color = Color.red;
    private float select_thickness = 3.0f;
    private boolean save_f = false;
    private boolean load_f = false;
    private boolean new_f = false;
    private boolean exit_f = false;
    private int size_1;

    Model() {
        setChanged();
    }

    public void add_shape(Shape s) {
        shape_collection.add(s);
    }
    
    public void clear_collection() {
        shape_collection.clear();
    }

    public ArrayList<Shape> get_shape_collection() {
        return shape_collection;
    }

    public void change_color(Color c) {
        select_color = c;
        System.out.println("changed" + c.toString());
        setChanged();
        notifyObservers();
    }

    public Color get_color() {
        return select_color;
    }

    public void change_thickness(float f) {
        select_thickness = f;
        System.out.println("changed " + Float.toString(f));
        setChanged();
        notifyObservers();
    }

    public float get_thickness() {
        return select_thickness;
    }

    public void save_file() {
        save_f = true;
    }

    public boolean get_save_f() {
        return save_f;
    }

    public void load_file() {
        load_f = true;
    }

    public boolean get_load_f() {
        return load_f;
    }

    public void new_file() {
        new_f = true;
    }

    public boolean get_new_f() {
        return new_f;
    }

    public void exit() {
        save_f = true;
        System.exit(0);
    }

    public boolean get_exit_f() {
        return exit_f;
    }
}
