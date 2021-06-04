package by.bsuir.servlet;

import by.bsuir.model.Hotel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/hotel")
public class HotelNameServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/hotelName.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Hotel> hotels = (List<Hotel>) req.getSession().getAttribute("hotels");
        String hotelName = req.getParameter("hotelName");
        boolean hasHotel = false;
        for (Hotel hotel : hotels) {
            if (hotel.getHotelName().equals(hotelName)) {
                hasHotel = true;
                req.getSession().setAttribute("hotel", hotel);
                resp.sendRedirect("/floorAndFeatures");
            }
        }
        if (!hasHotel) {
            req.setAttribute("hotelNameError", "Hotel " + hotelName + " not found");
            getServletContext().getRequestDispatcher("/pages/hotelName.jsp");
        }
    }
}
