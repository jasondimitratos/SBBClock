package SBBClock.view;

import SBBClock.model.WatchPM;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

/**
 * Created by andreazirn on 05/05/16.
 */
public class Minutenzeiger extends StackPane {
    private final WatchPM model;
    private Circle minutes;
    private Line minutenzeiger;
    private Line test;
    public Minutenzeiger(WatchPM model) {
        this.model = model;
        initializeControls();
        layoutControls();
        addBindings();
    }


    private void initializeControls() {
        minutes= new Circle(150,150,130);

        minutenzeiger= new Line(150,175,150,20);
        test= new Line(0,0,20,20);
    }

    private void layoutControls() {

        minutes.setStyle("-fx-fill: transparent ; -fx-stroke:black;");
        test.setStyle("-fx-fill: red ; -fx-stroke:red;");
        getChildren().addAll(minutenzeiger,minutes,test);
    }

    private void addEventHandlers() {
    }

    private void addValueChangedListeners() {
    }

    private void addBindings() {

    }

}
