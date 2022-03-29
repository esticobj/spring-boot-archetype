package org.example.archetype.common.handler;

import org.example.archetype.common.BaseResponse;
import org.example.archetype.common.BaseResponseUtil;
import org.example.archetype.common.exception.CommonErrorCode;
import org.example.archetype.common.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler
    public BaseResponse<String> handleException(Exception e){
        logger.error("controller抛出了异常", e);
        return BaseResponseUtil.fail(CommonErrorCode.UNKHOWN_ERROR.getCode(), "系统异常");
    }

    @ExceptionHandler
    public BaseResponse<String> handleServiceException(ServiceException e){
        logger.error("controller抛出了异常", e);
        return BaseResponseUtil.fail(e.getCode(), e.getMessage());
    }
}
