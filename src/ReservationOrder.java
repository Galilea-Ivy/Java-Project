import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class ReservationOrder {
	// Make a customer object
	private Costumer costumer = new Costumer();
	// Make a seat object
	private Seating seat = new Seating();
	// Make a flight object
	private Flights flight = new Flights();
	
	// Constructor
	public ReservationOrder() {
	}
	
	// Create costumer
	public void createCostumer(TextField tfF, TextField tfL, TextField tfP) {
		// Set costumer information
		costumer.setFirstName(tfF.getText());
		costumer.setLastName(tfL.getText());
		costumer.setPhoneNumber(tfP.getText());
		
		System.out.println(costumer.getFirstName() + " " + costumer.getLastName() + " " + costumer.getPhoneNumber());
		
	}
	
	// Get costumer information
	public GridPane getCostumer() {
		// Create GridPane to display costumer information
		GridPane gpCostumer = new GridPane();
		gpCostumer.setHgap(5);
		gpCostumer.setVgap(5);
		
		gpCostumer.add(new Label("Name: "), 0, 0);
		gpCostumer.add(new Label(costumer.getFirstName() + " " + costumer.getLastName()), 1, 0);
		gpCostumer.add(new Label("Phone Number: "), 0, 1);
		gpCostumer.add(new Label(costumer.getPhoneNumber()), 1, 1);
		
		gpCostumer.setAlignment(Pos.CENTER);
		
		return gpCostumer;
		
	}
	
	// Create Passengers
	public void createPassengers(TextField tfA, TextField tfC) {
		//Set Passengers
		seat.addAdult(Integer.parseInt(tfA.getText()));
		seat.addChild(Integer.parseInt(tfC.getText()));
		
		System.out.println(seat.getAdultNum() + " " + seat.getChildNum() + " " + seat.getPassengers());
	}
	
	// Get Passenger information
	public GridPane getPassengers() {
		// Create GridPane to display passenger information
		GridPane gpPassenger = new GridPane();
		gpPassenger.setHgap(5);
		gpPassenger.setVgap(5);
		
		gpPassenger.add(new Label("# of Adult Passengers: "), 0, 0);
		gpPassenger.add(new Label(String.valueOf(seat.getAdultNum())), 1, 0);
		gpPassenger.add(new Label("# of Children Passengers: "), 0, 1);
		gpPassenger.add(new Label(String.valueOf(seat.getChildNum())), 1, 1);
		gpPassenger.add(new Label("Total # of Passengers: "), 0, 2);
		gpPassenger.add(new Label(String.valueOf(seat.getPassengers())), 1, 2);
		
		gpPassenger.setAlignment(Pos.CENTER);
		
		return gpPassenger;
	}
	
	// Setting Seating
	public void setSeating(int index) {
		// Set seat
		seat.setSeat(index);
		
		System.out.println(index);
	}
	
	// Get Seating information
	public GridPane getSeating() {
		// Create GridPane to display seating information
		GridPane gpSeating = new GridPane();
		gpSeating.setHgap(5);
		gpSeating.setVgap(5);
		
		gpSeating.add(new Label("Seating Type: "), 0, 0);
		gpSeating.add(new Label(seat.getSeat()), 1, 0);
		gpSeating.add(new Label("Total Seating Cost: "), 0, 1);
		gpSeating.add(new Label("$" + seat.getSeatCost()), 1, 1);
		
		gpSeating.setAlignment(Pos.CENTER);
		
		return gpSeating;
	}
	
	// Setting Location
	public void setLocation(int index) {
		flight.setLocation(index);
		
		System.out.println(index);
	}
	
	// Setting Flight
	public void setFlight(String index) {
		flight.setFlight(index);
		
		System.out.println(index);
	}
	
	// returns Flight display
	public GridPane getFlightDisplay() {
		return flight.displayFlights();
	}
	
	// Display Order
	public Scene createOrder() {
		// Create Order information
		GridPane gpOrder = new GridPane();
		gpOrder.setHgap(25);
		gpOrder.setVgap(10);
		
		gpOrder.add(new Label(
				"      Order Overview\n"
				+ "------------------------"), 0, 0);
		gpOrder.add(new Label("Costumer Information\n--------------------------"), 0, 1);
		gpOrder.add(getCostumer(), 0, 2);
		gpOrder.add(new Label("Passenger Information\n----------------------"), 0, 3);
		gpOrder.add(getPassengers(), 0, 4);
		gpOrder.add(new Label("Total Cost: $" + flight.totalCost(seat.getSeatCost(), flight.getFlightCost())), 1, 0);
		gpOrder.add(new Label("Seating Information\n--------------------------"), 1, 1);
		gpOrder.add(getSeating(), 1, 2);
		gpOrder.add(new Label("Flight Information\n----------------------"), 1, 3);
		gpOrder.add(new Label(flight.getFlight()), 1, 4);
		
		gpOrder.setAlignment(Pos.CENTER);
		
		Scene sceneOrder = new Scene(gpOrder, 400, 250);
		
		return sceneOrder;

	}
}
