package com.june.implemented.common.application;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.Transient;

import com.june.implemented.model.data.*;
import com.june.common.api.AbstractWorkData;
import com.thoughtworks.xstream.XStream;

import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import org.hibernate.annotations.Cascade;
import com.june.implemented.common.function.*;
import java.util.ArrayList;
import com.june.implemented.common.authentication.*;

/**
*9
*/
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@Table(name = "flow_data_BDCS")
public class BDCSWorkData extends AbstractWorkData {
	
		



		private String fou1574;
		
		public String getFou1574() {
			return fou1574;
		}

		public void setFou1574(String fou1574) {
			if(fou1574 != null)
			this.fou1574 = fou1574.trim();
		}		
		

	@OneToMany
	@Cascade(value=org.hibernate.annotations.CascadeType.ALL)
	@JoinColumn(name="baoxiaoxixiang55012id")
	private List<Baoxiaoxixiang55012> baoxiaoxixiang55012;
	
	public List<Baoxiaoxixiang55012> getBaoxiaoxixiang55012() {
		if(baoxiaoxixiang55012 == null)
			baoxiaoxixiang55012 = new ArrayList<Baoxiaoxixiang55012>();
		return baoxiaoxixiang55012;
	}
	
	public void setBaoxiaoxixiang55012(List<Baoxiaoxixiang55012> baoxiaoxixiang55012) {
		this.baoxiaoxixiang55012 = baoxiaoxixiang55012;
	}	



		private String baoxiaojine59923;
		
		public String getBaoxiaojine59923() {
			return baoxiaojine59923;
		}

		public void setBaoxiaojine59923(String baoxiaojine59923) {
			if(baoxiaojine59923 != null)
			this.baoxiaojine59923 = baoxiaojine59923.trim();
		}		
		



		private String shi6191;
		
		public String getShi6191() {
			return shi6191;
		}

		public void setShi6191(String shi6191) {
			if(shi6191 != null)
			this.shi6191 = shi6191.trim();
		}		
		



		private String shifoutongguoshenhe51727;
		
		public String getShifoutongguoshenhe51727() {
			return shifoutongguoshenhe51727;
		}

		public void setShifoutongguoshenhe51727(String shifoutongguoshenhe51727) {
			if(shifoutongguoshenhe51727 != null)
			this.shifoutongguoshenhe51727 = shifoutongguoshenhe51727.trim();
		}		
		



		private String shenqingren26084;
		
		public String getShenqingren26084() {
			return shenqingren26084;
		}

		public void setShenqingren26084(String shenqingren26084) {
			if(shenqingren26084 != null)
			this.shenqingren26084 = shenqingren26084.trim();
		}		
		



		private String sqbbtgyy78335;
		
		public String getSqbbtgyy78335() {
			return sqbbtgyy78335;
		}

		public void setSqbbtgyy78335(String sqbbtgyy78335) {
			if(sqbbtgyy78335 != null)
			this.sqbbtgyy78335 = sqbbtgyy78335.trim();
		}		
		



		private String bumen35536;
		
		public String getBumen35536() {
			return bumen35536;
		}

		public void setBumen35536(String bumen35536) {
			if(bumen35536 != null)
			this.bumen35536 = bumen35536.trim();
		}		
		



		private String xiangmumingcheng42340;
		
		public String getXiangmumingcheng42340() {
			return xiangmumingcheng42340;
		}

		public void setXiangmumingcheng42340(String xiangmumingcheng42340) {
			if(xiangmumingcheng42340 != null)
			this.xiangmumingcheng42340 = xiangmumingcheng42340.trim();
		}		
	

	public void LoadInitData(){
		List<UserEntity> values = null;
		String strSql = "select userEntity from UserEntity userEntity";
		synchronized (WorkObjectImpl.em) {
			values = WorkObjectImpl.em.createQuery(strSql).getResultList();
		}
		if (!values.isEmpty()) {
			for(UserEntity ue:values){
			}
		}
	}

@Override
	public String toString() {
		return "BDCSWorkData ["+
				"fou1574="+fou1574+
				"baoxiaoxixiang55012="+baoxiaoxixiang55012+
				"baoxiaojine59923="+baoxiaojine59923+
				"shi6191="+shi6191+
				"shifoutongguoshenhe51727="+shifoutongguoshenhe51727+
				"shenqingren26084="+shenqingren26084+
				"sqbbtgyy78335="+sqbbtgyy78335+
				"bumen35536="+bumen35536+
				"xiangmumingcheng42340="+xiangmumingcheng42340+				"]";
	}
}