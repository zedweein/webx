package javax.webx.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Script{
	
	private StringBuffer buffer;

	/**
	 * 加载一个本地样式表
	 * @param jsFile 层叠样式表文件路径
	 */
	public Script(String jsFile) {
		buffer = new StringBuffer();
		script(jsFile);
	}

	public Script() {
		buffer = new StringBuffer();
	}

	/**
	 * 添加js方法
	 * @param js
	 * @return
	 */
	public Script with(String js) {
		buffer.append(js);
		return this;
	}

	/**
	 * 解析一个js文件
	 * @param jsFile
	 */
	public void script(String jsFile) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(jsFile)));
			String str = "";
			while ((str = br.readLine()) != null) {
				buffer.append(str);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void print() {
		System.out.println(buffer.toString());
	}

	public String scripts() {
		return buffer.toString();
	}

}
