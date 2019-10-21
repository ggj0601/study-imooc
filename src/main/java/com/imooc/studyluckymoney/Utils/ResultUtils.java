package com.imooc.studyluckymoney.Utils;

import com.imooc.studyluckymoney.domain.Result;

public class ResultUtils {

    public static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMessage("成功");
        result.setData(object);
        return result;
    }
    public static Result success(){
        return success(null);
    }
    public static Result error(Integer errorcode, String errormsg){
        Result result = new Result();
        result.setCode(errorcode);
        result.setMessage(errormsg);
        result.setData(null);
        return result;
    }
}
