package guiFX;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Account;

public class LoginWindow extends Stage {

	Account selectedUser;
	Button btnTest = new Button("Expected output is the name of the selected user");

	LoginWindow(String title, Account user) {
		this.setTitle(title);
		this.initModality(Modality.APPLICATION_MODAL);
		GridPane pane = new GridPane();
		this.initPaneContent(pane);
		Scene scene = new Scene(pane);
		this.setScene(scene);
		selectedUser = user;
	}

	private void initPaneContent(GridPane pane) {
		pane.setGridLinesVisible(false);
		pane.setPrefSize(400, 500);
		pane.setVgap(10);
		pane.setHgap(10);

		pane.add(btnTest, 5, 5);
		btnTest.setOnAction(e -> btnAction());

	}

	private void btnAction() {
		System.out.println("Selected user: " + selectedUser.getName());
	}

}
