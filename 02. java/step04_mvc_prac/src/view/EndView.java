package view;

import java.util.ArrayList;

import model.domain.Company;

public class EndView {
	public static void printAll(ArrayList<Company> all_c_data) {	
		for (Company data : all_c_data) {
			if (data != null) {
				System.out.println(data.toString());
			}
		}
	}

	public static void printOne(Company all_c_data) {
		System.out.println(all_c_data);
	}





















}

