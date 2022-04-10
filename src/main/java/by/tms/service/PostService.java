package by.tms.service;

import by.tms.model.Comment;
import by.tms.model.Post;
import by.tms.model.User;
import by.tms.storage.PostStorage;

import java.util.ArrayList;
import java.util.List;

public class PostService {
    private static final PostStorage postStorage = new PostStorage();


    public int getPostId() {
        return postStorage.getPostId();
    }

    public String doNewPost(String userName, String text, Integer idPost) {
        if (userName == null) {
            System.out.println("User doesnt created");
        }

        System.out.println("Enter your comment");
        Post post = new Post(idPost, text, userName, new ArrayList<Comment>(), new ArrayList<String>());
        postStorage.savePost(post);
        System.out.println(post);
        return (idPost+" | "+userName+" | "+text);
    }

    public String addLike(int idPost, String name) {
        postStorage.addLikeToPost(idPost, name);
        return name;
    }

    public String addCommentById(int idPost, Comment comment) {
        postStorage.addCommentByIdInPost(idPost, comment);
        return (comment.getCommentId()+" | "+comment.getUserName()+" | "+comment.getText());
    }

//    public String isEditPostId(int idPost, String login, String text, User user) {
//
//         if (postStorage.editPostById(idPost, login, text, user)==true) {
//             return (idPost+"|"+user+"|"+text);
//         }
//             return "Ничего не вышло";
//    }

    public String editCommentId(Post post1, int idComment, String login, String text, User user) {
        postStorage.editCommentByIdInPost(post1, idComment, login, text, user);
        return (idComment+" | "+user.getName()+" | "+text);
    }

    public boolean deleteCommentById(Post post1, int idComment, User user) {
        return postStorage.deleteCommentByIdInPost(post1, idComment, user);
    }



    public String isEditPostId(int idPost, String login, String text, User user) {
      postStorage.editPostById(idPost,login,text,user);
      return (idPost+" | "+user.getName()+" | "+text);
    }

    public boolean deletePostById(int idPost, User user) {
        return postStorage.deletePostById(idPost, user);
    }

    public Post findPost(int idPost) {
        return postStorage.findByIdPost(idPost);
    }

    public  List<Post> findAll() {
        return postStorage.getAll();
    }

}


