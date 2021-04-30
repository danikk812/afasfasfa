package by.bsuir.servlets.servlet;

import by.bsuir.servlets.service.ClassMethodsFinder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(urlPatterns = "/")
public class ClassMethodsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/home.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String className = req.getParameter("className");
        ClassMethodsFinder classMethodsFinder = new ClassMethodsFinder();
        Optional<List<String>> methodsNamesOptional = Optional.ofNullable(classMethodsFinder.findClassMethods(className));
        if (methodsNamesOptional.isPresent()) {
            req.setAttribute("className", className);
            req.setAttribute("methods", methodsNamesOptional.get());
            getServletContext().getRequestDispatcher("/classMethods.jsp").forward(req, resp);
        } else {
            req.setAttribute("classNotFoundMessage", "Class with name " + className + " not found");
            getServletContext().getRequestDispatcher("/home.jsp").forward(req, resp);
        }
    }
}
