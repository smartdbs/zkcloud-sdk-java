package com.zkteco.dbs.client.processor.impl;

import cn.hutool.core.convert.Convert;
import com.zkcloud.api.dbs.common.Message;
import com.zkteco.dbs.client.constant.ErrorCode;
import com.zkteco.dbs.client.constant.Sid;
import com.zkteco.dbs.client.model.RegisterFpTip;
import com.zkteco.dbs.client.processor.DataProcessor;
import com.zkteco.dbs.client.util.GsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @ClassName: RegisterFpTipProcessor
 * @Description: 远程登记指纹进度通知
 * @Author: <a href="mailto:huiwu.lin@zkteco.com">Lin Huiwu</a>
 * @Date: 2020-04-23
 * @Version: 1.0
 */
@Component
@Order(1)
@ConditionalOnExpression("${dbs.push.switch.registerFpTip:false}")
public class RegisterFpTipProcessor implements DataProcessor {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean match(Message request) {
        return Sid.REGISTER_FP_TIP.check(request.getSid());
    }

    @Override
    public Message handle(Message request) {
        RegisterFpTip registerFpTip = Convert.convert(RegisterFpTip.class, request.getPayload().getParams());
        // TODO: 设备远程登记指纹进度处理
        logger.debug("RegisterFpTipProcessor：" + GsonUtil.toJson(registerFpTip));
        return new Message(ErrorCode.CODE_SUCCESS.getCode(), ErrorCode.CODE_SUCCESS.getMessage());
    }
}
