package com.devsuperior.DSPosts.model.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.devsuperior.DSPosts.model.embedded.Author;
import com.devsuperior.DSPosts.model.embedded.Comment;
import com.devsuperior.DSPosts.model.entities.Post;

import jakarta.validation.constraints.NotBlank;

public class PostDTO {

	private String id;
	private Instant moment;
	@NotBlank(message = "Required field")
	private String title;
	@NotBlank(message = "Required field")
	private String body;

	private Author author;

	private List<Comment> comments = new ArrayList<>();

	public PostDTO() {

	}

	public PostDTO(String id, Instant moment, String title, String body, Author author) {
		this.id = id;
		this.moment = moment;
		this.title = title;
		this.body = body;
		this.author = author;
	}

	public PostDTO(Post entity) {
		this.id = entity.getId();
		this.moment = entity.getMoment();
		this.title = entity.getTitle();
		this.body = entity.getBody();
		this.author = entity.getAuthor();
		this.comments.addAll(entity.getComments());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
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

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<Comment> getComments() {
		return comments;
	}

}
