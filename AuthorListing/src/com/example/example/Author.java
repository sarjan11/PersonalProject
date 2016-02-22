package com.example.example;

public class Author {
	
	private int authorId;
	private String authorName;
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getAuthorName() {
		return authorName;
	}
	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", authorName=" + authorName
				+ "]";
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

}
