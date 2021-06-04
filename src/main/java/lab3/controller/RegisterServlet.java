package lab3.controller;

import lab3.entity.User;
import lab3.entity.UserStorage;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "registerServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User newUser;
        newUser = new User(
                req.getParameter("email"),
                req.getParameter("password")
        );
        UserStorage.getInstance().add(newUser);
        req.getSession().setAttribute("user", newUser);
        resp.sendRedirect(req.getContextPath() + "/setInfo.jsp");
    }
}
