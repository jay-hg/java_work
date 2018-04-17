package Entity;
/*
 * 对应每一份评议的表单
 * 
 */
public class FormEntity {
	//表单页面的地址
	private String pageUrl;
	//提交地址
	private String destUrl;
	//验证码
	private String validNums;
	//两个参数
	private String paraV;
	private String paraE;
	public String getPageUrl() {
		return pageUrl;
	}
	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}
	public String getDestUrl() {
		return destUrl;
	}
	public void setDestUrl(String destUrl) {
		this.destUrl = destUrl;
	}
	public String getValidNums() {
		return validNums;
	}
	public void setValidNums(String validNums) {
		this.validNums = validNums;
	}
	public String getParaV() {
		return paraV;
	}
	public void setParaV(String paraV) {
		this.paraV = paraV;
	}
	public String getParaE() {
		return paraE;
	}
	public void setParaE(String paraE) {
		this.paraE = paraE;
	}
	
}
