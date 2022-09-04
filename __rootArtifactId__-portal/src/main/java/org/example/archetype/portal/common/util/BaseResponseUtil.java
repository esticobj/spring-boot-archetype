package org.example.archetype.portal.common.util;

import org.example.archetype.portal.common.exception.CommonErrorCode;

public class BaseResponseUtil {
    private BaseResponseUtil() {}

    public static <T> BaseResponse<T> make(String code, String msg, T data){
        return new BaseResponse<>(code, msg, data);
    }

    public static <T> BaseResponse<T> ok(){
        return new BaseResponse<>(CommonErrorCode.SUCCESS.getCode(), null);
    }

    public static <T> BaseResponse<T> ok(T data){
        return new BaseResponse<>(CommonErrorCode.SUCCESS.getCode(), null, data);
    }

    public static <T> BaseResponse<T> fail(String code, String msg){
        return new BaseResponse<>(code, msg);
    }
}
