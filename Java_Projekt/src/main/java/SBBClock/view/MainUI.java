/*
 *
 * Copyright (c) 2015 by FHNW
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package SBBClock.view;

import SBBClock.model.TimeUpdatePM;
import SBBClock.model.WatchPM;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 * @author Luzian Seiler, Jason Dimitratos , Andrea Zirn
 */
public class MainUI extends Region{

    private final WatchPM model;
    private Zifferblatt zifferblatt;
    private Stundenzeiger stundenzeiger;
    private Minutenzeiger minutenzeiger;
    private Sekundenzeiger sekundenzeiger;

    private static final double PREFERRED_SIZE = 300;
    private static final double MINIMUM_SIZE   = 75;
    private static final double MAXIMUM_SIZE   = 800;

    private Pane drawingPane;

    public MainUI(WatchPM model) {
        this.model = model;
        init();
        initializeControls();
        layoutControls();
        addBindings();
    }

    private void init() {
        Insets padding = getPadding();
        double verticalPadding = padding.getTop() + padding.getBottom();
        double horizontalPadding = padding.getLeft() + padding.getRight();
        setMinSize(MINIMUM_SIZE + horizontalPadding, MINIMUM_SIZE + verticalPadding);
        setPrefSize(PREFERRED_SIZE + horizontalPadding, PREFERRED_SIZE + verticalPadding);
        setMaxSize(MAXIMUM_SIZE + horizontalPadding, MAXIMUM_SIZE + verticalPadding);
        addEventHandlers();
    }


    private void initializeControls() {
        zifferblatt = new Zifferblatt(model);
        stundenzeiger = new Stundenzeiger(model);
        minutenzeiger = new Minutenzeiger(model);
        sekundenzeiger = new Sekundenzeiger(model);
        drawingPane = new Pane();
        drawingPane.setMaxSize(PREFERRED_SIZE, PREFERRED_SIZE);
        drawingPane.setMinSize(PREFERRED_SIZE, PREFERRED_SIZE);
        drawingPane.setPrefSize(PREFERRED_SIZE, PREFERRED_SIZE);
    }

    private void layoutControls() {
        setPadding(new Insets(10));
        zifferblatt.setId("zifferblatt");
        stundenzeiger.setId("stundenzeiger");
        minutenzeiger.setId("minutenzeiger");
        sekundenzeiger.setId("sekundenzeiger");
        drawingPane.getChildren().addAll(zifferblatt, stundenzeiger, minutenzeiger, sekundenzeiger);
        getChildren().add(drawingPane);


        final Rotate stundenRotation = new Rotate();
        final Rotate minutenRotation = new Rotate();
        final Rotate sekundenRotation = new Rotate();

        stundenzeiger.getTransforms().add(stundenRotation);
        minutenzeiger.getTransforms().add(minutenRotation);
        sekundenzeiger.getTransforms().add(sekundenRotation);

        stundenRotation.setPivotX(150);
        stundenRotation.setPivotY(150);
        minutenRotation.setPivotX(150);
        minutenRotation.setPivotY(150);
        sekundenRotation.setPivotX(150);
        sekundenRotation.setPivotY(150);


        TimeUpdatePM tu = new TimeUpdatePM();
        // Wahl zwischen SBB-Verhalten und normalem Sekundenzeiger-Verhalten:
        // tu.use(stundenRotation, minutenRotation, sekundenRotation);
        // tu.usesbb(stundenRotation, minutenRotation, sekundenRotation);
        tu.usesbb(stundenRotation, minutenRotation, sekundenRotation);

        this.setOnKeyPressed(event -> {
            if(tu.sbbActive){
                tu.use(stundenRotation, minutenRotation, sekundenRotation);
            }else{
                tu.usesbb(stundenRotation, minutenRotation, sekundenRotation);
            }
            // System.out.println("Key pressed");
        });

        this.setOnMouseClicked(event -> {
            if(tu.sbbActive){
                tu.use(stundenRotation, minutenRotation, sekundenRotation);
            }else{
                tu.usesbb(stundenRotation, minutenRotation, sekundenRotation);
            }
            // System.out.println("Mouse clicked");
        });

    }


    @Override
    protected void layoutChildren() {
        super.layoutChildren();
        resize();
    }

    private void resize() {
        double width  = getWidth() - getInsets().getLeft() - getInsets().getRight();
        double height = getHeight() - getInsets().getTop() - getInsets().getBottom();
        double size = Math.max(Math.min(Math.min(width, height), MAXIMUM_SIZE), MINIMUM_SIZE);

        double scalingFactor = size / PREFERRED_SIZE;

        if(width > 0 && height > 0){
            drawingPane.relocate((getWidth() - PREFERRED_SIZE) * 0.5, (getHeight() - PREFERRED_SIZE) * 0.5);
            drawingPane.setScaleX(scalingFactor);
            drawingPane.setScaleY(scalingFactor);
        }
    }

    private void addEventHandlers() {
    }

    private void addValueChangedListeners() {
    }

    private void addBindings() {

    }

}
