package com.barak.user.exceptions;

import com.barak.user.enums.ErrorType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

// Exception handler class
@RestControllerAdvice
public class ExceptionsHandler {

    //	Response - Object in Spring
    @ExceptionHandler
    @ResponseBody
    // Variable name is throwable in order to remember that it handles Exception and Error
    public ErrorBean toResponse(Throwable throwable, HttpServletResponse response) {

        //	ErrorBean errorBean;
        if(throwable instanceof ApplicationException) {

            ApplicationException appException = (ApplicationException) throwable;

            ErrorType errorType = appException.getErrorType();
            int errorNumber = errorType.getErrorNumber();
            String errorMessage = errorType.getErrorMessage();
            String errorName = errorType.getErrorName();
            response.setStatus(errorNumber);

            ErrorBean errorBean = new ErrorBean(errorNumber, errorName, errorMessage);
            if(appException.getErrorType().isShowingStackTrace()) {
                appException.printStackTrace();
            }

            return errorBean;
        }

        response.setStatus(800);

        String errorMessage = throwable.getMessage();
        ErrorBean errorBean = new ErrorBean(800, "General error", errorMessage);
        throwable.printStackTrace();

        return errorBean;
    }

}