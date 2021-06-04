package by.bsuir.servlet;

import by.bsuir.model.Hotel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/clientWishes", name = "ClientWishesServlet")
public class ClientWishesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/clientWishes.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Hotel hotel = (Hotel) req.getSession().getAttribute("hotel");
        String wishes = req.getParameter("clientWishes");
        hotel.setClientWishes(wishes);
        req.getSession().setAttribute("hotel", hotel);
        resp.sendRedirect("/orderInfo");
    }
}
