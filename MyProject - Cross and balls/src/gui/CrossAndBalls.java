package gui;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CrossAndBalls extends Stage {

	public CrossAndBalls(String title, Stage owner) {
		this.setTitle(title);

		// this.initModality(Modality.APPLICATION_MODAL);

		this.setMinHeight(400);
		this.setMinWidth(400);

		GridPane pane = new GridPane();
		// this.initContent();

		Scene scene = new Scene(pane);
		this.setScene(scene);
	}

}
