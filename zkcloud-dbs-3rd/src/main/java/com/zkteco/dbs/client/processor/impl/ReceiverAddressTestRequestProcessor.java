package com.zkteco.dbs.client.processor.impl;

import com.zkcloud.api.dbs.common.Message;
import com.zkcloud.api.dbs.common.constant.ErrorCode;
import com.zkteco.dbs.client.constant.Sid;
import com.zkteco.dbs.client.processor.DataProcessor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @ClassName: ReceiverAddressTestRequestProcessor
 * @Description: DBS测试推送地址的请求处理器
 * @Author: <a href="mailto:huiwu.lin@zkteco.com">Lin Huiwu</a>
 * @Date: 2020-04-22
 * @Version: 1.0
 */
@Component
@Order
public class ReceiverAddressTestRequestProcessor implements DataProcessor {
    @Override
    public boolean match(Message request) {
        return Sid.PUSH_TEST.check(request.getSid());
    }

    @Override
    public Message handle(Message request) {
        return new Message(ErrorCode.CODE_SUCCESS, "success");
    }
}
