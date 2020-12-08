package com.zkteco.dbs.client.processor.impl;

import com.zkcloud.api.dbs.common.Message;
import com.zkteco.dbs.client.model.ReceiverDTO;
import com.zkteco.dbs.client.processor.PreReceiverProcessor;
import com.zkteco.dbs.client.util.GsonUtil;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(3)
public class DataConverProcessor implements PreReceiverProcessor {

    @Override
    public ReceiverDTO handle(ReceiverDTO receiver) {
        receiver.setRequest(GsonUtil.fromJson(receiver.getRequestStr(), Message.class));
        return receiver;
    }
}
