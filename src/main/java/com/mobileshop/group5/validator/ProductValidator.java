package com.mobileshop.group5.validator;

import com.mobileshop.group5.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
@Component
public class ProductValidator implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return Product.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Product product = (Product) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productName","field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "manufacturer","field.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "categoryByCategoryId","field.required");
        if (product.getProductName().length()>50){
            errors.rejectValue("productName","Size");
        }
        if (product.getManufacturer().length()>50){
            errors.rejectValue("manufacturer","Size");
        }
        if(product.getPrice()<=0){
            errors.rejectValue("price", "field.negativevalue");
        }

        if(product.getQuantity() <=0){
            errors.rejectValue("quantity", "field.negativevalue");
        }


    }
}
