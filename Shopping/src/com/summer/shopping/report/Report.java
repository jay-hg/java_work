package com.summer.shopping.report;
import java.awt.Font;
import java.awt.RenderingHints;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import com.summer.shopping.util.DB;
  
public class Report extends HttpServlet {  
	private static String imgPath = "E:\\java_work\\Shopping\\WebContent\\admin\\images\\report\\";
	static DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
    static DefaultPieDataset pieDataset = new DefaultPieDataset();
	static int num = 0;
    /*public static void main(String[] args) {  
        // 1. 得到数据  
        //CategoryDataset dataset = getDataSet();  
        // 2. 构造chart  
        JFreeChart chart = ChartFactory.createBarChart3D(  
                "水果产量图", // 图表标题  
                "水果", // 目录轴的显示标签--横轴  
                "产量", // 数值轴的显示标签--纵轴  
                dataset, // 数据集  
                PlotOrientation.VERTICAL, // 图表方向：水平、  
                true, // 是否显示图例(对于简单的柱状图必须  
                false, // 是否生成工具  
                false // 是否生成URL链接  
                );  
        // 3. 处理chart中文显示问题  
        processChart(chart);  
  
        // 4. chart输出图片  
        writeChartAsImage(chart);  
  
        // 5. chart 以swing形式输出  
        ChartFrame pieFrame = new ChartFrame("XXX", chart);  
        pieFrame.pack();  
        pieFrame.setVisible(true);  
  
    }  */
  
    
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
    	Connection conn = DB.getConn();
		String sql = "select p.name,sum(s.pcount) c from product p join salesitem s on (p.id=s.productid) group by p.id";
		System.out.println(sql);
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				dataset.addValue(rs.getInt("c"), "abc", rs.getString("p.name"));
				pieDataset.setValue(rs.getString("p.name"), rs.getInt("c"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(stmt);
			DB.close(conn);
		}
		
		JFreeChart chart = ChartFactory.createBarChart3D(  
                "产品销量图", // 图表标题  
                "产品", // 目录轴的显示标签--横轴  
                "销量", // 数值轴的显示标签--纵轴  
                dataset, // 数据集  
                PlotOrientation.VERTICAL, // 图表方向：水平、  
                false, // 是否显示图例(对于简单的柱状图必须  
                false, // 是否生成工具  
                false // 是否生成URL链接  
                );  
		
		JFreeChart chart2 = ChartFactory.createPieChart(
				"产品销量pie图", 
				pieDataset, 
				true, 
				false, 
				false);
		
		//processChart(chart);
		//processChart(chart2);
		  
        writeChartAsImage(chart);
        writeChartAsImage(chart2);
        
        this.getServletContext().getRequestDispatcher("/admin/showproductsaleschart.jsp").forward(req, resp);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
	}


	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		imgPath = config.getInitParameter("reportpath");
	}


	/** 
     * 获取一个演示用的组合数据集对象 
     *  
     * @return 
     */  
  
    /** 
     * 解决图表汉字显示问题 
     *  
     * @param chart 
     */  
    private static void processChart(JFreeChart chart) {  
        CategoryPlot plot = chart.getCategoryPlot();  
        CategoryAxis domainAxis = plot.getDomainAxis();  
        ValueAxis rAxis = plot.getRangeAxis();  
        chart.getRenderingHints().put(RenderingHints.KEY_TEXT_ANTIALIASING,  
                RenderingHints.VALUE_TEXT_ANTIALIAS_OFF);  
        TextTitle textTitle = chart.getTitle();  
        textTitle.setFont(new Font("宋体", Font.PLAIN, 20));  
        domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11));  
        domainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));  
        rAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));  
        rAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));  
        chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12));  
        // renderer.setItemLabelGenerator(new LabelGenerator(0.0));  
        // renderer.setItemLabelFont(new Font("宋体", Font.PLAIN, 12));  
        // renderer.setItemLabelsVisible(true);  
    }  
  
    /** 
     * 输出图片 
     *  
     * @param chart 
     */  
    private static void writeChartAsImage(JFreeChart chart) {  
        FileOutputStream fos_jpg = null;  
        try {  
            fos_jpg = new FileOutputStream(imgPath+"report"+num+".jpg");  
            ChartUtilities.writeChartAsJPEG(fos_jpg, 1, chart, 400, 300, null);  
            num ++;
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                fos_jpg.close();  
            } catch (Exception e) {  
            }  
        }  
    }  
}  
