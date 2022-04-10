package by.tms.servlet.post;

import by.tms.model.Post;
import by.tms.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/postHistory")
public class PostsHistoryServlet extends HttpServlet {

    private final PostService postService = new PostService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Post> all = postService.findAll();
        req.setAttribute("all", all);
        getServletContext().getRequestDispatcher("/history.jsp").forward(req, resp);
    }

}
