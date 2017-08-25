package com.metacube.printjob.heap;

import java.util.List;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PrintJob {

	private static Scanner scan;
	private static Heap heap = new Heap();
	private static void displayInput(int choice){
		switch(choice){
		case 1:
			System.out.println("Enter th department name");
			String department = scan.next();
			System.out.println("Enter the title of job");
			String jobTitle = scan.next();
			heap.addDocument(new Job(department, jobTitle));
			break;
		case 2:
			System.out.println("Printing Job According to thier priority.");
			heap.sort();
			List<Job> jobList = heap.getDocumentsToPrint();
			for(Job job : jobList){
				System.out.println(job.getDepartment()+" --> "+job.getJobTitle()+" --> "+job.getPriorityIndex());
			}
		}
	}
	public static void main(String[] args) {
		scan = new Scanner(System.in);
		System.out.println("1) Post a Job \n2)Print the Job \n3) Exit. \n");
		int choice;
		while(true){
			try{
				System.out.print("\nEnter your choice : ");
				choice = scan.nextInt();
				if(choice >0 && choice < 4){
					if(choice == 3){
						break;
					}
					displayInput(choice);
					continue;
				}
				System.out.println("Invalid Choice. Try Again");
			}catch(InputMismatchException e){
				System.out.println("Invalid Input . Try Again");
				scan.next();
			}
		}
		
	}
}
