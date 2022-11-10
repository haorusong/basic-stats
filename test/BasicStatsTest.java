import org.junit.Test;

import Controllers.AddNumCtrl;
import Controllers.ResetCtrl;
import Controllers.Controller;
import Models.BasicStatsModel;
import Models.Numbers;

import static org.junit.Assert.*;

import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;

import org.junit.*;
import gui.BasicStats;
import gui.Views.AddNumView;
import gui.Views.CountView;
import gui.Views.MaxView;
import gui.Views.MeanView;
import gui.Views.MedianView;
import gui.Views.NumbersView;
import gui.Views.ResetView;

public class BasicStatsTest {
  private static double EPS = 1e-9;
  private BasicStatsModel model = new BasicStatsModel();
  private AddNumView addNumView = new AddNumView();
  private CountView countView = new CountView();
  private MaxView maxView = new MaxView();
  private MeanView meanView = new MeanView();
  private MedianView medianView = new MedianView();
  private NumbersView numbersView = new NumbersView();
  private ResetView resetView = new ResetView();
  private AddNumCtrl addNumContr = new AddNumCtrl();
  private ResetCtrl ResetNumContr = new ResetCtrl();

  /**
   * register MVC
   * 
   * @param ResetCtrl
   */
  @Before
  public void registerMVC(Controller ResetCtrl) {

    addNumView.addController(addNumContr);
    resetView.addController(ResetCtrl);
    addNumContr.addModel(model);
    ResetCtrl.addModel(model);
    model.addView(countView);
    model.addView(meanView);
    model.addView(maxView);
    model.addView(medianView);
    model.addView(numbersView);
    model.addView(addNumView);
  }

  @Test
  public void testCentralTendency() {
    double[] numbers = { 2, 2, 3, 3, 3, 4, 4 };
    double mean = BasicStats.mean(numbers);
    assertEquals(3, mean, EPS);
    double median = BasicStats.median(numbers);
    assertEquals(3, median, EPS);
    double mode = BasicStats.mode(numbers);
    assertEquals(3, mode, EPS);
    double max = BasicStats.max(numbers);
    assertEquals(3, max, EPS);
  }

  // Add a number successfully completes
  @Test
  public void testAddNumCtrl() {
    this.addNumView.jtfNumber.setText("1");
    JButton button = addNumView.getButton();
    button.doClick();
    assertEquals(numbersView.show().getText(), "1.0");
  }

  // Add a number fails to complete
  @Test
  public void testAddFailNumCtrl() {
    this.addNumView.jtfNumber.setText("q");
    JButton button = addNumView.getButton();
    button.doClick();
    assertEquals(numbersView.show().getSelectedText(), "0 + num");
  }

  @Test
  public void testMedian() {
    // Median should be 8.0 since size is even
    /* double[] numbers = {1, 4, 7, 9, 11, 21}; */
    double[] numbers = { 9, 11, 1, 4, 7, 21 };

    double median = BasicStats.median(numbers);
    assertEquals(8.0, median, EPS);

    // Median should be 7 since size is odd
    double[] numbers2 = { 9, 1, 4, 7, 21 };
    median = BasicStats.median(numbers2);
    assertEquals(7, median, EPS);

    // Median should be 3 since size is 1
    double[] numbers3 = { 3 };
    median = BasicStats.median(numbers3);
    assertEquals(3, median, EPS);

    // Median should be 0 since size is 0
    double[] numbers4 = {};
    median = BasicStats.median(numbers4);
    assertEquals(0, median, EPS);
  }

  @Test
  public void testMode() {
    // Mode should be 1 since we are taking the first mode
    double[] numbers = { 1, 4, 7, 9, 11, 21 };
    double mode = BasicStats.mode(numbers);
    assertEquals(1, mode, EPS);

    // Mode should be 4
    double[] numbers2 = { 1, 4, 4, 7, 9, 11, 21 };
    mode = BasicStats.mode(numbers2);
    assertEquals(4, mode, EPS);

    // Mode should be 7
    double[] numbers3 = { 4, 4, 7, 7, 7, 11, 11 };
    mode = BasicStats.mode(numbers3);
    assertEquals(7, mode, EPS);

    // Mode should be 7
    double[] numbers4 = { 7 };
    mode = BasicStats.mode(numbers4);
    assertEquals(7, mode, EPS);

    // Mode should be 0
    double[] numbers5 = {};
    mode = BasicStats.mode(numbers5);
    assertEquals(0, mode, EPS);
  }

  @Test
  public void testMax() {
    // Max should be 21 since size is even
    /* double[] numbers = {1, 4, 7, 9, 11, 21}; */
    double[] numbers = { 9, 11, 1, 4, 7, 21 };

    double max = BasicStats.max(numbers);
    assertEquals(21, max, EPS);

    // Max should be 21 since size is odd
    double[] numbers2 = { 9, 1, 4, 7, 21 };
    max = BasicStats.max(numbers2);
    assertEquals(21, max, EPS);

    // Max should be 3 since size is 1
    double[] numbers3 = { 3 };
    max = BasicStats.max(numbers3);
    assertEquals(3, max, EPS);

    // Max should be 0 since size is 0
    double[] numbers4 = {};
    max = BasicStats.max(numbers4);
    assertEquals(0, max, EPS);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMaxFail() {
    double[] numbers4 = {};
    double max = BasicStats.max(numbers4);
  }

}
