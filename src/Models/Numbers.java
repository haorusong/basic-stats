package Models;

import java.util.ArrayList;

import gui.Views.AddNumView;
import gui.Views.CountView;
import gui.Views.MaxView;
import gui.Views.MeanView;
import gui.Views.MedianView;
import gui.Views.NumbersView;
import gui.Views.View;

//Model for this assignment
public class Numbers implements BasicStatsModel {

	// Variables for Model
	ArrayList<Double> numbers;
	ArrayList<View> observers;

	public Numbers() {
		numbers = new ArrayList<Double>();
		observers = new ArrayList<View>();
	}

	@Override
	public void addObserver(View view) {
		observers.add(view);
	}

	@Override
	public void addData(Double num) {
		numbers.add(num);

		updateViews();
	}

	@Override
	public void updateViews() {

		for (View view : observers) {
			if (numbers.size() == 0) {
				view.reset();
			} else {
				view.update(numbers);
			}
		}
	}

	@Override
	public void update(ArrayList<Double> information) {
		if (information.size() == 0) {
			numbers = information;
		} else {
			numbers.addAll(information);
		}

		updateViews();
	}

	@Override
	public ArrayList<Double> getData() {
		return numbers;
	}

	@Override
	public void addView(CountView countView) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addView(MeanView meanView) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addView(MaxView maxView) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addView(MedianView medianView) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addView(NumbersView numbersView) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addView(AddNumView addNumView) {
		// TODO Auto-generated method stub

	}

}
