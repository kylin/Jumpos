/**
 * 
 */
package com.june.implemented.common.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.june.implemented.model.action.LoginAction;
import com.june.implemented.model.output.Login_PageOutput;

@ManagedBean(name = "login")
@RequestScoped
public class Login {

    private Login_PageOutput pageOutput = new Login_PageOutput();

    private LoginAction loginAction = new LoginAction();

    // ======== Getter/Setter ========

    public Login_PageOutput getPageOutput() {
        return pageOutput;
    }

    public LoginAction getLoginAction() {
        return loginAction;
    }

}
