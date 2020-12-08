package com.zkteco.dbs.client.processor;

import com.zkcloud.api.dbs.common.Message;

public interface DataProcessor {
    boolean match(Message request);

    Message handle(Message request);
}
