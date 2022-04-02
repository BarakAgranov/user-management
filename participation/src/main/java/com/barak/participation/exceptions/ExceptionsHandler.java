package com.barak.participation.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import javax.servlet.http.HttpServletResponse;

// Exception handler class
@ControllerAdvice
public class ExceptionsHandler extends ExceptionHandlerExceptionResolver {

    //	Response - Object in Spring
    @ExceptionHandler
    @ResponseBody
    // Variable name is throwable in order to remember that it handles Exception and Error
    public ErrorBean toResponse(Throwable throwable, HttpServletResponse response) {


        //	ErrorBean errorBean;
        if(throwable instanceof ApplicationException) {

            ApplicationException appException = (ApplicationException) throwable;

            int errorNumber = appException.getErrorType().getErrorNumber();

            String errorMessage = appException.getMessage();

            String errorName = appException.getErrorType().getErrorName();

            response.setStatus(errorNumber);


            ErrorBean errorBean = new ErrorBean();

            errorBean.setErrorMessage(errorMessage);
            errorBean.setErrorName(errorName);
            errorBean.setErrorNumber(errorNumber);

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