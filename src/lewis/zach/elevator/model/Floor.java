package lewis.zach.elevator.model;

/**
 * This class represents a floor.
 * 
 * @author Zach Lewis
 */
public class Floor 
{
	private int id;
	
	public Floor(int id) 
	{
		super();
		this.id = id;
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
}