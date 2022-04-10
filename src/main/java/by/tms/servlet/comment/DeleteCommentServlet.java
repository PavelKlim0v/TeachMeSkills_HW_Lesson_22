package by.tms.servlet.comment;

import by.tms.model.Post;
import by.tms.model.User;
import by.tms.service.CommentService;
import by.tms.service.PostService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/deleteComment")
public class DeleteCommentServlet extends HttpServlet {

    //private final CommentService commentService = new CommentService();
    private final PostService postService = new PostService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/comment.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idPost = Integer.parseInt(req.getParameter("idPost"));
        int idComment = Integer.parseInt(req.getParameter("idComment"));
        User user = (User) req.getSession().getAttribute("user");
        //commentService.deleteCommentById(idComment, user);

        Post post1 = postService.findPost(idPost);
        postService.deleteCommentById(post1, idComment, user);

        getServletContext().getRequestDispatcher("/comment.jsp").forward(req, resp);
    }

}
