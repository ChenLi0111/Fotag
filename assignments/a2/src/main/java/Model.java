import java.awt.*;
import java.io.Serializable;
import java.util.Observable;
import java.util.ArrayList;

public class Model extends Observable implements Serializable {
    private  ArrayList<Shape> shape_collection = new ArrayList<Shape>();
    private Color select_color = Color.red;
    private float select_thickness = 3.0f;

    Model() {
        setChanged();
    }

    public void add_shape(Shape s) {
        shape_collection.add(s);
        setChanged();
        notifyObservers();
    }
    
    public void clear_collection() {
        shape_collection.clear();
        setChanged();
        notifyObservers();
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
}
