package gui.Views;

import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import gui.BasicStats;

public class MaxView implements View {
	// Instance variables
	double max;
	JTextField jtfmax;
	String name;

	/**
	 * 
	 */
	public MaxView() {
		max = 0;
		jtfmax = new JTextField(5);
		jtfmax.setEditable(false);
		name = "Max";
	}

	@Override
	public void update(ArrayList<Double> numbers) {
		max = BasicStats.max(BasicStats.getArrayDouble(numbers));

		// Set text
		jtfmax.setText("" + max);
	}

	@Override
	public void reset() {
		jtfmax.setText("");
	}

	@Override
	public JTextComponent show() {
		return jtfmax;
	}

	@Override
	public String getName() {
		return name;
	}

	public double getmax() {
		return max;
	}

}