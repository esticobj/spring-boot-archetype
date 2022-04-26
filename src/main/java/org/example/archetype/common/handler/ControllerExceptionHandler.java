package org.example.archetype.common.handler;

import org.example.archetype.common.BaseResponse;
import org.example.archetype.common.BaseResponseUtil;
import org.example.archetype.common.exception.CommonErrorCode;
import org.example.archetype.common.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ControllerExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler
    public BaseResponse<String> handleException(Exception e){
        logger.error("系统异常", e);
        return BaseResponseUtil.fail(CommonErrorCode.UNKHOWN_ERROR.getCode(), "系统异常");
    }

    @ExceptionHandler
    public BaseResponse<String> handleServiceException(ServiceException e){
        logger.error("业务异常", e);
        return BaseResponseUtil.fail(e.getCode(), e.getMessage());
    }

    @ExceptionHandler
    public BaseResponse<String> handleConstraintViolationException(ConstraintViolationException e){
        return BaseResponseUtil.fail(CommonErrorCode.ERROR_PARAM_FORMAT.getCode(), e.getMessage());
    }

    @ExceptionHandler
    public BaseResponse<String> handleConstraintViolationException(BindException e){
        String errorMsg = e.getBindingResult().getAllErrors().stream().map((cv) -> cv == null ? "null" : cv.getObjectName() + ": " + cv.getDefaultMessage())
                .collect(Collectors.joining(", "));
        return BaseResponseUtil.fail(CommonErrorCode.ERROR_PARAM_FORMAT.getCode(), errorMsg);
    }
}
