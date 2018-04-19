package validate;

import model.Calculator;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FormValidator implements Validator {

    static Pattern p = Pattern.compile("-?\\d+(\\.\\d+)?");

    @Override
    public boolean supports(Class<?> aClass) {
        return Calculator.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Calculator calculator = (Calculator) o;
        Matcher m = p.matcher(Double.toString(calculator.getDigit()));

        if (!m.matches()) {
            errors.rejectValue("digit", "", "Incorrect data");
        }
    }
}