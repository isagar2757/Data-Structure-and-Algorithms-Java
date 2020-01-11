
package exercise2;
import java.util.Random;

import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.LogarithmicAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

import exercise2.PrefixAverage;
public class ShowChart extends ApplicationFrame{

  public ShowChart(String title) {
	  super(title);
	  final XYSeries s1 = new XYSeries("prefixAverage1");
      final XYSeries s2 = new XYSeries("prefixAverage2");
      
	  PrefixAverage prefixAvg = new PrefixAverage();
	  long startTime = System.currentTimeMillis();
	  long endTime = System.currentTimeMillis();
	  long elapsed = endTime - startTime;
  

for(int i = 10000 ; i<=50000 ; i+=10000) 
{
	s1.add(i,runningTimePreAVG1(i));
	s2.add(i,runningTimePreAVG2(i));
}



//for(int i = 100000 ; i<=500000 ; i+=100000) 
//{
//	//s1.add(i,runningTimePreAVG1(i));
//	s2.add(i,runningTimePreAVG2(i));
//}

      final XYSeriesCollection dataset = new XYSeriesCollection();
      dataset.addSeries(s1);
      dataset.addSeries(s2);
    

      final JFreeChart chart = ChartFactory.createXYLineChart(
          "PrefixAvegare 1 & 2 Execution Time",          // chart title
          "Category",               // domain axis label
          "Value",                  // range axis label
          dataset,                  // data
          PlotOrientation.VERTICAL,
          true,                     // include legend
          true,
          false
      );

      final XYPlot plot = chart.getXYPlot();
      final NumberAxis domainAxis = new NumberAxis("Value of n");
      final NumberAxis rangeAxis = new LogarithmicAxis("Time (milliseconds)");
      plot.setDomainAxis(domainAxis);
      plot.setRangeAxis(rangeAxis);
      chart.setBackgroundPaint(Color.white);
      plot.setOutlinePaint(Color.black);
      final ChartPanel chartPanel = new ChartPanel(chart);
      chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
      setContentPane(chartPanel);

  }
/** Uses repeated concatenation to compose a String with n copies of character c. */
 
  public static void main(String[] args) {
	  
    
    final ShowChart demo = new ShowChart("Exercise 2");
    demo.pack();
    RefineryUtilities.centerFrameOnScreen(demo);
    demo.setVisible(true);

  }
public static double[] fillArray(int n) 
{
	double[] x = new double[n];
	 for(int i=0;i<n;i++)
	  {
		  double randomNumber = new Random().nextDouble();
		  x[i] = randomNumber;
	  }
	return x;
	
}

public static long runningTimePreAVG1(int n) 
{
	double[] x = fillArray(n);
	PrefixAverage prefixAvg = new PrefixAverage();
	  long startTime = System.currentTimeMillis();
	  double[] preAvg1_1 = prefixAvg.prefixAverage1(x);
	  long endTime = System.currentTimeMillis();
 long elapsed = endTime - startTime;
	return elapsed;
	
}

public static long runningTimePreAVG2(int n) 
{
	double[] x = fillArray(n);
	PrefixAverage prefixAvg = new PrefixAverage();
	  long startTime = System.currentTimeMillis();
	  double[] preAvg1_1 = prefixAvg.prefixAverage2(x);
	  long endTime = System.currentTimeMillis();
 long elapsed = endTime - startTime;
	return elapsed+10;	//because it takes less tan 1 millisecond that's why I put +10 Millisecond to show it in graph.
	
}
}
