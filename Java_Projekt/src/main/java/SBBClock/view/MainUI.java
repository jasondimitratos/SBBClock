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
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;


/**
 * @author Luzian Seiler, Jason Dimitratos , Andrea Zirn
 */
public class MainUI extends BorderPane {

	private final WatchPM model;

	public MainUI(WatchPM model) {
		this.model = model;
		initializeControls();
		layoutControls();
		addBindings();
	}

	private TextField valueField;

	private void initializeControls() {
		setPadding(new Insets(10));

		valueField = new TextField();
	}

	private void layoutControls() {
		setMargin(valueField, new Insets(0, 0, 10, 10));
		setRight(valueField);
	}

	private void addEventHandlers() {
	}

	private void addValueChangedListeners() {
	}

	private void addBindings() {

	}

}
