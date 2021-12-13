import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class StartEndGUI {
	// Main menu scene variables
	private Button Btreserve = new Button("Reserve Now");
	private Button Btnope = new Button("No, Thanks.");
	// End scene variables
	private Button btClose = new Button("Close");
		
	public StartEndGUI() {
		
	}
	
	// First Scene: Main Menu
	public BorderPane startMenuPane() {
		// HBox for the buttons
		HBox hBox  = new HBox(205);
		hBox.setPadding(new Insets(15, 15, 15, 15));
		hBox.getChildren().addAll(Btnope, Btreserve);
		
		// Create UI
		BorderPane bpStart = new BorderPane();
		bpStart.setCenter(new Label("Welcome to Fort Wayne Airline Reservation System!\n"
				+"----------------------------------------------------------\n"
				+ "     Want to register a one way flight reservation?"));
		bpStart.setBottom(hBox);
				
		return bpStart;
	}
	
	// Ending Scene: End
	public BorderPane endPane() {
		BorderPane bpEnd = new BorderPane();
		bpEnd.setCenter(new Label("Thank you\n----------------------------\n "
				+ "You may now close the window."));
		bpEnd.setBottom(btClose);
		
		return bpEnd;
	}
	
	public Button getBtReserve() {
		return Btreserve;
	}
	
	public Button getBtNope() {
		return Btnope;
	}
	
	public Button getBtClose() {
		return btClose;
	}
}
