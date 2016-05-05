package SBBClock.view;

import SBBClock.model.WatchPM;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

/**
 * Created by andreazirn on 05/05/16.
 */
public class Ziffernblatt extends VBox{

    private final WatchPM model;

    private Line line1;
    private Line line2;
    private Line line3;
    private Line line4;
    private Line line5;
    private Line line6;
    private Line line7;
    private Line line8;
    private Line line9;
    private Line line10;
    private Line line11;
    private Line line12;

    private Circle ziffernblatt;
    private Circle ziffernblattRand;

    public Ziffernblatt(WatchPM model) {
        this.model = model;
        initializeControls();
        layoutControls();
        addBindings();
    }


    public void initializeControls() {
        line1 = new Line();
        ziffernblatt = new Circle(0, 0, 200);

    }


    public void layoutControls() {
        getChildren().addAll(line1, ziffernblatt);

    }

    public void addEventHandlers() {

    }


    public void addValueChangedListeners() {

    }


    public void addBindings() {

    }
}
