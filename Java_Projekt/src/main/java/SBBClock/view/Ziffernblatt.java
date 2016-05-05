package SBBClock.view;

import SBBClock.model.WatchPM;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

/**
 * Created by andreazirn on 05/05/16.
 */
public class Ziffernblatt extends BorderPane{

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

    private Circle zblatt;
    private Circle zblattRand;

    public Ziffernblatt(WatchPM model) {
        this.model = model;
        initializeControls();
        layoutControls();
        addBindings();
    }


    public void initializeControls() {
        line1 = new Line(5.001, 150, 40.001, 150);
        line2 = new Line(259.514, 150, 294.525, 150);
        line3 = new Line(150.001, 40, 150.001, 5);
        line4 = new Line(149.001, 295, 149.001, 260);
        line5 = new Line(94.989, 55.156, 7.489, 24.845);
        line6 = new Line(222.511, 275.155, 05.012, 44.845);
        line7 = new Line(54.718, 94.99, 4.407, 77.489);
        line8 = new Line(275.593, 222.512, 245.282, 205.01);
        line9 = new Line(54.719, 205.011, 4.407, 222.512);
        line10 = new Line(275.593, 77.49, 245.281, 94.991);
        line11 = new Line(94.989, 45.282, 77.489, 275.594);
        line12 = new Line(205.011, 54.719, 222.511, 24.408);
        zblatt = new Circle(150, 150, 150);
        //ziffernblattRand = new Circle(150, 150, 140);

    }


    public void layoutControls() {
        zblatt.setStyle("-fx-fill: transparent ; -fx-stroke:black;");
        getChildren().addAll(line1, line2, line3, line4, line5, line6, line7, line8, line9, line10, line11, line12, zblatt);

    }

    public void addEventHandlers() {

    }


    public void addValueChangedListeners() {

    }


    public void addBindings() {

    }
}
