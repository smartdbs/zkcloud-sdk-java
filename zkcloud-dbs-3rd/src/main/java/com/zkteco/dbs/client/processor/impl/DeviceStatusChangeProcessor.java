package com.zkteco.dbs.client.processor.impl;

import cn.hutool.core.convert.Convert;
import com.zkcloud.api.dbs.common.Message;
import com.zkteco.dbs.client.constant.ErrorCode;
import com.zkteco.dbs.client.constant.Sid;
import com.zkteco.dbs.client.model.DeviceStatusChange;
import com.zkteco.dbs.client.processor.DataProcessor;
import com.zkteco.dbs.client.util.GsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @ClassName: DeviceStatusChangeProcessor
 * @Description: 设备在线/离线事件
 * @Author: <a href="mailto:huiwu.lin@zkteco.com">Lin Huiwu</a>
 * @Date: 2020-04-23
 * @Version: 1.0
 */
@Component
@Order(1)
@ConditionalOnExpression("${dbs.push.switch.deviceStatus:false}")
public class DeviceStatusChangeProcessor implements DataProcessor {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean match(Message request) {
        return Sid.DEVICE_STATUS_CHANGE.check(request.getSid());
    }

    @Override
    public Message handle(Message request) {
        DeviceStatusChange deviceStatusChange = Convert.convert(DeviceStatusChange.class, request.getPayload().getParams());
        // TODO: 设备在线离线事件处理
        logger.debug("DeviceStatusChangeProcessor：" + GsonUtil.toJson(deviceStatusChange));
        return new Message(ErrorCode.CODE_SUCCESS.getCode(), ErrorCode.CODE_SUCCESS.getMessage());
    }
}
