package lewis.zach.elevator.simulator;

import lewis.zach.elevator.controller.ElevatorController;
import lewis.zach.elevator.model.ElevatorRequest;

/**
 * This class runs the elevator simulator.
 * 
 * @author Zach Lewis
 */
public class ElevatorSimulator 
{
	public static void main(String[] args) 
	{
		int numFloors = 10;
		int numElevators = 5;
		
		ElevatorController controller = new ElevatorController(numFloors, numElevators);
		
//		ElevatorRequest test = new ElevatorRequest(8, 5);
		
		ElevatorRequest req1 = new ElevatorRequest(chooseFloor(numFloors), chooseFloor(numFloors));
		ElevatorRequest req2 = new ElevatorRequest(chooseFloor(numFloors), chooseFloor(numFloors));
		ElevatorRequest req3 = new ElevatorRequest(chooseFloor(numFloors), chooseFloor(numFloors));
		ElevatorRequest req4 = new ElevatorRequest(chooseFloor(numFloors), chooseFloor(numFloors));
		ElevatorRequest req5 = new ElevatorRequest(chooseFloor(numFloors), chooseFloor(numFloors));
		
		controller.handleRequest(req1);
		controller.handleRequest(req2);
		controller.handleRequest(req3);
		controller.handleRequest(req4);
		controller.handleRequest(req5);
		
//		controller.handleRequest(test);
	}
	
	/**
	 * Select a random floor.
	 * 
	 * @param max
	 */
	private static int chooseFloor(int max)
	{
		double random = Math.random();
		
		return (int) (random * max);
	}
}