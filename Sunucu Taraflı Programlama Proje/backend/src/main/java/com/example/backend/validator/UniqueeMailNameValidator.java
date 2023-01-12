package com.example.backend.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.backend.repository.UserRepository;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
public final class UniqueeMailNameValidator implements ConstraintValidator<UniqueeMail, String> {
    private final UserRepository userRepository;
    @Override
    public boolean isValid(String eMail, ConstraintValidatorContext context) {
        return !userRepository.existsUserByUsername(eMail);
    }
}
