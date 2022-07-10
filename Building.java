package main;

/**
 * The Building class represents a building that can be the subject of a project
 * or a issuance of a certificate.
 *
 * @author Alexandre Insua Moreira
 * @version 1.0.0 2022.05.21
 */
public class Building {
	// base to calculate id
	private static long uid = 1;
	// internal id
	private long id;
	// address of the building
	public String address;
	// flag to control the kind of building
	public boolean isCommunal;

	/**
	 * Constructor for objects of class Build. By default all building are not
	 * communal.
	 * 
	 * @param address    the address of building.
	 * @param isCommunal the building is communal or not.
	 */

	public Building(String address, boolean isCommunal) {
		setId();
		setAddress(address);
		setCommunal(isCommunal ? isCommunal : false);
	}

	/**
	 * Returns unique id of building
	 * 
	 * @returns id of building
	 */
	public long getId() {
		return id;
	}

	/**
	 * Set id of building
	 */
	private void setId() {
		this.id = this.uid;
		this.uid++;
	}

	/**
	 * Returns the address of the building.
	 * 
	 * @returns the address of the building.
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Set the address of the building.
	 * 
	 * @param address address of the building.
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * Return if the building is communal.
	 * 
	 * @return isCommunal true if the building is communal, false otherwise.
	 */
	public boolean isCommunal() {
		return isCommunal;
	}

	/**
	 * Set the type of building.
	 * 
	 * @param isCommunal true if it is communal.
	 */
	public void setCommunal(boolean isCommunal) {
		this.isCommunal = isCommunal;
	}

	/**
	 * Show the information building.
	 * 
	 * @return information a formated string with the information building.
	 */
	public String toString() {
		return "Id. " + getId() + "\t" + getAddress() + (isCommunal() ? ", comunal" : "");
	}
}
