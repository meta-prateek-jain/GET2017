package com.metacube.printjob;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.metacube.printjob.heap.JobHeap;
import com.metacube.printjob.model.Job;

/**
 * This class is used to display the menu and take input from the user
 * 
 * @author Prateek Jain
 *
 */
public class Printer {

	private static Scanner scan;
	private static JobHeap jobHeap = new JobHeap();

	/**
	 * Method is used to take the required input and display the output
	 * depending on the choice
	 * 
	 * @param choice
	 */
	private static void displayInput(int choice) {
		// switch case to work according to the choice selected
		switch (choice) {
		case 1:
			scan.nextLine();
			String department = "";
			//loop continue till user do not enter something
			while (true) {
				System.out.println("Enter the department name");
				department = scan.nextLine();
				if (!department.isEmpty()) {
					break;
				}
				System.out.println("Please Enter something.");
			}
			String jobTitle = "";
			//loop continue till user do not enter something
			while (jobTitle.isEmpty()) {
				System.out.println("Enter the title of job");
				jobTitle = scan.nextLine();
			}
			jobHeap.addDocument(new Job(department, jobTitle));
			break;
		case 2:
			List<Job> jobList = jobHeap.getDocumentsToPrint();
			
			/*
			 * if no job is present then print the message 
			 * else print the job
			 */
			if (jobList.isEmpty()) {
				System.out.println("No Job is available\n");
			} else {
				System.out.println("Printing Job According to thier priority.");
				
				// loop iterate till all jobs are displayed to user
				for (Job job : jobList) {
					System.out.println("Department : "+job.getDepartment()+" --> Job title : "+job.getJobTitle());
				}
			}
		}
	}

	/**
	 * Main method of this application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		int choice;
		// loop continue till exit choice is entered
		while (true) {
			try {
				System.out.println("1) Post a Job \n2) Print the Jobs \n3) Exit. \n");
				System.out.print("\nEnter your choice : ");
				choice = scan.nextInt();
				/*
				 *  if choice is valid then continue
				 *  else print invalid choice
				 */
				if (choice > 0 && choice < 4) {
					// if choice is three then exit from th application
					if (choice == 3) {
						System.out.println("Exiting from the application");
						System.exit(0);
						break;
					}
					displayInput(choice);
				} else {
					System.out.println("Invalid Choice. Try Again");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid Input . Try Again");
				scan.next();
			}
		}
	}
}
