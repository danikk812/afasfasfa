package by.bsuir.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@FacesValidator("valid")
public class LineValidator implements Validator<String> {

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, String value) throws ValidatorException {

        Pattern pattern = Pattern.compile("^([0-9]| )+");
        Matcher matcher = pattern.matcher(value);

        if (!matcher.find()) {
            String message = MessageFormat.format("{0} incorrect input", value);
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
            throw new ValidatorException(fm);
        }
    }
}
