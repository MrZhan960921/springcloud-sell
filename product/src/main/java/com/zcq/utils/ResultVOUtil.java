package com.zcq.utils;

import com.zcq.model.vo.ResultVO;

/**
 * @author Maybeeeee
 * @date 2019-09-08 21:29
 */
public class ResultVOUtil {

    public static ResultVO success(Object data) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(data);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }
}
