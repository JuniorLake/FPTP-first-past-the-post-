
public class DistrictsInfo {
	private String districtsNames[];
	private String candidateNames[];//This variable holds the names of the candidates.
	private int votes[];//This variable holds the amount of votes each candidate gets.
	private String partyNames[];//This variable holds the names of the parties.
	private int numberOfSeats[];//This variable holds the amount of seats each party holds.
	
	public void districtsInfoArraySize(int numberOfParties) {
		this.districtsNames = new String[numberOfParties];
		this.candidateNames = new String[numberOfParties];
		this.votes = new int[numberOfParties];
		this.partyNames = new String[numberOfParties];
		this.numberOfSeats = new int[numberOfParties];
	}

	
	//Getter & Setter
	public String getDistrictsName(int index) {return this.districtsNames[index];}
	public void setDistrictsName(int index,String value) {this.districtsNames[index] = value;}
	
	public String getCandidateName(int index) {return this.candidateNames[index];}
	public void setCandidateName(int index,String value) {this.candidateNames[index] = value;}
	
	public int getVotes(int index) {return this.votes[index];}
	public void setVotes(int index,int value) {this.votes[index] = value;}
	
	public String getPartyNames(int index) {return this.partyNames[index];}
	public void setPartyName(int index,String value) {this.partyNames[index] = value;}
	
	public int getNumberOfSeats(int index) {return this.numberOfSeats[index];}
	public void setNumberOfSeats(int index,int value) {this.numberOfSeats[index] = value;}
}
