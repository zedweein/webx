package javax.webx.tags;

import java.util.LinkedList;
import java.util.List;

import javax.webx.common.Attrs;

import org.apache.commons.lang3.StringUtils;

public class Tag extends Attrs{

	private Tag parentNode;
	public List<Tag> childNode;
	private boolean self;
	private String tagName;
	private String text;
	private int position;

	/**
	 * @param name 标签名称
	 * @param self 是否自关闭
	 */
	public Tag(String tagName, boolean self) {
		this.tagName = tagName;
		this.self = self;
		this.childNode = new LinkedList<Tag>();
	}

	/**
	 * @param name 标签名称
	 */
	public Tag(String tagName) {
		this.tagName = tagName;
		this.self = false;
		this.childNode = new LinkedList<Tag>();
	}

	/**
	 * 将元素插入当前元素内部
	 * @param tags
	 * @return
	 */
	public Tag insert(Tag... tags) {
		if (tags.length > 0) {
			for (Tag _tag : tags) {
				_tag.setParentNode(this);
				this.childNode.add(_tag);
			}
		}
		return this;
	}
	
	/**
	 * 在当前元素内部插入文本
	 * @param text 
	 * @param position Tags.FRONT Tags.AFTER
	 * @return
	 */
	public Tag text(String text, int position) {
		this.text = text;
		this.position = position;
		return this;
	}
	
	/**
	 * 在当前元素内部插入文本
	 * @param text 
	 * @param position Tags.FRONT Tags.AFTER
	 * @return
	 */
	public Tag text(String text) {
		this.text = text;
		this.position = Tags.FRONT;
		return this;
	}

	/**
	 * 将构建的元素整合组装
	 * @return
	 */
	public String build() {
		String content = "";
		content = cascade(this, content);
		return content;
	}
	
	public Tags with(Tag tag) {
		Tags tags = new Tags();
		tags.add(this);
		tags.add(tag);
		return tags;
	}

	private String cascade(Tag tag, String content) {
		if (tag != null) {
			String tagName = tag.getTagName();
			String asseme = tag.assemble();
			// 自关闭标签
			if (tag.self) {
				if(tag.position == Tags.FRONT) {
					if(StringUtils.isNotEmpty(tag.text)) {
						content += tag.text;
					}
				}
				content += "<" + tagName + asseme + "/>";
				if(tag.position == Tags.AFTER) {
					if(StringUtils.isNotEmpty(tag.text)) {
						content += tag.text;
					}
				}
			}
			// 非自关闭标签
			else {
				if(StringUtils.equals(tagName, Tags.HTML)) {
					content = "<!DOCTYPE html><" + tagName;
				}else {
					content += "<" + tagName;
				}
				if(StringUtils.isNotEmpty(asseme)) {
					content += asseme;
				}
				content += ">";
				if(tag.position == Tags.FRONT) {
					if(StringUtils.isNotEmpty(tag.text)) {
						content += tag.text;
					}
				}
				if (tag.childNode.size() > 0) {
					for (Tag _tag : tag.childNode) {
						content = cascade(_tag, content);
					}
				}
				if(tag.position == Tags.AFTER) {
					if(StringUtils.isNotEmpty(tag.text)) {
						content += tag.text;
					}
				}
				content += "</" + tagName + ">";
			}
		}
		return content;
	}

	public Tag getParentNode() {
		return parentNode;
	}

	public void setParentNode(Tag parentNode) {
		this.parentNode = parentNode;
	}

	public boolean isSelf() {
		return self;
	}

	public Tag setSelf(boolean self) {
		this.self = self;
		return this;
	}

	public String getTagName() {
		return tagName;
	}

	public Tag setTagName(String tagName) {
		this.tagName = tagName;
		return this;
	}
}
