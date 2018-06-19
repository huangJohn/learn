package com.example.controller;

import com.example.constant.ControllerError;
import com.example.exception.StudyRuntimeException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SampleController {

    @RequestMapping("/{error}")
    public String testException(@PathVariable("error") String error) {
        switch (error) {
            case "0":
                throw new StudyRuntimeException(ControllerError.SYSTEM_ERROR);
            case "1":
                throw new StudyRuntimeException(ControllerError.PARAMETER_INVALID_ERROR);
            case "2":
                throw new StudyRuntimeException(ControllerError.NOT_PERMISSION_ERROR);
            default:
                throw new StudyRuntimeException(ControllerError.SYSTEM_ERROR);
        }
    }

}