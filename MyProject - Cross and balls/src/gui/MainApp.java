package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Label lblWelcome;
	private CheckBox chbBalls;
	private Button btnStart;

	private CrossAndBalls ballsWindow;
	private final Controller controller = new Controller();

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Minigames");

		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();

		ballsWindow = new CrossAndBalls("Cross and balls", stage);

	}

	public void initContent(GridPane pane) {

		pane.setGridLinesVisible(true);

		pane.setPadding(new Insets(20));
		pane.setHgap(10);
		pane.setVgap(10);

		pane.setPrefSize(400, 600);

		lblWelcome = new Label("Welcome to the minigames. \n Pick a game");
		pane.add(lblWelcome, 10, 4);

		chbBalls = new CheckBox("Cross and balls bitch");
		pane.add(chbBalls, 4, 15, 20, 1);

		btnStart = new Button("Start selected game");
		pane.add(btnStart, 4, 20, 20, 1);
		btnStart.setOnAction(e -> controller.startGame());

	}

	private class Controller {

		private void startGame() {
			if (chbBalls.isSelected()) {

			} else {
				System.out.println("No game has been picked");
			}

		}
	}
}