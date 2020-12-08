package com.zkteco.dbs.client.processor.impl;

import cn.hutool.core.convert.Convert;
import com.zkcloud.api.dbs.common.Message;
import com.zkteco.dbs.client.constant.ErrorCode;
import com.zkteco.dbs.client.constant.Sid;
import com.zkteco.dbs.client.model.DoorRealStatuss;
import com.zkteco.dbs.client.model.DoorTransactionRecords;
import com.zkteco.dbs.client.processor.DataProcessor;
import com.zkteco.dbs.client.util.GsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/****
 * 门实时状态
 *
 * @author howard.liu
 * @date 2020/10/9 11:01
 * @since 1.0.0
 */
@Component
@Order(1)
@ConditionalOnExpression("${dbs.push.switch.doorRealStatus:false}")
public class DoorRealStatusProcessor implements DataProcessor {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean match(Message request) {
        return Sid.DOOR_REAL_STATUS.check(request.getSid());
    }

    @Override
    public Message handle(Message request) {
        DoorRealStatuss doorRealStatuss = Convert.convert(DoorRealStatuss.class, request.getPayload().getParams());
        // TODO: 门实时状态记录
        logger.debug("DoorRealStatusProcessor：" + GsonUtil.toJson(doorRealStatuss));
        return new Message(ErrorCode.CODE_SUCCESS.getCode(), ErrorCode.CODE_SUCCESS.getMessage());
    }
}
