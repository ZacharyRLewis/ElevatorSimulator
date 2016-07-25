package lewis.zach.elevator.controller;

import java.util.ArrayList;
import java.util.List;

import lewis.zach.elevator.model.Elevator;
import lewis.zach.elevator.model.ElevatorRequest;
import lewis.zach.elevator.model.Floor;

/**
 * This class controls elevator operations.
 * 
 * @author Zach Lewis
 */
public class ElevatorController 
{
	public static final int MIN_FLOOR = 1;
	
	private List<Floor> floors = new ArrayList<Floor>();
	private List<Elevator> elevators = new ArrayList<Elevator>();
	
	public ElevatorController(int numFloors, int numElevators)
	{
		for(int i = 1; i <= numFloors; i++)
		{
			floors.add(new Floor(i));
		}
		
		for(int i = 1; i <= numElevators; i++)
		{
			elevators.add(new Elevator(i));
		}
	}

	/* Methods */
	
	/**
	 * Handle the elevator trip request.
	 * 
	 * @param request
	 */
	public void handleRequest(ElevatorRequest request)
	{
		Elevator elev = selectElevator(request.getOriginFloor(), request.getDestinationFloor());
		
		elev.move(request.getDestinationFloor(), elevators.size(), MIN_FLOOR);
	}
	
	/**
	 * Select the elevator that will respond to the trip request.
	 * 
	 * @param origin
	 * @param destination
	 */
	private Elevator selectElevator(int origin, int destination)
	{
		Elevator selected = null;
		
		for(Elevator e : elevators)
		{
			if(!e.isActive() || e.isMoving())
			{
				continue;
			}
			else if(e.getCurrentFloor() == origin)
			{
				return e;
			}
			else if(selected == null)
			{
				selected = e;
			}
			else
			{
				int diff1 = Math.abs(e.getCurrentFloor() - origin);
				int diff2 = Math.abs(selected.getCurrentFloor() - origin);
				
				if(diff1 < diff2)
				{
					selected = e;
				}
			}
		}
		
		return selected;
	}
	
	/**
	 * Service an elevator.
	 * 
	 * @param id
	 */
	public void serviceElevator(int id)
	{
		for(Elevator elev : elevators)
		{
			if(elev.getId() == id)
			{
				elev.receiveMaintenance();
			}
		}
	}
	
	/* Getters and Setters */
	
	public List<Floor> getFloors() 
	{
		return floors;
	}

	public List<Elevator> getElevators() 
	{
		return elevators;
	}
}
