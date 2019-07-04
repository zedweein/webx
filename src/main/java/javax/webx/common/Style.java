package javax.webx.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.w3c.css.sac.InputSource;
import org.w3c.dom.css.CSSRule;
import org.w3c.dom.css.CSSRuleList;
import org.w3c.dom.css.CSSStyleRule;
import org.w3c.dom.css.CSSStyleSheet;

import com.steadystate.css.parser.CSSOMParser;

public class Style extends ArrayList<String> {

	private static final long serialVersionUID = 1L;

	/**
	 * 加载一个本地样式表
	 * @param cssFile 层叠样式表文件路径
	 */
	public Style(String cssFile) {
		styleSheet(cssFile);
	}

	public Style() {
		
	}

	/**
	 * 添加css方法
	 * @param css
	 * @return
	 */
	public Style with(String css) {
		this.add(css);
		return this;
	}

	/**
	 * 解析一个css文件
	 * @param cssFile
	 */
	public void styleSheet(String cssFile) {
		InputStream inStream = null;
		try {
			inStream = new FileInputStream(cssFile);
			InputSource source = new InputSource();
			source.setByteStream(inStream);
			source.setEncoding("UTF-8");
			CSSOMParser parser = new CSSOMParser();
			CSSStyleSheet sheet = parser.parseStyleSheet(source, null, null);
			CSSRuleList rules = sheet.getCssRules();
			if (rules.getLength() > 0) {
				for (int i = 0; i < rules.getLength(); i++) {
					final CSSRule rule = rules.item(i);
					String cssText = ((CSSStyleRule) rule).getCssText();
					this.with(cssText);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("parse css file error, please check : " + cssFile);
		}finally {
			if(inStream!=null) {
				try {
					inStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void print() {
		if(this.size() > 0) {
			for(String css:this) {
				System.out.println(css);
			}
		}
	}

	public String styles() {
		StringBuffer buff = new StringBuffer();
		if(this.size() > 0) {
			for(String css:this) {
				buff.append(css);
			}
		}
		return buff.toString();
	}

}
