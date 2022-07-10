package main;

import java.util.Scanner;

/**
 * The class Employee represents an employee of the Firm.
 *
 * @author Alexandre Insua Moreira.
 * @version 1.0.0 2022.05.21.
 */
public abstract class Employee extends Person {
	// Represents the firm
	protected Firm firm;

	// aux to handle responses by console.
	protected Scanner scanner;

	/**
	 * Constructor for objects of class Employee.
	 * 
	 * @param name   name of the employee.
	 * @param idCard id number of identification card.
	 */
	public Employee(String name, String idCard) {
		super(name, idCard);
		scanner = new Scanner(System.in);
	}

	/**
	 * 
	 * @return
	 */
	public Firm getFirm() {
		return this.firm;
	}

	/**
	 * Check if the firm was set.
	 * 
	 * @returns returns true if the firm is set and false otherwise.
	 */
	public boolean isFirm() {
		if (firm == null) {
			System.err.println("No se ha definido el estudio para el empleado numéro " + this.getId() + ".");
			return false;
		}
		return true;
	}

	public void handleOptions() {

	}
}
