package com.lxy.loj.service;

import com.lxy.loj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.lxy.loj.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lxy.loj.model.entity.User;

/**
* @author 爱宕
* @description 针对表【question_submit(题目提交)】的数据库操作Service
* @createDate 2024-01-18 18:34:43
*/
public interface QuestionSubmitService extends IService<QuestionSubmit> {

    /**
     * 题目提交
     *
     * @param 题目提交信息
     * @param loginUser
     * @return
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);

}
