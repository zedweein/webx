# webx
偏后端程序员直接将Web(Html/JavaScript/StyleSheet)绘制在Java端

## 用法

1.新建xxPage类,直接写java代码方法一样</br>

public class LoginPage {

	public String index() {

		Style css = new Style();
		Script js = new Script();
		// 自定义样式加入到Style对象
		css.with("body,html{width:100%;height:100%;margin:0;padding:0;background:#eee;display: flex;align-items: center;justify-content: center;}");</br>
		css.with("#loginPanel{width: 350px;height: 200px;border: 1px solid #000;border-radius: 5px;position: relative;top: -80px;padding: 20px;}");</br>
		css.with(".topctn{width:100%;height:40%;display: flex;align-items: center;justify-content: center;}.btm{width:100%;height:20%;display: flex;align-items: center;justify-content: center;}");</br>
		css.with("#username,#password{height:30px;width:65%;margin-left:10px;border-radius: 5px;outline: none;border: 1px solid #c1c1c1;padding: 0px 5px;}");</br>
		css.with("#loginBtn{display:inline-block;background:green;color:#fff;border-radius:3px;padding:5px 10px;}");</br>
		
		//自定义脚本加入到script对象</br>
		js.with("window.onload=function(){alert('welcome login');}");</br>
		
		Tag html = new Tag(Tags.HTML);</br>
		Tag body = new Tag(Tags.BODY);</br>
		Tag head = new Tag(Tags.HEAD);</br>
		Tag style = new Tag(Tags.STYLE).text(css.styles());</br>
		Tag script = new Tag(Tags.SCRIPT).text(js.scripts());</br>

		head.insert(style);</br>
		head.insert(script);</br>
		body.insert(head);</br>
		html.insert(body);</br>

		Tag div = (Tag) new Tag(Tags.DIV).id("loginPanel");</br>
		Tag divtop = new Tag(Tags.DIV);</br>
		Tag divctn = new Tag(Tags.DIV);</br>
		Tag divbtm = new Tag(Tags.DIV);</br>
		divtop.with(divctn).clazz("topctn");</br>
		divbtm.clazz("btm");</br>
		Tag username = (Tag) new Tag(Tags.INPUT, true).id("username").type("text").placeholder("请输入用户名");</br>
		username.text("用户:", Tags.FRONT);</br>
		Tag password = (Tag) new Tag(Tags.INPUT, true).id("password").type("password").placeholder("请输入密码");</br>
		password.text("密码:", Tags.FRONT);</br>
		Tag loginbtn = (Tag) new Tag(Tags.A).id("loginBtn");</br>
		loginbtn.text("登录");</br>
		divtop.insert(username);</br>
		divctn.insert(password);</br>
		divbtm.insert(loginbtn);</br>
		div.insert(divtop, divctn, divbtm);</br>
		body.insert(div);</br>

		String build = html.build();</br>

		// 格式化输出</br>
		System.out.println(JsoupUtil.format(build));</br>

		return build;</br>

	}</br>

}</br>

2.在Controller直接return String类型的Model即可</br>

  @RequestMapping("/auth/login")</br></br>
	public String login() {</br>
		return new LoginPage().index();</br>
	}</br>

