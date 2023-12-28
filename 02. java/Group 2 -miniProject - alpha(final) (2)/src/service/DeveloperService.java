package service;

import dto.Developer;

import java.util.ArrayList;

import db.DeveloperDB;

public class DeveloperService {

	private DeveloperDB developerDB = DeveloperDB.getInstance();

	public ArrayList<Developer> getAllDevelopers() {
		return developerDB.getDeveloperList();
	}

	public void addDeveloper(Developer developer) {
		developerDB.insertDeveloper(developer);
	}

	public void updateDeveloper(Developer developer, String name, String[] skill, int career) {
		developerDB.updateDeveloper(developer, name, skill, career);
	}

	public void deleteDeveloper(Developer developer) {
		developerDB.removeDeveloper(developer);
	}

	public ArrayList<Developer> searchDeveloperByName(String name) {
		ArrayList<Developer> result = new ArrayList<>();
		for (Developer developer : developerDB.getDeveloperList()) {
			if (developer.getName().equalsIgnoreCase(name)) {
				result.add(developer);
			}
		}
		return result;
	}

}
