package by.tms.model;

import java.util.ArrayList;
import java.util.List;

public class Post {

    private int postId;
    private String text;
    private String userName;
    private List<Comment> comments;
    private List<String> like;

    public Post(int postId, String text, String userName, List<Comment> comments, List<String> like) {
        this.postId = postId;
        this.text = text;
        this.userName = userName;
        this.comments = comments;
        this.like = like;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(Comment comments) {
        this.comments.add(comments);
    }

    public List<String> getLike() {
        return like;
    }

    public void setLike(List<String> like) {
        this.like = like;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", userName='" + userName + '\'' +
                ", text='" + text + '\'' +
                ", comments=" + comments +
                ", like=" + like +
                '}';
    }

}
