package main;

/**
 * The class Occupancy represents a occupancy certificate.
 * 
 * @author Alexandre Insua Moreira
 * @version 1.0.0
 */
public class Occupancy extends Certificate {

	/**
	 * Constructor for the class Occupancy.
	 * 
	 * @param client   client ordering the certificate.
	 * @param building certificate building.
	 *
	 */
	public Occupancy(Client client, Building building) {
		super(client, building);
	}
}
