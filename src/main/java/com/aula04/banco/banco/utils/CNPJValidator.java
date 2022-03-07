package com.aula04.banco.banco.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CNPJValidator implements ConstraintValidator<CNPJ, String> {
    @Override
    public void initialize(CNPJ constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String cnpj, ConstraintValidatorContext context) {
        String cnpjSomenteDigitos = cnpj.replaceAll("\\D", "");


        if(cnpjSomenteDigitos == null ||
                cnpjSomenteDigitos.length() != 14 ||
                cnpjSomenteDigitos.equals("00000000000000") ||
                cnpjSomenteDigitos.equals("11111111111111") ||
                cnpjSomenteDigitos.equals("22222222222222") ||
                cnpjSomenteDigitos.equals("33333333333333") ||
                cnpjSomenteDigitos.equals("44444444444444") ||
                cnpjSomenteDigitos.equals("55555555555555") ||
                cnpjSomenteDigitos.equals("66666666666666") ||
                cnpjSomenteDigitos.equals("77777777777777") ||
                cnpjSomenteDigitos.equals("88888888888888") ||
                cnpjSomenteDigitos.equals("99999999999999")
        ){return  false;}
        return true;

    }
}
