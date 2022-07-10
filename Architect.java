package main;

/**
 * The class Architect represents an architect of the firm.
 * 
 * @param name   name of architect.
 * @param idCard id card number of architect.
 * @param firm   firm where architect works.
 * @throws IllegarStateException In this cases: during creation, if name or
 *                               idCard are not provided. During addition of new
 *                               administrator has not been provided.
 *
 * @author Alexandre Insua Moreira
 * @version 1.0.0 2022.05.21
 */
public class Architect extends Employee {

	/**
	 * Constructor for the class Architect.
	 * 
	 * @param name   name of architect.
	 * @param idCard id number of identification card.
	 * @param firm   firm where architect is working in.
	 */
	public Architect(String name, String idCard, Firm firm) {
		super(name, idCard);
		this.firm = firm;
	}

	public void handleOptions() {
		String response;

		do {
			System.out.println("(" + getName() + ") Seleccione una opción:");
			System.out.println("0: salir, 1: ver clientes activos, 2: ver proyectos pendientes, 3: diseñar proyectos.");

			System.out.print("> ");
			response = scanner.nextLine();

			try {
				switch (Integer.parseInt(response)) {
				case 0:
					System.out.println("Volviendo a menú principal...");
					break;
				case 1:
					printClients();
					break;
				case 2:
					printPendingProjects();
					break;
				case 3:
					dessignProject();
					break;

				default:
					System.out.println("Opcion errónea");
					break;
				}

			} catch (Exception e) {
				System.err.println("Menú arquitectos. Se ha produciodo un error. La respuesta no es válida");
				System.err.println(e.getMessage());
			}

		} while (!response.equals("0"));
	}

	/**
	 * 
	 */
	public void printClients() {
		try {
			this.firm.printClients(1, getId());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * 
	 */
	public void printPendingProjects() {
		try {
			this.firm.printProjects(1, getId(), ProjectStatusEnum.ASSIGNED);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * 
	 */
	public void dessignProject() {

		if (super.isFirm()) {
			try {
				System.out.println("Introduzca el id del proyecto: ");
				System.out.println("> ");
				long projectId = Long.parseLong(scanner.nextLine());

				System.out.println("Introduzca la duración del proyecto: ");
				System.out.println("> ");
				short duration = Short.parseShort(scanner.nextLine());

				firm.dessignProject(projectId, duration);

			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}
}
