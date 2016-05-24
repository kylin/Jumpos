package com.june.implemented.model.data;

import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.june.implemented.common.util.ServerListener;

public class XmlOperate {
	// 保存用户登录的记录信息
	public static void saveLoginRecoder(LoginRecoderEntity recordInfo)
			throws Exception {
		ServletContext servletContext = ServerListener.getServletContext();
		String path = servletContext.getRealPath("/")
				+ "\\XML\\loginRecord.xml";
		File file = new File(path);
		if (file.exists()) {
			try {
				SAXReader saxReader = new SAXReader();
				Document document = saxReader.read(file);
				// 获取根节点
				Element rootResult = document.getRootElement();
				List valuePoints = rootResult.selectNodes("//value");
				// 第一个用户登录
				if (valuePoints.isEmpty()) {
					Element value = rootResult.addElement("value");
					Element recordId = value.addElement("recordId");
					recordId.setText("1");
					Element onlineTime = value.addElement("onlineTime");
					onlineTime.setText(recordInfo.getOnlineTime());
					Element userId = value.addElement("userId");
					userId.setText(recordInfo.getUserId());
				} else {
					List recordIdPoints = document.selectNodes("//recordId");
					// 记录当前最大数
					// int maxRecordId = 1;
					// for (Object o : recordIdPoints) {
					// Element recordIdElement = (Element) o;
					// if (Integer.valueOf(recordIdElement.getText())
					// .intValue() > maxRecordId)
					// maxRecordId = Integer.valueOf(recordIdElement
					// .getText());
					// }
					int maxRecordId = Integer
							.valueOf(
									((Element) recordIdPoints
											.get(recordIdPoints.size() - 1))
											.getText()).intValue();

					Element value = rootResult.addElement("value");
					Element recordId = value.addElement("recordId");
					recordId.setText(String.valueOf(maxRecordId + 1));
					Element onlineTime = value.addElement("onlineTime");
					onlineTime.setText(recordInfo.getOnlineTime());
					value.addElement("offlineTime");
					Element userId = value.addElement("userId");
					userId.setText(recordInfo.getUserId());
				}

				OutputFormat format = OutputFormat.createPrettyPrint();
				format.setEncoding("GBK");
				XMLWriter writer = new XMLWriter(new FileWriter(path), format);
				writer.write(document);
				writer.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("xml文件不存在！");
		}
	}

	// 获取用户上次访问时间
	public static String getLastAccessTime(String userId) {
		String lastAccessTime = null;
		ServletContext servletContext = ServerListener.getServletContext();
		String path = servletContext.getRealPath("/")
				+ "\\XML\\loginRecord.xml";
		File file = new File(path);
		if (file.exists()) {
			try {
				SAXReader saxReader = new SAXReader();
				Document document = saxReader.read(file);
				List userIdPoints = document.selectNodes("//userId");
				// 用户是否是第一次登录
				if (userIdPoints.isEmpty()) {
					lastAccessTime = "";
				} else {
					lastAccessTime = "";
					int maxRecordId = 0;// 记录匹配用户record
					Element root = document.getRootElement();
					Iterator iterator = root.elementIterator();
					while (iterator.hasNext()) {
						Element value = (Element) iterator.next();
						if (value.element("userId").getText().equals(userId)) {
							// 记录recordId
							int record = Integer.valueOf(
									value.element("recordId").getText())
									.intValue();
							if (record > maxRecordId) {
								lastAccessTime = value.element("onlineTime")
										.getText();
								maxRecordId = record;
							}
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("xml文件不存在！");
		}

		return lastAccessTime;
	}
}