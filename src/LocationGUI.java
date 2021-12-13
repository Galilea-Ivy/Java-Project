import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class LocationGUI {
	// Location Variables
	private String[] locationName = {"Chicago, IL", "Dallas, TX", "Orlando, FL", "Atlanta, GA"};
	private Label titleL = new Label("\n             Locations\n-------------------------------");
	private Button btNext4 = new Button("Next");
	
	public LocationGUI() {
		
	}
	
	// Fifth Scene: Location
	public BorderPane location(ReservationOrder order) {
		//Creating pane for the locations
		BorderPane bpLocation = new BorderPane();
		BorderPane paneForCB = new BorderPane();
		paneForCB.setPadding(new Insets(3,30,20,25));
		
		Flights flightD = new Flights();
		
		// Dropdown
		ComboBox<String> cbo = new ComboBox<>();
		paneForCB.setLeft(new Label("Select a Location: "));
	    paneForCB.setCenter(cbo);
	    paneForCB.setRight(btNext4);
	    paneForCB.setAlignment(cbo, Pos.CENTER_LEFT);
	    
	    ObservableList<String> items = 
	    FXCollections.observableArrayList(locationName); 
	    cbo.getItems().addAll(items); 
		
	    // Location display
	    bpLocation.setTop(titleL);
		bpLocation.setCenter(flightD.displayLocations());
		bpLocation.setBottom(paneForCB);
		
		bpLocation.setAlignment(titleL, Pos.TOP_CENTER);
		
		cbo.setOnAction(e -> order.setLocation(items.indexOf(cbo.getValue())));
		System.out.print(items.indexOf(cbo.getValue()));
		
		return bpLocation;
	}
	
	public Button getBtNextL() {
		return btNext4;
	}

}
