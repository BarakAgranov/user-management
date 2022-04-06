package com.barak.group.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Locale;


@Slf4j
@ControllerAdvice
public class ExceptionsHandler extends ExceptionHandlerExceptionResolver {

    private ApplicationErrorBean applicationErrorBean = new ApplicationErrorBean();



    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ApplicationErrorBean onException(Exception e, HttpServletResponse response) {

        if (e instanceof ApplicationException) {
            ApplicationException appException = (ApplicationException) e;

            int errorNumber = appException.getErrorType().getErrorNumber();

            String errorMessage = appException.getMessage();

            String errorName = appException.getErrorType().getErrorName();

            response.setStatus(errorNumber);

            log.info("exception with message: -" + errorMessage);

            this.applicationErrorBean.setErrorMessage(errorMessage);
            this.applicationErrorBean.setErrorName(errorName);
            this.applicationErrorBean.setErrorNumber(errorNumber);

            if (appException.getErrorType().isShowingStackTrace()) {
                appException.printStackTrace();
            }

            return applicationErrorBean;
        }
        else if (e instanceof MethodArgumentNotValidException) {

            MethodArgumentNotValidException ex = (MethodArgumentNotValidException) e;

            String message = "";
            String newMessage = "";

            for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
                message = fieldError.getDefaultMessage().toLowerCase(Locale.ROOT);
                newMessage = newMessage + " - " + message;
            }

            log.info("exception with message: -" + newMessage);

            applicationErrorBean.setErrorMessage(newMessage);
            applicationErrorBean.setErrorNumber(400);
            applicationErrorBean.setErrorName("VALIDATION_ERROR");
            response.setStatus(400);
            e.printStackTrace();

            return applicationErrorBean;
        }
        else if (e instanceof TransactionSystemException) {

            ConstraintViolationException ex =
                    (ConstraintViolationException)((TransactionSystemException) e)
                            .getOriginalException().getCause();

            String message = "";
            String newMessage = "";

            for (ConstraintViolation violation : ex.getConstraintViolations()) {
                message = violation.getMessage().toLowerCase(Locale.ROOT);
                newMessage = newMessage + " - " + message;
            }

            log.info("exception with message: -" + newMessage);

            applicationErrorBean.setErrorMessage(newMessage);
            applicationErrorBean.setErrorNumber(400);
            applicationErrorBean.setErrorName("VALIDATION_ERROR");
            response.setStatus(400);
            e.printStackTrace();

            return applicationErrorBean;
        }

        else {
            applicationErrorBean.setErrorMessage("general error");
            applicationErrorBean.setErrorNumber(800);
            applicationErrorBean.setErrorName("GENERAL_ERROR");
            response.setStatus(800);
            e.printStackTrace();

            return applicationErrorBean;
        }

    }

}