package com.mobileshop.group5.validator;

import com.mobileshop.group5.model.Member;
import com.mobileshop.group5.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidation implements Validator {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void validate(Object target, Errors errors) {
        Member user = (Member) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"userId","field.required");
        if (user.getFullName().length()<3 || user.getFullName().length() > 32){
            errors.rejectValue("fullName","Size");
        }
        if (userRepository.findByUserId(user.getUserId()) != null ){
            errors.rejectValue("userId", "Duplicate");
        }
        if (user.getPhone().length()!=10){
            errors.rejectValue("phone","Size");
        }
        if (user.getEmail().length()<3 || user.getEmail().length() > 32){
            errors.rejectValue("email","Size");
        }

        if (user.getPassword().length() <4 || user.getPassword().length() > 32){
            errors.rejectValue("password", "Size");
        }
        if (!user.getPassword().equals(user.getPasswordComfirm())){
            errors.rejectValue("passwordComfirm","Diff");
        }
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Member.class.equals(clazz);
    }
}
