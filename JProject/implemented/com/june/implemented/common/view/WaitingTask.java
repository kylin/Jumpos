package com.june.implemented.common.view;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.commons.beanutils.BeanUtils;

import com.june.implemented.model.action.OpenAssignAction;
import com.june.implemented.model.output.WaitingTask_PageOutput;

@ManagedBean(name = "waitingTask")
@RequestScoped
public class WaitingTask{

    private WaitingTask_PageOutput pageOutput = new WaitingTask_PageOutput();

    private OpenAssignAction openAssignAction = new OpenAssignAction();

//    @PostConstruct
//    public void getPageOutputData() {
//        try {
//            openAssignAction.getProcess().getPageOutputForPendingWork(pageOutput);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    // ======== Getter/Setter ========

    public WaitingTask_PageOutput getPageOutput() throws Exception {

        // BY yhhe 由于需要通过推送方式让客户端刷新待办工作列表，因此在此getter里查询
    	
//        openAssignAction.getProcess().getPageOutputForPendingWork(pageOutput);
    	String workclass = openAssignAction.getProcess().getUser().getWorkclass();
		String username = openAssignAction.getProcess().getUser().getUsername();
		String usergroup = openAssignAction.getProcess().getUser().getUsergroup();
		String location = openAssignAction.getProcess().getUser().getLocation();
		String linkage = openAssignAction.getProcess().getUser().getLinkage();
    	List pendingWork = openAssignAction.getProcess().getActiveWorkObject().getPendingWork(workclass, username, usergroup, location, linkage);
        
        BeanUtils.setProperty(pageOutput, "pendingWork", pendingWork);
        return pageOutput;
    }

    public OpenAssignAction getOpenAssignAction() {
        return openAssignAction;
    }



}
