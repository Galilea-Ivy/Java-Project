import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PassengerGUI {
	// Passenger variables
	private TextField tfChildren = new TextField();
	private TextField tfAdults = new TextField();
	private Button btSave2 = new Button("Save");
	private Button btNext2 = new Button("Next");
	
	public PassengerGUI() {
		
	}
	
	// Third Scene: Passenger information
	public GridPane passenger(ReservationOrder order) {
		GridPane gpPass = new GridPane();
		gpPass.setHgap(5);
		gpPass.setVgap(5);
		gpPass.add(new Label("  !Please Save Before Continuing!\n   Passenger Information\n"
				+ "---------------------------------------"), 1, 0);
		gpPass.add(new Label("Enter number of Adults (16+): "), 0, 1);
		gpPass.add(tfAdults, 1, 1);
		gpPass.add(new Label("Enter number of Children: "), 0, 2);
		gpPass.add(tfChildren, 1, 2);
		gpPass.add(btSave2, 0, 3);
		gpPass.add(btNext2, 1, 3);
		
		gpPass.setAlignment(Pos.CENTER);
		gpPass.setHalignment(btSave2, HPos.RIGHT);
		gpPass.setHalignment(btNext2, HPos.RIGHT);
		
		btSave2.setOnAction(e -> order.createPassengers(tfAdults, tfChildren));
		
		
		return gpPass;
	}
	
	public Button getbtNextP() {
		return btNext2;
	}

}
