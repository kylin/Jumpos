
/**
 * 	FileName   : Geguanggao5875
 * 	Package    : com.june.implemented.common.function
 *	Create Time: 2015-2-2 18:15:11
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
@Table(name = "renyuanleibie")
public class Renyuanleibie {
	@Id
	@GeneratedValue
	private long id;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	private String xuhao; //序号
	private String xingming; //姓名
	private String nianling; //年龄
	private String zhuzhi; //住址

	public String getXuhao() {
		return xuhao;
	}
	public void setXuhao(String xuhao) {
		this.xuhao = xuhao;
	}
	public String getXingming() {
		return xingming;
	}
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	public String getNianling() {
		return nianling;
	}
	public void setNianling(String nianling) {
		this.nianling = nianling;
	}
	public String getZhuzhi() {
		return zhuzhi;
	}
	public void setZhuzhi(String zhuzhi) {
		this.zhuzhi = zhuzhi;
	}
	
	
}