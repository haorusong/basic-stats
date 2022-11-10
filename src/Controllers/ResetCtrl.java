package Controllers;

import Models.BasicStatsModel;
import java.util.ArrayList;

//Controller for ResetView
public class ResetCtrl implements Controller {

	ArrayList<BasicStatsModel> models;

	public ResetCtrl() {
		models = new ArrayList<BasicStatsModel>();
	}

	@Override
	public void addModel(BasicStatsModel model) {
		models.add(model);
	}

	@Override
	public void updateModels(Double num) {
		// New ArrayList resets model in Numbers.java
		for (BasicStatsModel model : models) {
			model.update(new ArrayList<Double>());
		}
	}

}
