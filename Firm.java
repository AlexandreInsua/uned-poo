package main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 * The class Firm represents a architecture firm.
 *
 * @author Alexandre Insua Moreira
 * @version 1.0.0 2022.05.31
 */
public class Firm {

	// FIELDS

	// Represents the employees of the studio (except administrators)
	private List<Employee> employees;

	// Represents the clients who have requested services form the firm
	private List<Client> clients;

	// represents the buildings
	private List<Building> buildings;

	// Represents the projects that have been developed by the firm
	private List<Project> projects;

	// Represents the certificates that have been issued by the firm
	private List<Certificate> certificates;

	private boolean isLogged = false;

	private Employee activeUser;

	protected Scanner scanner;

	// MAIN METHOD
	// core

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Firm f = new Firm();
		// TODO REMOVE
		// ================================
		Administrator a = new Administrator("Alexandre Insua Moreira", "36162615W");
		a.setFirm(f);
		f.addAdministrator(a);

		Administrator b = new Administrator("Aitana Sole Varela", "75299276J");
		b.setFirm(f);
		f.addAdministrator(b);

		Administrator c = new Administrator("Teófilo Benito Estévez", "44559751B");
		c.setFirm(f);
		f.addAdministrator(c);

		Architect a1 = new Architect("Patricia Martos Figueroa", "38194923L", f);
		f.addEmployee(a1);
		Architect a2 = new Architect("Liliana Dorado Plasencia", "42054335P", f);
		f.addEmployee(a2);
		Architect a3 = new Architect("Rosendo Serrano Fernández", "42141107R", f);
		f.addEmployee(a3);

		QuantitySurveyor q1 = new QuantitySurveyor("Virgínia Míquez Pascual", "11658812C", f);
		f.addEmployee(q1);
		QuantitySurveyor q2 = new QuantitySurveyor("Sira Berrocal Martínez", "61151733T", f);
		f.addEmployee(q2);
		QuantitySurveyor q3 = new QuantitySurveyor("Antonia Rodríguez San-Juan", "61151733T", f);
		f.addEmployee(q3);
		QuantitySurveyor q4 = new QuantitySurveyor("Alberto Merino Diéguez", "34469064E", f);
		f.addEmployee(q4);

		Accountant ac1 = new Accountant("Agustina Francisco García", "68209352T", f);
		f.addEmployee(ac1);
		Accountant ac2 = new Accountant("Oscar Rodríguez Sebastián", "20270151K", f);
		f.addEmployee(ac2);

		Client ci1 = new Client("Guillermo Belmonte Criado", "20270151K");
		f.addClient(ci1);
		Client ci2 = new Client("Maribel Souto Expósito", "20270151K");
		f.addClient(ci2);
		Client ci3 = new Client("Tania Asensio Coronado", "58308192H");
		f.addClient(ci3);
		Client ci4 = new Client("Maria-Luisa Saavedra", "58308192H");
		f.addClient(ci4);

		Building bu1 = new Building("Calle del Príncipe 48", false);
		f.addBuilding(bu1);
		Building bu2 = new Building("Plaza de la Constitución 7", true);
		f.addBuilding(bu2);
		Building bu3 = new Building("Plaza de Santiago de Compostela 11", false);
		f.addBuilding(bu3);
		Building bu4 = new Building("Rúa dos cesteiros 6", false);
		f.addBuilding(bu4);
		Building bu5 = new Building("Avenida de Bouzas 138", false);
		f.addBuilding(bu5);
		Building bu6 = new Building("Avenida de Beiramar 319", true);
		f.addBuilding(bu6);

		Project p1 = new Housing(ci1, bu1);
		p1.setArchitect(a1);
		p1.setQuantitySurveyor(q1);
		p1.setAccountant(ac1);
		p1.setStatus(ProjectStatusEnum.ASSIGNED);
		f.projects.add(p1);

		Project p2 = new Housing(ci2, bu2);
		p2.setArchitect(a1);
		p2.setQuantitySurveyor(q2);
		p2.setAccountant(ac2);
		p2.setStatus(ProjectStatusEnum.ASSIGNED);
		f.projects.add(p2);

		Project p3 = new Housing(ci3, bu3);
		p3.setArchitect(a1);
		p3.setQuantitySurveyor(q3);
		p3.setAccountant(ac1);
		p3.setStatus(ProjectStatusEnum.ASSIGNED);
		f.projects.add(p3);

		Project p4 = new NoHousing(ci4, bu4);
		p4.setArchitect(a2);
		p4.setQuantitySurveyor(q4);
		p4.setAccountant(ac2);
		p4.setStatus(ProjectStatusEnum.ASSIGNED);
		f.projects.add(p4);

		Project p5 = new Housing(ci1, bu5);
		p5.setArchitect(a1);
		p5.setQuantitySurveyor(q1);
		p5.setAccountant(ac2);
		p5.setStatus(ProjectStatusEnum.ASSIGNED);
		f.projects.add(p5);

		Project p6 = new Refurbish(ci2, bu6);
		p3.setArchitect(a2);
		p3.setQuantitySurveyor(q2);
		p3.setAccountant(ac1);
		p4.setStatus(ProjectStatusEnum.ASSIGNED);
		f.projects.add(p6);

		// ================================
		f.run(f);
	}

	// CONSTRUCTOR
	/**
	 * Constructor for objects of class Firm
	 */
	public Firm() {
		employees = new ArrayList<Employee>();
		clients = new ArrayList<Client>();
		buildings = new ArrayList<Building>();
		projects = new ArrayList<Project>();
		certificates = new ArrayList<Certificate>();

		scanner = new Scanner(System.in);
	}

	// MAIN MENU METHODS
	private void run(Firm f) {
		boolean isFinished = false;

		greet();
		do {
			if (!isConfig(f)) {
				do {
					config(f);
				} while (!isConfig(f));
			}

			do {
				log(f);
			} while (!isLogged);

			do {
				handleOptions(f);
			} while (isLogged);
		} while (!isFinished);
	};

	private void exit() {
		System.out.println("Saliendo de la aplicación... ");
		System.exit(0);
	}

	/**
	 * Show a initial greet when application is starting.
	 */
	private void greet() {
		System.out.println("INICIANDO SISTEMA INTEGRADO DE GESTIÓN DEL ESTUDIO DE ARQUITECTURA");
		System.out.println("Cargando configuración del sistema...");
		System.out.println();
	}

	private boolean isConfig(Firm f) {
		boolean isConfig = false;
		for (Employee e : employees) {
			if (e instanceof Administrator) {
				isConfig = true;
			}
		}
		return isConfig;
	}

	private void config(Firm f) {
		String response;

		do {
			System.out.println("El sistema no está configurado. ¿Desea realizar la configuración inicial?");
			System.out.println("1: configurar. 2: no (sale de la aplicación).");
			System.err.print("> ");

			response = this.scanner.nextLine();
			try {
				switch (Integer.parseInt(response)) {
				case 1:
					System.out.println("Introduzca el nombre del administrador:");
					System.err.print(">");

					String name = this.scanner.nextLine();

					System.out.println("Introduzca el dni administrator:");
					System.err.print("> ");

					String idCard = this.scanner.nextLine();

					Administrator admin = new Administrator(name, idCard);

					admin.setFirm(f);

					f.addAdministrator(admin);

					System.out.println("Se ha configurado el sistema.");
					System.out.println();
					System.out.println();
					response = "2";

					break;

				case 2:
					exit();
					break;

				default:
					System.out.println("Opcion erronea");
				}
			} catch (Exception e) {
				System.err.println("Se ha produciodo un error. La respuesta no es válida");
			}

		} while (!response.contentEquals("2"));
	}

	private void log(Firm f) {
		String response;
		long id;

		if (f.employees.size() == 0) {
			System.out.println("Sólo se han dado de alta administradores.");
			System.out.println("Debe Registrarse como administrador para poder dar de alta otros empleados.");
			System.out.println("Pulse 1 para seleccionar el perfil de administrador ó 0 para salir de aplicación.");
			System.out.print("> ");
		} else {
			System.out.println("Seleccione el perfil de usuario:");
			System.out
					.println("0: salir de la aplicación, 1: administrador, 2: arquitecto, 3: aparejador, 4: contable.");
			System.out.print("> ");
		}

		response = this.scanner.nextLine();

		try {
			switch (Integer.parseInt(response)) {
			case 0:
				exit();
				break;
			case 1:
				askForUser(1);
				break;
			case 2:
				askForUser(2);
				break;
			case 3:
				askForUser(3);
				break;
			case 4:
				askForUser(4);
				break;

			default:
				System.out.println("Opción errónea");
				break;
			}

		} catch (Exception e) {
			System.err.println("Se ha producido un error. La respuesta no es válida");
		}

	}

	private void askForUser(int option) {
		String command = "Introduzca el id del ";
		String errorMsg = "No se ha podido encontrar el %s con el id ";
		String okMsg = "Usuario registrado: ";
		Employee employee;
		Long id;

		switch (option) {
		case 1:
			command += "administrador:";
			errorMsg = "No se ha podido encontrar el administrator con el id ";
			break;
		case 2:
			command += "arquitecto:";
			errorMsg = "No se ha podido encontrar el arquitecto con el id ";
			break;
		case 3:
			command += "aparejador:";
			errorMsg = "No se ha podido encontrar el aparejador con el id ";
			break;
		case 4:
			command += "contable";
			errorMsg = "No se ha podido encontrar el contable con el id ";
			break;
		}

		System.out.println(command);
		System.err.print("> ");

		id = Long.parseLong(this.scanner.nextLine());

		if (option == 1) {
			employee = getAdministrator(id);
		} else {
			employee = getEmployee(id);
		}

		if (employee == null) {
			System.out.println(errorMsg + id);
		} else {
			System.err.println(okMsg + employee.getName());
			activeUser = employee;
			isLogged = true;
		}

	}

	private void logOut() {
		activeUser = null;
		isLogged = false;
	}

	private void handleOptions(Firm f) {
		activeUser.handleOptions();
		String response;
		do {

			System.out.println("¿Desea realizar más acciones?");
			System.out.println("0: no (salir), 1: sí, 2: cambiar de usuario.");

			response = scanner.nextLine();

			try {
				switch (Integer.parseInt(response)) {
				case 0:
					logOut();
					break;
				case 1:
					activeUser.handleOptions();
					break;
				case 2:
					log(f);
					activeUser.handleOptions();
					break;
				default:
					System.out.println("Opcion errónea");
					break;
				}
			} catch (Exception e) {
				System.err.println("Se ha produciodo un error. La respuesta no es válida");
			}

		} while (!response.equals("0"));
	}

	// ADMINISTRATORS
	/**
	 * Print administrator list
	 */
	public void printAdministrators(Firm f) {
		System.out.println("ADMINISTRADORES");

		if (!isConfig(f)) {
			System.out.print("No se ha dado de alta ningÃºn administrator");
		} else {
			for (Employee e : employees) {
				if (e instanceof Architect) {
					System.out.println(e.toString());
				}
			}
			System.out.println();
		}
	}

	/**
	 * Add a new administrator
	 * 
	 * @param admin administrator to be added.
	 */
	public void addAdministrator(Administrator admin) {
		if (admin == null) {
			throw new IllegalArgumentException("No administrator has been indicated.");
		}

		this.employees.add(admin);
	}

	/**
	 * Update an administrator
	 * 
	 * @param uid   id that identifies the current administrator
	 * @param admin new values for the current administrator
	 */
	public void updateAdministratior(long id, Administrator admin) {
		Iterator<Employee> it = employees.iterator();
		while (it.hasNext()) {
			Employee e = it.next();
			if (e.getId() == id) {
				e.setName(admin.getName());
				e.setIdCard(admin.getIdCard());
			}
		}
	}

	/**
	 * Delete an administrator
	 * 
	 * @param uid id that identifies the administrator be deleted
	 */
	public void deleteAdministration(long id) {
		Iterator<Employee> it = employees.iterator();
		while (it.hasNext()) {
			Employee e = it.next();
			if (e.getId() == id) {
				it.remove();
			}
		}
	}

	/**
	 * Get an administrator from the list;
	 * 
	 * @param administratorId id of the administrator
	 * @return administrator an administrator whose id matches with sent parameter.
	 */
	private Administrator getAdministrator(long administratorId) {
		Administrator administrator = null;
		Iterator<Employee> it = employees.iterator();
		while (it.hasNext()) {
			Employee e = it.next();
			if (e.getId() == administratorId) {
				administrator = (Administrator) e;
			}
		}
		return administrator;
	}

	// EMPLOYEES
	/**
	 * Print employees list
	 */
	public void printEmployees(Firm f) {

		printAdministrators(f);
		printArquitects();
		printQuantitySurveyors();
		printAccountants();
	}

	/**
	 * Print architects list
	 */
	public void printArquitects() {
		System.out.println("ARQUITECTOS");
		for (Employee e : employees) {
			if (e instanceof Architect) {
				System.out.println(e.toString());
			}
		}
		System.out.println();
	}

	/**
	 * Print quantity surveyors list
	 */
	public void printQuantitySurveyors() {
		System.out.println("APAREJADORES");
		for (Employee e : employees) {
			if (e instanceof QuantitySurveyor) {
				System.out.println(e.toString());
			}
		}
		System.out.println();
	}

	/**
	 * Print accountants list
	 */
	public void printAccountants() {
		System.out.println("CONTABLES");
		for (Employee e : employees) {
			if (e instanceof Accountant) {
				System.out.println(e.toString());
			}
		}
		System.out.println();
	}

	/**
	 * Add a new employee
	 * 
	 * @param employee employee to be added.
	 */
	public void addEmployee(Employee employee) {
		if (employee == null) {
			throw new IllegalArgumentException("No administrator has been indicated.");
		}
		this.employees.add(employee);
	}

	/**
	 * Update an employee
	 * 
	 * @param uid   id that identifies the current employee
	 * @param admin new values for the current employee
	 */
	public void updateEmployee(long id, Employee employee) {
		Iterator<Employee> it = employees.iterator();
		while (it.hasNext()) {
			Employee a = it.next();
			if (a.getId() == id) {
				a.setName(employee.getName());
				a.setIdCard(employee.getIdCard());
			}
		}
	}

	/**
	 * Delete an employee
	 * 
	 * @param uid id that identifies the employee be deleted
	 */
	public void deleteEmployee(long id) {
		Iterator<Employee> it = employees.iterator();
		while (it.hasNext()) {
			Employee e = it.next();
			if (e.getId() == id) {
				it.remove();
			}
		}
	}

	/**
	 * Get an employee from the list;
	 * 
	 * @param employeeId id of employee.
	 * @return employee an employee whose id matches with sent parameter.
	 */
	private Employee getEmployee(long employeeId) {
		Employee employee = null;
		Iterator<Employee> it = employees.iterator();
		while (it.hasNext()) {
			Employee e = it.next();
			if (e.getId() == employeeId) {
				employee = e;
			}
		}
		return employee;
	}

	// CLIENTS
	/**
	 * Print clients list
	 */
	public void printClients() {
		System.out.println("CLIENTES");
		if (clients.size() == 0) {
			System.out.println("No se ha dado de alta ningún cliente");
		} else {
			for (Client c : clients) {
				System.out.println(c.toString());
			}
		}
		System.out.println();
	}

	/**
	 * Add a new client.
	 * 
	 * @param client client to be added.
	 */
	public void addClient(Client client) {
		if (client == null) {
			throw new IllegalArgumentException("No client has been indicated.");
		}
		this.clients.add(client);
	}

	/**
	 * Update a client new information.
	 * 
	 * @param id    id that identifies the current client.
	 * @param admin new values for the current client.
	 */
	public void updateClient(long id, Client client) {
		Iterator<Client> it = clients.iterator();
		while (it.hasNext()) {
			Client c = it.next();
			if (c.getId() == id) {
				c.setName(client.getName());
				c.setIdCard(client.getIdCard());
			}
		}
	}

	/**
	 * Delete a client.
	 * 
	 * @param id id that identifies the client to be deleted.
	 */
	public void deleteClient(long id) {
		Iterator<Client> it = clients.iterator();
		while (it.hasNext()) {
			Client c = it.next();
			if (c.getId() == id) {
				it.remove();
			}
		}
	}

	/**
	 * Get a client from the list;
	 * 
	 * @param clientId id of client
	 * @return client a client that matches with the sent parameter.
	 */
	private Client getClient(long clientId) {
		Client client = null;
		Iterator<Client> it = clients.iterator();
		while (it.hasNext()) {
			Client c = it.next();
			if (c.getId() == clientId) {
				client = c;
			}
		}
		return client;
	}
	// BUILDINGS

	/**
	 * Print the building list.
	 */
	public void printBuildings() {
		System.out.println("EDIFICIOS");
		if (buildings.size() == 0) {
			System.out.println("No se ha dado de alta ningún edificio");
		} else {
			for (Building b : buildings) {
				System.out.println(b.toString());
			}

		}
		System.out.println();
	}

	/**
	 * Add a new building.
	 * 
	 * @param building
	 */
	public void addBuilding(Building building) {
		if (building == null) {
			throw new IllegalArgumentException("No building has been provide");
		}
		this.buildings.add(building);
	}

	/**
	 * Update a build with new information.
	 * 
	 * @param id       id that identifies the current building.
	 * @param building new values for the current building.
	 */
	public void updateBuilding(long id, Building building) {
		Iterator<Building> it = buildings.iterator();
		while (it.hasNext()) {
			Building b = it.next();
			if (b.getId() == id) {
				b.setAddress(building.getAddress());
				b.setCommunal(building.isCommunal());
			}
		}
	}

	/**
	 * Delete a building
	 * 
	 * @param id id that identifies the build to be deleted.
	 */
	public void deleteBuild(long id) {
		Iterator<Building> it = buildings.iterator();
		while (it.hasNext()) {
			Building b = it.next();
			if (b.getId() == id) {
				it.remove();
			}
		}
	}

	/**
	 * Get a Building from the list.
	 * 
	 * @param buildingId id of building.
	 * @return building a building that matches with the setn parameter.
	 */
	private Building getBuilding(long buildingId) {
		Building building = null;
		Iterator<Building> it = buildings.iterator();
		while (it.hasNext()) {
			Building b = it.next();
			if (b.getId() == buildingId) {
				building = b;
			}
		}
		return building;
	}

	// PROJECTS
	/**
	 * Print the projects lists.
	 */
	public void printProjects() {
		System.out.println("PROYECTOS");

		if (projects.size() == 0) {
			System.out.println("No se ha dado de alta ningún proyecto");
		} else {
			for (Project p : projects) {
				System.out.println(p.toString());
			}
		}
	}

	/**
	 * 
	 * @param type
	 * @param id
	 * @param status
	 */
	public void printProjects(int type, long employeeId) {
		Employee employee = getEmployee(employeeId);

		if (employee == null) {
			throw new IllegalArgumentException("Employee not found.");
		}
		
		Predicate<Project> employeeFilter = this.getEmployeeFilter(type, employeeId);

		if (projects.size() == 0) {
			System.out.println("No se ha dado de alta ningún proyecto");
		} else {
//			this.projects.stream().filter(employeeFilter)
//					.forEach(project -> System.out.println(project.toShortString()));
			
			for (Project project: projects) {
				if (project.getArchitect().getId() == employeeId) {
				System.out.println(	project.toShortString());
//					project.toString();
				}
				
			}
		}
	}

	/**
	 * 
	 * @param type
	 * @param id
	 * @param status
	 */
	public void printProjects(int type, long id, ProjectStatusEnum status) {
		Employee employee = getEmployee(id);

		Predicate<Project> statusFilter = p -> p.getStatus() == status;
		Predicate<Project> employeeFilter = this.getEmployeeFilter(type, id);

		if (employee == null) {
			throw new IllegalArgumentException("Employee not found.");
		}

		if (projects.size() == 0) {
			System.out.println("No se ha dado de alta ningún proyecto");
		} else {
			this.projects.stream().filter(statusFilter).filter(employeeFilter)
					.forEach(project -> System.out.println(project.toString()));
		}
	}

	/**
	 * 
	 * @param type
	 * @param id
	 * @return
	 */
	private Predicate<Project> getEmployeeFilter(int type, long id) {
		Predicate<Project> filter;
		switch (type) {
		case 1:
			filter = p -> p.getArchitect().getId() == id;
			break;
		case 2:
			filter = p -> p.getQuantitySurveyor().getId() == id;
			break;
		case 3:
			filter = p -> p.getAccountant().getId() == id;
			break;
		default:
			throw new IllegalArgumentException("Employee type is wrong.");
		}
		return filter;
	}

	/**
	 * Creates a project.
	 * 
	 * @param clientId   id of the client.
	 * @param buildingId id of the building.
	 * @param architecId id of the arquitect.
	 * @param type       type of the project. 1: housing, 2: non housing, 3:
	 *                   refurbish.
	 */
	public void addProject(long clientId, long buildingId, int type) {
		Project project = null;
		Client client = getClient(clientId);
		Building building = getBuilding(buildingId);

		if (client == null) {
			throw new IllegalArgumentException("Client not found.");
		}
		if (building == null) {
			throw new IllegalArgumentException("Building not found.");
		}

		switch (type) {
		case 1:
			project = new Housing(client, building);
			break;
		case 2:
			project = new NoHousing(client, building);
			break;
		case 3:
			project = new Refurbish(client, building);

			break;
		}
		projects.add(project);
	}

	/**
	 * Assign a employee to a project.
	 * 
	 * @param projectId  id of project.
	 * @param employeeId id of employee.
	 * @param type       type of employee. 1: architect, 2: quantity surveyor, 3:
	 *                   accountant.
	 */
	public void assignEmployee(long projectId, long employeeId, short type) {
		Project project = getProject(projectId);
		if (project == null) {
			throw new IllegalArgumentException("No se encuenta el id del proyecto");
		}

		switch (type) {
		case 1:
			// TODO explain it
			project.setArchitect((Architect) getEmployee(employeeId));
			break;
		case 2:
			// TODO explain it
			project.setQuantitySurveyor((QuantitySurveyor) getEmployee(employeeId));
			break;
		case 3:
			// TODO explain it
			project.setAccountant((Accountant) getEmployee(employeeId));
			break;
		}
	}

	/**
	 * 
	 * @param projectId
	 * @param architectId
	 * @param QSId
	 * @param accountantId
	 */

	public void assignEmployees(long projectId, long architectId, long QSId, long accountantId) {
		Project project = getProject(projectId);
		if (project == null) {
			throw new IllegalArgumentException("No se encuenta el id del proyecto");
		}

		Architect architect = (Architect) getEmployee(architectId);
		if (architect == null) {
			throw new IllegalArgumentException("No se encuenta el id del arquitecto");
		}

		QuantitySurveyor qs = (QuantitySurveyor) getEmployee(QSId);
		if (qs == null) {
			throw new IllegalArgumentException("No se encuenta el id del aparejador");
		}

		Accountant accountant = (Accountant) getEmployee(accountantId);
		if (accountant == null) {
			throw new IllegalArgumentException("No se encuenta el id del contable");
		}

		project.setArchitect(architect);
		project.setQuantitySurveyor(qs);
		project.setAccountant(accountant);
		project.setStatus(ProjectStatusEnum.ASSIGNED);
	}

	/**
	 * 
	 * @param id
	 */
	public void updateProyect(long id) {

	}

	/**
	 * 
	 * @param id
	 */
	public void deliveryProject(long id) {
		Project project = getProject(id);
		if (project == null) {
			throw new IllegalArgumentException("No se encuenta el id del proyecto");
		}
		project.setStatus(ProjectStatusEnum.DELIVERED);
	}

	public void dessignProject(long projectId, short duration) {
		Project project = getProject(projectId);

		if (project == null) {
			throw new IllegalArgumentException("No se encuenta el id del proyecto");
		}

		project.setDuration(duration);
		project.setStatus(ProjectStatusEnum.DESIGNED);

	}

	/**
	 * 
	 * @param id
	 */
	public void finishProject(long id) {
		Project project = getProject(id);
		if (project == null) {
			throw new IllegalArgumentException("No se encuenta el id del proyecto");
		}
		project.setStatus(ProjectStatusEnum.FINISHED);
	}

	/**
	 * 
	 * @param id
	 */
	public void deleteProject(long id) {
		Iterator<Project> it = projects.iterator();
		while (it.hasNext()) {
			Project p = it.next();
			if (p.getId() == id) {
				it.remove();
			}
		}
	}

	/**
	 * Get a Project from the list.
	 * 
	 * @param projectId id of project.
	 * @return project a project that matches with the sent parameter.
	 */
	private Project getProject(long projectId) {
		Project project = null;
		Iterator<Project> it = projects.iterator();
		while (it.hasNext()) {
			Project p = it.next();
			if (p.getId() == projectId) {
				project = p;
			}
		}
		return project;
	}

	// CERTIFICATES

	// CLIENTS
	public void printClients(int type, long employeeId) {
		System.out.println();
		System.out.println("INFORMACIÓN DE CLIENTES ASIGNADOS");
		try {
			printProjects(type, employeeId);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}
}
