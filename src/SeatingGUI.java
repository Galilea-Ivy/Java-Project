import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class SeatingGUI {
	// Seating variables
	private String[] seatName = {"Economy Class", "Premium Economy", 
			"Business Class", "First Class"};
	private Label title = new Label("\n          Seating Type                            Min-Max\n"
			+ "------------------------------------------------------------");
	private Button btNext3 = new Button("Next");
	
	public SeatingGUI() {
		
	}
	
	// Fourth Scene: Seating type
	public BorderPane seating(ReservationOrder order) {
		//Creating pane for the seating information
		BorderPane bpSeating = new BorderPane();
		BorderPane paneForCB = new BorderPane();
		paneForCB.setPadding(new Insets(3, 30, 20, 25));
		
		Seating seatingD = new Seating();
		
		// Dropdown
		ComboBox<String> cbo = new ComboBox<>();
		paneForCB.setLeft(new Label("Select a seating type: "));
	    paneForCB.setCenter(cbo);
	    paneForCB.setRight(btNext3);
	    paneForCB.setAlignment(cbo, Pos.CENTER_LEFT);
	    
	    ObservableList<String> items = 
	    FXCollections.observableArrayList(seatName); 
	    cbo.getItems().addAll(items); 
		
	    // Seating display
	    bpSeating.setTop(title);
		bpSeating.setCenter(seatingD.displaySeating());
		bpSeating.setBottom(paneForCB);
		
		bpSeating.setAlignment(title, Pos.TOP_CENTER);
		
		cbo.setOnAction(e -> order.setSeating(cbo.getSelectionModel().getSelectedIndex()));
		
		return bpSeating;
	}
	
	public Button getBtNextS() {
		return btNext3;
	}

}
