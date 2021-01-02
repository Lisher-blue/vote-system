package com.sha.exception.handler;

import com.sha.exception.UserException;
import com.sha.exception.msg.UserMessage;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Lisher
 */
@ControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(UserException.class)
    public String handlerException(UserException e, Model model) {
        UserMessage userMessage = e.getUserMessage();
        model.addAttribute("err",userMessage);
        return "err";
    }
}
