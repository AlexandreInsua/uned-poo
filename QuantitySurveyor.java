package main;

/**
 * The class QuantitySurveyor represents a quantity surveyor of the firm.
 * 
 * @param name   name of quantity surveyor
 * @param idCard id card number of quantity surveyor
 * @param firm   firm where the quantity surveyor works
 * @throws IllegarStateException In this cases: during creation, if name or
 *                               idCard are not provided. During addition of new
 *                               administrator has not been provided.
 *
 * @author Alexandre Insua Moreira
 * @version 1.0.0 2022.05.21
 */
public class QuantitySurveyor extends Employee {

	/**
	 * Constructor for objects of class Aparejador
	 */
	public QuantitySurveyor(String name, String idCard, Firm firm) {
		super(name, idCard);
		this.firm = firm;
	}
}
