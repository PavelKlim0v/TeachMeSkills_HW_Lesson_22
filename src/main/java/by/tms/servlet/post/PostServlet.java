package by.tms.servlet.post;

import by.tms.model.User;
import by.tms.service.PostService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/post")
public class PostServlet extends HttpServlet {

    private final PostService postService = new PostService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/post.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = req.getParameter("text");
        int idPost = postService.getPostId();
        User user = (User) req.getSession().getAttribute("user");
        String textPost =  postService.doNewPost(user.getName(), text, idPost);

//        String action = req.getServletPath();
//
//        switch (action) {
//            case "/update":                                // редактирование по id
//                updateData(request, response);
//                break;
//            case "/delete":                                // удаление пользователя по id
//                deleteById(request, response);
//                break;
//            default:                                       // вывод списка
//                listUsers(request, response);
//                break;
//        }

        req.setAttribute("textPost", textPost);
        getServletContext().getRequestDispatcher("/post.jsp").forward(req, resp);
    }

}
