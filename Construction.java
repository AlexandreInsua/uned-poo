package main;

/**
 * The class Construction represents a project of construction work.
 *
 * @author Alexandre Insua Moreira.
 * @version 1.0.0 2022.05.21.
 */
public abstract class Construction extends Project {

	// surface of plot where building is
	private int plotArea;
	// surface of building
	private int buildingArea;

	/**
	 * Constructor for the class Construction.
	 * 
	 * @param client client ordering the project.
	 * @param build  build involved in the project.
	 * 
	 */
	public Construction(Client client, Building building) {
		super(client, building);
	}

	/**
	 * Constructor for the class Construction.
	 * 
	 * @param client client ordering the project.
	 * @param build  build involved in the project.
	 * 
	 */
	public Construction(Client client, Building building, int plotArea, int buildingArea) {
		super(client, building);
		this.plotArea = plotArea;
		this.buildingArea = buildingArea;
	}

	/**
	 * Returns the area of plot.
	 * 
	 * @returns the area of plot.
	 */
	public int getPlotArea() {
		return plotArea;
	}

	/**
	 * Set the area of plot.
	 * 
	 * @param plotArea the area of plot in square meters.
	 */
	public void setPlotArea(int plotArea) {
		this.plotArea = plotArea;
	}

	/**
	 * Returns the area of building.
	 * 
	 * @return the area of building.
	 */
	public int getBuildingArea() {
		return buildingArea;
	}

	/**
	 * Set the area of building
	 * 
	 * @param buildingArea the area of building in square meters
	 */
	public void setBuildingArea(int buildingArea) {
		this.buildingArea = buildingArea;
	}
	
	

}
