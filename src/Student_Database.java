import java.util.InputMismatchException;
import java.util.Scanner;

//LAB 3.1 - Student Database
//-------------------------------------------------
//Task:  Write a program that will recognize invalid inputs when the user requests information about students in a class.    
//-------------------------------------------------
//What will the application do?
//Provide information about students in a class of at least 10 people
//Prompt the user to ask about a particular student 
//Give proper responses according to user-submitted information 
//Ask if the user would like to learn about another student
//Validate user choices and ask again if they provide an invalid number or information type.
//-------------------------------------------------
//Build Specifications
//Account for invalid user input with exceptions 
//Try to incorporate IndexOutOfBoundsException
//-------------------------------------------------
//Hints:
//Make it easy for the user – tell them what information is available
//Use parallel arrays to hold the student data
//-------------------------------------------------
//Extended Challenges:
//Create other exceptions and catch those too!
//-------------------------------------------------
//Console Preview: 
//Welcome to our Java class.  Which student would you like to learn more about? (enter a number 1-10): 100
//That student does not exist.  Please try again. (enter a number 1-10): 10
//Student 10 is Kim Driscoll.  What would you like to know about Kim? (enter or “hometown” or “favorite food”): age
//That data does not exist.  Please try again. (enter or “hometown” or “favorite food”): hometown
//Kim is from Detroit, MI.  Would you like to know more? (enter “yes” or “no): no
//Thanks! 
//
//Grading Criteria:
//There are ten possible points:
//List or array containing 10 students
//Prompt to select a specific student and returns the specified student
//Prompt includes validation of input for a valid student upon selection
//Prompt will continue to ask for valid student selection in a loop until valid input is provided
//Prompt that will select specified hometown or favorite food for specified student
//Prompt includes validation of input for hometown or favorite food prompt
//Prompt will continue to ask for valid hometown or favorite food in a loop until valid input is provided
//Incorporates IndexoutOfBoundsException in an appropriate way
//Asks if user would like to know more, and behaves appropriately upon input
//Prompt includes validation of input for prompt to know more information

public class Student_Database {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		String[] student = { "Susan", "Sam", "Cam", "Yaksh", "Sharv", "Jill", "Alex", "Anish", "Aamil", "Rick" };
		String[] hometown = { "Detroit, MI", "Seattle, WA", "San Jose, CA", "Bakersfield, CA", "Canton, MI",
				"Atlanta, GA", "Hell, MI", "Novi, MI", "Harrisburg, PA", " St Louis, MS" };
		String[] favFood = { "Hot Dog", "Burger", "Shawarma", "Binget", "Churro", "Donuts", "Candy", "Hasbrown",
				"Fruits", "Veggies" };
		boolean awdy = false;
		int studentID;
		String homeOrFood;
		System.out.println("Welcome to our Java class.");
		while (!awdy) {
			studentID = (validStudent()-1);
			homeOrFood = validInformation(student, studentID);
			if (homeOrFood.equalsIgnoreCase("hometown")) {
				System.out.println(student[studentID] + " is from " + hometown[studentID]
						+ ".  Would you like to know more? (enter “yes” or “no):");
				if (keepGoing().equalsIgnoreCase("no")) {
					awdy = true;
				} else {
					
				}
			} else if (homeOrFood.equalsIgnoreCase("favorite food")) {
				System.out.println(student[studentID] + " likes a good " + favFood[studentID]
						+ ".  Would you like to know more? (enter “yes” or “no):");
				if (keepGoing().equalsIgnoreCase("no")) {
			
				} else {
					
				}
			}
		}
		System.out.println("Thanks! bye.");
	}

	public static int validStudent() {
		System.out.println(
				"Which student would you like to learn more about? (enter a number 1-10)");
		boolean awdy = false;
		int userInput = 0;
		while (!awdy) {
			try {
				userInput = scan.nextInt();
				if (userInput >= 1 && userInput <= 10) {
					awdy = true;
				} else {
					throw new InvalidStudentException();
				}
			} catch (InvalidStudentException ex) {
				System.out.println(userInput + " Invalid Student, Please try again");
				
			} catch (InputMismatchException ex) {
				System.out.println("Please enter an INTEGER 1-10, Inclusive. ");
				scan.next();
			} catch (Exception ex) {
				System.out.println("An exception occures that is not handled pelase try entering another integer");
				scan.next();
			}
		
		}
		return userInput;
	}

	public static String validInformation(String[] student, int studentID) {

		String userHomeFood = "";
		boolean awdy = false;
		while (!awdy) {
			System.out.println(
					"Student " + (studentID+1) + " is " + student[studentID] + ". What would you like to know about "
							+ student[studentID] + "? (enter or \"hometown\" or \"favorite food\"): ");
			try {
				//this part is so weird i dont even know the problem
				scan.nextLine();
				userHomeFood = scan.nextLine();
				if (userHomeFood.equalsIgnoreCase("hometown") || userHomeFood.equalsIgnoreCase("favorite food")) {
					awdy = true;
//					scan.close();
				} else {
					System.out.println(userHomeFood + " is not a valid entry, please try again");
//					scan.close();
				}
			} catch (Exception ex) {
				System.out.println("Your entry was not valid please enter (enter or “hometown” or “favorite food”): ");
			}
		}
		return userHomeFood;
	}

	public static String keepGoing() {
//		Scanner scan = new Scanner(System.in);
		String keepGoing = null;
		boolean awdy = false;
		while (!awdy) {
			try {
				keepGoing = scan.next();
				if (keepGoing.equalsIgnoreCase("no") || keepGoing.equalsIgnoreCase("yes")) {
//					scan.close();
					awdy = true;
				} else {
					System.out.println("Input invalid Please type \"yes\" or \"no\"");
//					scan.close();
				}
			} catch (Exception ex) {
				System.out.println("Your Input caused an exception, Please enter \"yes\" or \"no\"");
//				scan.close();
			}

		}
		return keepGoing;
	}

}
