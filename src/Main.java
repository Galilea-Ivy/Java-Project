import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	// Create a reservation order
	ReservationOrder order = new ReservationOrder();
	// Creat starting menu and end menu object
	StartEndGUI menuGUI = new StartEndGUI();
	// Create costumer GUI object
	CostumerGUI cGUI = new CostumerGUI();
	// Create passenger GUI object
	PassengerGUI pGUI = new PassengerGUI();
	// Create seating GUI object
	SeatingGUI sGUI = new SeatingGUI();
	// Create location GUI object
	LocationGUI lGUI = new LocationGUI();
	// Create flight GUI object
	FlightGUI fGUI = new FlightGUI();
		
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		// Create a scene and place it in the stage
		Scene scene = new Scene(menuGUI.startMenuPane(), 400, 250);
		primaryStage.setTitle("Fort Wayne Airline"); // Set title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

		menuGUI.getBtReserve().setOnAction(e -> {
			Scene scene1 = new Scene(cGUI.customer(order), 400, 250);
			primaryStage.setScene(scene1);});
		
		menuGUI.getBtNope().setOnAction(e -> {
			Scene sceneEnd = new Scene(menuGUI.endPane(), 400, 250);
			primaryStage.setScene(sceneEnd);
		});
		
		menuGUI.getBtClose().setOnAction(e -> Platform.exit());
		
		cGUI.getBtNextC().setOnAction(e -> {
		Scene scene2 = new Scene(pGUI.passenger(order), 400, 250);
		primaryStage.setScene(scene2);});
		
		pGUI.getbtNextP().setOnAction(e -> {
			Scene scene3 = new Scene(sGUI.seating(order), 400, 250);
			primaryStage.setScene(scene3);
		});
		
		sGUI.getBtNextS().setOnAction(e -> {
			Scene scene4 = new Scene(lGUI.location(order), 400, 250);
			primaryStage.setScene(scene4);
		});
		
		lGUI.getBtNextL().setOnAction(e -> {
			Scene scene5 = new Scene(fGUI.flights(order), 400, 250);
			primaryStage.setScene(scene5);
		});
		
		fGUI.getBtNextF().setOnAction(e -> {
			primaryStage.setScene(order.createOrder());
		});
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);

	}

}