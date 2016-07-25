package lewis.zach.elevator.model;

import java.text.MessageFormat;

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
	
	public void move(int destination)
	{
		String direction = currentFloor < destination ? "up" : "down";
		
		logTrip(destination, direction);
		
		while(Math.abs(currentFloor - destination) > 0)
		{
			if(direction.equals("up"))
			{
				currentFloor++;
			}
			else
			{
				currentFloor--;
			}
			
			if(Math.abs(currentFloor - destination) > 0)
			{
				passFloor(currentFloor);
			}
			else
			{
				openDoor(currentFloor);
			}
		}
	}
	
	public void logTrip(int destination, String direction)
	{
		System.out.println(MessageFormat.format("Elevator #{0} embarking on trip #{1} going {2} to floor #{3} from floor #{4}", id, totalTrips, direction, destination, currentFloor));
	}
	
	public void passFloor(int floor)
	{
		System.out.println(MessageFormat.format("	Elevator #{0} passed floor #{1}", id, floor));
	}

	public void openDoor(int floor)
	{
		System.out.println(MessageFormat.format("	Elevator #{0} opened door at floor #{1}", id, floor));
		
		isMoving = false;
	}
	
	public void closeDoor(int floor)
	{
		System.out.println(MessageFormat.format("	Elevator #{0} closed door at floor #{1}", id, floor));
	}
	
	public void stopForMaintenance()
	{
		System.out.println(MessageFormat.format("	Elevator #{0} stopping for maintenance after trip #{1}", id, totalTrips));
		
		isMoving = false;
		isActive = false;
	}
	
	public void restartFromMaintenance()
	{
		System.out.println(MessageFormat.format("	Elevator #{0} restarting after maintenance on floor #{1}", id, currentFloor));
		
		isActive = true;
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