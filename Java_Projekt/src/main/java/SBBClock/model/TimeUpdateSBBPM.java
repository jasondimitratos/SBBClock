package SBBClock.model;

import javafx.animation.*;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Luzian Seiler on 05/05/16.
 */
public class TimeUpdateSBBPM {

    public TimeUpdateSBBPM(Rotate stundenRotation, Rotate minutenRotation, Rotate sekundenRotation){
        Calendar myKalender = GregorianCalendar.getInstance();
        final double startStundenWinkel = myKalender.get(Calendar.HOUR)*360/12 + myKalender.get(Calendar.MINUTE)*30/60;
        final double startSekundenWinkel = myKalender.get(Calendar.SECOND)*360/60;
        stundenRotation.setAngle(startStundenWinkel);
        sekundenRotation.setAngle(startSekundenWinkel);

        final Timeline stundenAktualisierer = new Timeline(
                new KeyFrame(
                        Duration.hours(12),
                        new KeyValue(
                                stundenRotation.angleProperty(),
                                startStundenWinkel+360,
                                Interpolator.LINEAR
                        )
                )
        );
        stundenAktualisierer.setCycleCount(Animation.INDEFINITE);
        stundenAktualisierer.play();

        final Timeline minutenAktualisierer = new Timeline(
                new KeyFrame(
                        Duration.seconds(0),
                        actionEvent -> {
                            Calendar kalender = GregorianCalendar.getInstance();
                            double aktuelleSekundenWinkel = kalender.get(Calendar.SECOND)*360/60;
                            double aktuelleMinutenWinkel = kalender.get(Calendar.MINUTE)*360/60;
                            if (kalender.get(Calendar.SECOND) == 0) {
                            } else if (kalender.get(Calendar.SECOND) == 1){
                                /*Timeline sprung = new Timeline(
                                        new KeyFrame(Duration.ZERO, event -> minutenRotation.setAngle(aktuelleMinutenWinkel-3)),
                                        new KeyFrame(Duration.millis(50), event -> minutenRotation.setAngle(aktuelleMinutenWinkel-2)),
                                        new KeyFrame(Duration.millis(50), event -> minutenRotation.setAngle(aktuelleMinutenWinkel-1)),
                                        new KeyFrame(Duration.millis(50), event -> minutenRotation.setAngle(aktuelleMinutenWinkel)),
                                        new KeyFrame(Duration.millis(50), event -> minutenRotation.setAngle(aktuelleMinutenWinkel+1)),
                                        new KeyFrame(Duration.millis(50), event -> minutenRotation.setAngle(aktuelleMinutenWinkel+2)),
                                        new KeyFrame(Duration.millis(50), event -> minutenRotation.setAngle(aktuelleMinutenWinkel+3)),
                                        new KeyFrame(Duration.millis(50), event -> minutenRotation.setAngle(aktuelleMinutenWinkel+2)),
                                        new KeyFrame(Duration.millis(50), event -> minutenRotation.setAngle(aktuelleMinutenWinkel+1)),
                                        new KeyFrame(Duration.millis(50), event -> minutenRotation.setAngle(aktuelleMinutenWinkel)),
                                        new KeyFrame(Duration.millis(50), event -> minutenRotation.setAngle(aktuelleMinutenWinkel-1)),
                                        new KeyFrame(Duration.millis(50), event -> minutenRotation.setAngle(aktuelleMinutenWinkel-2)),
                                        new KeyFrame(Duration.millis(50), event -> minutenRotation.setAngle(aktuelleMinutenWinkel-3)),
                                        new KeyFrame(Duration.millis(50), event -> minutenRotation.setAngle(aktuelleMinutenWinkel-2)),
                                        new KeyFrame(Duration.millis(50), event -> minutenRotation.setAngle(aktuelleMinutenWinkel-1)),
                                        new KeyFrame(Duration.millis(50), event -> minutenRotation.setAngle(aktuelleMinutenWinkel))
                                );
                                sprung.play();*/
                                final Animation animation1 = new Transition() {
                                    {
                                        setCycleDuration(Duration.millis(400));
                                    }
                                    protected void interpolate(double frac) {
                                        minutenRotation.setAngle(aktuelleMinutenWinkel-6+6*frac);
                                        // animiert bis 3° über den neuen Zeiger-Standort hinaus
                                    }
                                };
                                animation1.play();
                                final Animation animation2 = new Transition() {
                                    {
                                        setCycleDuration(Duration.millis(300));
                                    }
                                    protected void interpolate(double frac) {
                                        minutenRotation.setAngle(aktuelleMinutenWinkel-3*frac);
                                        // animiert bis 3° vor dem neuen Zeiger-Standort
                                    }
                                };
                                animation2.play();
                                final Animation animation3 = new Transition() {
                                    {
                                        setCycleDuration(Duration.millis(300));
                                    }
                                    protected void interpolate(double frac) {
                                        minutenRotation.setAngle(aktuelleMinutenWinkel-3+3*frac);
                                        // animiert bis zum neuen Zeiger-Standort
                                    }
                                };
                                animation3.play();
                            } else{
                                minutenRotation.setAngle(aktuelleMinutenWinkel);
                            }
                        }
                ),
                new KeyFrame(Duration.seconds(1))
        );
        minutenAktualisierer.setCycleCount(Animation.INDEFINITE);
        minutenAktualisierer.play();

        final Timeline sekundenAktualisierer = new Timeline(
                new KeyFrame(
                        Duration.seconds(60),
                        new KeyValue(
                                sekundenRotation.angleProperty(),
                                startSekundenWinkel+360,
                                Interpolator.LINEAR
                        )
                )
        );
        sekundenAktualisierer.setCycleCount(Animation.INDEFINITE);
        sekundenAktualisierer.play();

    }
}

