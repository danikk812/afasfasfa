package lab3.util;

import lab3.entity.Format;
import lab3.entity.User;
import lab3.entity.UserPreference;

import javax.servlet.http.HttpServletRequest;

public class UserUtil {
    public static User setParams(HttpServletRequest req) {
        User user = (User) req.getSession().getAttribute("user");
        UserPreference preference = user.getPreference();
        preference.setFavProducer(req.getParameter("name"));
        preference.setFavGenre(req.getParameter("genre"));
        preference.setHome(Boolean.parseBoolean(req.getParameter("home")));
        preference.setCinema(Boolean.parseBoolean(req.getParameter("cinema")));
        preference.setPreference(setFormat(req));
        user.setPreference(preference);
        return user;
    }

    private static Format setFormat(HttpServletRequest req) {
        if ("full".equals(req.getParameter("format"))) {
            return Format.FILM;
        } else {
            return Format.SERIAL;
        }
    }
}
