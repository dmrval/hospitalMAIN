package com.dmrval.hospitalapp.validator;


        import com.dmrval.hospitalapp.entity.User;
        import com.dmrval.hospitalapp.service.UserServise;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Component;
        import org.springframework.validation.Errors;
        import org.springframework.validation.ValidationUtils;
        import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserServise userServise;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "Required");
        if (userServise.findByLogin(user.getLogin()) != null) {
            errors.rejectValue("login", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
        if (!user.getConfirmPassword().equals(user.getPassword())) {
            errors.rejectValue("confirmPassword", "Different.UserForm.password");
        }

    }
}
