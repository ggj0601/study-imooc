package com.imooc.studyluckymoney.handle;

import com.imooc.studyluckymoney.Utils.ResultUtils;
import com.imooc.studyluckymoney.domain.Result;
import com.imooc.studyluckymoney.enums.ResultEnums;
import com.imooc.studyluckymoney.exception.GirlException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof GirlException){
            GirlException girlException = (GirlException)e;
            return ResultUtils.error(girlException.getCode(), girlException.getMessage());
        }else {
            return ResultUtils.error(ResultEnums.UNKONW_ERROR.getCode(), ResultEnums.UNKONW_ERROR.getMsg());
        }
    }
}
