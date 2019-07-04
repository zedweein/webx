package javax.webx.tags;

import java.util.ArrayList;

public class Tags extends ArrayList<Tag> {

	private static final long serialVersionUID = 1L;

	/**
	 * 插入的标签在当前位置的位置（前后）
	 */
	public static final int FRONT = 0;
	public static final int AFTER = 1;

	public Tags with(Tag tag) {
		super.add(tag);
		return this;
	}
	
	public Tags style(String style) {
		for (int i = 0; i < this.size(); i++) {
			this.get(i).style(style);
		}
		return this;
	}
	
	public Tags clazz(String clazzName) {
		for (int i = 0; i < this.size(); i++) {
			this.get(i).clazz(clazzName);
		}
		return this;
	}
	
	
	
	public static final String HTML= "html";
	public static final String HEAD= "head";
	public static final String STYLE= "style";
	public static final String BODY= "body";
	public static final String META= "meta";
	public static final String LINK= "link";
	public static final String SCRIPT= "script";
	public static final String DIV= "div";
	public static final String A= "a";
	public static final String AUDIO= "audio";
	public static final String VIDEO= "video";
	public static final String BLOCKQUOTE= "blockquote";
	public static final String BR = "br";
	public static final String BUTTON = "button";
	public static final String CANVAS = "canvas";
	public static final String CAPTION = "caption";
	public static final String DD = "dd";
	public static final String DL = "dl";
	public static final String DT = "dt";
	public static final String HEADER = "header";
	public static final String FOOTER = "footer";
	public static final String FORM = "form";
	public static final String FRAME = "frame";
	public static final String IFRAME = "iframe";
	public static final String IMG = "img";
	public static final String INPUT = "input";
	public static final String LABEL = "label";
	public static final String UL = "ul";
	public static final String LI = "li";
	public static final String NAV = "nav";
	public static final String OL = "ol";
	public static final String SELECT = "select";
	public static final String OPTION = "option";
	public static final String P = "p";
	public static final String SECTION = "section";
	public static final String SPAN = "span";
	public static final String TABLE = "table";
	public static final String TH = "th";
	public static final String TR = "tr";
	public static final String TD = "td";
	public static final String THEAD = "thead";
	public static final String TBODY = "tbody";
	public static final String TFOOT = "tfoot";
	public static final String TEXTAREA = "textarea";
	public static final String TITLE = "title";
}
