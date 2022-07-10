package main;

import java.time.LocalDate;

/**
 * The class Certificate represents a certificate entity.
 *
 * @author Alexandre Insua Moreira
 * @version 1.0.0 2022.05.31
 */
public abstract class Certificate {
	// base to calculate id
	private static long uid = 1;
	// internal id
	private long id;
	// client requesting the certificate
	private Client client;
	// architect assigned to the certificate
	private Architect architect;
	// quantity surveyor assigned to the certificate
	private QuantitySurveyor qs;
	// account assigned to the certificate
	private Accountant accountant;
	// building
	private Building building;

	// status of the certificate
	private CertificateStatusEnum status;
	// certificate application date
	private LocalDate application;
	// visit date
	private LocalDate visit;
	// issuance date
	private LocalDate issuance;
	// certificate delivery date
	private LocalDate delivery;

	/**
	 * Constructor for the class Certificate
	 * 
	 * @param client   client ordering the certificate.
	 * @param building certificate building.
	 */
	public Certificate(Client client, Building building) {
		setClient(client);
		setBuilding(building);
		setApplication(LocalDate.now());
		setId();
	}

	/**
	 * Returns the id number of the certificate.
	 * 
	 * @return id the id number of the certificate.
	 */
	public long getId() {
		return id;
	}

	/**
	 * Set the certificate's id.
	 */
	private void setId() {
		this.id = this.uid;
		this.uid++;
	}

	/**
	 * Returns the client requesting the certificate.
	 * 
	 * @return the client requesting the certificate.
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * Set the client requesting the certificate.
	 * 
	 * @param client the client to set.
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * Returns the architect that manages the certificate.
	 * 
	 * @return architect the architect that manages the certificate.
	 */
	public Architect getArchitect() {
		return architect;
	}

	/**
	 * Set the architect that manages the certificate.
	 * 
	 * @param architect the architect that manages the certificate.
	 */
	public void setArchitect(Architect architect) {
		this.architect = architect;
	}

	/**
	 * . Returns the quantity surveyor involved in the certificate.
	 * 
	 * @return qs the quantity surveyor involved in the certificate.
	 */
	public QuantitySurveyor getQs() {
		return qs;
	}

	/**
	 * Set the quantity surveyor involved in the certificate.
	 * 
	 * @param qs the quantity surveyor involved in the certificate.
	 */
	public void setQs(QuantitySurveyor qs) {
		this.qs = qs;
	}

	/**
	 * Returns the accountant that budgets the certificate.
	 * 
	 * @return accountant the accountant that budgets the certificate.
	 */
	public Accountant getAccountant() {
		return accountant;
	}

	/**
	 * Set the accountant that budgets the certificate.
	 * 
	 * @param accountant the accountant that budgets the certificate.
	 */
	public void setAccountant(Accountant accountant) {
		this.accountant = accountant;
	}

	/**
	 * @return the building
	 */
	public Building getBuilding() {
		return building;
	}

	/**
	 * @param building the building to set
	 */
	public void setBuilding(Building building) {
		this.building = building;
	}

	/**
	 * Get the status of the certificate.
	 * 
	 * @return status the status of the certificate.
	 */
	public CertificateStatusEnum getStatus() {
		return status;
	}

	/**
	 * Set the status of the certificate.
	 * 
	 * @param status the status of the certificate.
	 */
	public void setStatus(CertificateStatusEnum status) {
		this.status = status;
	}

	/**
	 * Returns the date on which the client has requested the certificate.
	 * 
	 * @return application the date on which the client has requested the
	 *         certificate.
	 */
	public LocalDate getApplication() {
		return application;
	}

	/**
	 * Set the date on which the client has requested the certificate.
	 * 
	 * @param application the date on which the client has requested the
	 *                    certificate.
	 */
	public void setApplication(LocalDate application) {
		this.application = application;
	}

	/**
	 * Returns the quality surveyor date visit
	 * 
	 * @return the visit the quality surveyor date visit
	 */
	public LocalDate getVisit() {
		return visit;
	}

	/**
	 * Set the quality surveyor date visit
	 * 
	 * @param visit the visit to set
	 */
	public void setVisit(LocalDate visit) {
		this.visit = visit;
	}

	/**
	 * Returns the date of certificate issuance
	 * 
	 * @return the issuance the date of certificate issuance
	 */
	public LocalDate getIssuance() {
		return issuance;
	}

	/**
	 * Set the date of certificate issuance
	 * 
	 * @param issuance the issuance to set
	 */
	public void setIssuance(LocalDate issuance) {
		this.issuance = issuance;
	}

	/**
	 * Returns the date on which the certificate has been delivered to the client.
	 * 
	 * @return delivery the date on which the certificate has been delivered to the
	 *         client.
	 */
	public LocalDate getDelivery() {
		return delivery;
	}

	/**
	 * Set the date on which the certificate has been delivered to the client.
	 * 
	 * @param delivery the date on which the certificate has been delivered to the
	 *                 client.
	 */
	public void setDelivery(LocalDate delivery) {
		this.delivery = delivery;
	}

}
