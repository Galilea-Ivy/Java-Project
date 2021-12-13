import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class FlightGUI {
	// Flight Variables
	private String[] flightID = {"1435", "1436", "1567", "1568"};
	private Label titleF = new Label(
			    "\n   Flight  ID   |   Departure   |   Arrival    |   Cost"
			+ "\n----------------------------------------------------");
	private Button btNext5 = new Button("Next");
	
	public FlightGUI() {
		
	}
	
	// Sixth Scene: Flights
	public BorderPane flights(ReservationOrder order) {
		// Creating pane for the flight information
		BorderPane bpFlights = new BorderPane();
		BorderPane paneForCB = new BorderPane();
		paneForCB.setPadding(new Insets(3, 30, 20, 25));
		
		// Dropdown
		ComboBox<String> cbo = new ComboBox<>();
		paneForCB.setLeft(new Label("Select a Flight: "));
		paneForCB.setCenter(cbo);
		paneForCB.setRight(btNext5);
		paneForCB.setAlignment(cbo, Pos.CENTER_LEFT);
			    
		ObservableList<String> items = 
		FXCollections.observableArrayList(flightID); 
		cbo.getItems().addAll(items); 
				
		// Flight display
		bpFlights.setTop(titleF);
		bpFlights.setCenter(order.getFlightDisplay());
		bpFlights.setBottom(paneForCB);
				
		bpFlights.setAlignment(titleF, Pos.TOP_CENTER);
				
		cbo.setOnAction(e -> order.setFlight(flightID[items.indexOf(cbo.getValue())]));
		System.out.println("They all excute");
			
		return bpFlights;
	}
	
	public Button getBtNextF() {
		return btNext5;
	}

}
