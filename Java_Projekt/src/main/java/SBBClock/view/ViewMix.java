package SBBClock.view;

/**
 * Created by andreazirn on 05/05/16.
 */
public interface ViewMix<T> {

    T getWatchPM();

    default void init() {
        initializeControls();
        layoutControls();
        addEventHandlers();
        addValueChangedListeners();
        addBindings();
    }

    void initializeControls();

    void layoutControls();

    default void addEventHandlers() {
    }

    default void addValueChangedListeners() {
    }

    default void addBindings() {
    }
}