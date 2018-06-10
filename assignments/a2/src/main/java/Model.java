import java.util.Observable;

public class Model extends Observable {
    public int temp = 1;

    public void model_notify() {
        setChanged();
        notifyObservers();
    }
}
