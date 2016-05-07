package com.june.implemented.common.application;


import com.june.common.api.AbstractWorkData;


public class Admin1WorkData extends AbstractWorkData {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private String yonghuxinxi20399;
		
		public String getYonghuxinxi20399() {
			return yonghuxinxi20399;
		}

		public void setYonghuxinxi20399(String yonghuxinxi20399) {
			if(yonghuxinxi20399 != null)
			this.yonghuxinxi20399 = yonghuxinxi20399.trim();
		}		
		



		private String yonghuming16748;
		
		public String getYonghuming16748() {
			return yonghuming16748;
		}

		public void setYonghuming16748(String yonghuming16748) {
			if(yonghuming16748 != null)
			this.yonghuming16748 = yonghuming16748.trim();
		}		
	
	public String toString() {
		return "Admin1WorkData ["+
				"yonghuxinxi20399="+yonghuxinxi20399+
				"yonghuming16748="+yonghuming16748+				"]";
	}
}