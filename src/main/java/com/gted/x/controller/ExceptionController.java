package com.gted.x.controller;

import com.gted.x.entity.Response;
import com.gted.x.exception.EntityNotFoundException;
import com.gted.x.exception.JobException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Вадим on 02.10.2017.
 */

@ControllerAdvice
@ResponseBody
public class ExceptionController {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Response handleNotFoundException(EntityNotFoundException e) {
        return new Response(HttpServletResponse.SC_NOT_FOUND,e.getMessage());
    }

    @ExceptionHandler(JobException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response handleJobException(JobException e) {
        return new Response(HttpServletResponse.SC_BAD_REQUEST,e.getMessage());
    }


}
