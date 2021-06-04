package by.bsuir.servlet;

import by.bsuir.model.Hotel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/floorAndFeatures", name = "FloorAndFeaturesServlet")
public class FloorAndFeaturesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/floorAndFeatures.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Hotel hotel = (Hotel) req.getSession().getAttribute("hotel");
        Optional<String> floorOptional = Optional.ofNullable(req.getParameter("floor"));
        if (floorOptional.isPresent()) {
            int floor = Integer.parseInt(floorOptional.get());
            boolean hasConditioner = Boolean.parseBoolean(req.getParameter("conditioner"));
            boolean hasExtraBathroom = Boolean.parseBoolean(req.getParameter("extraBathroom"));
            hotel.setFloor(floor);
            hotel.setConditioner(hasConditioner);
            hotel.setExtraBathroom(hasExtraBathroom);
            req.getSession().setAttribute("hotel", hotel);
            resp.sendRedirect("/clientWishes");
        } else {
            req.setAttribute("floorError", "Floor not found");
            getServletContext().getRequestDispatcher("/pages/floorAndFeatures.jsp").forward(req, resp);
        }
    }
}
