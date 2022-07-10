package main;

/**
 * The class NoHousing represents a non residential building project.
 *
 * @author Alexandre Insua Moreira
 * @version 1.0.0 2022.05.21
 */
public class NoHousing extends Construction {

	// purpose of the project
	private String purpose;

	/**
	 * Constructor for objects of class NoResidencial.
	 * 
	 * @param client  client ordering the project.
	 * @param build   building involved in the project.
	 * @param purpose purpose of project
	 */
	public NoHousing(Client client, Building building) {
		super(client, building);
	}

	/**
	 * Constructor for objects of class NoResidencial.
	 * 
	 * @param client       client ordering the project.
	 * @param build        building involved in the project.
	 * @param plotArea     area occupied by the plot.
	 * @param buildingArea area occupied by the building.
	 * @param purpose      purpose of project
	 */
	public NoHousing(Client client, Building building, int plotArea, int buildingArea, String purpose) {
		super(client, building, plotArea, buildingArea);
		this.purpose = purpose;

	}

	/**
	 * Returns the purpose of the work.
	 * 
	 * @return purpose purpose of the work.
	 */
	public String getPurpose() {
		return purpose;
	}

	/**
	 * Set the purpose of the work.
	 * 
	 * @param purpose the purpose of the work.
	 */
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

}
