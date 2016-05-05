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
        line1 = new Line(6.501,150,41.501,150);
        line2 = new Line(261.024,150,296.025,150);
        line3 = new Line(151.501,40,151.501,5);//
        line4 = new Line(150.501,295,150.501,260);//
        line5 = new Line(96.489,55.156,78.989,24.845);//
        line6 = new Line(224.011,275.155,206.512,244.845);//
        line7 = new Line(56.218,94.99,25.907,77.489);//
        line8 = new Line(277.093,222.512,246.782,205.01);//
        line9 = new Line(56.219,205.011,25.907,222.512);//
        line10 = new Line(277.093,77.49,246.781,94.991);//
        line11 = new Line(96.489,245.282,78.989,275.594);//
        line12 = new Line(206.511,54.719,224.011,24.408);
        zblatt = new Circle(150, 150, 150);
        //ziffernblattRand = new Circle(150, 150, 140);

    }


    public void layoutControls() {
        zblatt.setStyle("-fx-fill: transparent ; -fx-stroke:black;");
        line1.setStyle("-fx-stroke-width: 9px");
        line2.setStyle("-fx-stroke-width: 9px");
        line3.setStyle("-fx-stroke-width: 9px");
        line4.setStyle("-fx-stroke-width: 9px");
        line5.setStyle("-fx-stroke-width: 9px");
        line6.setStyle("-fx-stroke-width: 9px");
        line7.setStyle("-fx-stroke-width: 9px");
        line8.setStyle("-fx-stroke-width: 9px");
        line9.setStyle("-fx-stroke-width: 9px");
        line10.setStyle("-fx-stroke-width: 9px");
        line11.setStyle("-fx-stroke-width: 9px");
        line12.setStyle("-fx-stroke-width: 9px");


        getChildren().addAll(line1, line2, line3, line4, line5, line6, line7, line8, line9, line10, line11, line12, zblatt);

    }

    public void addEventHandlers() {

    }


    public void addValueChangedListeners() {

    }


    public void addBindings() {

    }
}
