package socialNetwork.entity;

import java.util.List;

import socialNetwork.posts.Posts;
/**
 * Abstract class containing properties inherit by person and organization 
 * 
 * @author Prateek Jain
 *
 */
public abstract class Entity {
	private String id;
	private String name;
	private String type;
	private String password;
	private List<Posts> postsList;
	
	/**
	 * Initialize the variables
	 * 
	 * @param id
	 * @param name
	 * @param password
	 * @param type
	 */
	public Entity(String id, String name, String password, String type) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Posts> getPostsList() {
		return postsList;
	}

	public void setPostsList(List<Posts> postsList) {
		this.postsList = postsList;
	}
	/*
	 * hashCode method checks for similar data
	 * (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	/*
	 * equals method is for same data
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entity other = (Entity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
