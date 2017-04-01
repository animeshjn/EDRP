package beans;

public class Book_fine_pojo {
	int accno,fine;
	String title,idate,ddate,rdate,status;
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public int getFine() {
		return fine;
	}
	public void setFine(int fine) {
		this.fine = fine;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIdate() {
		return idate;
	}
	public void setIdate(String idate) {
		this.idate = idate;
	}
	public String getDdate() {
		return ddate;
	}
	public void setDdate(String ddate) {
		this.ddate = ddate;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Title= "+ title+"   Fine= " + fine+ "    status= " + status;
	}
	public Book_fine_pojo(int accno, int fine, String title, String idate,
			String ddate, String rdate, String status) {
		super();
		this.accno = accno;
		this.fine = fine;
		this.title = title;
		this.idate = idate;
		this.ddate = ddate;
		this.rdate = rdate;
		this.status = status;
	}
	

}
