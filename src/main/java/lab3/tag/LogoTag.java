package lab3.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;

public class LogoTag extends BodyTagSupport {
    private String heading;
    private String image;
    private String width;
    private String height;

    @Override
    public int doStartTag() throws JspException {
        try {
            int h = Integer.parseInt(heading);
            if (!(h > 0 && h < 7)) {
                throw new JspException("The 'heading' attribute value must between 1 and 6 inclusive");
            }
        } catch (Exception e) {
            throw new JspException(e.getMessage());
        }
        return EVAL_BODY_BUFFERED;
    }

    @Override
    public int doEndTag() throws JspException {
        JspWriter out = pageContext.getOut();
        String imgDir = ((HttpServletRequest) pageContext.getRequest()).getContextPath() + "/"/*+ "/images/"*/;
        String message = getBodyContent().getString().trim();

        try {
            out.println("<img src=\"" + imgDir + image
                    + "\" width=\"" + width
                    + "\" + height=\"" + height
                    + "\" + align=\"left\">"
                    + "<div>" + "<h" + heading + ">"
                    + message
                    + "</h" + heading + ">" + "</div>"
            );
        } catch (IOException ignored) {
        }
        return EVAL_PAGE;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void release() {
        heading = null;
        image = null;
        width = null;
        height = null;
    }
}
