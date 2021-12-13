
public class FlightOrder {
	// Class variables
	private int childPass;
	private int adultPass;
	private int totalPass;
	
	// Constructor
	public FlightOrder(){
		childPass = 0;
		adultPass = 0;
		totalPass = 0;
	}
	
	// Setters and getters
	public void addChild(int child) {
		childPass = childPass + child;
	}
	
	public int getChildNum() {
		return childPass;
	}
	
	public void addAdult(int adult) {
		adultPass = adultPass + adult;
	}
	
	public int getAdultNum() {
		return adultPass;
	}
	
	public int getPassengers() {
		return totalPass = adultPass + childPass;
	}
	
	// Total order cost method
	public int totalCost(int flight, int seat) {
		int total;
		
		total = flight + seat;
		
		return total;
	}

}
