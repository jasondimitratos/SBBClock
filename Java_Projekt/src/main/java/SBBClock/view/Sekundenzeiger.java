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
    private Circle visualSek;
    private Line sekundenzeiger;
    public Sekundenzeiger(WatchPM model) {
        this.model = model;
        initializeControls();
        layoutControls();
        addBindings();
    }


    private void initializeControls() {
        seconds= new Circle(150,150,110);
        visualSek= new Circle(251.167,150,8.833);
        sekundenzeiger= new Line(128.333,150,260,150);
    }

    private void layoutControls() {
        getChildren().addAll(seconds,sekundenzeiger,visualSek);
    }

    private void addEventHandlers() {
    }

    private void addValueChangedListeners() {
    }

    private void addBindings() {

    }
}
