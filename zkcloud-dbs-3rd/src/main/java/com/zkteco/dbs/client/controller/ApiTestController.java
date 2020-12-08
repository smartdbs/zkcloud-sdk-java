package com.zkteco.dbs.client.controller;

import com.zkcloud.api.dbs.common.Message;
import com.zkcloud.api.dbs.model.CompanyRequest;
import com.zkcloud.api.dbs.model.CreateCompanyResponse;
import com.zkcloud.api.dbs.model.EmployeeUpdateRequest;
import com.zkcloud.api.dbs.model.User;
import com.zkteco.dbs.client.DBSApi;
import com.zkteco.dbs.client.constant.ErrorCode;
import com.zkteco.dbs.client.exception.ExceptionAdvice;
import com.zkteco.dbs.client.model.ReceiverDTO;
import com.zkteco.dbs.client.processor.DataProcessor;
import com.zkteco.dbs.client.processor.PreReceiverProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * api接口调用示例
 */
@RestController
@ExceptionAdvice
public class ApiTestController {


    @RequestMapping(value = "/dbs/testCreateCompany", method = RequestMethod.POST)
    @ResponseBody
    public Message testCreateCompany() {
        CompanyRequest companyRequest = new CompanyRequest("C1004", "天行科技", "huiwu.lin123@zkteco.com");
        Message<CreateCompanyResponse> response = DBSApi.dbsClient.createCompany(companyRequest);
        return response;
    }
    @RequestMapping(value = "/dbs/testUpdateEmployee", method = RequestMethod.POST)
    @ResponseBody
    public Message testUpdateEmployee() {
        EmployeeUpdateRequest employee = new EmployeeUpdateRequest("2956", "惠武", "林", "林惠武");
        //employee.setOrganization(Arrays.asList("10001"));
        employee.setApiUser(new User("huiwu.lin123@zkteco.com", "IubkQb"));
        Message response = DBSApi.dbsClient.updateEmployee(employee);
        return response;
    }

}
