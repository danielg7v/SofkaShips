package com.example.mongodb;

import com.example.mongodb.model.lanzadera;
import com.example.mongodb.model.notripulada;

import com.example.mongodb.persistance.DatabaseConection;

import java.util.Scanner;


public class MongodbApplication {



	public static void main(String[] args) {

		DatabaseConection databaseConection = new DatabaseConection("mongodb+srv://admin:admin@cluster0.zkwopwe.mongodb.net/?retryWrites=true&w=majority");
		databaseConection.setDatabase("SpaceShips");
		databaseConection.setTypeOneCollection("typeOne");
		databaseConection.setTypeTwoCollection("typeTwo");
		System.out.println(databaseConection);



		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter option");
		System.out.println("1. Ingresar nueva nave");
		System.out.println("2. Consultar naves");
		System.out.println("3. Exit");

		String option = scanner.nextLine();
		while (!option.equals("3")){

			switch(option) {
				case "1":
					System.out.println("Ingrese opción");
					System.out.println("1. Ingresar vehiculo lanzadera");
					System.out.println("2. Ingresar nave no tripulada");
					System.out.println("3. Ingresar nave tripulada");
					String opt = scanner.nextLine();

					switch(opt) {
						case "1": //para ingresar datos de vehiculo lanzadera
							askDataLanzadera(databaseConection, scanner);
							break;
						case "2":
							askDataNotripulada(databaseConection, scanner);
							break;
						case "3":

							break;
					}
					break;
				case "2":
					System.out.println("caso 2");

					break;
				case "3":
					System.out.println("bye");
					break;
				default: // Si no es alguna de las opciones
					System.out.println(option + " es una selección invalida, por favor ingrese nuevamente.");
			}
			if (!option.equals("3")){
				System.out.println("Ingrese opción");
				System.out.println("1. Ingresar nueva nave");
				System.out.println("2. Consultar naves");
				System.out.println("3. Exit");
				option = scanner.nextLine();
			}
		}
	}

	private static void askDataLanzadera(DatabaseConection databaseConection, Scanner scanner) {
		System.out.println("caso 1");
		lanzadera lanzadera = new lanzadera();
		System.out.println("Nombre de la nave: ");
		lanzadera.setName(scanner.nextLine());
		System.out.println("Velocidad nave: ");
		lanzadera.setDescription(scanner.nextLine());
		System.out.println("Color nave: ");
		lanzadera.setColor(scanner.nextLine());
		databaseConection.insertLanzaderaToCollection(lanzadera);
		lanzadera.toHonkLanzadera();
		System.out.println("Nave guardada");
	}

	private static void askDataNotripulada(DatabaseConection databaseConection, Scanner scanner) {
		System.out.println("caso 1");
		notripulada notripulada = new notripulada();
		System.out.println("Nombre de la nave: ");
		notripulada.setName(scanner.nextLine());
		System.out.println("Velocidad nave: ");
		notripulada.setDescription(scanner.nextLine());
		System.out.println("Color nave: ");
		notripulada.setColor(scanner.nextLine());
		databaseConection.insertNoTripuladaToCollection(notripulada);
		System.out.println("Nave guardada");
	}

	private static void askDataTripulada(DatabaseConection databaseConection, Scanner scanner) {
		System.out.println("caso 1");
		tripulada tripulada = new tripulada();
		System.out.println("Nombre de la nave: ");
		tripulada.setName(scanner.nextLine());
		System.out.println("Velocidad nave: ");
		tripulada.setDescription(scanner.nextLine());
		System.out.println("Color nave: ");
		tripulada.setColor(scanner.nextLine());
		databaseConection.insertTripuladaToCollection(tripulada);
		System.out.println("Nave guardada");
	}
}
