
package com.zkteco.dbs.client.exception;

import com.zkcloud.api.dbs.common.Message;
import com.zkcloud.api.dbs.exception.ZKCloudSDKException;
import com.zkteco.dbs.client.constant.ErrorCode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

/**
 * @ClassName: GlobalExceptionHandler
 * @Description: 全局异常，当前仅针对ExceptionAdvice自定义注解
 * @Author: <a href="mailto:huiwu.lin@zkteco.com">Lin Huiwu</a>
 * @Date: 2020-04-23
 * @Version: 1.0
 */
@ControllerAdvice(annotations = {ExceptionAdvice.class})
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(getClass());


    /**
     * 全局捕获ZKCloudSDKException异常
     * @param e
     * @return
     */
    @ExceptionHandler(ZKCloudSDKException.class)
    @ResponseBody
    public Message zkExceptionHandler(ZKCloudSDKException e) {
        logger.error(e.getMessage(), e);
        return new Message(e.getCode(), e.getMessage());
    }


    /**
     * 参数类型异常
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseBody
    public Message missingRequestParamterExceptionHandler(Exception e) {
        logger.error(e.getMessage(), e);
        return new Message(ErrorCode.CODE_ERROR_PARAM_TYPE.getCode(), ErrorCode.CODE_ERROR_PARAM_TYPE.getMessage());
    }

    /**
     * 参数转换异常
     * @param e
     * @return
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public Message messageNotReadableHandler(Exception e) {
        logger.error(e.getMessage(), e);
        return new Message(ErrorCode.CODE_ERROR_PARAM_NOT_READ.getCode(), ErrorCode.CODE_ERROR_PARAM_NOT_READ.getMessage());
    }

    /**
     * 其他未知异常
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Message exceptionHandler(Exception e) {
        logger.error(e.getMessage(), e);
        return new Message(ErrorCode.CODE_ERROR_GLOBAL_EXCEPTION.getCode(), ErrorCode.CODE_ERROR_GLOBAL_EXCEPTION.getMessage());
    }
}
