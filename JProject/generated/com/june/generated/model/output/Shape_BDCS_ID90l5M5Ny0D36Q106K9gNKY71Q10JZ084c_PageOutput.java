
/**
 * 	FileName   : Shape_BDCS_ID90l5M5Ny0D36Q106K9gNKY71Q10JZ084c_PageOutput
 * 	Package    : com.june.generated.model.output
 *	Create Time: 2016-5-25 8:42:41
 *	Usage	   : Decision的output部分 
 *	Purpose	   : null 
 *	Note	   :
 *  taskName   : 是否通过审核
 *
 */
package com.june.generated.model.output;

import com.june.common.model.output.AbstractPageOutput;
import com.june.implemented.common.application.BDCSWorkData;
import com.june.implemented.common.function.*;
import java.util.*;

public class Shape_BDCS_ID90l5M5Ny0D36Q106K9gNKY71Q10JZ084c_PageOutput extends AbstractPageOutput {

	private String shifoutongguoshenhe51727;
	
	public String getShifoutongguoshenhe51727() {
		return shifoutongguoshenhe51727;
	}
	
	public void setShifoutongguoshenhe51727(String shifoutongguoshenhe51727) {
		this.shifoutongguoshenhe51727 = shifoutongguoshenhe51727;
	}
	private String fou1574;
	
	public String getFou1574() {
		return fou1574;
	}
	
	public void setFou1574(String fou1574) {
		this.fou1574 = fou1574;
	}
	private String shi6191;
	
	public String getShi6191() {
		return shi6191;
	}
	
	public void setShi6191(String shi6191) {
		this.shi6191 = shi6191;
	}
	public Shape_BDCS_ID90l5M5Ny0D36Q106K9gNKY71Q10JZ084c_PageOutput() {
		super();
        this.LoadInitData();
	}
	
	private void LoadInitData(){	
	
	

	}

	public void getDataFromProcess() {
		BDCSWorkData workData = (BDCSWorkData) process.getActiveWorkObject().getWorkDataInstance();
		setShifoutongguoshenhe51727(workData.getShifoutongguoshenhe51727());
		setFou1574(workData.getFou1574());
		setShi6191(workData.getShi6191());
		
	}

}