package main;

/**
 * The Administrator class represents and administrator of system. Creates,
 * shows modifies and deletes system users (administrators, architects, quantity
 * surveyors, accountants and clients) and also displays the information related
 * to them. In the same way, creates, shows, modifies and deletes the buildings
 * that were involved in an architectonic project or in the issuance of a
 * certificate. Also, creates
 *
 * @author Alexandre Insua Moreira
 * @version 1.0.0 2022.05.21
 */
public class Administrator extends Employee {
	/**
	 * Constructor for objects of class Administrator.
	 * 
	 * @param name   name of administrator.
	 * @param idCard id card number of administrator.
	 * @throws IllegarStateException In this cases: during creation, if name or
	 *                               idCard are not provided. During addition of new
	 *                               administrator has not been provided.
	 */
	public Administrator(String name, String idCard) {
		super(name, idCard);
	}

	// CONFIG
	/**
	 * Set the firm that is managed by administrator.
	 * 
	 * @param firm that administrator manages.
	 */
	public void setFirm(Firm firm) {
		this.firm = firm;
	}

	// OPTIONS MENU
	public void handleOptions() {
		String response;

		do {
			System.out.println("(" + getName() + ") Seleccione una opción:");
			System.out.println("0: salir, 1: administradores, 2: empleados, 3: clientes");
			System.out.println("4: edificios, 5: proyectos, 6: certificados");
			System.out.print("> ");
			response = scanner.nextLine();

			try {
				switch (Integer.parseInt(response)) {
				case 0:
					System.out.flush();
					System.out.println("Volviendo a menú principal...");
					break;
				case 1:
					handleAdministratorsOptions();
					break;

				case 2:
					handleEmployeesOptions();
					break;
				case 3:
					handleClientsOptions();
					break;
				case 4:
					handleBuildingsOptions();
					break;
				case 5:
					handleProyectsOptions();
					break;
				case 6:
					handleCertificatesOptions();
					break;
				default:
					System.out.println("Opcion errónea");
					break;
				}

			} catch (Exception e) {
				System.err.println("Se ha produciodo un error. La respuesta no es válida");
				System.err.println(e.getMessage());
			}

		} while (!response.equals("0"));

	}

	private void handleAdministratorsOptions() {
		String response;
		do {
			System.out.println("(Menú administratores) Seleccione una opción: ");
			System.out.println("0: salir. 1: ver todos. 2: añadir, 3: modificar: 4: eliminar.");

			System.out.print("> ");
			response = scanner.nextLine();

			try {
				switch (Integer.parseInt(response)) {
				case 0:
					System.out.println("Volviendo a menú de usuario");
					break;
				case 1:
					printAdministrators();
					break;
				case 2:
					addAministrator();
					break;
				case 3:
					updateAdministrator();
					break;
				case 4:
					deleteAdministrator();
					break;
				default:
					System.out.println("Opcion errónea");
					break;
				}

			} catch (Exception e) {
				System.err.println("(Menú administratores). Se ha producido un error. La respuesta no es válida");
				System.err.println(e.getMessage());
			}

		} while (!response.equals("0"));
	}

	private void handleEmployeesOptions() {
		String response;
		do {
			System.out.println("(Menú empleados) Seleccione una opción: ");
			System.out.println("0: salir. 1: ver todos. 2: añadir, 3: modificar: 4: eliminar.");

			System.out.print("> ");
			response = scanner.nextLine();

			try {
				switch (Integer.parseInt(response)) {
				case 0:
					System.out.println("Volviendo a menú de usuario");
					break;
				case 1:
					printEmployees();
					break;
				case 2:
					addEmployee();
					break;
				case 3:
					updateEmployee();
					break;
				case 4:
					deleteEmployee();
					break;
				default:
					System.out.println("Opcion errónea");
					break;
				}

			} catch (Exception e) {
				System.err.println("(Menú administratores). Se ha producido un error. La respuesta no es válida");
				System.err.println(e.getMessage());
			}

		} while (!response.equals("0"));
	}

	private void handleClientsOptions() {
		String response;
		do {
			System.out.println("(Menú clientes) Seleccione una opción: ");
			System.out.println("0: salir. 1: ver todos. 2: añadir, 3: modificar: 4: eliminar.");

			System.out.print("> ");
			response = scanner.nextLine();

			try {
				switch (Integer.parseInt(response)) {
				case 0:
					System.out.println("Volviendo a menú de usuario");
					break;
				case 1:
					printClients();
					break;
				case 2:
					addClient();
					break;
				case 3:
					updateClient();
					break;
				case 4:
					deleteClient();
					break;
				default:
					System.out.println("Opcion errónea");
					break;
				}

			} catch (Exception e) {
				System.err.println("(Menú administratores). Se ha producido un error. La respuesta no es válida");
				System.err.println(e.getMessage());
			}

		} while (!response.equals("0"));
	}

	private void handleBuildingsOptions() {
		String response;
		do {
			System.out.println("(Menú edificios) Seleccione una opción: ");
			System.out.println("0: salir. 1: ver todos. 2: añadir, 3: modificar: 4: eliminar.");

			System.out.print("> ");
			response = scanner.nextLine();

			try {
				switch (Integer.parseInt(response)) {
				case 0:
					System.out.println("Volviendo a menú de usuario");
					break;
				case 1:
					printBuildings();
					break;
				case 2:
					addBuilding();
					break;
				case 3:
					updateBuilding();
					break;
				case 4:
					deleteBuilding();
					break;
				default:
					System.out.println("Opcion errónea");
					break;
				}

			} catch (Exception e) {
				System.err.println("(Menú edificios). Se ha producido un error. La respuesta no es válida");
				System.err.println(e.getMessage());
			}

		} while (!response.equals("0"));
	}

	private void handleProyectsOptions() {
		String response;
		do {
			System.out.println("(Menú proyectos) Seleccione una opción: ");
			System.out.println("0: salir, 1: ver, 2: añadir, 3: asignar empleados: 4: entregar, 5: eliminar.");

			System.out.print("> ");
			response = scanner.nextLine();

			try {
				switch (Integer.parseInt(response)) {
				case 0:
					System.out.println("Volviendo a menú de usuario");
					break;
				case 1:
					printProjects();
					break;
				case 2:
					addProject();
					break;
				case 3:
					assignEmployees();
					break;
				case 4:
					deliveryProject();
					break;
				case 5:
					deleteProject();
					break;
				default:
					System.out.println("Opcion errónea");
					break;
				}

			} catch (Exception e) {
				System.err.println("(Menú proyectos). Se ha producido un error. La respuesta no es válida");
				System.err.println(e.getMessage());
			}

		} while (!response.equals("0"));
	}

	private void handleCertificatesOptions() {
	}

	private void askForId(String s) {
		System.out.println("Introduzca el id " + s);
		System.out.print("> ");
	}

	private void askForName() {
		System.out.println("Introduzca el nombre:");
		System.out.print("> ");
	}

	private void askForIdCard() {
		System.out.println("Introduzca el dni:");
		System.out.print("> ");
	}

	private void askForType(String s) {
		System.out.println("Introduzca el tipo" + s);
	}

	private void askForAdddres() {
		System.out.println("Introduzca la dirección:");
		System.out.print("> ");
	}

	private void askForIsCommunal() {
		System.out.println("¿Es comunal? s(í), n(o)");
		System.out.print("> ");
	}
	// ADMINISTRATORS

	/**
	 * Print administrator list.
	 */
	public void printAdministrators() {
		firm.printAdministrators(getFirm());
	}

	/**
	 * Add a new administrator. It asks the user for the data to complete the
	 * operation. The new administrator is linked to the firm.
	 * 
	 * @return true if the operation was successful and false otherwise.
	 */
	public boolean addAministrator() {
		String name;
		String idCard;

		boolean result = false;

		if (super.isFirm()) {
			askForName();
			name = scanner.nextLine();

			askForIdCard();
			idCard = scanner.nextLine();

			if (name == null || name == "") {
				System.err.println("El nombre introducido no es correcto");
				result = false;
			}

			if (idCard == null || idCard == "") {
				System.err.println("El dni introducido no es correcto");
				result = false;
			}

			if (this.getName().equals(name) || this.getIdCard().equals(idCard)) {
				System.err.println("Un administrador no se puede agregar a sÃ­ mismo.");
				result = false;
			}

			try {
				Administrator admin = new Administrator(name, idCard);
				admin.setFirm(firm);
				firm.addAdministrator(admin);
				result = true;
			} catch (Exception e) {
				System.err.println("No se ha indicado ningÃºn administrador.");
				result = false;
			}
		}
		return result;
	}

	/**
	 * Update an administrator.
	 * 
	 * @param uid   id that identifies the current administrator.
	 * @param admin new values for the current administrator.
	 */
	public void updateAdministrator() {
		long id;
		String name;
		String idCard;

		if (super.isFirm()) {
			askForId(" del administrator:");
			id = Long.parseLong(scanner.nextLine());

			askForName();
			name = scanner.nextLine();

			askForIdCard();
			idCard = scanner.nextLine();

			if (name == null || name == "") {
				System.err.println("El nombre introducido no es correcto");
			}

			if (idCard == null || idCard == "") {
				System.err.println("El dni introducido no es correcto");
			}

			firm.updateAdministratior(id, new Administrator(name, idCard));
		}
	}

	/**
	 * Delete an administrator.
	 * 
	 * @param uid id that identifies the administrator be deleted.
	 */
	public void deleteAdministrator() {
		long id;
		if (super.isFirm()) {
			askForId(" del administrator:");
			id = Long.parseLong(scanner.nextLine());

			if (this.getId() == id) {
				System.err.println("Un administrador no se puede borrar a sÃ­ mismo.");
				throw new IllegalArgumentException("An administrator cannot delete himself");
			}
			firm.deleteAdministration(id);
		}
	}

	// EMPLOYES
	/**
	 * Print employees list.
	 */
	public void printEmployees() {
		firm.printEmployees(getFirm());
	}

	/**
	 * Add a new employee.
	 * 
	 * @param admin administrator to be added.
	 */
	public boolean addEmployee() {
		boolean result = false;
		String name;
		String idCard;
		short type;
		Employee employee = null;

		if (super.isFirm()) {

			askForType(" de empleado");
			System.out.println("(1: administrador, 2: arquitecto, 3: aparejador, 4: contable");
			System.out.print("> ");
			type = Short.parseShort(scanner.nextLine());

			askForName();
			name = scanner.nextLine();

			askForIdCard();
			idCard = scanner.nextLine();

			switch (type) {
			case 1:
				Administrator admin = new Administrator(name, idCard);
				admin.setFirm(firm);
				employee = admin;
				break;
			case 2:
				employee = new Architect(name, idCard, firm);
				break;
			case 3:
				employee = new QuantitySurveyor(name, idCard, firm);
				break;
			case 4:
				employee = new Accountant(name, idCard, firm);
				break;
			}

			try {
				firm.addEmployee(employee);
				result = true;
			} catch (Exception e) {
				System.err.println("No se ha indicado ningÃºn empleado.");
				result = false;
			}
		}
		return result;
	}

	/**
	 * Update an employee.
	 * 
	 * @param uid   id that identifies the current employee.
	 * @param admin new values for the current employee.
	 */
	public void updateEmployee() {
		long id;
		String name;
		String idCard;

		if (super.isFirm()) {
			askForId(" del empleado:");
			id = Long.parseLong(scanner.nextLine());

			askForName();
			name = scanner.nextLine();

			askForIdCard();
			idCard = scanner.nextLine();

			if (name == null || name == "") {
				System.err.println("El nombre introducido no es correcto");
			}

			if (idCard == null || idCard == "") {
				System.err.println("El dni introducido no es correcto");
			}

			firm.updateEmployee(id, new Employee(name, idCard) {
			});
		}
	}

	/**
	 * Delete an employee.
	 * 
	 * @param uid id that identifies the employee be deleted.
	 */
	public void deleteEmployee() {
		Long id;
		if (super.isFirm()) {
			askForId(" del empleado:");
			id = Long.parseLong(scanner.nextLine());

			firm.deleteEmployee(id);
		}
	}

	// CLIENTS
	/**
	 * Print clients list.
	 */
	public void printClients() {
		firm.printClients();
	}

	/**
	 * Add a new client.
	 * 
	 * @param name   name of client to be added.
	 * @param idCard id card number of client to be added.
	 * @return
	 */
	public boolean addClient() {
		String name;
		String idCard;
		boolean result = false;

		if (super.isFirm()) {

			askForName();
			name = scanner.nextLine();

			askForIdCard();
			idCard = scanner.nextLine();

			try {
				firm.addClient(new Client(name, idCard));
				result = true;
			} catch (Exception e) {
				System.err.println("No se ha indicado ningÃºn cliente.");
				result = false;
			}
		}
		return result;
	}

	/**
	 * Update a client.
	 * 
	 * @param id    id that identifies the current client.
	 * @param admin new values for the current client.
	 */
	public void updateClient() {
		long id;
		String name;
		String idCard;

		if (super.isFirm()) {
			askForId(" del cliente:");
			id = Long.parseLong(scanner.nextLine());

			askForName();
			name = scanner.nextLine();

			askForIdCard();
			idCard = scanner.nextLine();

			firm.updateClient(id, new Client(name, idCard));
		}
	}

	/**
	 * Delete a client.
	 * 
	 * @param id id that identifies the client to be deleted.
	 */
	public void deleteClient() {
		Long id;
		if (super.isFirm()) {
			askForId(" del cliente:");
			id = Long.parseLong(scanner.nextLine());

			firm.deleteClient(id);
		}
	}

	// BUILDINGS
	/**
	 * print buildings list
	 */
	public void printBuildings() {
		firm.printBuildings();
	}

	/**
	 * Add a new build.
	 * 
	 * @param address    address of the building.
	 * @param isCommunal type of building.
	 * @return true if the operation was successful and false otherwise.
	 */
	public boolean addBuilding() {
		String address;
		boolean isCommunal;
		boolean result = false;

		if (super.isFirm()) {
			try {
				askForAdddres();
				address = scanner.nextLine();

				askForIsCommunal();
				String aux = scanner.nextLine();

				if (aux.equals("s")) {
					isCommunal = true;
				} else {
					isCommunal = false;
				}

				System.out.println(address + " " + isCommunal);

				firm.addBuilding(new Building(address, isCommunal));
				result = true;
			} catch (Exception e) {
				System.err.println("No se ha indicado ningún edificio");
				System.err.println(e.getMessage());
			}
		}
		return result;
	}

	/**
	 * Update the information of a building.
	 * 
	 * @param id         id that identifies the building.
	 * @param address    new address for the building.
	 * @param isCommunal new type for the building
	 */
	public void updateBuilding() {
		long id;
		String address;
		boolean isCommunal;

		if (super.isFirm()) {
			askForId("del edificio:");
			id = Long.parseLong(scanner.nextLine());

			askForAdddres();
			address = scanner.nextLine();

			askForIsCommunal();
			isCommunal = scanner.nextLine().contains("s") ? true : false;

			firm.updateBuilding(id, new Building(address, isCommunal));
		}
	}

	/**
	 * Delete a building.
	 * 
	 * @param id id than identifies the building to be deleted.
	 */
	public void deleteBuilding() {
		long id;

		if (super.isFirm()) {
			askForId("del edificio:");
			id = Long.parseLong(scanner.nextLine());
			firm.deleteBuild(id);
		}

	}

	// PROJECTS

	/**
	 * Print projects.
	 */
	public void printProjects() {
		firm.printProjects();
	}

	/**
	 * Creates a project.
	 * 
	 * @param clientId   id of the client.
	 * @param buildingId id of the building.
	 * @param architecId id of the architect.
	 * @param type       type of the project. 1: housing, 2: non housing, 3:
	 *                   refurbish.
	 */
	public void addProject() {
		long clientId;
		long buildingId;
		int type;

		try {
			askForId("del cliente:");
			clientId = Long.parseLong(scanner.nextLine());

			askForId("del edificio:");
			buildingId = Long.parseLong(scanner.nextLine());

			askForType(" de proyecto:\n(1: residencial, 2: no residencial, 3: reforma)");
			type = Integer.parseInt(scanner.nextLine());

			firm.addProject(clientId, buildingId, type);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * Assign a employee to a project.
	 * 
	 * @param projectId  id of project.
	 * @param employeeId id of employee.
	 * @param type       type of employee. 1: architect, 2: quantity surveyor, 3:
	 *                   accountant.
	 */
	public void assignEmployees() {
		long projectId;

		long architectId;
		long QSId;
		long accountantId;

		try {
			askForId(" del proyecto:");
			projectId = Long.parseLong(scanner.nextLine());

			askForId(" del arquitecto:");
			architectId = Long.parseLong(scanner.nextLine());

			askForId(" del aparejador:");
			QSId = Long.parseLong(scanner.nextLine());

			askForId(" del contable:");
			accountantId = Long.parseLong(scanner.nextLine());

			firm.assignEmployees(projectId, architectId, QSId, accountantId);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	/**
	 * 
	 */
	public void deliveryProject() {
		long id;
		if (super.isFirm()) {
			
			askForId("del proyecto: ");
			id = Long.parseLong(scanner.nextLine());
			
			try {
				firm.deliveryProject(id);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}

	/**
	 * 
	 */
	public void deleteProject() {
		long id;
		if (super.isFirm()) {
			askForId("del proyecto: ");
			id = Long.parseLong(scanner.nextLine());
			firm.deleteProject(id);
		}
	}
	// CERTIFICATES
}
