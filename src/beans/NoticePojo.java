package beans;


public class NoticePojo {
	
	String noticeDate,read;
	String subject,content,sender;
	int noticeID;

	public NoticePojo(String noticeDate, String subject, String content,
			String sender,String read,int noticeID) {
		super();
		this.noticeDate = noticeDate;
		this.subject = subject;
		this.content = content;
		this.sender = sender;
		this.read = read;
		this.noticeID = noticeID;
	}
	
	public String getNoticeDate() {
		return noticeDate;
	}
	public String getRead() {
		return read;
	}
	public int getNoticeID(){
		
		return noticeID;
	}
	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	
}
