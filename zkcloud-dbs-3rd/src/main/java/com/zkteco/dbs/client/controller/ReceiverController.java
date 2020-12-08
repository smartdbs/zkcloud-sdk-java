package com.zkteco.dbs.client.controller;

import com.zkcloud.api.dbs.common.Message;
import com.zkteco.dbs.client.constant.ErrorCode;
import com.zkteco.dbs.client.exception.ExceptionAdvice;
import com.zkteco.dbs.client.model.ReceiverDTO;
import com.zkteco.dbs.client.processor.DataProcessor;
import com.zkteco.dbs.client.processor.PreReceiverProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 数据推送 示例地址
 */
@RestController
@ExceptionAdvice
public class ReceiverController {

    @Autowired(required = false)
    private DataProcessor[] dataProcessors;

    @Autowired(required = false)
    private PreReceiverProcessor[] preReceiverProcessors;

    @RequestMapping(value = "/dbs/receiver", method = RequestMethod.POST)
    @ResponseBody
    public Message receiver(@RequestParam Long timestamp, @RequestParam String nonce, @RequestParam String sign, @RequestBody String request) {

        ReceiverDTO receiverDTO = new ReceiverDTO(timestamp, nonce, sign, request);
        if (preReceiverProcessors != null) {
            for (PreReceiverProcessor preReceiverProcessor : preReceiverProcessors) {
                preReceiverProcessor.handle(receiverDTO);
            }
        }

        if (dataProcessors != null) {
            for (DataProcessor processor : dataProcessors) {
                if (processor.match(receiverDTO.getRequest())) {
                    return processor.handle(receiverDTO.getRequest());
                }
            }
        }

        return new Message(ErrorCode.CODE_NOT_SUPPORT.getCode(), ErrorCode.CODE_NOT_SUPPORT.getMessage());
    }


}
