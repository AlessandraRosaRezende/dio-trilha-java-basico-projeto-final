package one.digitalinnovation.projetofinalspring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String postId;
	private String title;
	private String body;

	public String getPostId() {
		return postId;
	}

    public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
    }
    
    public String getBody() {
        return body;
	}

    public void setBody(String body) {
        this.body = body;
    }
}
