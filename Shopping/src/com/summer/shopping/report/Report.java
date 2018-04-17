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
        // 1. �õ�����  
        //CategoryDataset dataset = getDataSet();  
        // 2. ����chart  
        JFreeChart chart = ChartFactory.createBarChart3D(  
                "ˮ������ͼ", // ͼ�����  
                "ˮ��", // Ŀ¼�����ʾ��ǩ--����  
                "����", // ��ֵ�����ʾ��ǩ--����  
                dataset, // ���ݼ�  
                PlotOrientation.VERTICAL, // ͼ����ˮƽ��  
                true, // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ����  
                false, // �Ƿ����ɹ���  
                false // �Ƿ�����URL����  
                );  
        // 3. ����chart������ʾ����  
        processChart(chart);  
  
        // 4. chart���ͼƬ  
        writeChartAsImage(chart);  
  
        // 5. chart ��swing��ʽ���  
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
                "��Ʒ����ͼ", // ͼ�����  
                "��Ʒ", // Ŀ¼�����ʾ��ǩ--����  
                "����", // ��ֵ�����ʾ��ǩ--����  
                dataset, // ���ݼ�  
                PlotOrientation.VERTICAL, // ͼ����ˮƽ��  
                false, // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ����  
                false, // �Ƿ����ɹ���  
                false // �Ƿ�����URL����  
                );  
		
		JFreeChart chart2 = ChartFactory.createPieChart(
				"��Ʒ����pieͼ", 
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
     * ��ȡһ����ʾ�õ�������ݼ����� 
     *  
     * @return 
     */  
  
    /** 
     * ���ͼ������ʾ���� 
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
        textTitle.setFont(new Font("����", Font.PLAIN, 20));  
        domainAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 11));  
        domainAxis.setLabelFont(new Font("����", Font.PLAIN, 12));  
        rAxis.setTickLabelFont(new Font("sans-serif", Font.PLAIN, 12));  
        rAxis.setLabelFont(new Font("����", Font.PLAIN, 12));  
        chart.getLegend().setItemFont(new Font("����", Font.PLAIN, 12));  
        // renderer.setItemLabelGenerator(new LabelGenerator(0.0));  
        // renderer.setItemLabelFont(new Font("����", Font.PLAIN, 12));  
        // renderer.setItemLabelsVisible(true);  
    }  
  
    /** 
     * ���ͼƬ 
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
