package javax.webx.pages;

import javax.webx.common.Style;
import javax.webx.tags.Tag;
import javax.webx.tags.Tags;
import javax.webx.utils.JsoupUtil;

public class MainPage {
	
	public static void main(String[] args) {
		
		//声明一个css对象,加载一个css文件
		Style css = new Style("C:\\Users\\Awn\\Desktop\\Share\\plugins\\style.css");
		
		//自定义样式加入到Style对象
		css.with("div{width:25%;float:left;height:300px;}");
		
		Tag html = new Tag(Tags.HTML);
		Tag body = new Tag(Tags.BODY);
		html.insert(body);
		Tag head = new Tag(Tags.HEAD);
		body.insert(head);
		Tag style = new Tag(Tags.STYLE);
		style.text(css.styles());
		
		head.insert(style);
		
		Tag meta = new Tag(Tags.META);
		meta.httpEquiv("Content-Type").content("text/html;charset=utf-8");
		head.insert(meta);
		
		Tag div1 = new Tag(Tags.DIV);
		Tag div2 = new Tag(Tags.DIV);
		Tag div3 = new Tag(Tags.DIV);
		Tag div4 = new Tag(Tags.DIV);
		div1.insert(new Tag(Tags.INPUT,true));
		
		body.insert(div1,div2,div3,div4);
		
		//结束一定要build一下才能使用
		String build = html.build();
		
		//格式化输出
		System.out.println(JsoupUtil.format(build));
		
	}
	
	
}
