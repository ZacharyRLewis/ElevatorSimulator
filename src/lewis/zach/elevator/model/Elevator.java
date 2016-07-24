package lewis.zach.elevator.model;

/**
 * This class represents an elevator.
 * 
 * @author Zach Lewis
 */
public class Elevator 
{
	private int id;
	private int currentFloor = 1;
	private int totalTrips = 0;
	private int totalFloors = 0;
	
	boolean isMoving;
	boolean isActive;
	
	public Elevator(int id)
	{
		this.id = id;
	}
	
	/* Methods */
	
	public void move()
	{
		
	}
	
	public void passFloor()
	{
		
	}
	
	public void logTrip()
	{
		
	}
	
	public void openDoor()
	{
		
	}
	
	public void closeDoor()
	{
		
	}
	
	public void stopForMaintenance()
	{
		
	}
	
	public void restartFromMaintenance()
	{
		
	}
	
	/* Getters and Setters */
	
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public int getCurrentFloor() 
	{
		return currentFloor;
	}
	
	public void setCurrentFloor(int currentFloor) 
	{
		this.currentFloor = currentFloor;
	}
	
	public int getTotalTrips() 
	{
		return totalTrips;
	}
	
	public void setTotalTrips(int totalTrips) 
	{
		this.totalTrips = totalTrips;
	}
	
	public int getTotalFloors() 
	{
		return totalFloors;
	}
	
	public void setTotalFloors(int totalFloors) 
	{
		this.totalFloors = totalFloors;
	}
	
	public boolean isMoving() 
	{
		return isMoving;
	}
	
	public void setMoving(boolean isMoving) 
	{
		this.isMoving = isMoving;
	}
	
	public boolean isActive() 
	{
		return isActive;
	}
	
	public void setActive(boolean isActive) 
	{
		this.isActive = isActive;
	}
}