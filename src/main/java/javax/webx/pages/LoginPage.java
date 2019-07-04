package javax.webx.pages;

import javax.webx.common.Script;
import javax.webx.common.Style;
import javax.webx.tags.Tag;
import javax.webx.tags.Tags;
import javax.webx.utils.JsoupUtil;

public class LoginPage {

	public String index() {

		Style css = new Style();
		Script js = new Script();
		// 自定义样式加入到Style对象
		css.with("body,html{width:100%;height:100%;margin:0;padding:0;background:#eee;display: flex;align-items: center;justify-content: center;}");
		css.with("#loginPanel{width: 350px;height: 200px;border: 1px solid #000;border-radius: 5px;position: relative;top: -80px;padding: 20px;}");
		css.with(".topctn{width:100%;height:40%;display: flex;align-items: center;justify-content: center;}.btm{width:100%;height:20%;display: flex;align-items: center;justify-content: center;}");
		css.with("#username,#password{height:30px;width:65%;margin-left:10px;border-radius: 5px;outline: none;border: 1px solid #c1c1c1;padding: 0px 5px;}");
		css.with("#loginBtn{display:inline-block;background:green;color:#fff;border-radius:3px;padding:5px 10px;}");
		
		//自定义脚本加入到script对象
		js.with("window.onload=function(){alert('welcome login');}");
		
		Tag html = new Tag(Tags.HTML);
		Tag body = new Tag(Tags.BODY);
		Tag head = new Tag(Tags.HEAD);
		Tag style = new Tag(Tags.STYLE).text(css.styles());
		Tag script = new Tag(Tags.SCRIPT).text(js.scripts());

		head.insert(style);
		head.insert(script);
		body.insert(head);
		html.insert(body);

		Tag div = (Tag) new Tag(Tags.DIV).id("loginPanel");
		Tag divtop = new Tag(Tags.DIV);
		Tag divctn = new Tag(Tags.DIV);
		Tag divbtm = new Tag(Tags.DIV);
		divtop.with(divctn).clazz("topctn");
		divbtm.clazz("btm");
		Tag username = (Tag) new Tag(Tags.INPUT, true).id("username").type("text").placeholder("请输入用户名");
		username.text("用户:", Tags.FRONT);
		Tag password = (Tag) new Tag(Tags.INPUT, true).id("password").type("password").placeholder("请输入密码");
		password.text("密码:", Tags.FRONT);
		Tag loginbtn = (Tag) new Tag(Tags.A).id("loginBtn");
		loginbtn.text("登录");
		divtop.insert(username);
		divctn.insert(password);
		divbtm.insert(loginbtn);
		div.insert(divtop, divctn, divbtm);
		body.insert(div);

		String build = html.build();

		// 格式化输出
		System.out.println(JsoupUtil.format(build));

		return build;

	}

}
