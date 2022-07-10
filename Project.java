package main;

import java.time.LocalDate;

/**
 * The class Project represents an architectonic project.
 *
 * @author Alexandre Insua Moreira
 * @version 1.0.0 2022.05.21
 */
public abstract class Project {
	// base to calculate id
	private static long uid = 1;
	// internal id
	private long id;
	// client requesting the project
	private Client client;
	// architect assigned to the project
	private Architect architect;
	// quantity surveyor assigned to the project
	private QuantitySurveyor qs;
	// account assigned to the project
	private Accountant accountant;
	// building
	private Building building;

	// status of the project
	private ProjectStatusEnum status;
	// project application date
	private LocalDate application;
	// project delivery date
	private LocalDate delivery;
	// start date of construction work
	private LocalDate start;
	// end date of construction work
	private LocalDate end;
	// duration of work in days
	private short duration;
	// cost in local currency
	private long budget;

	/**
	 * Constructor for objects of class Project.
	 * 
	 * @param client   client ordering the project.
	 * @param building project building.
	 */
	public Project(Client client, Building building) {
		setClient(client);
		setApplication(LocalDate.now());
		setBuilding(building);
		setId();
		setStatus(ProjectStatusEnum.NEW);
	}

	/**
	 * Constructor for objects of class Project.
	 * 
	 * @param client    client ordering the project.
	 * @param building  project building.
	 * @param architect architect creating the project.
	 */

	public Project(Client client, Building building, Architect architect) {
		setClient(client);
		setApplication(LocalDate.now());
		setBuilding(building);
		setArchitect(architect);
		setId();
	}

	/**
	 * Returns the id number of the project.
	 * 
	 * @return id the id number of the project.
	 */
	public long getId() {
		return id;
	}

	/**
	 * Set the project's id.
	 */
	@SuppressWarnings("static-access")
	private void setId() {
		this.id = this.uid;
		this.uid++;
	}

	/**
	 * Returns the client commissioning the project.
	 * 
	 * @return client the client commissioning the project.
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * Set the client commissioning the project.
	 * 
	 * @param client the client commissioning the project.
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * Returns the architect that manages the project.
	 * 
	 * @return architect the architect that manages the project.
	 */
	public Architect getArchitect() {
		return architect;
	}

	/**
	 * Set the architect that manages the project.
	 * 
	 * @param architect the architect that manages the project.
	 */
	public void setArchitect(Architect architect) {
		this.architect = architect;
	}

	/**
	 * . Returns the quantity surveyor involved in the project.
	 * 
	 * @return qs the quantity surveyor involved in the project.
	 */
	public QuantitySurveyor getQuantitySurveyor() {
		return qs;
	}

	/**
	 * Set the quantity surveyor involved in the project.
	 * 
	 * @param qs the quantity surveyor involved in the project.
	 */
	public void setQuantitySurveyor(QuantitySurveyor qs) {
		this.qs = qs;
	}

	/**
	 * Returns the accountant that budgets the project.
	 * 
	 * @return accountant the accountant that budgets the project.
	 */
	public Accountant getAccountant() {
		return accountant;
	}

	/**
	 * Set the accountant that budgets the project.
	 * 
	 * @param accountant the accountant that budgets the project.
	 */
	public void setAccountant(Accountant accountant) {
		this.accountant = accountant;
	}

	/**
	 * Get the status of the project.
	 * 
	 * @return status the status of the project.
	 */
	public ProjectStatusEnum getStatus() {
		return status;
	}

	/**
	 * Set the status of the project.
	 * 
	 * @param status the status of the project.
	 */
	public void setStatus(ProjectStatusEnum status) {
		this.status = status;
	}

	/**
	 * Returns the date on which the client has requested the project.
	 * 
	 * @return application the date on which the client has requested the project.
	 */
	public LocalDate getApplication() {
		return application;
	}

	/**
	 * Set the date on which the client has requested the project.
	 * 
	 * @param application the date on which the client has requested the project.
	 */
	public void setApplication(LocalDate application) {
		this.application = application;
	}

	/**
	 * Returns the date on which the project has been delivered to the client.
	 * 
	 * @return delivery the date on which the project has been delivered to the
	 *         client.
	 */
	public LocalDate getDelivery() {
		return delivery;
	}

	/**
	 * Set the date on which the project has been delivered to the client.
	 * 
	 * @param delivery the date on which the project has been delivered to the
	 *                 client.
	 */
	public void setDelivery(LocalDate delivery) {
		this.delivery = delivery;
	}

	/**
	 * Returns the date of constructions work starts.
	 * 
	 * @return start the date of constructions work starts.
	 */
	public LocalDate getStart() {
		return start;
	}

	/**
	 * Set the date of construction work starts.
	 * 
	 * @param start the date of constructions work starts.
	 */
	public void setStart(LocalDate start) {
		checkDates();
		this.start = start;
	}

	/**
	 * Returns the date of construction work ends.
	 * 
	 * @return end the date of construction work ends.
	 */
	public LocalDate getEnd() {
		return end;
	}

	/**
	 * Set the date of construction work ends.
	 * 
	 * @param end the date of construction work ends.
	 */
	public void setEnd(LocalDate end) {
		checkDates();
		this.end = end;
	}

	/**
	 * Returns the duration of construction work in days.
	 * 
	 * @return the duration of construction work in days.
	 */
	public short getDuration() {
		return duration;
	}

	/**
	 * Set the duration of construction work in days.
	 * 
	 * @param duration the duration of construction work in days.
	 */
	public void setDuration(short duration) {
		this.duration = duration;
	}

	/**
	 * Get the budget of project in local currency.
	 * 
	 * @return budget the budget of project in local currency.
	 */
	public long getBudget() {
		return budget;
	}

	/**
	 * Set the budget of project in local currency.
	 * 
	 * @param budget the budget of project in local currency.
	 */
	public void setBudget(long budget) {
		this.budget = budget;
	}

	/**
	 * Returns the building.
	 * 
	 * @returns the building.
	 */
	public Building getBuilding() {
		return building;
	}

	/**
	 * Set the building.
	 * 
	 * @param building the building.
	 */
	public void setBuilding(Building building) {
		this.building = building;
	}

	// TODO check dates
	private void checkDates() {

	};

	public String toString() {
		String number = "Id: " + getId();
		String application = "\t\tSolicitud: " + getApplication().toString();

		String building = getBuilding().getAddress();
		String client = "Cliente: " + getClient().getName();

		String architect = "Arquitecto: " + (getArchitect() != null ? getArchitect().getName() : "");
		String qs = "Aparejador: " + (getQuantitySurveyor() != null ? getQuantitySurveyor().getName() : "");
		String accountant = "Contable: " + (getAccountant() != null ? getAccountant().getName() : "");

		String head = number + "\t" + getStatusToString() + "\t" + application + "\n";
		String staff = architect + qs + "\n" + accountant + "\n";

		return "\n" + head + building + client + staff;
	}
	
	public String toShortString() {
		String client = "Cliente: " + getClient().getName();
		String number = " Proyecto: " + getId() + " ";
		return client + number + getStatusToString();
	}

	private String getStatusToString() {
		String status = null;

		switch (getStatus()) {
		case NEW:
			status = "NUEVO";
			break;
		case ASSIGNED:
			status = "ASIGNADO";
			break;
		case DESIGNED:
			status = "DISEÑADO";
			break;
		case BUDGETED:
			status = "VALORADO";
			break;
		case DELIVERED:
			status = "ENTREGADO";
			break;
		case ONGOING:
			status = "EN CONSTRUCCIÓN";
			break;
		case FINISHED:
			status = "FINALIZADO";
			break;
		}

		return status;
	}
}
