package main;

/**
 * Enumeration class ProjectStatusEnum represents the possible states of the
 * project. The statuses that have been established are as follows:
 * 
 * <ol>
 * <li>NEW: the project has been created.</li> // admin
 * <li>ASSIGNED: the project has been assigned.</li> // admin
 * <li>DESIGNED: star and end dates have been set.</li> // arch
 * <li>BUDGETED: the budget has been established.</li> // account
 * <li>DELIVERED: the project has been delivered to the client.</li> admin
 * <li>ONGOING: the building is under construction.</li> // qs
 * <li>FINISHED: the project has been finished.</li> // admin
 * </ol>
 * 
 * @author Alexandre Insua Moreira
 * @version 1.0.0 2022.05.21
 */
public enum ProjectStatusEnum {
	NEW, ASSIGNED, DESIGNED, BUDGETED, DELIVERED, ONGOING, FINISHED
}
