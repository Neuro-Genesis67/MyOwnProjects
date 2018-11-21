package model;

import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class Stylizer {

	private Label setLblMedium(Label lbl) {
		lbl.setPrefSize(350, 75);
		lbl.setFont(Font.font("Bold Arial", 40));
		return lbl;
	}
}
