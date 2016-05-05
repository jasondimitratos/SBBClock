package SBBClock.view;

import SBBClock.model.WatchPM;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

/**
 * Created by andreazirn on 05/05/16.
 */
public class Sekundenzeiger extends HBox {
    private final WatchPM model;
    private Circle seconds;
    private Line sekundenzeiger;
    public Sekundenzeiger(WatchPM model) {
        this.model = model;
        initializeControls();
        layoutControls();
        addBindings();
    }


    private void initializeControls() {
        seconds= new Circle(150,150,130);
        sekundenzeiger= new Line(150,175,150,20);
    }

    private void layoutControls() {
        getChildren().addAll(seconds,sekundenzeiger);
    }

    private void addEventHandlers() {
    }

    private void addValueChangedListeners() {
    }

    private void addBindings() {

    }
}
