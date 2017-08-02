package socialNetwork.posts;

/**
 * Class has all Posts details of entity
 * 
 * @author Prateek Jain
 *
 */
public class Posts {
	private String title;
	private String content;

	/**
	 * Initialize the variables
	 * 
	 * @param title
	 * @param content
	 */
	public Posts(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
