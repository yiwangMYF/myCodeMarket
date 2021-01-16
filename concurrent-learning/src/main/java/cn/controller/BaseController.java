package cn.controller;

import cn.excutors.Result;

/**
 * @Description 基础信息
 * @Author myf
 * @CreateDate 2021/1/9 17:25
 * @Version 1.0
 **/
public class BaseController {
    protected Result result;

    public BaseController() {
        this.result = new Result();
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
