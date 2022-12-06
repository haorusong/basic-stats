package gui.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.BasicStatsModel;

public class NumbersView implements View {
	/** TextArea that shows all the numbers */
	private JTextArea jtaNumbers;

	public NumbersView(JFrame jfMain) {
		super();

		jtaNumbers = new JTextArea(10, 5);
		jtaNumbers.setEditable(false);

		jfMain.getContentPane().add(jtaNumbers, BorderLayout.SOUTH);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see gui.view.View#update(model.BasicStatsModel)
	 */
	public void update(BasicStatsModel model) {
		// Reset
		// if 按下reset
		if (model.getArrayDouble().length == 0) {
			jtaNumbers.setText("");
		}
		// Add number
		// else if 按下 add 按钮
		else {
			// Update the displayed list of numbers
			// double num = model.getArrayDouble()[model.getArrayDouble().length - 1];
			// jtaNumbers.append(num + ",");
			jtaNumbers.setText("");
			for (double d : model.getArrayDouble()) {
				jtaNumbers.append(d + ",");
			}
			// jtaNumbers.append(model.getArrayDouble().toString());
		}

		// // Undo number
		// if (model.getArrayDouble().length > 0) {
		// double num = model.getArrayDouble()[model.getArrayDouble().length - 1];
		// jtaNumbers.setText("");
		// jtaNumbers.append(num + ",");
		// }
	}

	public String getStringValue() {
		// This is a snapshot of the current value to support
		// testability and debuggability without breaking the encapsulation.
		return jtaNumbers.getText();
	}
}
