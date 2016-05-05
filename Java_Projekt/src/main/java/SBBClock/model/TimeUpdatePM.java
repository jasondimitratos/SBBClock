package SBBClock.model;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.scene.transform.Rotate;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Luzian Seiler on 05/05/16.
 */
public class TimeUpdatePM {

    public TimeUpdatePM(Rotate stundenRotation, Rotate minutenRotation, Rotate sekundenRotation){
        final Timeline aktualisierer = new Timeline(
                new KeyFrame(
                        Duration.seconds(0),
                        actionEvent -> {
                            Calendar kalender = GregorianCalendar.getInstance();
                            double aktuelleStundenWinkel = kalender.get(Calendar.HOUR)*360/12;
                            double aktuelleMinutenWinkel = kalender.get(Calendar.MINUTE)*360/60;
                            double aktuelleSekundenWinkel = kalender.get(Calendar.SECOND)*360/60;
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
}

