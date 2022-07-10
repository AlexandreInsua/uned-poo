package main;

/**
 * The class TIB represents a technical inspection building certificate.
 * 
 * @author Alexandre Insua Moreira
 * @version 1.0.0 2022.05.21
 */
public class TIB extends Certificate {

	/**
	 * Constructor for the class TIB.
	 * 
	 * @param client   client ordering the certificate.
	 * @param building certificate building.
	 *
	 */
	public TIB(Client client, Building building) {
		super(client, building);
	}
}
