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

@WebServlet("/updateComment")
public class EditCommentServlet extends HttpServlet {

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
        String newText = req.getParameter("text");
        User user = (User) req.getSession().getAttribute("user");
        String login = user.getLogin();

        Post post1 = postService.findPost(idPost);
        String textComment = postService.editCommentId(post1, idComment, login, newText, user);
        //String textComment = commentService.isEditCommentId(id, idComment, login, newText, user);

        req.setAttribute("textComment", textComment);
        getServletContext().getRequestDispatcher("/comment.jsp").forward(req, resp);
    }

}
