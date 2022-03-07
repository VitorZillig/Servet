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
        String cpfSomenteDigitos = cnpj.replaceAll("\\D", "");


        if(cpfSomenteDigitos == null ||
                cpfSomenteDigitos.length() != 14 ||
                cpfSomenteDigitos.equals("00000000000000") ||
                cpfSomenteDigitos.equals("11111111111111") ||
                cpfSomenteDigitos.equals("22222222222222") ||
                cpfSomenteDigitos.equals("33333333333333") ||
                cpfSomenteDigitos.equals("44444444444444") ||
                cpfSomenteDigitos.equals("55555555555555") ||
                cpfSomenteDigitos.equals("66666666666666") ||
                cpfSomenteDigitos.equals("77777777777777") ||
                cpfSomenteDigitos.equals("88888888888888") ||
                cpfSomenteDigitos.equals("99999999999999")
        ){return  false;}
        return true;

    }
}
