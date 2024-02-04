package com.lxy.loj.judge.codesandbox;

import com.lxy.loj.judge.codesandbox.model.ExecuteCodeRequest;
import com.lxy.loj.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * 代码沙箱接口定义
 */
public interface CodeSandbox {
    /**
     * 通用接口方法
     *
     *
     * @param executeCodeRequest
     * @return
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}