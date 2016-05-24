
/**
 * 	FileName   : Baoxiaoxixiang55012
 * 	Package    : com.june.implemented.common.function
 *	Create Time: 2016-5-24 9:41:12
 *	Usage	   : 列表对应的数据库表 
 *	Note	   :
 *
 */
package com.june.implemented.common.function;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "baoxiaoxixiang55012")
public class Baoxiaoxixiang55012 {
	@Id
	@GeneratedValue
	private long id;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	private String baoxiaojine59923;
	
	public void setBaoxiaojine59923(String baoxiaojine59923){
		this.baoxiaojine59923 = baoxiaojine59923;
	}
	
	public String getBaoxiaojine59923(){
		return baoxiaojine59923;
	}
	private String riqi12548;
	
	public void setRiqi12548(String riqi12548){
		this.riqi12548 = riqi12548;
	}
	
	public String getRiqi12548(){
		return riqi12548;
	}
	private String feiyongmingcheng39006;
	
	public void setFeiyongmingcheng39006(String feiyongmingcheng39006){
		this.feiyongmingcheng39006 = feiyongmingcheng39006;
	}
	
	public String getFeiyongmingcheng39006(){
		return feiyongmingcheng39006;
	}
	
}