package com.june.implemented.model.output;

import javax.faces.model.SelectItem;

import com.june.common.model.output.AbstractPageOutput;

public class Login_PageOutput extends AbstractPageOutput {
    private SelectItem[] userSelectItems = null;
    private SelectItem[] userGroupSelectItems = null;
    private SelectItem[] userPasswordSelectItems = null;

    public SelectItem[] getUserPasswordSelectItems() {
		return userPasswordSelectItems;
	}

	public void setUserPasswordSelectItems(SelectItem[] userPasswordSelectItems) {
		this.userPasswordSelectItems = userPasswordSelectItems;
	}

	public SelectItem[] getUserSelectItems() {
		return userSelectItems;
	}

	public void setUserSelectItems(SelectItem[] userSelectItems) {
		this.userSelectItems = userSelectItems;
	}

	public Login_PageOutput() {
		super();
        this.LoadInitData();
	}
	
	private void LoadInitData(){
	    SelectItem[] userlist = null;
		userlist = new SelectItem[2];
		userlist[0] = new SelectItem("王刚");
		userlist[1] = new SelectItem("李宏");
		this.userSelectItems = userlist;
		
	    SelectItem[] userGrouplist = null;
	    userGrouplist = new SelectItem[2];
	    userGrouplist[0] = new SelectItem("企业");
	    userGrouplist[1] = new SelectItem("平台");
		this.userGroupSelectItems = userGrouplist;
		
		SelectItem[] userPasswordlist = null;
		userPasswordlist = new SelectItem[2];
		userPasswordlist[0] = new SelectItem("admin");
		userPasswordlist[1] = new SelectItem("admin");
		this.userPasswordSelectItems = userPasswordlist;
		
	}

	public void setUserGroupSelectItems(SelectItem[] userGroupSelectItems) {
		this.userGroupSelectItems = userGroupSelectItems;
	}

	public SelectItem[] getUserGroupSelectItems() {
		return userGroupSelectItems;
	}
	
	
}
