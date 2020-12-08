package com.zkteco.dbs.client.processor.impl;

import cn.hutool.core.convert.Convert;
import com.zkcloud.api.dbs.common.Message;
import com.zkteco.dbs.client.constant.ErrorCode;
import com.zkteco.dbs.client.constant.Sid;
import com.zkteco.dbs.client.model.DeviceInit;
import com.zkteco.dbs.client.model.DoorInit;
import com.zkteco.dbs.client.processor.DataProcessor;
import com.zkteco.dbs.client.util.GsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/****
 * 门初始化事件
 *
 * @author howard.liu
 * @date 2020/10/9 11:01
 * @since 1.0.0
 */
@Component
@Order(1)
@ConditionalOnExpression("${dbs.push.switch.doorInit:false}")
public class DoorInitProcessor implements DataProcessor {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean match(Message request) {
        return Sid.DOOR_INIT.check(request.getSid());
    }

    @Override
    public Message handle(Message request) {
        DoorInit doorInit = Convert.convert(DoorInit.class, request.getPayload().getParams());
        // TODO: 门初始化记录
        logger.debug("DoorInitProcessor：" + GsonUtil.toJson(doorInit));
        return new Message(ErrorCode.CODE_SUCCESS.getCode(), ErrorCode.CODE_SUCCESS.getMessage());
    }
}
