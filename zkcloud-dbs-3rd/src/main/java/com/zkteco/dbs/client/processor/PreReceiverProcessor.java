package com.zkteco.dbs.client.processor;

import com.zkteco.dbs.client.model.ReceiverDTO;

public interface PreReceiverProcessor {
    ReceiverDTO handle(ReceiverDTO receiver);
}
