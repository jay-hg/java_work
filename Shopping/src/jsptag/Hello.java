package jsptag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class Hello extends TagSupport{

	@Override
	public int doEndTag() throws JspException {
		try {
			this.pageContext.getOut().println("hello world!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doEndTag();
	}
	
}
