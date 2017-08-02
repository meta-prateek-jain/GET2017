package socialNetwork.index.action;

import java.util.Scanner;

import socialNetwork.entity.Entity;
import socialNetwork.entity.Organization;
import socialNetwork.entity.Person;
import socialNetwork.graph.Graph;
/**
 * Class is used to edit entity profile data
 * 
 * @author Prateek Jain
 *
 */
public class EditProfile {
	private static int choice;
	private static Scanner scan = new Scanner(System.in);

	/**
	 * Function to edit profile of type person
	 * 
	 * @param (Person)graph
	 * @param id
	 * @return
	 */
	public boolean editPersonProfile(Graph<Entity>graph, String id) {
		boolean back = false;
		// loop continue till valid choice is selected
		do {
			System.out.println("1.Edit Name\n2.Edit Age\n3.Change Password\n4.Display Profile\n5.Delete Profile\n6.Back ");
			while (!scan.hasNextInt()) {
				System.out.println("Enter Integer value:");
				scan.nextLine();
			}
			choice = scan.nextInt();
			// if entered value is other then options then print message and try
			// again
			if (choice > 6 || choice < 1) {
				System.out.println("Enter Value in the range 1 to 4");
				continue;
			}
			scan.nextLine();
			// perform operation according to choice selected
			switch (choice) {
			case 1:
				System.out.println("Enter New Name");
				graph.getNodeById(id).setName(scan.nextLine());
				break;
			case 2:
				int age = getValidAge();
				Person person1 = (Person)graph.getNodeById(id);
				person1.setAge(age);
				break;
			case 3:
				System.out.println("Enter your Current password");
				/*
				 * validate the password if valid then enter the new password
				 * else error message
				 */
				if (graph.getNodeById(id).getPassword().equals(scan.nextLine())) {
					System.out.println("Enter new Password :");
					graph.getNodeById(id).setPassword(scan.nextLine());
				} else {
					System.out.println("Wrong password");
				}
				break;
			case 4:
				Person person = (Person)graph.getNodeById(id);
				System.out.println("Name - " + person.getName() + "\t Age - " + person.getAge());
				break;
			case 5:
				//if profile exist then delete it from graph
				if (deleteProfile()) {
					graph.removeNodeById(id);
					System.out.println("Removed");
					return true;
				}
				break;
			case 6:
				back = true;
				break;
			default:
				System.out.println("Enter correct choice\n");
			}
		} while (!back);
		return false;
	}

	/**
	 * Function is used to edit profile of Organization
	 * 
	 * @param graph
	 * @param entityId
	 * @return
	 */
	public boolean editOrganizationProfile(Graph<Entity> graph, String entityId) {
		boolean back = false;
		//loop continue till valid choice is not selected
		do {
			System.out.println("1.Edit Name\n2.Edit Category\n3.Change Password\n4.Display Profile\n5.Delete Profile\n6.Back ");
			//loop continue till valid input is entered
			while (!scan.hasNextInt()) {
				System.out.println("Enter Integer value:");
				scan.nextLine();
			}
			choice = scan.nextInt();
			// if entered value is other then options then print message and try
			// again
			if (choice > 6 || choice < 1) {
				System.out.println("Enter Value in the range 1 to 4");
				continue;
			}
			scan.nextLine();

			// perform operation according to the choice selected
			switch (choice) {
			case 1:
				System.out.println("Enter New Name");
				graph.getNodeById(entityId).setName(scan.nextLine());
				break;
			case 2:
				System.out.println("Enter New Category");
				Organization organization = (Organization)graph.getNodeById(entityId);
				organization.setCategory(scan.nextLine());
				break;
			case 3:
				System.out.println("Enter your Current password");
				/*
				 * validate the password if valid then enter the new password
				 * else error message
				 */
				if (graph.getNodeById(entityId).getPassword().equals(scan.nextLine())) {
					System.out.println("Enter new Password :");
					graph.getNodeById(entityId).setPassword(scan.nextLine());
				} else {
					System.out.println("Wrong password");
				}
				break;
			case 4:
				Organization organization1 = (Organization) graph.getNodeById(entityId);
				System.out.println("\nName - " + organization1.getName() + "\t Category - " + organization1.getCategory() + "\n");
				break;
			case 5:
				//if profile exist then delete profile
				if (deleteProfile()) {
					graph.removeNodeById(entityId);
					back = true;
					return true;
				}
				break;
			case 6:
				back = true;
				break;
			default:
				System.out.println("Enter correct choice\n");
			}
		} while (!back);
		return false;
	}
	/**
	 * Function to validate the age 
	 * @return
	 */
	private int getValidAge() {
		System.out.println("Enter age");
		int age;
		while (!scan.hasNextInt() || (age = scan.nextInt()) > 100 || age < 1) {
			System.out.println("Enter Correct Age:");
			scan.nextLine();
		}
		return age;
	}
	/**
	 * Function is used to check entity is present or not for deletion
	 * @return
	 */
	private boolean deleteProfile() {
		boolean status = false;
		System.out.println("Are you sure .?? Y/N");
		String answer = scan.next();
		if ("Y".equalsIgnoreCase(answer)) {
			System.out.println("Removed");
			status = true;
		}
		return status;
	}
}
