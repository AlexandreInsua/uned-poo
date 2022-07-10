package main;

/**
 * The class ExpertReport represents a report of an expert.
 *
 * @author Alexandre Insua Moreira
 * @version 1.0.0 2022.05.31
 */
public class ExpertReport extends Certificate {

	/**
	 * Constructor for the class ExpertReport
	 * 
	 * @param client   client ordering the certificate.
	 * @param building certificate building.
	 *
	 */
	public ExpertReport(Client client, Building building) {
		super(client, building);
	}
}
