package application;

import java.io.Serializable;

public class Document
{
		private String Id;
		private String title;
		private String subject;
		private String Subcontent;
		public Document(String Id, String title,String subject, String Subcontent)
		{
			this.Id = new String(Id);
			this.title = new String(title);
			this.subject = new String(subject);
			this.Subcontent = new String(Subcontent);
		}
		public String getId() {
			return Id;
		}
		public void setId(String Id) {
			this.Id = Id;
		}
		public String gettitle() {
			return title;
		}
		public void settitle(String title) {
			this.title = title;
		}
		public String getsubject() {
			return subject;
		}
		public void setsubject(String subject) {
			this.subject = subject;
		}
		public String getSubcontent() {
			return Subcontent;
		}
		public void setSubcontent(String Subcontent) {
			this.Subcontent = Subcontent;
		}

	}



