package javax.webx.common;

/**
 * 属性构造器
 * 
 * @author Awn
 *
 */
public class Attrs {

	protected String id = "";
	protected String clazz = "";
	protected String style = "";
	protected String title = "";
	protected String data = "";
	protected String rel = "";
	protected String href = "";
	protected String type = "";
	protected String httpEquiv = "";
	protected String content = "";
	protected String sizes = "";
	protected String src = "";
	protected String value = "";
	protected String placeholder = "";
	
	/**
	 * 元素id属性
	 * @param id
	 * @return
	 */
	public Attrs id(String id) {
		this.id = " id='" + id + "'";
		return this;
	}

	/**
	 * 样式类名
	 * @param clazz
	 * @return
	 */
	public Attrs clazz(String clazz) {
		this.clazz = " class='" + clazz + "'";
		return this;
	}

	/**
	 * 内联样式表
	 * @param style
	 * @return
	 */
	public Attrs style(String style) {
		this.style = " style='" + style + "'";
		return this;
	}

	/**
	 * 给标签一个自定义属性
	 * @param key 属性名
	 * @param value 属性值
	 * @return
	 */
	public Attrs data(String key, String value) {
		this.data = " " + key + "='" + value + "'";
		return this;
	}

	/**
	 * 标签tile属性
	 * @param value
	 * @return
	 */
	public Attrs title(String value) {
		this.title = " title='" + title + "'";
		return this;
	}

	/**
	 * 标签rel属性
	 * @param value
	 * @return
	 */
	public Attrs rel(String value) {
		this.rel = " rel='" + value + "'";
		return this;
	}

	/**
	 * 标签href属性
	 * @param value
	 * @return
	 */
	public Attrs href(String value) {
		this.href = " href='" + value + "'";
		return this;
	}

	/**
	 * 标签type属性
	 * @param value
	 * @return
	 */
	public Attrs type(String value) {
		this.type = " type='" + value + "'";
		return this;
	}

	public Attrs httpEquiv(String value) {
		this.httpEquiv = " http-equiv='" + value + "'";
		return this;
	}

	public Attrs content(String value) {
		this.content = " content='" + value + "'";
		return this;
	}

	public Attrs sizes(String value) {
		this.sizes = " sizes='" + value + "'";
		return this;
	}
	public Attrs src(String value) {
		this.src = " src='" + value + "'";
		return this;
	}
	public Attrs value(String value) {
		this.value = " value='" + value + "'";
		return this;
	}
	
	public Attrs placeholder(String placeholder) {
		this.placeholder = " placeholder='" + placeholder + "'";
		return this;
	}
	
	

	public String assemble() {
		String contents = "";
		if (id.length() > 0) {
			contents += id;
		}
		if (clazz.length() > 0) {
			contents += clazz;
		}
		if (style.length() > 0) {
			contents += style;
		}
		if (title.length() > 0) {
			contents += title;
		}
		if (data.length() > 0) {
			contents += data;
		}
		if (rel.length() > 0) {
			contents += rel;
		}
		if (href.length() > 0) {
			contents += href;
		}
		if (type.length() > 0) {
			contents += type;
		}
		if (httpEquiv.length() > 0) {
			contents += httpEquiv;
		}
		if (content.length() > 0) {
			contents += content;
		}
		if (sizes.length() > 0) {
			contents += sizes;
		}
		if (src.length() > 0) {
			contents += src;
		}
		if (value.length() > 0) {
			contents += value;
		}
		if (placeholder.length() > 0) {
			contents += placeholder;
		}
		
		return contents;
	}

	public String getId() {
		return handAttr(id);
	}

	public String getClazz() {
		return handAttr(clazz);
	}

	public String getStyle() {
		return handAttr(style);
	}

	public String getTitle() {
		return handAttr(title);
	}

	public String getData() {
		return handAttr(data);
	}

	public String getRel() {
		return handAttr(rel);
	}

	public String getHref() {
		return handAttr(href);
	}

	public String getType() {
		return handAttr(type);
	}

	public String getHttpEquiv() {
		return handAttr(httpEquiv);
	}

	public String getContent() {
		return handAttr(content);
	}

	public String getSizes() {
		return handAttr(sizes);
	}

	public String getSrc() {
		return handAttr(src);
	}
	
	public String getValue() {
		return handAttr(value);
	}
	
	public String getPlaceHolder() {
		return handAttr(placeholder);
	}
	
	private String handAttr(String value) {
		if(value.indexOf("=")!=-1 && value.split("=").length==2) {
			return value.split("=")[1].substring(1,value.split("=")[1].length()-1);
		}
		return "";
	}
}
