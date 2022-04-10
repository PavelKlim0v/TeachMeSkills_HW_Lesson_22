package by.tms.storage;

import by.tms.model.Comment;
import by.tms.model.User;

import java.util.ArrayList;
import java.util.List;

public class CommentStorage {

    private static final List<Comment> comments = new ArrayList<Comment>();

    public void saveComment(Comment comment) {
        comments.add(comment);
    }

    public List<Comment> getAllComments() {
        return new ArrayList<Comment>(comments);
    }


    public Comment findByIdComment(int idComment) {
        for (Comment comment : comments) {
            if (comment == null) {
                System.out.println("Check user and password");
            } else if (comment.getCommentId() == idComment) {
                return comment;
            }
        }
        return null;
    }

    public boolean editCommentById (int idComment, String login, String text, User user){
        for (Comment comment : comments){
            if (comment == null) {
                System.out.println("post=null ");
            } else if (comment.getCommentId() == idComment || user.getLogin().equals(login)){
                comment.setText(text);
                return true;
            }
        }
        return false;
    }

    public boolean deleteCommentById (int idComment, User user){
        for (Comment comment: comments){
            if (comment == null||user==null) {
                System.out.println("Check user and password");
            } else if (comment.getCommentId() == idComment) {
                comments.remove(idComment - 1);
                return true;
            }
        }
        return false;
    }

    public int getCommentId() {
        return comments.size() + 1;
    }
}
