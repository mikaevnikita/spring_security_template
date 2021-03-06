package ru.mikaev.blogstar.utils;

import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControllerUtils {
    public static Map<String, List<String>> getErrors(BindingResult bindingResult){
        Map<String, List<String>> errorsMap = new HashMap<>();

        bindingResult.getFieldErrors().stream().forEach(fieldError -> {
            String key = fieldError.getField() + "Errors";
            List<String> errors = errorsMap.get(key);
            if(errors == null) {
                errors = new ArrayList<>();
                errorsMap.put(key, errors);
            }
            errors.add(fieldError.getDefaultMessage());
        });
        return errorsMap;
    }
}
