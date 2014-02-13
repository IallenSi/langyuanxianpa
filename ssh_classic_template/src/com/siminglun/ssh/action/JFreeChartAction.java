/**
 * 
 */
package com.siminglun.ssh.action;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import com.opensymphony.xwork2.ActionSupport;
import com.siminglun.ssh.service.IDemoService;

/**
 * @author 司明仑 --2014-1-10
 *
 */
public class JFreeChartAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2042888645875223633L;
	private IDemoService demoService;
	//供ChartResult调用->ActionInvocation.getStack().findValue("chart")
	private JFreeChart chart;

	/**
	 * @return the demoService
	 */
	public IDemoService getDemoService() {
		return demoService;
	}

	/**
	 * @param demoService the demoService to set
	 */
	public void setDemoService(IDemoService demoService) {
		this.demoService = demoService;
	}

	/**
	 * @return the chart
	 */
	public JFreeChart getChart() {
		return chart;
	}

	/**
	 * @param chart the chart to set
	 */
	public void setChart(JFreeChart chart) {
		this.chart = chart;
	}

	/** 
	 * 此方法是产生直方行图表,并存到指定的目录下 
	 * @return 
	 */
	/*public JFreeChart getChart() {

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		// 显示一行的所有列，一字型排开  
		dataset.addValue(1.0, "Row 1", "Column 1");
		dataset.addValue(5.0, "Row 1", "Column 2");
		dataset.addValue(3.0, "Row 1", "Column 3");
		dataset.addValue(2.0, "Row 2", "Column 1");
		dataset.addValue(3.0, "Row 2", "Column 2");
		dataset.addValue(2.0, "Row 2", "Column 3");
		List<Map> list = demoService.queryByZw();
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for (Map m : list) {
			dataset.addValue((BigInteger) m.get("count"), m.get("zw")
					.toString(), m.get("sex").toString());
		}

		JFreeChart chart = ChartFactory.createBarChart3D("用户表", // chart title  
				"横坐标值", // domain axis label  
				"竖坐标值", // range axis label  
				dataset, // data  
				PlotOrientation.VERTICAL, // 图显示的方向为水平显示  
				true, // include legend  
				true, // tooltips?  
				false // URLs?  
				);
		chart.setBackgroundPaint(Color.BLUE);

		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		plot.setBackgroundPaint(Color.GREEN);
		plot.setRangeGridlinePaint(Color.red); // 修改网格线的颜色  
		BarRenderer renderer = (BarRenderer) plot.getRenderer();
		renderer.setItemMargin(0.0);

		// 产生标签指示器，1代表列名，2代表数据值，3代表百分比  
		CategoryItemLabelGenerator generator = new StandardCategoryItemLabelGenerator(
				"{2}", new DecimalFormat("0.0"));
		renderer.setBaseItemLabelGenerator(generator);
		//renderer.setBaseItemLabelsVisible(true);  // 设置标签是否可见  

		// 单独指定显示系列的标签  
		renderer.setBaseItemLabelsVisible(null); // 清除所有系列的标志，必须得要  
		renderer.setSeriesItemLabelsVisible(0, true);
		renderer.setSeriesItemLabelsVisible(1, false);

		return chart;
	}
	*/

	/**
	 * 生成饼状图
	 */
	@Override
	public String execute() throws Exception {
		List<Map> list = demoService.queryByZw();
		DefaultPieDataset dataset = new DefaultPieDataset();
		for (Map m : list) {
			dataset.setValue(m.get("zw").toString(),
					(BigInteger) m.get("count"));
		}
		//生成JFreeChart对象
		chart = ChartFactory.createPieChart("Pie Chart", dataset, true, true,
				false);
		return SUCCESS;
	}
}
