package Models;

import java.util.ArrayList;

import gui.Views.AddNumView;
import gui.Views.CountView;
import gui.Views.MaxView;
import gui.Views.MeanView;
import gui.Views.MedianView;
import gui.Views.NumbersView;
import gui.Views.View;

public interface BasicStatsModel {

	// Add observer to the model
	public void addObserver(View view);

	// addData allows for single data point to be added from any source
	public void addData(Double data);

	// Updates each view
	public void updateViews();

	// Taking an ArrayList allows for data to be read in from this kind of data
	// structure
	public void update(ArrayList<Double> information);

	// returns data as ArrayList
	public ArrayList<Double> getData();

	public void addView(CountView countView);

	public void addView(MeanView meanView);

	public void addView(MaxView maxView);

	public void addView(MedianView medianView);

	public void addView(NumbersView numbersView);

	public void addView(AddNumView addNumView);

}
