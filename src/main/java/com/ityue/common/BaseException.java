package com.ityue.common;


import com.ityue.controller.ex.*;
import com.ityue.service.ex.*;
import com.ityue.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice(annotations = {ResponseBody.class, Controller.class,Service.class})
@ResponseBody
public class BaseException {

    public static final Integer OK = 200;

    @ExceptionHandler({ServiceException.class,FileUploadException.class})
    public JsonResult<Void> exceptionHandler(Exception e){
        JsonResult<Void> result = new JsonResult<>(e);
        if (e instanceof UsernameDuplicatedException){
            result.setState(4000);
        }else if (e instanceof UserNotException){
            result.setState(5001);
        }else if (e instanceof PasswordNotMatchException){
            result.setState(5002);
        }else if (e instanceof InsertException){
            result.setState(5000);
        }else if (e instanceof UpdateException){
            result.setState(5001);
        }else if (e instanceof FileEmptyException){
            result.setState(6000);
        }else if (e instanceof FileSizeException){
            result.setState(6001);
        }else if (e instanceof FileStateException){
            result.setState(6002);
        }else if (e instanceof FiletypeException){
            result.setState(6003);
        }else if (e instanceof FileUploadIOException){
            result.setState(6004);
        }
        return result;
    }
}
