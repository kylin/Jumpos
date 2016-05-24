package com.june.implemented.common.function;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "activityCount")
public class ActivityCount implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="activityCountseq")
    @SequenceGenerator(name="activityCountseq",sequenceName="activityCountseq",allocationSize=1) 
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    
    long flowId;  //流程id
    String nodeid;//activity节点id
    int count;  //计数
    
    // ---------------- Getters/Setters ----------------
    

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getFlowId() {
		return flowId;
	}

	public void setFlowId(long flowId) {
		this.flowId = flowId;
	}

	public String getNodeid() {
		return nodeid;
	}

	public void setNodeid(String nodeid) {
		this.nodeid = nodeid;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}


}