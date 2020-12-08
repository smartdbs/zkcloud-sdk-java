package com.zkteco.dbs.client.model;

import com.zkcloud.api.dbs.common.Message;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReceiverDTO {
    private Long timestamp;
    private String nonce;
    private String sign;
    private String requestStr;
    private Message request;
    private String sid;

    public ReceiverDTO(Long timestamp, String nonce, String sign, String requestStr) {
        this.timestamp = timestamp;
        this.nonce = nonce;
        this.sign = sign;
        this.requestStr = requestStr;
    }

    @Override
    public String toString() {
        return "ReceiverDTO{" +
                "timestamp=" + timestamp +
                ", nonce='" + nonce + '\'' +
                ", sign='" + sign + '\'' +
                ", requestStr='" + requestStr + '\'' +
                '}';
    }
}
