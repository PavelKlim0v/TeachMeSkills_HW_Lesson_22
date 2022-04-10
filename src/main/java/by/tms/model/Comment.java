package by.tms.model;

public class Comment {

    private String text;
    private String userName;
    private int commentId;

    public Comment() { }

    public Comment(String text, String userName, int commentId) {
        this.text = text;
        this.userName = userName;
        this.commentId = commentId;
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

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "text='" + text + '\'' +
                ", userName='" + userName + '\'' +
                ", commentId=" + commentId +
                '}';
    }

}
