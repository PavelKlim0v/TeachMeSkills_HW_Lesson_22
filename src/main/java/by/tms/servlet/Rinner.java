package by.tms.servlet;

import by.tms.model.Post;
import by.tms.model.User;
import by.tms.model.UserRole;
import by.tms.service.PostService;
import by.tms.storage.PostStorage;

import java.util.ArrayList;

public class Rinner {
    public static void main(String[] args) {
        User user = new User("Maxim", "1","Rte", UserRole.USER_ROLE);
        PostService postService = new PostService();
        postService.doNewPost(user.getName(),"sfdgvfsvsdfv", 1);
        postService.doNewPost(user.getName(),"sfdgvfsvsdfv", 2);
        PostStorage postStorage = new PostStorage();

        postService.isEditPostId(2,"Rte","Hello", user);
        postService.deletePostById(1, user);

        postService.findAll();



        Post post = new Post(1, "text post 1", "Pavel", new ArrayList<>(), new ArrayList<>());


//        static int km;
//
//        Car car1 = new Car();
//        car1.km = 100;
//
//        Car car2 = new Car();
//        car2.km = 80;
//
//        System.out.println(car1.km + " " + car2.km);

    }
}
