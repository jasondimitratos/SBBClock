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

import SBBClock.model.WatchPM;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.BorderPane;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import java.util.Calendar;
import java.util.GregorianCalendar;


/**
 * @author Luzian Seiler, Jason Dimitratos , Andrea Zirn
 */
public class MainUI extends BorderPane{

    private final WatchPM model;
    private Ziffernblatt ziffernblatt;
    private Stundenzeiger stundenzeiger;
    private Minutenzeiger minutenzeiger;
    private Sekundenzeiger sekundenzeiger;

    public MainUI(WatchPM model) {
        this.model = model;
        initializeControls();
        layoutControls();
        addBindings();
    }


    private void initializeControls() {
        ziffernblatt = new Ziffernblatt(model);
        stundenzeiger = new Stundenzeiger(model);
        minutenzeiger = new Minutenzeiger(model);
        sekundenzeiger = new Sekundenzeiger(model);
    }

    private void layoutControls() {
        setPrefSize(300,300);
        ziffernblatt.setId("ziffernblatt");
        stundenzeiger.setId("stundenzeiger");
        minutenzeiger.setId("minutenzeiger");
        sekundenzeiger.setId("sekundenzeiger");
        getChildren().addAll(ziffernblatt, stundenzeiger, minutenzeiger, sekundenzeiger);

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

        final Timeline aktualisierer = new Timeline(
                new KeyFrame(
                        Duration.seconds(0),
                        actionEvent -> {
                            Calendar kalender = GregorianCalendar.getInstance();
                            double aktuelleStundenWinkel = kalender.get(Calendar.HOUR)*360/12+90;
                            double aktuelleMinutenWinkel = kalender.get(Calendar.MINUTE)*360/60;
                            double aktuelleSekundenWinkel = kalender.get(Calendar.SECOND)*360/60-90;
                            stundenRotation.setAngle(aktuelleStundenWinkel);
                            minutenRotation.setAngle(aktuelleMinutenWinkel);
                            sekundenRotation.setAngle(aktuelleSekundenWinkel);
                        }
                ),
                new KeyFrame(Duration.seconds(1))
        );
        aktualisierer.setCycleCount(Animation.INDEFINITE);
        aktualisierer.play();

    }

    private void addEventHandlers() {
    }

    private void addValueChangedListeners() {
    }

    private void addBindings() {

    }

}
