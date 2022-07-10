package main;

/**
 * The class Accountant represents an accountant working in the firm.
 * 
 * @author Alexandre Insua Moreira.
 *
 * @version 1.0.0 2022-05-21.
 */
public class Accountant extends Employee {

	/**
	 * Constructor for the class Accountant.
	 * 
	 * @param name   name of the accountant.
	 * @param idCard id number of identification card.
	 */
	public Accountant(String name, String idCard, Firm firm) {
		super(name, idCard);
		this.firm = firm;
	}

}
