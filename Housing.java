package main;

/**
 * The class Housing represents a housing building project.
 *
 * @author Alexandre Insua Moreira
 * @version 1.0.0 2022.05.21
 */
public class Housing extends Construction {

	// number of floors
	private byte floors;
	// number of rooms
	private byte rooms;
	// number of bath
	private byte baths;

	/**
	 * Constructor for the class Housing.
	 * 
	 * @param client       client ordering the project.
	 * @param build        build involved in the project.
	 * 
	 */
	public Housing(Client client, Building building) {
		super(client, building);
	}

	/**
	 * Constructor for the class Housing.
	 * 
	 * @param client       client ordering the project.
	 * @param build        build involved in the project.
	 * @param plotArea     area occupied by the plot.
	 * @param buildingArea area occupied by the building.
	 * @param floors       number of floors in the building.
	 * @param rooms        number of rooms in the building.
	 * @param baths        number of baths in the building.
	 */
	public Housing(Client client, Building building, int plotArea, int buildingArea, byte floors, byte rooms,
			byte baths) {
		super(client, building, plotArea, buildingArea);
		this.floors = floors;
		this.rooms = rooms;
		this.baths = baths;
	}

	/**
	 * Returns the number of floors.
	 * 
	 * @return floors the number of floors.
	 */
	public byte getFloors() {
		return floors;
	}

	/**
	 * Set the number of floors.
	 * 
	 * @param floors the number of floors.
	 */
	public void setFloors(byte floors) {
		this.floors = floors;
	}

	/**
	 * Returns the number of rooms.
	 * 
	 * @return rooms the number of rooms.
	 */
	public byte getRooms() {
		return rooms;
	}

	/**
	 * Set the number of rooms.
	 * 
	 * @param rooms the number of rooms.
	 */
	public void setRooms(byte rooms) {
		this.rooms = rooms;
	}

	/**
	 * Returns the number of baths.
	 * 
	 * @return baths the number of baths.
	 */
	public byte getBaths() {
		return baths;
	}

	/**
	 * Set the number of baths.
	 * 
	 * @param baths the number of baths.
	 */
	public void setBaths(byte baths) {
		this.baths = baths;
	}
	
	
}
