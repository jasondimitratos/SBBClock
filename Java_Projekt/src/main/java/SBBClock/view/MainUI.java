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
import javafx.scene.layout.BorderPane;


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
	}

	private void addEventHandlers() {
	}

	private void addValueChangedListeners() {
	}

	private void addBindings() {

	}

}
