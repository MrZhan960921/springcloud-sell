package com.zcq.utils;


import com.zcq.model.vo.ResultVO;

/**
 * @author Maybeeeee
 * @date 2019-09-08 23:00
 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }
}
