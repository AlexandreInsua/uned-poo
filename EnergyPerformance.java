package main;

/**
 * The class EnergyPerformance represents represents a certificate of energetic
 * performace.
 *
 * @author Alexandre Insua Moreira
 * @version 1.0.0 2022.05.31
 */
public class EnergyPerformance extends Certificate {
	// energetic performance category
	private EPCategoryEnum category;

	/**
	 * Constructor for the class EnergyPerformance.
	 * 
	 * @param client   client ordering the certificate.
	 * @param building certificate building.
	 *
	 */
	public EnergyPerformance(Client client, Building building) {
		super(client, building);
	}

	/**
	 * Returns the category of certificate.
	 * 
	 * @return category the category of certificate.
	 */
	public EPCategoryEnum getCategory() {
		return category;
	}

	/**
	 * set the category of certificate.
	 * 
	 * @param category the category to set.
	 */
	public void setCategory(EPCategoryEnum category) {
		this.category = category;
	}
}
