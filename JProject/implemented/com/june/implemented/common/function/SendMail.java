package com.june.implemented.common.function;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.util.*;
import javax.activation.*;


public class SendMail {
	private static String host = "smtp.qiye.163.com";
	private static String from = "is@juneintelligence.com.cn";
	private static String username = "is@juneintelligence.com.cn";
	private static String password = "intelligence2012";
	private List<String> cc=new ArrayList<String>();
	public List<String> getCc() {
		return cc;
	}

	public void setCc(List<String> cc) {
		this.cc = cc;
	}

	private String subject;
	

	private String content;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	private String attachmentPath;
	private String attachmentName;

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static void setFrom(String from) {
		SendMail.from = from;
	}

	public static String getFrom() {
		return from;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getAttachmentPath() {
		return attachmentPath;
	}

	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}

	public String getAttachmentName() {
		return attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	public void doSendTo(String to) {

		// 发送者的邮箱用户名
		System.out.println("to:"+to);
		String user = username;
		// 发送者的邮箱密码
		String ps = password;
		Properties props = System.getProperties();
		// 设置发送邮件的邮件服务器的属性（这里使用新浪的smtp服务器）
		props.put("mail.smtp.host", host);
		// 需要经过授权，也就是有户名和密码的校验，这样才能通过验证（一定要有 // 这一条）
		props.put("mail.smtp.auth", "true");
		// 用刚刚设置好的props对象构建一个session
		if(host.indexOf("smtp.gmail.com") >= 0)	//gmail需要设置的参数
        {
			props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
			props.setProperty("mail.smtp.socketFactory.fallback", "false"); 
			props.setProperty("mail.smtp.port", "465"); 
			props.setProperty("mail.smtp.socketFactory.port", "465"); 
        }

		Session session = Session.getDefaultInstance(props);
//		Session session = Session.getInstance(props);

		// 有了这句便可以在发送邮件的过程中在console处显示过程信息，供调试使

		// 用（有的时候网络连通性不够好，发送邮件可能会有延迟，在这里面会有所 // 提示，所以最好是加上这句，避免盲目的等待）

		session.setDebug(true);
		// 定义消息对象
		MimeMessage message = new MimeMessage(session);

		try {
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			if(subject == null || subject.trim().equals("")){
				message.setSubject("来自："+message.getFrom()+"的邮件！");
			}
			else
			message.setSubject(subject);
			// 向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
			MimeMultipart multipart = new MimeMultipart();
			// 设置邮件的文本内容
			MimeBodyPart contentPart = new MimeBodyPart();	
			if(content == null && content.trim().equals("")){
				message.setContent(null);
			}
			contentPart.setDataHandler(new DataHandler(content,"text/html;charset=GB2312"));
//			contentPart.setText(content, "GB2312", "html");
			//
			// contentPart.setContent(content, "text/html;charset=GB2312");
			multipart.addBodyPart(contentPart);
			// 添加附件
			if (!(attachmentPath == null || attachmentPath.equals(""))) {
				MimeBodyPart attachmentPart = new MimeBodyPart();
				FileDataSource source = new FileDataSource(attachmentPath);
				attachmentPart.setDataHandler(new DataHandler(source));
				// 注意：下面定义的enc对象用来处理中文附件名，否则名称是中文的附 // 件在邮箱里面显示的会是乱码
				// sun.misc.BASE64Encoder enc = new sun.misc.BASE64Encoder();
				// //需要重新加载jre的包
				attachmentPart.setFileName(MimeUtility.encodeWord(attachmentName, "GB2312", null));
				// attachmentPart.setFileName("=?GBK?B?"+enc.encode(attachmentName.getBytes())+"?=");
				multipart.addBodyPart(attachmentPart);
			}
			// 将multipart对象放到message中

			message.setContent(multipart);
			// 发送邮件
			for(String c:cc){
			message.addRecipients(Message.RecipientType.CC, c);
			}
			message.saveChanges();
			Transport transport = session.getTransport("smtp");
			transport.connect(host, username, password);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sendtoLDHT(final String subject,final String content){
		
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				host="smtp.gmail.com";
				from = "js.qiyeplatform@gmail.com";
				username = "js.qiyeplatform@gmail.com";
				password = "qiyeplatform";
				setSubject(subject);
				setContent(content);
				doSendTo("kwang@juneintelligence.cn");
			}
		});
		thread.start();
	}
	
	
	public void sendtoFWDJ(final String subject,final String content){
		
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				host="smtp.gmail.com";
				from = "js.qiyeplatform@gmail.com";
				username = "js.qiyeplatform@gmail.com";
				password = "qiyeplatform";
				setSubject(subject);
				setContent(content);
				doSendTo("kwang@juneintelligence.cn");
			}
		});
		thread.start();
	}
	
	public void sendtest(final String subject,final String content){
		host="smtp.ym.163.com";
		from = "kwang@juneintelligence.cn";
		username = "kwang@juneintelligence.cn";
		password = "admin123";
		setSubject(subject);
		setContent(content);
		doSendTo("kwang@juneintelligence.com.cn");
	}
	
	public static void main(String[] args) {
		new SendMail().sendtoLDHT("Test11", "里面的内容是内容");
		
//		host="smtp.ym.163.com";
//		from = "kwang@juneintelligence.cn";
//		username = "kwang@juneintelligence.cn";
//		password = "wk6963665";
////		host="smtp.163.com";
////		from = "dogrex@163.com";
////		username = "dogrex@163.com";
////		password = "wf1990517";
//		String path = "E:\\考勤表.xls";
//		//System.out.println("path:" + path);
//		SendMail sm = new SendMail();
//		//设置主题
//		sm.setSubject("测试");
//		//设置内容
//		sm.setContent("测试内容");
//		//抄送
////		sm.getCc().add("dogrex@163.com");
////		sm.getCc().add("evgn_rex@163.com");
//		//设置附件路径
//		sm.setAttachmentPath(path);
//		//设置附件名，注意文件格式
//		sm.setAttachmentName("考勤表.xls");
//		sm.doSendTo("vswk001@gmail.com");

	}

}
