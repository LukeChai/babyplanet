package com.bp.app.taglib;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class RushTag extends TagSupport {

	private static final long serialVersionUID = 1L;
	private String url = "#";
	private String name;
	private String onclick;

	public void setUrl(String url) {
		this.url = url;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOnclick(String onclick) {
		this.onclick = onclick;
	}

	@Override
	public int doStartTag() throws JspException {
		final StringBuffer stringBuffer = new StringBuffer();

		stringBuffer.append("<a href=\"#\" ");
		if (!org.springframework.util.StringUtils.isEmpty(name)) {
			stringBuffer.append("name=\"");
			stringBuffer.append(name);
			stringBuffer.append("\" ");
		}
		if (org.springframework.util.StringUtils.isEmpty(onclick)) {
			stringBuffer.append("onclick=\"submitA('");
			stringBuffer.append(url);
			stringBuffer.append("') \"");
		} else {
			stringBuffer.append("onclick=\"");
			stringBuffer.append(onclick);
			stringBuffer.append("\" ");
		}
		stringBuffer.append(">");

		try {
			pageContext.getOut().print(stringBuffer.toString());
		} catch (IOException e) {
			throw new JspException(e.getMessage());
		}
		return EVAL_BODY_INCLUDE;
	}

	@Override
	public int doEndTag() throws JspException {
		try {
			pageContext.getOut().print("</a>");
		} catch (IOException e) {
			throw new JspException(e.getMessage());
		}
		return EVAL_PAGE;
	}

}
