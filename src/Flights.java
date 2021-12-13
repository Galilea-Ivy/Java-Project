import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class Flights extends FlightOrder{
	// class variables
	private String[] locations = new String[4];
	private String[] depart = new String[4];
	private String[][] arrival = new String[3][5];
	private String[] flightID = new String[4];
	private Integer[] flightCosts = new Integer[4];
	private String location;
	private int locationNum;
	private int reLocationNum;
	private String flightInfo;
	private int flightCost;
	
	// Constructor
	public Flights() {
		locations[0] = "Chicago, IL";
		locations[1] = "Dallas, TX";
		locations[2] = "Orlando, FL";
		locations[3] = "Atlanta, GA";
		
		depart[0] = "9:30 am  ";
		depart[1] = "1:00 pm  ";
		depart[2] = "5:00 pm  ";
		depart[3] = "10:30 pm ";
		
		arrival[0][0] = locations[0];
		arrival[1][0] = locations[1] + " " + locations[2];
		arrival[2][0] = locations[3];
		arrival[0][1] = "9:40 am ";
		arrival[1][1] = "11:30 am";
		arrival[2][1] = "11:00 am";
		arrival[0][2] = "1:10 pm ";
		arrival[1][2] = "3:00 pm ";
		arrival[2][2] = "2:30 pm ";
		arrival[0][3] = "5:10 pm ";
		arrival[1][3] = "7:00 pm ";
		arrival[2][3] = "6:30 pm ";
		arrival[0][4] = "10:40 pm";
		arrival[1][4] = "12:30 am";
		arrival[2][4] = "12:00 am";

		
		flightCosts[0] = 40;
		flightCosts[1] = 60;
		flightCosts[2] = 55;
		flightCosts[3] = 50;
		
		flightID[0] = "1435";
		flightID[1] = "1436";
		flightID[2] = "1567";
		flightID[3] = "1568";
	}
	
	// Setters and getters
	public void setLocation(int i) {
		if (i > 4) {
			System.out.println("Invalid Input");
		} else {
			location = locations[i];
			locationNum = i;
		}
		
		setFlightCost(i);
		
		if(locationNum == 1 || locationNum == 2)
			reLocationNum = 1;
		else if (locationNum == 0)
			reLocationNum = 0;
		else if (locationNum == 3)
			reLocationNum = 2;
	}
	
	public void setFlight(String id) {		
		if (id.equals(flightID[0])) {
			flightInfo = "Location: " + location + "\nDeparture: " + depart[0] + "\nArrival: " + arrival[reLocationNum][1];
		} else if (id.equals(flightID[1])){
			flightInfo = "Location: " + location + "\nDeparture: " + depart[1] + "\nArrival: " + arrival[reLocationNum][2];
		} else if (id.equals(flightID[2])){
			flightInfo = "Location: " + location + "\nDeparture: " + depart[2] + "\nArrival: " + arrival[reLocationNum][3];
		} else if (id.equals(flightID[3])){
			flightInfo = "Location: " + location + "\nDeparture: " + depart[3] + "\nArrival: " + arrival[reLocationNum][4];
		} else
			System.out.println("Invalid Input");
	}
	
	public String getFlight() {
		return flightInfo;
	}
	
	public void setFlightCost(int i) {
		flightCost = flightCosts[i];
	}
	
	public int getFlightCost() {
		return flightCost;
	}
	
	
	// Displays location
	public GridPane displayLocations() {
		int row = 0;
		// Creating GridPane to display locations
		GridPane displayL = new GridPane();
		displayL.setPadding(new Insets(5,15,15,166));
		displayL.setHgap(10);
		displayL.setVgap(25);
		
		for (int i = 0; i < 4; i++) {
			displayL.add(new Label(locations[i] + ""), 0, row);
			row++;
		}
		
		return displayL;
		
	}
	
	// Displays flight based on location
	public GridPane displayFlights() {
		int c = locationNum;
		int a = reLocationNum;
		int a2 = 1;
		int row = 1;
		
		GridPane displayF = new GridPane();
		displayF.setPadding(new Insets(5,15,15,100));
		displayF.setHgap(15);
		displayF.setVgap(15);
		
		
		displayF.add(new Label("Location: " + location), 0, 0);
		for (int i = 0; i < 4; i++) {
			displayF.add(new Label(flightID[i] + "      |   " + depart[i] + "   | " + arrival[a][a2] + " | $" + flightCosts[c]),
					0, row);
			a2++;
			row++;
		}
		
		return displayF;
	}

}
