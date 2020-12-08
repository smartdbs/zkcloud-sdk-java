package com.zkteco.dbs.client.model;

import lombok.Data;

import java.util.List;

/**
 * @ClassName: PunchPhotos
 * @Description: 打卡照片
 * @Author: <a href="mailto:huiwu.lin@zkteco.com">Lin Huiwu</a>
 * @Date: 2020-04-23
 * @Version: 1.0
 */
@Data
public class PunchPhotos extends BaseModel {

    private List<PunchPhoto> punchPhotos;

    @Data
    class PunchPhoto {
        private String sn;
        private String employeeNo;
        private Long punchTime;
        private String photo;
    }
}
