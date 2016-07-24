package lewis.zach.elevator.controller;

/**
 * This class controls elevator operations.
 * 
 * @author Zach Lewis
 */
public class ElevatorController 
{
	public static final int MIN_FLOOR = 1;
	public static final int MAX_TRIPS_B4_MAINTENANCE = 100;
	
	private int numFloors;
	private int numElevators;
	
	public ElevatorController(int numFloors, int numElevators)
	{
		this.numFloors = numFloors;
		this.numElevators = numElevators;
	}
	
}
