package by.tms.servlet.post;

import by.tms.model.User;
import by.tms.service.PostService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/deletePost")
public class DeletePostServlet extends HttpServlet {

    private final PostService postService = new PostService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/post.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idPost = Integer.parseInt(req.getParameter("idPost"));
        User user = (User) req.getSession().getAttribute("user");
        postService.deletePostById(idPost, user);
//        if (user.getRole().equals(UserRole.ADMIN_ROLE)){
//            String loginUser = postService.getPostId();
//            postService.deletePostById(idPost, loginUser);
//        } else {
//        postService.deletePostById(idPost, user);
//    }
        getServletContext().getRequestDispatcher("/post.jsp").forward(req, resp);
    }
}
