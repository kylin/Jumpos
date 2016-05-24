package com.june.implemented.common.function;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "userEntity")
public class UserEntity implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="userEntityseq")
    @SequenceGenerator(name="userEntityseq",sequenceName="userEntity_seq",allocationSize=1) 
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    
    String userId;  
    String userName;  //用户名（用户登录�?
    String userPassword; //用户密码（用户登录）
    String userHigher; //用户上级
    
    String location;
    String userGroup; //用户组（企业�?   管理人员组）
    String linkage; 
    String note; //备注
    
    // ---------------- Getters/Setters ----------------

    public String getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

	public String getUserHigher() {
		return userHigher;
	}

	public void setUserHigher(String userHigher) {
		this.userHigher = userHigher;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLinkage() {
		return linkage;
	}

	public void setLinkage(String linkage) {
		this.linkage = linkage;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}