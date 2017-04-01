package beans;

public class Accounts_pojo {
String recptno,recpttype,recptdate,amt;

@Override
public String toString() {
	return "Accounts_pojo [recptno=" + recptno + ", recpttype=" + recpttype
			+ ", recptdate=" + recptdate + ", amt=" + amt + "]";
}

public String getRecptno() {
	return recptno;
}

public void setRecptno(String recptno) {
	this.recptno = recptno;
}

public String getRecpttype() {
	return recpttype;
}

public void setRecpttype(String recpttype) {
	this.recpttype = recpttype;
}

public String getRecptdate() {
	return recptdate;
}

public void setRecptdate(String recptdate) {
	this.recptdate = recptdate;
}

public String getAmt() {
	return amt;
}

public void setAmt(String amt) {
	this.amt = amt;
}

public Accounts_pojo(String recptno, String recpttype, String recptdate,
		String amt) {
	super();
	this.recptno = recptno;
	this.recpttype = recpttype;
	this.recptdate = recptdate;
	this.amt = amt;
}
}
