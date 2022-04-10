package by.tms.storage;

import by.tms.model.Comment;
import by.tms.model.Post;
import by.tms.model.User;

import java.util.ArrayList;
import java.util.List;

public class PostStorage {

    private static final List<Post> posts = new ArrayList<Post>();

    public int getPostId() {
        return posts.size() + 1;
    }

    public void savePost(Post post){
        posts.add(post);
    }

    public List<Post> getAllPost() {
        return new ArrayList<Post>(posts);
    }

    public Post findByIdPost (int idPost) {
        for (Post post : posts) {
            if (post == null) {
                System.out.println("post=null, проверь findByIdPost");
            } else if (post.getPostId() ==idPost) {
                return post;
            }
        }
        return null;
    }

//    public boolean editPostById (int idPost, String login, String text, User user){
//        for (Post post : posts){
//            if (post == null|| user ==null) {
//                System.out.println("post=null or user ==null ");
//            } else if (post.getPostId() == idPost || user.getLogin().equals(login)){
//                post.setText(text);
//                return true;
//            }
//        }
//        return false;
//    }
    public boolean editPostById(int idPost, String login, String text, User user){
        for (Post post : posts){
            if (post == null || user == null) {
                System.out.println("post=null or user ==null ");
            } else if (post.getPostId() == idPost && user.getLogin().equals(login)){
                post.setText(text);
                return true;
            }
        }
        return false;
    }

    public boolean deletePostById(int idPost, User user){
        for (Post post : posts){
            if (post == null||user==null) {
                System.out.println("post=null, проверь deletePostById");
            } else if (post.getPostId() == idPost) {
                posts.remove(idPost - 1);
                return true;
            }
        }
        return false;
    }

    public boolean addCommentByIdInPost(int idPost, Comment comment){
        for (Post post : posts){
            if (post == null) {
                System.out.println("post=null or user ==null ");
            } else if (post.getPostId() == idPost){
                post.setComments(comment);
                return true;
            }
        }
        return false;
    }

    public boolean editCommentByIdInPost(Post post1, int idComment, String login, String text, User user){
        for (Comment comment : post1.getComments()){
            if (comment == null || user == null) {
                System.out.println("post=null or user ==null ");
            } else if (comment.getCommentId() == idComment && user.getLogin().equals(login)){
                comment.setText(text);
                return true;
            }
        }
        return false;
    }

    public boolean deleteCommentByIdInPost(Post post1, int idComment, User user){
        for (Comment comment : post1.getComments()){
            if (comment == null||user==null) {
                System.out.println("post=null, проверь deletePostById");
            } else if (comment.getCommentId() == idComment) {
                posts.remove(comment.getCommentId() - 1);
                return true;
            }
        }
        return false;
    }

    public boolean addLikeToPost(int idPost, String name) {
        for (Post post : posts) {
            if (post.getPostId() == idPost) {
                post.getLike().add(name);
                return true;
            }
        }
        return false;
    }

    public List<Post> getAll() {
        return new ArrayList<Post>(posts);
    }

}

