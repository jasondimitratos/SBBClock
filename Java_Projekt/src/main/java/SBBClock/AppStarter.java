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

package SBBClock;

import SBBClock.model.WatchPM;
import SBBClock.view.MainUI;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

/**
 * @author Dieter Holz
 */
public class AppStarter extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		WatchPM model = new WatchPM();

		Region rootPanel = new MainUI(model);

		Scene scene = new Scene(rootPanel);

		/* Variante ohne Lambda:
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				System.out.println("Key pressed 2");
				System.out.println("Key pressed 3");
			}
		});

		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				throw new event k;
			}
		});

		        scene.addEventHandler(MouseEvent.MOUSE_CLICKED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        System.out.println("Mouse clicked");
                        event.consume();
                    }
                }
        );

         scene.setOnKeyPressed(event -> {
            System.out.println("Key pressed");
        });

		scene.setOnMouseClicked(event -> {
            System.out.println("Mouse clicked");
        });

		*/

        String stylesheet = getClass().getResource("style.css").toExternalForm();
		scene.getStylesheets().add(stylesheet);

		primaryStage.setTitle(model.getWindowTitle());
		primaryStage.setScene(scene);

		primaryStage.setWidth(315);
		primaryStage.setHeight(340);
		primaryStage.centerOnScreen();

		primaryStage.show();
		rootPanel.requestFocus(); // nötig für KeyPressed event!
	}

	public static void main(String[] args) {
		launch(args);
	}
}
