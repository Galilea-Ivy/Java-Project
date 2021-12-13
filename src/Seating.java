import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class Seating extends FlightOrder{
	// Class variables
	private long seatingID;
	private String[] seatingType = new String[4];
	private Integer[] seatingCost = new Integer[4];
	private Integer[][] minMax = new Integer[4][2];
	private String seat;
	private int seatCost;
	
	// Constructor
	public Seating() {
		seatingType[0] = "Economy Class       ";
		seatingType[1] = "Premium Economy ";
		seatingType[2] = "Business Class     ";
		seatingType[3] = "First Class        ";
		
		minMax[0][0] = 15;
		minMax[0][1] = 20;
		minMax[1][0] = 60;
		minMax[1][1] = 80;
		minMax[2][0] = 400;
		minMax[2][1] = 600;
		minMax[3][0] = 1300;
		minMax[3][1] = 1500;
		
		seatingCost[0] = getRandomNumber(15, 20);
		seatingCost[1] = getRandomNumber(60, 80);
		seatingCost[2] = getRandomNumber(400, 600);
		seatingCost[3] = getRandomNumber(1300, 1500);
	}
	
	// Setters and Getters
	public void setSeat(int i) {			
		if (i > 4) {
			System.out.println("Invalid input");
		} else
			seat = seatingType[i];
		
		setSeatCost(i);
	}
	
	public String getSeat() {
		return seat;
	}
	
	public void setSeatCost(int i) {
		if(i > 4) {
			System.out.println("Invalid input");
		} else {
			seatCost = seatingCost[i] * getPassengers();
		}
	}
	
	public int getSeatCost() {
		return seatCost;
	}
	
	public GridPane displaySeating() {
		int j = 0;
		int h = 1;
		int row = 0;
		int column = 0;
		// Create GridPane to diaplay seating options
		GridPane displayS = new GridPane();
		displayS.setPadding(new Insets(5, 15, 15, 95));
		displayS.setHgap(10);
		displayS.setVgap(25);
		
		for (int i = 0; i < 4; i++) {
			displayS.add(new Label(seatingType[i] + "----------$" + minMax[i][j] + " - $" + minMax[i][h]), 
					column, row);
			row++;
		}
		
		return displayS;
	}
	
	// Random number method for price range
	public int getRandomNumber(int min, int max) {
	    return (int) ((Math.random() * (max - min)) + min);
	}

}