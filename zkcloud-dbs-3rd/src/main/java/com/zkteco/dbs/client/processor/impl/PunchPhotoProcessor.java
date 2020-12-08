package com.zkteco.dbs.client.processor.impl;

import cn.hutool.core.convert.Convert;
import com.zkcloud.api.dbs.common.Message;
import com.zkteco.dbs.client.constant.ErrorCode;
import com.zkteco.dbs.client.constant.Sid;
import com.zkteco.dbs.client.model.PunchPhotos;
import com.zkteco.dbs.client.processor.DataProcessor;
import com.zkteco.dbs.client.util.GsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @ClassName: PunchPhotoProcessor
 * @Description: 打卡照片处理器
 * @Author: <a href="mailto:huiwu.lin@zkteco.com">Lin Huiwu</a>
 * @Date: 2020-04-23
 * @Version: 1.0
 */
@Component
@Order(1)
@ConditionalOnExpression("${dbs.push.switch.punchPhoto:false}")
public class PunchPhotoProcessor implements DataProcessor {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean match(Message request) {
        return Sid.PUNCH_PHOTO.check(request.getSid());
    }

    @Override
    public Message handle(Message request) {
        PunchPhotos photos = Convert.convert(PunchPhotos.class, request.getPayload().getParams());
        // TODO: 处理打卡照片
        logger.debug("PunchPhotoProcessor：" + GsonUtil.toJson(photos));
        return new Message(ErrorCode.CODE_SUCCESS.getCode(), ErrorCode.CODE_SUCCESS.getMessage());
    }

}
