package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MainApp extends Application {

	private CheckBox chbWeigh, chbWater, chbShower, chbYoga, chbFoodTed, chbImprovCoding, chbStudy, chbSiesta,
			chbWorkout, chbHobby, chbHomework, chbNoScreens;

	// Time of action:
	private Label lblWeigh, lblShower, lblYoga, lblFoodTed, lblImprovCoding, lblStudy, lblSiesta, lblWorkoutOrHobby,
			lblHomework, lblNoScreens;

	private Button btnSaveTheDay;

	public static void main(String[] args) {
		Application.launch(args);

	}

	public void start(Stage stage) {
		stage.setTitle("Daily Routine Checklist App Incorporation Schedule Demolisher");

		GridPane pane = new GridPane();
		initContent(pane);
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	public void initContent(GridPane pane) {
		pane.setVgap(10);
		pane.setHgap(10);
		pane.setPrefSize(1500, 550);

		// Checkboxes and their labels:

		chbWeigh = new CheckBox("Weigh your body");
		pane.add(chbWeigh, 4, 4);
		lblWeigh = new Label("05:00");
		pane.add(lblWeigh, 2, 4);

		chbWater = new CheckBox("Drink 500ml.");
		pane.add(chbWater, 5, 4);

		chbShower = new CheckBox("Shower");
		pane.add(chbShower, 4, 6);
		lblShower = new Label("05:10");
		pane.add(lblShower, 2, 6);

		chbYoga = new CheckBox("Yoga");
		pane.add(chbYoga, 4, 8);
		lblYoga = new Label("06:00");
		pane.add(lblYoga, 2, 8);

		chbFoodTed = new CheckBox("Food & Ted talk");
		pane.add(chbFoodTed, 4, 10);
		lblFoodTed = new Label("07:30");
		pane.add(lblFoodTed, 2, 10);

		chbImprovCoding = new CheckBox("Improv coding");
		pane.add(chbImprovCoding, 4, 12);
		lblImprovCoding = new Label("07:00");
		pane.add(lblImprovCoding, 2, 12);

		chbStudy = new CheckBox("Study");
		pane.add(chbStudy, 4, 14);
		lblStudy = new Label("08:30");
		pane.add(lblStudy, 2, 14);

		chbSiesta = new CheckBox("Siesta");
		pane.add(chbSiesta, 4, 16);
		lblSiesta = new Label("14:30");
		pane.add(lblSiesta, 2, 16);

		chbWorkout = new CheckBox("Workout");
		pane.add(chbWorkout, 4, 18);
		chbHobby = new CheckBox("Hobby");
		pane.add(chbHobby, 5, 18);
		lblWorkoutOrHobby = new Label("18:00");
		pane.add(lblWorkoutOrHobby, 2, 18);

		chbHomework = new CheckBox("Homework");
		pane.add(chbHomework, 4, 20);

		lblHomework = new Label("21:00");
		pane.add(lblHomework, 2, 20);

		chbNoScreens = new CheckBox("Screen free");
		pane.add(chbNoScreens, 4, 22);

		lblNoScreens = new Label("23:00");
		pane.add(lblNoScreens, 2, 22);

		// Save-button
		btnSaveTheDay = new Button("Save the day");
		pane.add(btnSaveTheDay, 4, 28);

	}

}
