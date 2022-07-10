package main;

/**
 * The class Refurbish represents a refurbish project.
 *
 * @author Alexandre Insua Moreira
 * @version 1.0.0 2022.05.21
 */
public class Refurbish extends Project {

	// surface to be renewed in square meters
	private int surface;

	/**
	 * Constructor for objects of class Refurbish.
	 * 
	 * @param client  client ordering the project.
	 * @param address address where building is located.
	 * 
	 */
	public Refurbish(Client client, Building building) {
		super(client, building);
	}

	/**
	 * Constructor for objects of class Refurbish.
	 * 
	 * @param client  client ordering the project.
	 * @param address address where building is located.
	 * @param surface surface to be renewed in square meters
	 */
	public Refurbish(Client client, Building building, int surface) {
		super(client, building);
		this.surface = surface;
	}

	/**
	 * Get the surface to be refurbished.
	 * 
	 * @return surface the surface to be refurbished.
	 */
	public int getSurface() {
		return surface;
	}

	/**
	 * Set the surface to be refurbished.
	 * 
	 * @param the surface to be refurbished.
	 */
	public void setSurface(int surface) {
		this.surface = surface;
	}

}
