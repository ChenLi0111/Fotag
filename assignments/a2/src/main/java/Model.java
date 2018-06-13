import java.awt.*;
import java.util.Observable;
import java.util.ArrayList;

public class Model extends Observable {
    private  ArrayList<Shape> shape_collection = new ArrayList<Shape>();
    private Color select_color = Color.red;
    private float select_thickness = 3.0f;

    Model() {
        setChanged();
    }

    public void add_shape(Shape s) {
        shape_collection.add(s);
    }

    public ArrayList<Shape> get_shape_collection() {
        return shape_collection;
    }

    public void change_color(Color c) {
        select_color = c;
        System.out.println("changed" + c.toString());
        model_notify();
    }

    public Color get_color() {
        return select_color;
    }

    public void change_thickness(float f) {
        select_thickness = f;
        System.out.println("changed " + Float.toString(f));
        model_notify();
    }

    public float get_thickness() {
        return select_thickness;
    }

    public void model_notify() {
        setChanged();
        notifyObservers();
    }
}
