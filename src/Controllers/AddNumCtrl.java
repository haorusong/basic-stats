package Controllers;

import java.util.ArrayList;

import Models.BasicStatsModel;

//Controller for AddNumView
public class AddNumCtrl implements Controller {

	ArrayList<BasicStatsModel> models;

	public AddNumCtrl() {
		models = new ArrayList<BasicStatsModel>();
	}

	@Override
	public void addModel(BasicStatsModel model) {
		models.add(model);
	}

	@Override
	public void updateModels(Double num) {

		for (BasicStatsModel model : models) {
			model.addData(num);
		}
	}

}
