package by.tms.service;

import by.tms.model.Comment;
import by.tms.model.User;
import by.tms.storage.CommentStorage;

public class CommentService {

    private static final CommentStorage commentStorage = new CommentStorage();

    public String doNewComment(String userName, String text, int idComment) {

        if ( userName==null) {
            System.out.println("User doesnt created");
        }

        //System.out.println("Enter your comment");
        Comment comment = new Comment(text, userName, idComment);
        commentStorage.saveComment(comment);

        return (idComment+" | "+userName+" | "+text);
    }

    public String isEditCommentId(int idComment, String login, String text, User user) {
        commentStorage.editCommentById(idComment, login, text, user);
        return (idComment+" | "+user.getName()+" | "+text);

    }

    public boolean deleteCommentById(int idComment, User user) {
        return commentStorage.deleteCommentById(idComment, user);
    }

    public Comment findComment(int idComment) {
        return commentStorage.findByIdComment(idComment);
    }

    public int getCommentId() {
        return commentStorage.getCommentId();
    }

}

