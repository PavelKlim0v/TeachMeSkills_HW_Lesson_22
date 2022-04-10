package by.tms.servlet.comment;

import by.tms.model.Comment;
import by.tms.model.User;
import by.tms.service.CommentService;
import by.tms.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/comment")
public class CommentServlet extends HttpServlet {

    private final CommentService commentService = new CommentService();
    private final PostService postService = new PostService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/comment.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = req.getParameter("text");
        int idPost = Integer.parseInt(req.getParameter("idPost"));
        int idComment = commentService.getCommentId();
        User user = (User) req.getSession().getAttribute("user");

        commentService.doNewComment(user.getName(), text, idComment);
        String textComment = postService.addCommentById(idPost, commentService.findComment(idComment));

        req.setAttribute("textComment", textComment);
        getServletContext().getRequestDispatcher("/comment.jsp").forward(req, resp);
    }

//    @Override
//    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int idComment = Integer.parseInt(req.getParameter("idComment"));
//        String newText = req.getParameter("text");
//        User user = (User) req.getSession().getAttribute("user");
//        String login = user.getLogin();
//        commentService.isEditCommentId(idComment, login, newText, user);
//        getServletContext().getRequestDispatcher("/post.jsp").forward(req, resp);
//    }
//
//    @Override
//    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int idComment = Integer.parseInt(req.getParameter("idComment"));
//        User user = (User) req.getSession().getAttribute("user");
//        commentService.deleteCommentById(idComment, user);
//        getServletContext().getRequestDispatcher("/post.jsp").forward(req, resp);
//    }

}
