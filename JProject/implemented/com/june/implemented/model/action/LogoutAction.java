package com.june.implemented.model.action;

import javax.el.ELContext;
import javax.faces.context.FacesContext;

import com.june.common.model.action.AbstractAction;
import com.june.implemented.common.authentication.User;

// @ManagedBean(name="loginAction")
public class LogoutAction extends AbstractAction {

    // @ManagedProperty(value = "#{user}")
    User user;

    public LogoutAction() {
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        user = (User) elContext.getELResolver().getValue(elContext, null, "user");
    }

    public String perform() {
        user.setUsername(null);
        user.setUsergroup(null);
        return "/index.html";
    }
}
