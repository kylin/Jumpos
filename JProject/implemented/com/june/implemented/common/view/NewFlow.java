package com.june.implemented.common.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.commons.beanutils.BeanUtils;

import com.june.common.view.AbstractManagedBean;
import com.june.implemented.model.action.NewFlowAction;
import com.june.implemented.model.action.*;
import com.june.implemented.model.action.OpenAssignAction;
import com.june.implemented.model.action.PushWorkAction;
import com.june.implemented.model.output.NewFlow_PageOutput;

@ManagedBean(name = "newFlow")
@RequestScoped
public class NewFlow extends AbstractManagedBean {

    private NewFlow_PageOutput pageOutput = new NewFlow_PageOutput();

    private NewFlowAction newFlowAction = new NewFlowAction();

    private PushWorkAction pushWorkAction = new PushWorkAction();

    private OpenAssignAction openAssignAction = new OpenAssignAction();
    
    
	private NewWorkAction0 newWorkAction0 = new NewWorkAction0();
    
    
    @PostConstruct
    public void getPageOutputData() {
        try {
//            openAssignAction.getProcess().getPageOutputForPendingWork(pageOutput);
            String workclass = openAssignAction.getProcess().getUser().getWorkclass();
    		String username = openAssignAction.getProcess().getUser().getUsername();
    		String usergroup = openAssignAction.getProcess().getUser().getUsergroup();
    		String linkage = openAssignAction.getProcess().getUser().getLinkage();
    		String location = openAssignAction.getProcess().getUser().getLocation();
        	List pendingWork = openAssignAction.getProcess().getActiveWorkObject().getPendingWork(workclass, username,usergroup, location, linkage);
            BeanUtils.setProperty(pageOutput, "pendingWork", pendingWork);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ======== Getter/Setter ========
    

	public NewFlow_PageOutput getPageOutput() {
        return pageOutput;
    }

	public NewFlowAction getNewFlowAction() {
        return newFlowAction;
    }
    

	public PushWorkAction getPushWorkAction() {
        return pushWorkAction;
    }

    public OpenAssignAction getOpenAssignAction() {
        return openAssignAction;
    }

    public NewWorkAction0 getNewWorkAction0() {
		return newWorkAction0;
	}

	public void setNewWorkAction0(NewWorkAction0 newWorkAction0) {
		this.newWorkAction0 = newWorkAction0;
	}

}
