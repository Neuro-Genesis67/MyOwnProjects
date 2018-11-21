package guiFX;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Account;
import model.Stylizer;

public class MainApp extends Application {

	private final Controller controller = new Controller();
	private Label lblName, lblPass, lblError;
	private Button btnCreate, btnLogin, btnDelete;
	private TextField txfName;
	private PasswordField txfPass;
	private HBox hbActions, hbName, hbPass;
	private VBox vb;
	private ListView lvwAccounts;
	private static int accountID;
	private String accountName;
	private ArrayList<Account> accounts = new ArrayList<>();
	Account selectedAccount;
	Stylizer stylizer;

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		stage.setTitle("Programming motivation logger");
		GridPane pane = new GridPane();

		pane.setPrefSize(500, 700);
		this.initPaneContent(pane);

		Scene scene = new Scene(pane);

		stage.setMaximized(true);
		stage.setScene(scene);
		stage.show();

	}

	public void initPaneContent(GridPane pane) {
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(10);
		pane.setVgap(10);

		// Labels
		lblName = new Label("Name");
		lblPass = new Label("Password");
		lblError = new Label("");

//		stylizer.lblName.setPrefSize(350, 75);
		lblName.setFont(Font.font("Bold Arial", 40));

		lblPass.setPrefSize(350, 75);
		lblPass.setFont(Font.font("Bold Arial", 40));

		// Textfield & Passfield
		txfName = new TextField();
		txfPass = new PasswordField();
		pane.add(txfName, 6, 8, 25, 1);
		pane.add(txfPass, 6, 10, 25, 1);

		// Buttons
		btnLogin = new Button("Login");
		btnCreate = new Button("Create new account");
		btnDelete = new Button("Delete account");
		// Stylizer.createMediumButton(btnTitle);
		btnLogin.setPrefSize(350, 75);
		btnLogin.setFont(Font.font("Bold Arial", 40));

		btnLogin.setOnAction(e -> this.controller.loginAction());
		btnCreate.setOnAction(e -> this.controller.createAction());
		btnDelete.setOnAction(e -> this.controller.removeAction());

		// ListView
		lvwAccounts = new ListView();
		pane.add(lvwAccounts, 6, 17, 20, 1);
		lvwAccounts.getItems().setAll(accounts);
		lvwAccounts.setOnMouseClicked(event -> controller.selectedListItem());

		// VBox & HBox
		vb = new VBox();

		hbName = new HBox();
		hbPass = new HBox();
		hbActions = new HBox();

		hbName.setSpacing(75);
		hbPass.setSpacing(75);
		hbActions.setSpacing(75);

		hbName.getChildren().add(lblName);
		hbName.getChildren().add(txfName);
		hbPass.getChildren().add(lblPass);
		hbPass.getChildren().add(txfPass);
		hbActions.getChildren().add(btnLogin);
		hbActions.getChildren().add(btnCreate);
		hbActions.getChildren().add(btnDelete);

		pane.add(vb, 1, 1);
		vb.getChildren().add(hbName);
		vb.getChildren().add(hbPass);
		vb.getChildren().add(hbActions);
		vb.getChildren().add(lvwAccounts);

	}

	private class Controller {

		private void createAction() {
			if (txfName.getText() == null) {
				lblError.setText("Name required");
			} else if (txfPass.getText() == null) {
				lblError.setText("Password required");
			} else {

				String name = txfName.getText();
				String pass = txfPass.getText();
				txfName.clear();
				txfPass.clear();

				if (name.length() != 0 && pass.length() != 0) {

					Account newAccount = new Account(name, pass);
					accounts.add(newAccount);
					lvwAccounts.getItems().setAll(accounts);
					accountID += 1;

				}
			}
		}

		private void loginAction() {

			// boolean found = false;
			selectedAccount = null;

			for (Account u : accounts) {
				String name = u.getName();
				String pass = u.getPassword();
				String tempName = txfName.getText();
				String tempPass = txfPass.getText();

				if (name.equals(tempName) && pass.equals(tempPass)) {
					selectedAccount = u;
					LoginWindow lw = new LoginWindow("Current account: " + selectedAccount.getName(), selectedAccount);
					lw.showAndWait();
					lblError.setText("Success");
				}
				if (selectedAccount == null) {
					lblError.setText("Incorrect password, fool");
				}

			}

			txfPass.clear();

		}

		private void removeAction() {
			accounts.remove(lvwAccounts.getSelectionModel().getSelectedItem());
			lvwAccounts.getItems().setAll(accounts);
			txfName.clear();
			// Husk at du nu bruger account istedet for user
			// user = (User) lvwUsers.getSelectionModel().getSelectedItem();
			// for (int i = 0; i < user.getUsers().size(); i++) {
			// if (user.getUsers().get(i) == user) {
			// user.removeUser(user.getUsers().get(i));
			// }
			// }
		}

		private void selectedListItem() {
			txfPass.clear();
			Account item = (Account) lvwAccounts.getSelectionModel().getSelectedItem();
			txfName.setText(item.getName());
			txfPass.requestFocus();
		}

	}
}
