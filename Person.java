package main;

/**
 * The class Person represents an abstraction of a human being. It has, as
 * characteristics, a name and an official identification number and,
 * internally, a unique identification number.
 * 
 * @author Alexandre Insua Moreira
 * @version 1.0.0 2022.05.31
 */
public abstract class Person {
	// base to calculate id
	private static long uid = 1;
	// internal id
	private long id;
	// name of the person
	private String name;
	// id card number of the person
	private String idCard;

	/**
	 * Constructor for objects of class Person.
	 * 
	 * @param name   name of the person.
	 * @param idCard id card number of the person.
	 * @throws IllegalStateExpection if name and/or idCard are missing.
	 */
	public Person(String name, String idCard) {
		if (name == null || idCard == null) {
			System.err.println("Se ha producido un error: falta el nombre o la identificación.");
			throw new IllegalStateException("An error has occurred: name or id is missing.");
		}

		this.id = this.uid++;
		setName(name);
		setIdCard(idCard);
	}

	/**
	 * Returns internal id
	 * 
	 * @returns internal id.
	 */
	public long getId() {
		return this.id;
	}

	/**
	 * Sets the name of the person
	 * 
	 * @param name name of the person to be set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns name of the person
	 * 
	 * @returns name name of the person.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Sets the id card number
	 * 
	 * @param idCard id card number of person to be set.
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	/**
	 * Returns id card number of person
	 * 
	 * @returns idCard id card of person
	 */
	public String getIdCard() {
		return this.idCard;
	}

	/**
	 * Show the basic information of person
	 */
	public String toString() {
		return "ID: " + this.getId() + "\tNombre: " + this.getName() + "\tDNI:" + this.getIdCard();
	}

}
