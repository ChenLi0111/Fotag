import java.util.Observable;

public class ImageModel extends Observable {
    private ImageCollectionModel imagecollectionmodel;

    ImageModel(ImageCollectionModel imagecollectionmodel) {
        this.imagecollectionmodel = imagecollectionmodel;
    }
}