package com.zkteco.dbs.client.processor.impl;

import cn.hutool.core.convert.Convert;
import com.zkcloud.api.dbs.common.Message;
import com.zkteco.dbs.client.constant.ErrorCode;
import com.zkteco.dbs.client.constant.Sid;
import com.zkteco.dbs.client.model.DeviceInit;
import com.zkteco.dbs.client.processor.DataProcessor;
import com.zkteco.dbs.client.util.GsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @ClassName: DeviceInitProcessor
 * @Description: 设备初始化
 * @Author: <a href="mailto:huiwu.lin@zkteco.com">Lin Huiwu</a>
 * @Date: 2020-04-23
 * @Version: 1.0
 */
@Component
@Order(1)
@ConditionalOnExpression("${dbs.push.switch.deviceInit:false}")
public class DeviceInitProcessor implements DataProcessor {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean match(Message request) {
        return Sid.DEVICE_INIT.check(request.getSid());
    }

    @Override
    public Message handle(Message request) {
        DeviceInit deviceInit = Convert.convert(DeviceInit.class, request.getPayload().getParams());
        // TODO: 设备初始化记录
        logger.debug("DeviceInitProcessor：" + GsonUtil.toJson(deviceInit));
        return new Message(ErrorCode.CODE_SUCCESS.getCode(), ErrorCode.CODE_SUCCESS.getMessage());
    }
}
