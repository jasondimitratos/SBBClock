package SBBClock.model;

import javafx.animation.*;
import javafx.util.Duration;
import javafx.scene.transform.Rotate;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Luzian Seiler on 05/05/16.
 */
public class TimeUpdatePM {

    public boolean sbbActive = false;
    private Timeline sekundenInitialisierer;
    private Timeline stundenAktualisierer;
    private Timeline sbbAktualisierer;

    private Timeline defaultAktualisierer;

    public void use(Rotate stundenRotation, Rotate minutenRotation, Rotate sekundenRotation){
        sbbActive = false;
        if(sekundenInitialisierer != null){
            sekundenInitialisierer.stop();
            stundenAktualisierer.stop();
            sbbAktualisierer.stop();
        }

        defaultAktualisierer = new Timeline(
                new KeyFrame(
                        Duration.seconds(0),
                        actionEvent -> {
                            Calendar kalender = GregorianCalendar.getInstance();
                            double aktuelleStundenWinkel = kalender.get(Calendar.HOUR)*360/12 + kalender.get(Calendar.MINUTE)*30/60;
                            double aktuelleMinutenWinkel = kalender.get(Calendar.MINUTE)*360/60;
                            double aktuelleSekundenWinkel = kalender.get(Calendar.SECOND)*360/60;
                            stundenRotation.setAngle(aktuelleStundenWinkel);
                            minutenRotation.setAngle(aktuelleMinutenWinkel);
                            sekundenRotation.setAngle(aktuelleSekundenWinkel);
                        }
                ),
                new KeyFrame(Duration.seconds(1))
        );
        defaultAktualisierer.setCycleCount(Animation.INDEFINITE);
        defaultAktualisierer.play();

    }

    public void usesbb(Rotate stundenRotation, Rotate minutenRotation, Rotate sekundenRotation){
        sbbActive = true;
        if(defaultAktualisierer != null){
            defaultAktualisierer.stop();
        }
        Calendar myKalender = GregorianCalendar.getInstance();
        final double startStundenWinkel = myKalender.get(Calendar.HOUR)*360/12 + myKalender.get(Calendar.MINUTE)*30/60;
        final double startMinutenWinkel = myKalender.get(Calendar.MINUTE)*360/60;
        final double startSekundenWinkel = myKalender.get(Calendar.SECOND)*360/60;
        stundenRotation.setAngle(startStundenWinkel);
        minutenRotation.setAngle(startMinutenWinkel);
        sekundenRotation.setAngle(startSekundenWinkel);

        sekundenInitialisierer = new Timeline(
                new KeyFrame(
                        Duration.seconds(60-myKalender.get(Calendar.SECOND)),
                        new KeyValue(
                                sekundenRotation.angleProperty(),
                                startSekundenWinkel+6*(60-myKalender.get(Calendar.SECOND)),
                                Interpolator.LINEAR
                        )
                )
        );
        sekundenInitialisierer.play();

        stundenAktualisierer = new Timeline(
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

        sbbAktualisierer = new Timeline(
                new KeyFrame(
                        Duration.seconds(0),
                        actionEvent -> {
                            Calendar kalender = GregorianCalendar.getInstance();
                            double aktuelleMinutenWinkel = kalender.get(Calendar.MINUTE)*360/60;
                            if (kalender.get(Calendar.SECOND) == 0) {
                            } else if (kalender.get(Calendar.SECOND) == 1){
                                final Animation animation1 = new Transition() {
                                    {
                                        setCycleDuration(Duration.millis(400));
                                    }
                                    protected void interpolate(double frac) {
                                        minutenRotation.setAngle(aktuelleMinutenWinkel-6+6*frac);
                                    }
                                };
                                animation1.play();
                                final Animation animation2 = new Transition() {
                                    {
                                        setCycleDuration(Duration.millis(300));
                                    }
                                    protected void interpolate(double frac) {
                                        minutenRotation.setAngle(aktuelleMinutenWinkel-3*frac);
                                    }
                                };
                                animation2.play();
                                final Animation animation3 = new Transition() {
                                    {
                                        setCycleDuration(Duration.millis(300));
                                    }
                                    protected void interpolate(double frac) {
                                        minutenRotation.setAngle(aktuelleMinutenWinkel-3+3*frac);
                                    }
                                };
                                animation3.play();
                            } else if (kalender.get(Calendar.SECOND) == 2){
                                minutenRotation.setAngle(aktuelleMinutenWinkel);
                                sekundenRotation.setAngle(0);
                                final Timeline sekundenAktualisierer = new Timeline(
                                        new KeyFrame(
                                                Duration.seconds(58),
                                                new KeyValue(
                                                        sekundenRotation.angleProperty(),
                                                        sekundenRotation.getAngle()+360,
                                                        Interpolator.LINEAR
                                                )
                                        )
                                );
                                sekundenAktualisierer.play();
                            }
                        }
                ),
                new KeyFrame(Duration.seconds(1))
        );
        sbbAktualisierer.setCycleCount(Animation.INDEFINITE);
        sbbAktualisierer.play();

    }
}

