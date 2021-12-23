import java.util.Scanner;

public class FPTP {
	public static void main(String[] arg) {
		
		
		int numberOfParties,numberOfDistricts,numberOfRefunds = 0;
		int totalVotes;//This variable will hold the total votes in the district and will change in each district.
		int mostVotes;//This variable holds the largest amount of votes and will change in each district.
		int mostSeats;//This variable holds the party with the most seats.
		double refund;//This variable holds the 20% of the votes and will change in each district.
		@SuppressWarnings("resource")
		Scanner readln = new Scanner(System.in);
		DistrictsInfo districtsInfo = new DistrictsInfo();
		
			
		
		//This part of the program tells the user what the program will do.
		System.out.println("This program will ask you to enter the amount of districts and parties");
		System.out.println("then, ask you to name the parties and districts.");
		System.out.println("You will then be asked to enter the names of the candidates in the districts");
		System.out.println("and the amount of votes each of them got.");
		System.out.println("The program will then calculate if the candidate got 20% of more. if they did they");
		System.out.println("will receive a refund. It will also tell you which party won in that district.");
		System.out.println("At the end of the program it will show you how many candidates got a refund and ");
		System.out.println("which party got the most seats.");
		readln.nextLine();
		
		
		    
		//This part of the program ask the user for the date.
		System.out.printf("Please enter the number of Parties : ");
		numberOfParties = readln.nextInt();
		System.out.printf("Please enter the number of districts : ");
		numberOfDistricts = readln.nextInt();


		districtsInfo.districtsInfoArraySize(numberOfParties);
		
		for(int i = 0; i < numberOfParties; i++){
			System.out.printf("Please enter the name of party %d : ",i + 1);
			districtsInfo.setPartyName(i, readln.next());
		}
		for(int i = 0; i < numberOfDistricts; i++){
			System.out.printf("Enter the name of district %d : ",i + 1);
			districtsInfo.setDistrictsName(i, readln.next());
		}
		  
		for(int i = 0; i < numberOfDistricts; i++){
			totalVotes = 0;
		    mostVotes = 0;
		    for(int j = 0; j < numberOfParties; j++){
		    	System.out.printf("Please enter the Name of the Candidate representing %s in %s : ",districtsInfo.getPartyNames(j),districtsInfo.getDistrictsName(i));
		    	districtsInfo.setCandidateName(j, readln.next());
		        System.out.printf("Please enter the the number of votes %s received : ",districtsInfo.getCandidateName(j));
		        districtsInfo.setVotes(j, readln.nextInt());
		        if(districtsInfo.getVotes(j) > mostVotes){
		        	mostVotes = districtsInfo.getVotes(j);
		        }
		        totalVotes = totalVotes + districtsInfo.getVotes(j);
		    }
		    //This part of the program determines whether the candidate got a refund or not
		    //how many seat each party got and how many candidates got a refund.
		    refund = totalVotes * 0.2;
		    System.out.println(districtsInfo.getDistrictsName(i) + " Disrtict");
		    for(int j = 0; j < numberOfParties; j++) {
		    	if (districtsInfo.getVotes(j) >= refund){
		    		numberOfRefunds++;
			        System.out.println(districtsInfo.getPartyNames(j) + " : " + districtsInfo.getCandidateName(j) + " got " + districtsInfo.getVotes(j) + " votes : Refund Due");
			        if (districtsInfo.getVotes(j) == mostVotes){
			        	System.out.println(districtsInfo.getPartyNames(j) + " : " + districtsInfo.getCandidateName(j) + " Won in the " + districtsInfo.getDistrictsName(i) + " district.");
			        	districtsInfo.setNumberOfSeats(j,districtsInfo.getNumberOfSeats(j) + 1);
			        }
		    	}else {
		    		System.out.println(districtsInfo.getPartyNames(j) + " : " + districtsInfo.getCandidateName(j) + " got " + districtsInfo.getVotes(j) + " votes : No Refund");
		    	}
		    }
		}
		
		//This part of the program displays the number of candidates that received a refund,
	    //the number of seats each party got and who got the most seats.
	    mostSeats = 0;
	    System.out.println("Number of candiates that got a refund :" + numberOfRefunds);
	    for(int i = 0; i < numberOfParties; i++) {
	    	System.out.println(districtsInfo.getPartyNames(i) + " got " + districtsInfo.getNumberOfSeats(i) + " seats.");
	        if (districtsInfo.getNumberOfSeats(i) > mostSeats) {
	        	mostSeats = i;
	        }
	    }
	    System.out.println(districtsInfo.getPartyNames(mostSeats) + " got the most seats so they are the Winner!!!");
	    System.out.println("End of program");

	}
	
}

