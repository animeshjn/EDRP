package beans;

public class BookData {
	
	String author, publisher, edition,title;
	char available;
	int accno;
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String toString(){
		
		
		return "Acc No: "+accno+"\nEdition: "+edition+"\nStatus: "+getAvailable();
		
		
	}
	public String getAvailable() {
		
		String res;
		
		if(available=='A'){
			
			res = "Available";
			
		}
		
		else if(available=='N'){
			
			res = "Not Available";
			
		}
		
		else {
			
			res = "Reference";
			
		}
		return res;
	}
	public void setAvailable(char available) {
		this.available = available;
	}
	public int getAccno() {
		return accno;
	}
	public void setAccno(int accno) {
		this.accno = accno;
	}
	public BookData(String author, String publisher, String edition,
			String title, char available, int accno) {
		super();
		this.author = author;
		this.publisher = publisher;
		this.edition = edition;
		this.title = title;
		this.available = available;
		this.accno = accno;
	}

}
