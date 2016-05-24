/**
 * 		BDCS
 */
package com.june.implemented.common.application;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import com.june.common.api.AbstractWorkFlow;
import com.june.common.model.WorkFlow;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class BDCS extends AbstractWorkFlow implements WorkFlow {

 private static final long serialVersionUID = 2935649750128384966L;

    public BDCS() {
    	this.flowName = "BDCS";
    	this.flowNameCN = "BDCS";
    }
    
    public String getName() {
        return this.getClass().getName();
    }

}