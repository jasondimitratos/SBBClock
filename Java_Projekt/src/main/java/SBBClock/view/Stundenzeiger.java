package SBBClock.view;

import SBBClock.model.WatchPM;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

/**
 * Created by andreazirn on 05/05/16.
 */
public class Stundenzeiger extends HBox {
    private final WatchPM model;
    private Circle stunden;
    private Line stundenzeiger;
    public Stundenzeiger(WatchPM model) {
        this.model = model;
        initializeControls();
        layoutControls();
        addBindings();
    }


    private void initializeControls() {
        stunden= new Circle(150,150,130);
        stundenzeiger= new Line(150,175,150,20);
    }

    private void layoutControls() {
        getChildren().addAll(stundenzeiger,stunden);
    }

    private void addEventHandlers() {
    }

    private void addValueChangedListeners() {
    }

    private void addBindings() {

    }
}
