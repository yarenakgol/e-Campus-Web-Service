package com.example.backend.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.backend.repository.UserRepository;

import lombok.RequiredArgsConstructor;

/**
 *
 * @author KadirRA
 * @since 1.0
 */
@RequiredArgsConstructor
public final class UniquePhoneNoValidator implements ConstraintValidator<UniquePhoneNo, String> {

    private final UserRepository userRepository;

    @Override
    public boolean isValid(String ogrNo, ConstraintValidatorContext context) {
        return !userRepository.existsUserByUsername(ogrNo);
    }

}
