package javax.webx.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupUtil {
	/**
	 * 格式化html代码
	 * @param html 原始html
	 * @param doctype 是否携带DOCTYPE头
	 * @return
	 */
	public static String format(String html,boolean doctype){  
		try {
			Document doc = Jsoup.parseBodyFragment(html);
			html = doc.toString();
			html = doctype ? "<!DOCTYPE html>" + html : html;
			return html;
		} catch (Exception e) {
			e.printStackTrace();
			return html;
		}
	} 
	
	/**
	 * 格式化html代码
	 * @param html 原始html
	 * @return
	 */
	public static String format(String html){  
		boolean doctype = true;
		try {
			Document doc = Jsoup.parseBodyFragment(html);
			html = doc.toString();
			html = doctype ? "<!DOCTYPE html>\n" + html : html;
			return html;
		} catch (Exception e) {
			e.printStackTrace();
			return html;
		}
	} 
	
	
}
