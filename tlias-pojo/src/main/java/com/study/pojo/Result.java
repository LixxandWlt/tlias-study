package com.study.pojo;

import lombok.Data;

/**
 * 统一响应结果Result
 */
@Data
public class Result {
    private Integer code; // 状态码：1成功，0失败
    private String msg; // 错误信息
    private Object data; // 返回数据

    /**
     * 成功
     * @return
     */
    public static Result success() {
        Result result = new Result();
        result.code = 1;
        result.msg = "操作成功";
        return result;
    }

    /**
     * 成功
     * @param object // 返回数据
     * @return
     */
    public static Result success(Object object) {
        Result result = new Result();
        result.code = 1;
        result.msg = "操作成功";
        result.data = object;
        return result;
    }

    /**
     * 失败
     * @param msg
     * @return
     */
    public static Result error(String msg) {
        Result result = new Result();
        result.code = 0;
        result.msg = msg;
        return result;
    }
}
