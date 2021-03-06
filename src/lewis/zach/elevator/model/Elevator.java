package lewis.zach.elevator.model;

import java.text.MessageFormat;

/**
 * This class represents an elevator.
 * 
 * @author Zach Lewis
 */
public class Elevator 
{
	public static final int MAX_TRIPS_B4_MAINTENANCE = 100;
	
	private int id;
	private int currentFloor = 1;
	private int totalTrips = 0;
	private int totalFloors = 0;
	
	boolean isMoving = false;
	boolean isActive = true;
	
	public Elevator(int id)
	{
		this.id = id;
	}
	
	/* Methods */
	
	/**
	 * Move the elevator to the destination floor.
	 * 
	 * @param destination
	 * @param max
	 * @param min
	 */
	public void move(int destination, int origin, int max, int min)
	{
		int stop = destination > origin ? destination : origin;
		
		String direction = currentFloor < stop ? "up" : "down";
		
		logTrip(destination, origin);
		
		while(Math.abs(currentFloor - stop) > 0)
		{			
			if(direction.equals("up") && (currentFloor + 1 <= max))
			{
				currentFloor++;
			}
			else if(currentFloor - 1 >= min)
			{
				currentFloor--;
			}
			else
			{
				System.out.println(MessageFormat.format("Something unexpected happened when trying to go {0} from floor {1}", direction, currentFloor));
			}
			
			if(Math.abs(currentFloor - destination) > 0)
			{
				if(currentFloor == origin)
				{
					openDoor(currentFloor, true);
					closeDoor(currentFloor);
					isMoving = true;
					
					if(destination > stop && !direction.equals("up"))
					{
						direction = "up";
						stop = destination;
					}
					else if(destination < stop && !direction.equals("down"))
					{
						direction = "down";
						stop = destination;
					}
				}
				else
				{
					passFloor(currentFloor);
				}
			}
			else if(direction.equals("up") && origin > destination)
			{
				passFloor(currentFloor);
			}
			else if(direction.equals("down") && origin < destination)
			{
				passFloor(currentFloor);
			}
			else
			{
				openDoor(currentFloor, false);
				isMoving = false;
				closeDoor(currentFloor);
			}
		}
		
		if(totalTrips % MAX_TRIPS_B4_MAINTENANCE == 0)
		{
			stopForMaintenance();
		}
	}
	
	public void logTrip(int destination, int origin)
	{
		System.out.println(MessageFormat.format("Elevator #{0} embarking on trip #{1} starting at floor #{2}, stopping at floor #{3} to pick up and dropping off at floor #{4}", id, ++totalTrips, currentFloor, origin, destination));
	}
	
	public void passFloor(int floor)
	{
		System.out.println(MessageFormat.format("	Elevator #{0} passed floor #{1}", id, floor));
	}

	public void openDoor(int floor, boolean pickup)
	{
		String extra = pickup ? "pick up" : "drop off";
		
		System.out.println(MessageFormat.format("	Elevator #{0} opened door at floor #{1} to {2} passenger", id, floor, extra));
		
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
	
	public void receiveMaintenance()
	{
		System.out.println(MessageFormat.format("	Elevator #{0} has received maintenance on floor #{1}. Will reactivate.", id, currentFloor));
		
		isActive = true;
	}
	
	public String toString() 
	{
		return "Elevator [id=" + id + ", currentFloor=" + currentFloor + ", totalTrips=" + totalTrips + ", totalFloors="
				+ totalFloors + ", isMoving=" + isMoving + ", isActive=" + isActive + "]";
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