package by.bsuir.filter;

import by.bsuir.model.Hotel;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = {"FloorAndFeaturesServlet", "ClientWishesServlet", "OrderInformationServlet"})
public class HotelFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        Hotel hotel = (Hotel) req.getSession().getAttribute("hotel");
        if (hotel != null) {
            chain.doFilter(req, res);
        } else {
            res.sendRedirect("/hotel");
        }
    }
}
