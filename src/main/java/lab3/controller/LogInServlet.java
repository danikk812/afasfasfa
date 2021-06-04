package lab3.controller;

import lab3.entity.User;
import lab3.entity.UserStorage;
import lab3.exception.UserNotFoundException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "loginServlet", urlPatterns = "/login")
public class LogInServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Optional<User> user = UserStorage.getInstance().getUser(email, password);
        if (user.isPresent()) {
            user.ifPresent(us -> req.getSession().setAttribute("user", us));
            resp.sendRedirect(req.getContextPath() + "/home.jsp");
        } else {
            try {
                throw new UserNotFoundException("user not found");
            } catch (UserNotFoundException e) {
                e.printStackTrace();
            }
            resp.sendRedirect(req.getContextPath() + "/error.jsp");
        }
    }
}
