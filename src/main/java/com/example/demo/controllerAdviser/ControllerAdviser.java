package com.example.demo.controllerAdviser;

import com.example.demo.Api.ApiException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;


@ControllerAdvice
public class ControllerAdviser {


@ExceptionHandler(value = NoResourceFoundException.class)
    public ResponseEntity NoResourceFoundException(NoResourceFoundException e ){
        String message = e.getMessage();
return ResponseEntity.status(400).body(message);
    }

// غلط في طلب Mapping
    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity DataIntegrityViolationException (DataIntegrityViolationException e){
    String message = e.getMessage();
    return ResponseEntity.status(400).body(message);
    }

    ///    اذا كان العميل يريد اضافة تقييم ولايوجد ID لعامل الصيانه

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity IllegalArgumentException(IllegalArgumentException e){
    String message = e.getMessage();
    return ResponseEntity.status(400).body(message);
    }


@ExceptionHandler(value = MethodArgumentNotValidException.class)
    public  ResponseEntity MethodArgumentNotValidException(MethodArgumentNotValidException e){
    String message = e.getMessage();
    return ResponseEntity.status(400).body(message);
    }

    /// تقييم عامل الصيانه يجب ان يكون اكبر من صفر
@ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity ConstraintViolationException(ConstraintViolationException e){
    String message = e.getMessage();
    return ResponseEntity.status(400).body(message);
    }

    /// غلط في كتابة JSON

    @ExceptionHandler(value = HttpMessageNotReadableException.class)
public ResponseEntity HttpMessageNotReadableException (HttpMessageNotReadableException e){
        String message = e.getMessage();
        return ResponseEntity.status(400).body(message);
}

///يتعامل مع exception الي ضفتها في Service مثل اضافة حجز عامل صيانة (JobReservation service :  saveJobReservation)
@ExceptionHandler(value = ApiException.class)
public ResponseEntity ApiException(ApiException e){
    String message = e.getMessage();
    return ResponseEntity.status(400).body(message);
}


///غلط في path variable
@ExceptionHandler(value =MissingPathVariableException.class )
public ResponseEntity MissingPathVariableException (MissingPathVariableException e){
    String message = e.getMessage();
    return ResponseEntity.status(400).body(message);
}


}
