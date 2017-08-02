package socialNetwork.index.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import socialNetwork.entity.Entity;
import socialNetwork.graph.Graph;
import socialNetwork.posts.Posts;
/**
 * Post class is used to display and add /remove post 
 * @author Prateek Jain
 *
 */
public class Post {
	private Scanner scan;

	/**
	 * Display all the option related to Post and perform function according to
	 * choice
	 * 
	 * @param graph
	 * @param entityId
	 */
	protected void posts(Graph<Entity> graph, String entityId) {
		scan = new Scanner(System.in);
		boolean back = false;
		//loop continue till valid choice is selected
		do {
			System.out.println("1.Display Post\n2.Add Post\n3.Remove Post\n4.Back To Previous Menu");
			//loop continue till valid input entered
			while (!scan.hasNextInt()) {
				System.out.println("Enter Integer Value:");
				scan.nextLine();
			}
			int choice = scan.nextInt();
			// if entered value is other then options then print message and try again
			if (choice > 4 || choice < 1) {
				System.out.println("Enter Value in the range 1 to 4");
				continue;
			}
			scan.nextLine();
			//perform actions according to the choice
			switch (choice) {
			case 1:
				displayPost(graph, entityId);
				break;
			case 2:
				addPost(graph, entityId);
				break;
			case 3:
				removePost(graph, entityId);
				break;
			case 4:
				back = true;
				break;
			default:
				System.out.println("Enter correct choice\n");
			}
		} while (!back);
	}

	/**
	 * Remove post by using title of post
	 * 
	 * @param graph
	 * @param entityId
	 */
	private void removePost(Graph<Entity> graph, String entityId) {
		System.out.println("Enter Post title");
		String title = scan.nextLine();
		boolean flag = false;
		//loop continue till end of Posts List
		for (Posts posts : graph.getNodeById(entityId).getPostsList()) {
			//if post is available then delete the post
			if (posts.getTitle().equalsIgnoreCase(title)) {
				graph.getNodeById(entityId).getPostsList().remove(posts);
				flag = true;
				break;
			}
		}
		/*
		 * if flag is true then print post deleted
		 * else print no post exist
		 */
		if (flag) {
			System.out.println(title + " Deleted ");
		} else {
			System.out.println("No such post exit ");
		}
	}

	/**
	 * Add post to record List
	 * 
	 * @param graph
	 * @param id
	 */
	private void addPost(Graph<Entity> graph, String id) {
		System.out.println("post Title :");
		String title = scan.nextLine();
		System.out.println("write END in the last line of Content: ");
		String content = "\n";
		String checkEnd;
		//loop continue takes input until END is entered in last line
		while (!(checkEnd = scan.nextLine()).equalsIgnoreCase("END")) {
			content += checkEnd + "\n";
		}
		//if postList of entity is null then set postList with empty value
		if (graph.getNodeById(id).getPostsList() == null) {
			List<Posts> post = new ArrayList<Posts>();
			graph.getNodeById(id).setPostsList(post);
		}
		graph.getNodeById(id).getPostsList().add(new Posts(title, content));
	}

	/**
	 * Display all the post from current entity
	 * 
	 * @param graph
	 * @param personId
	 */
	private void displayPost(Graph<Entity> graph, String personId) {
		/*
		 * if post list is null then print no post message
		 * else print the post
		 */
		if (graph.getNodeById(personId).getPostsList() == null || graph.getNodeById(personId).getPostsList().size() == 0) {
			System.out.println("\n--------You have no Post-------\n");
		} else {
			//loop continue till all posts are get 
			for (Posts post : graph.getNodeById(personId).getPostsList()) {
				System.out.println("\nTitle of Post -> " + post.getTitle());
				System.out.println("Content -> " + post.getContent());
			}
		}
	}
}
