package controller;

import model.CompanyModel;
import model.domain.Company;
import view.EndView;


public class AplicationController {
	public static void request(int reqNumber) {
		if (reqNumber == 1) {
			EndView.printAll(CompanyModel.getAll());
		} else if(reqNumber == 2) {
		EndView.printOne(CompanyModel.getOne("KT"));
		}
	}
}
