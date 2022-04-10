package by.tms.servlet.post;

import by.tms.model.User;
import by.tms.service.PostService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updatePost")
public class EditPostServlet extends HttpServlet {

    private final PostService postService = new PostService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/post.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int idPost = Integer.parseInt(req.getParameter("idPost"));
        String newText = req.getParameter("text");
        User user = (User) req.getSession().getAttribute("user");
        String login = user.getLogin();
        String textPost = postService.isEditPostId(idPost, login, newText, user);
        req.setAttribute("textPost", textPost);
        getServletContext().getRequestDispatcher("/post.jsp").forward(req, resp);
    }

}
