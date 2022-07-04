package com.study.jdbc.entity;

public class Notice {
		private String id;
		private String pwd;
		private String name;
		private int uniquenumber;
		
		public Notice() {
			
		}

		public Notice(String id, String pwd, String name, int uniquenumber) {
			this.id = id;
			this.pwd = pwd;
			this.name = name;
			this.uniquenumber = uniquenumber;
		}




		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getPwd() {
			return pwd;
		}
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getUniquenumber() {
			return uniquenumber;
		}
		public void setUniquenumber(int uniquenumber) {
			this.uniquenumber = uniquenumber;
		}
}
