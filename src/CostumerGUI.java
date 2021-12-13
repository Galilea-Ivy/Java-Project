import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CostumerGUI {
	// Customer variables
	private TextField tfFirstName = new TextField();
	private TextField tfLastName = new TextField();
	private TextField tfPhoneNumber = new TextField();
	private Button btSave = new Button("Save");
	private Button btNext = new Button("Next");
	
	public CostumerGUI() {
		
	}
	
	// Second Scene: Customer information
	public GridPane customer(ReservationOrder order) {
		// Create GridPane for the customer information
		GridPane gpCustomer = new GridPane();
		gpCustomer.setHgap(5);
		gpCustomer.setVgap(5);
		gpCustomer.add(new Label("  !Please Save Before Continuing!\n   Add the following information\n"
				+ "---------------------------------------"), 1, 0);
		gpCustomer.add(new Label("First Name: "), 0, 1);
		gpCustomer.add(tfFirstName, 1, 1);
		gpCustomer.add(new Label("Last Name: "), 0, 2);
		gpCustomer.add(tfLastName, 1, 2);
		gpCustomer.add(new Label("Phone Number: "), 0, 3);
		gpCustomer.add(tfPhoneNumber, 1, 3);
		gpCustomer.add(btSave,  0, 4);
		gpCustomer.add(btNext, 1, 4);
		
		gpCustomer.setAlignment(Pos.CENTER);
		gpCustomer.setHalignment(btNext, HPos.RIGHT);
		
		btSave.setOnAction(e -> order.createCostumer(tfFirstName, tfLastName, tfPhoneNumber));
		
		return gpCustomer;
	}
	
	public Button getBtNextC() {
		return btNext;
	}

}
