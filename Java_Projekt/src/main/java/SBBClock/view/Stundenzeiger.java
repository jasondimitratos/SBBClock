package SBBClock.view;

import SBBClock.model.WatchPM;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

/**
 * Created by andreazirn on 05/05/16.
 */
public class Stundenzeiger extends BorderPane {
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
        stunden= new Circle(150,150,95);
        stundenzeiger= new Line(150,55,150,171.333);
    }

    private void layoutControls() {

        stunden.setStyle("-fx-fill: transparent ");
        stundenzeiger.setStyle("-fx-stroke-width: 12 px");
        getChildren().addAll(stundenzeiger,stunden);
    }

    private void addEventHandlers() {
    }

    private void addValueChangedListeners() {
    }

    private void addBindings() {

    }
}
