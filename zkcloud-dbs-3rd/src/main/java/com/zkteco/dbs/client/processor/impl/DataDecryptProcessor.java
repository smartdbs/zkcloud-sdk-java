package com.zkteco.dbs.client.processor.impl;

import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import com.zkteco.dbs.client.model.ReceiverDTO;
import com.zkteco.dbs.client.processor.PreReceiverProcessor;
import com.zkteco.dbs.client.processor.config.DbsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @ClassName: DataDecryptProcessor
 * @Description: 数据解密，当推送配置开启了数据加密后使用，默认不加密
 * @Author: <a href="mailto:huiwu.lin@zkteco.com">Lin Huiwu</a>
 * @Date: 2020-04-22
 * @Version: 1.0
 */
@Component
@Order(2)
@ConditionalOnExpression("${dbs.push.switch.encrypt:false}")
public class DataDecryptProcessor implements PreReceiverProcessor {

    @Autowired
    private DbsConfig dbsConfig;

    @Override
    public ReceiverDTO handle(ReceiverDTO receiver) {
        String json = new SymmetricCrypto(SymmetricAlgorithm.AES, dbsConfig.getPushSecret().getBytes()).decryptStr(receiver.getRequestStr());
        receiver.setRequestStr(json);
        return receiver;
    }
}
