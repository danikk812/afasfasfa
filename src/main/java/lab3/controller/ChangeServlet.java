package lab3.controller;

import lab3.entity.User;
import lab3.util.UserUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "change", urlPatterns = "/change")
public class ChangeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = UserUtil.setParams(req);
        req.setAttribute("user", user);
        resp.sendRedirect(req.getContextPath() + "/home.jsp");
    }
}
