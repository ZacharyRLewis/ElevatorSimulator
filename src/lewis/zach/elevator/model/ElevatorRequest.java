package lewis.zach.elevator.model;

/**
 * This class represents an elevator trip request.
 * 
 * @author Zach Lewis
 */
public class ElevatorRequest 
{
	private int originFloor;
	private int destinationFloor;
	
	public ElevatorRequest(int originFloor, int destinationFloor) 
	{
		this.originFloor = originFloor;
		this.destinationFloor = destinationFloor;
	}

	/* Getters and Setters */
	
	public int getOriginFloor() 
	{
		return originFloor;
	}
	
	public int getDestinationFloor() 
	{
		return destinationFloor;
	}
}