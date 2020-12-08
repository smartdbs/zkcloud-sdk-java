package com.zkteco.dbs.client.processor.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.crypto.SecureUtil;
import com.zkcloud.api.dbs.exception.ZKCloudSDKException;
import com.zkteco.dbs.client.constant.ErrorCode;
import com.zkteco.dbs.client.model.ReceiverDTO;
import com.zkteco.dbs.client.processor.PreReceiverProcessor;
import com.zkteco.dbs.client.processor.config.DbsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @ClassName: RequestValidProcessor
 * @Description: DBS数据推送请求签名验证
 * @Author: <a href="mailto:huiwu.lin@zkteco.com">Lin Huiwu</a>
 * @Date: 2020-04-23
 * @Version: 1.0
 */
@Component
@Order(1)
@ConditionalOnExpression("${dbs.push.switch.signVerify:false}")
public class RequestValidProcessor implements PreReceiverProcessor {

    // 根据参数dbs.push.switch.signVerify配置是否开启签名验证机制

    @Autowired
    private DbsConfig dbsConfig;

    @Override
    public ReceiverDTO handle(ReceiverDTO receiver) {

        // 验证时间戳
        if (Math.abs(DateUtil.currentSeconds() - receiver.getTimestamp()) > dbsConfig.getValidRangTime()) {
            throw new ZKCloudSDKException(ErrorCode.CODE_INVALID.getMessage(), ErrorCode.CODE_INVALID.getCode());
        }

        // 验证签名
        String checkSign = SecureUtil.md5(receiver.getTimestamp() + receiver.getNonce() + dbsConfig.getPushToken());
        if (!checkSign.equals(receiver.getSign())) {
            throw new ZKCloudSDKException(ErrorCode.CODE_ERROR_SIGN.getMessage(), ErrorCode.CODE_ERROR_SIGN.getCode());
        }
        return null;
    }
}
