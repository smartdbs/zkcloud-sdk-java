package com.zkcloud.api.dbs;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONUtil;
import com.zkcloud.api.dbs.common.Credential;
import com.zkcloud.api.dbs.common.Message;
import com.zkcloud.api.dbs.common.constant.ErrorCode;
import com.zkcloud.api.dbs.common.profile.HttpProfile;
import com.zkcloud.api.dbs.common.profile.Language;
import com.zkcloud.api.dbs.exception.ZKCloudSDKException;
import com.zkcloud.api.dbs.model.AlarmCancelRequest;
import com.zkcloud.api.dbs.model.AntiPassBackDeleteRequest;
import com.zkcloud.api.dbs.model.AntiPassBackUpdateRequest;
import com.zkcloud.api.dbs.model.AuxInQueryRequest;
import com.zkcloud.api.dbs.model.AuxInQueryResponse;
import com.zkcloud.api.dbs.model.AuxInUpdateRequest;
import com.zkcloud.api.dbs.model.AuxOutQueryRequest;
import com.zkcloud.api.dbs.model.AuxOutQueryResponse;
import com.zkcloud.api.dbs.model.AuxOutUpdateRequest;
import com.zkcloud.api.dbs.model.BiotemplateRequest;
import com.zkcloud.api.dbs.model.CancelRegisterBiometricRequest;
import com.zkcloud.api.dbs.model.CancelRegisterFpRequest;
import com.zkcloud.api.dbs.model.CommandListByPageRequest;
import com.zkcloud.api.dbs.model.CommandListByPageResponse;
import com.zkcloud.api.dbs.model.CompanyRequest;
import com.zkcloud.api.dbs.model.CreateCompanyResponse;
import com.zkcloud.api.dbs.model.CreateDeviceRequest;
import com.zkcloud.api.dbs.model.DeviceDeleteRequest;
import com.zkcloud.api.dbs.model.DeviceDisableRequest;
import com.zkcloud.api.dbs.model.DeviceEnableRequest;
import com.zkcloud.api.dbs.model.DeviceQueryRequest;
import com.zkcloud.api.dbs.model.DeviceQueryResponse;
import com.zkcloud.api.dbs.model.DeviceRebootRequest;
import com.zkcloud.api.dbs.model.FirstOpenDeleteRequest;
import com.zkcloud.api.dbs.model.FirstOpenUpdateRequest;
import com.zkcloud.api.dbs.model.InterLockDeleteRequest;
import com.zkcloud.api.dbs.model.InterLockUpdateRequest;
import com.zkcloud.api.dbs.model.LinkageDeleteRequest;
import com.zkcloud.api.dbs.model.LinkageUpdateRequest;
import com.zkcloud.api.dbs.model.ReloadDeviceInfoRequest;
import com.zkcloud.api.dbs.model.ReloadDeviceRecordRequest;
import com.zkcloud.api.dbs.model.DeviceRefreshEmployeeRequest;
import com.zkcloud.api.dbs.model.DeviceReloadEmployeeRequest;
import com.zkcloud.api.dbs.model.DeviceReloadPunchRequest;
import com.zkcloud.api.dbs.model.DeviceUpdateRequest;
import com.zkcloud.api.dbs.model.DeviceUpgradeBatchRequest;
import com.zkcloud.api.dbs.model.DeviceUpgradeBatchResponse;
import com.zkcloud.api.dbs.model.DeviceUpgradeHistoryRequest;
import com.zkcloud.api.dbs.model.DeviceUpgradeHistoryResponse;
import com.zkcloud.api.dbs.model.DeviceUpgradeRequest;
import com.zkcloud.api.dbs.model.DeviceUpgradeResponse;
import com.zkcloud.api.dbs.model.DoorCloseRequest;
import com.zkcloud.api.dbs.model.DoorHolidayDeleteRequest;
import com.zkcloud.api.dbs.model.DoorHolidayUpdateRequest;
import com.zkcloud.api.dbs.model.DoorParam;
import com.zkcloud.api.dbs.model.DoorParamQueryRequest;
import com.zkcloud.api.dbs.model.DoorParamQueryResponse;
import com.zkcloud.api.dbs.model.DoorParamUpdateRequest;
import com.zkcloud.api.dbs.model.DoorPasswordDeleteRequest;
import com.zkcloud.api.dbs.model.DoorPasswordOpenRequest;
import com.zkcloud.api.dbs.model.DoorPasswordUpdateRequest;
import com.zkcloud.api.dbs.model.DoorPermissionGroupAddDoorDevice;
import com.zkcloud.api.dbs.model.DoorPermissionGroupAddDoorRequest;
import com.zkcloud.api.dbs.model.DoorPermissionGroupAddEmployeeRequest;
import com.zkcloud.api.dbs.model.DoorPermissionGroupDeleteRequest;
import com.zkcloud.api.dbs.model.DoorPermissionGroupRemoveAllEmployeeRequest;
import com.zkcloud.api.dbs.model.DoorPermissionGroupRemoveDoorRequest;
import com.zkcloud.api.dbs.model.DoorPermissionGroupRemoveEmployeeRequest;
import com.zkcloud.api.dbs.model.DoorPermissionGroupUpdateRequest;
import com.zkcloud.api.dbs.model.DoorQRCodeRequest;
import com.zkcloud.api.dbs.model.DoorQRCodeResponse;
import com.zkcloud.api.dbs.model.DoorQueryRequest;
import com.zkcloud.api.dbs.model.DoorQueryResponse;
import com.zkcloud.api.dbs.model.DoorTimeZoneDeleteRequest;
import com.zkcloud.api.dbs.model.DoorTimeZoneDetail;
import com.zkcloud.api.dbs.model.DoorTimeZoneUpdateRequest;
import com.zkcloud.api.dbs.model.DoorTransactionRecordRequest;
import com.zkcloud.api.dbs.model.DoorTransactionRecordResponse;
import com.zkcloud.api.dbs.model.DoorUpdateRequest;
import com.zkcloud.api.dbs.model.EmployeeBindDeviceRequest;
import com.zkcloud.api.dbs.model.EmployeeBindDeviceResponse;
import com.zkcloud.api.dbs.model.EmployeeDeleteBatchRequest;
import com.zkcloud.api.dbs.model.EmployeeDeleteRequest;
import com.zkcloud.api.dbs.model.EmployeeDeleteResponse;
import com.zkcloud.api.dbs.model.EmployeeFaceRequest;
import com.zkcloud.api.dbs.model.EmployeeFaceResponse;
import com.zkcloud.api.dbs.model.EmployeeFaceSyncRequest;
import com.zkcloud.api.dbs.model.EmployeeGroupDeleteRequest;
import com.zkcloud.api.dbs.model.EmployeeGroupUpdateRequest;
import com.zkcloud.api.dbs.model.EmployeeUnbindDeviceRequest;
import com.zkcloud.api.dbs.model.EmployeeUnbindDeviceResponse;
import com.zkcloud.api.dbs.model.EmployeeUpdateBatchRequest;
import com.zkcloud.api.dbs.model.EmployeeUpdateRequest;
import com.zkcloud.api.dbs.model.EmployeeUpdateResponse;
import com.zkcloud.api.dbs.model.FwSeriesRequest;
import com.zkcloud.api.dbs.model.FwSeriesResponse;
import com.zkcloud.api.dbs.model.LockGateRequest;
import com.zkcloud.api.dbs.model.MultiGroupDeleteRequest;
import com.zkcloud.api.dbs.model.MultiGroupUpdateRequest;
import com.zkcloud.api.dbs.model.NewFwVersionsRequest;
import com.zkcloud.api.dbs.model.NewFwVersionsResponse;
import com.zkcloud.api.dbs.model.NormalOpenRequest;
import com.zkcloud.api.dbs.model.OpenDoorRequest;
import com.zkcloud.api.dbs.model.OrgBindDeviceRequest;
import com.zkcloud.api.dbs.model.OrgBindDeviceResponse;
import com.zkcloud.api.dbs.model.OrgDeleteBatchRequest;
import com.zkcloud.api.dbs.model.OrgDeleteRequest;
import com.zkcloud.api.dbs.model.OrgUnbindDeviceRequest;
import com.zkcloud.api.dbs.model.OrgUnbindDeviceResponse;
import com.zkcloud.api.dbs.model.OrgUpdateBatchRequest;
import com.zkcloud.api.dbs.model.OrgUpdateRequest;
import com.zkcloud.api.dbs.model.OrgUpdateResponse;
import com.zkcloud.api.dbs.model.PunchRecordByPageRequest;
import com.zkcloud.api.dbs.model.PunchRecordByPageResponse;
import com.zkcloud.api.dbs.model.PunchRecordVerifyRequest;
import com.zkcloud.api.dbs.model.PunchRecordVerifyResponse;
import com.zkcloud.api.dbs.model.ReaderParam;
import com.zkcloud.api.dbs.model.ReaderParamQueryRequest;
import com.zkcloud.api.dbs.model.ReaderParamQueryResponse;
import com.zkcloud.api.dbs.model.ReaderParamUpdateRequest;
import com.zkcloud.api.dbs.model.ReaderQueryRequest;
import com.zkcloud.api.dbs.model.ReaderQueryResponse;
import com.zkcloud.api.dbs.model.ReaderUpdateRequest;
import com.zkcloud.api.dbs.model.RegisterBiometricRequest;
import com.zkcloud.api.dbs.model.RegisterBiometricResponse;
import com.zkcloud.api.dbs.model.RegisterFpRequest;
import com.zkcloud.api.dbs.model.RegisterFpResponse;
import com.zkcloud.api.dbs.model.SuperUserDeleteRequest;
import com.zkcloud.api.dbs.model.SuperUserUpdateRequest;
import com.zkcloud.api.dbs.model.TimeSyncRequest;
import com.zkcloud.api.dbs.model.TodayNormalOpenRequest;
import com.zkcloud.api.dbs.model.TriggerData;
import com.zkcloud.api.dbs.model.TriggerListDeleteRequest;
import com.zkcloud.api.dbs.model.TriggerListUpdateRequest;
import com.zkcloud.api.dbs.model.User;
import com.zkcloud.api.dbs.model.UserAntiPassBackDeleteRequest;
import com.zkcloud.api.dbs.model.UserAntiPassBackUpdateRequest;
import com.zkcloud.api.dbs.model.UserInterLockDeleteRequest;
import com.zkcloud.api.dbs.model.UserInterLockUpdateRequest;
import com.zkcloud.api.dbs.model.UserLinkageDeleteRequest;
import com.zkcloud.api.dbs.model.UserLinkageUpdateRequest;
import com.zkcloud.api.dbs.model.VerifyInfoByDeviceRequest;
import com.zkcloud.api.dbs.model.VerifyInfoByDeviceResponse;
import com.zkcloud.api.dbs.model.VerifyInfoByEmployeeRequest;
import com.zkcloud.api.dbs.model.VerifyInfoByEmployeeResponse;
import com.zkcloud.api.dbs.model.VerifyInfoRequest;
import com.zkcloud.api.dbs.model.VerifyInfoResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.JVM)
public class DBSClientTest {

    String endpoint = "smartdbs-apigateway.zkclouds.com";

    String appKey = "a3f8ea844d2e40d9a595ec92fab76de9";
    String appSecret = "6c14263d95eb4a59b9ea8a5756645a82";
    DBSClient client;

    String defaultCompanyCode = "111241";
    String defaultCompanyName = "414141";
    String defaultCompanyEmail = "981335155@qq.com";
    String defaultCompanyApiUsername = "9813351551924";
    String defaultCompanyApiPassword = "zk123456";


    @Before
    public void before() throws Exception {
        Credential credential = new Credential(appKey, appSecret);
        client = new DBSClient(endpoint, credential);
        client.getClientProfile().getHttpProfile().setProtocol(HttpProfile.REQ_HTTP); // 非必须，默认https
        client.refreshToken();//刷新accessToken

        client.getClientProfile().setLanguage(Language.ZH_CN);
    }

    @After
    public void after() throws Exception {
    }


    /**
     * Method: createCompany(CompanyRequest company)
     */
    @Test
    public void testCreateCompany() throws Exception {
        CompanyRequest companyRequest = new CompanyRequest(defaultCompanyCode, defaultCompanyName, defaultCompanyEmail);
        Message<CreateCompanyResponse> response = client.createCompany(companyRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(true, "E0010034".equals(response.getCode()) || ErrorCode.CODE_SUCCESS.equals(response.getCode()));
        if (ErrorCode.CODE_SUCCESS.equals(response.getCode())) {
            //集成账号
            defaultCompanyApiUsername = response.getPayload().getResults().getApiUser().getUserName();
            //集成账号密码
            defaultCompanyApiPassword = response.getPayload().getResults().getApiUser().getPassword();
        }
    }

    /**
     * Method: updateCompany(CompanyRequest company)
     */
    @Test
    public void testUpdateCompany() throws Exception {
        CompanyRequest companyRequest = new CompanyRequest(defaultCompanyCode, defaultCompanyName);
        companyRequest.setAddress1("福建省");
        companyRequest.setEmail(RandomUtil.randomString(5) + "@zkteco.com");
        companyRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.updateCompany(companyRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());
    }

    /**
     * Method: updateOrg(OrgUpdateRequest org)
     */
    @Test
    public void testUpdateOrg() throws Exception {
        OrgUpdateRequest org = new OrgUpdateRequest("10001", "厦门中控智慧");
        org.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.updateOrg(org);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());
    }

    /**
     * Method: updateOrgBatch(OrgUpdateBatchRequest orgList)
     */
    @Test
    public void testUpdateOrgBatch() throws Exception {
        List<OrgUpdateRequest> orgList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            OrgUpdateRequest org = new OrgUpdateRequest("10001_" + i, "研发部门_" + i, "10001");
            orgList.add(org);
        }

        OrgUpdateBatchRequest request = new OrgUpdateBatchRequest(orgList);
        request.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message<List<OrgUpdateResponse>> response = client.updateOrgBatch(request);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());

        response.getPayload().getResults().forEach(e -> {
            Assert.assertEquals(e.getMessage(), ErrorCode.CODE_SUCCESS, e.getCode());
        });
    }

    /**
     * Method: deleteOrg(OrgDeleteRequest org)
     */
    @Test
    public void testDeleteOrg() throws Exception {
        OrgDeleteRequest org = new OrgDeleteRequest("10001_0");
        org.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.deleteOrg(org);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true, "E0010021".equals(response.getCode()) || ErrorCode.CODE_SUCCESS.equals(response.getCode()));
    }

    /**
     * Method: deleteOrgBatch(OrgDeleteBatchRequest orgList)
     */
    @Test
    public void testDeleteOrgBatch() throws Exception {
        List<OrgDeleteRequest> orgList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            OrgDeleteRequest org = new OrgDeleteRequest("10001_" + i);
            orgList.add(org);
        }

        OrgDeleteBatchRequest request = new OrgDeleteBatchRequest(orgList);
        request.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message<List<OrgUpdateResponse>> response = client.deleteOrgBatch(request);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true, "E0010021".equals(response.getCode()) || ErrorCode.CODE_SUCCESS.equals(response.getCode()));
        response.getPayload().getResults().forEach(e -> {
            Assert.assertEquals(e.getMessage(), true, "E0010021".equals(e.getCode()) || ErrorCode.CODE_SUCCESS.equals(e.getCode()));
        });
    }

    /**
     * Method: updateEmployee(EmployeeUpdateRequest employee)
     */
    @Test
    public void testUpdateEmployee() throws Exception {
        EmployeeUpdateRequest employee = new EmployeeUpdateRequest("2956", "Huiwu", "Lin","Huiu.Li");
        employee.setOrganization(Arrays.asList("10001"));
        employee.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.updateEmployee(employee);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());
    }

    /**
     * Method: updateEmployeeBatch(EmployeeUpdateBatchRequest employeeList)
     */
    @Test
    public void testUpdateEmployeeBatch() throws Exception {
        List<EmployeeUpdateRequest> employeeList = new ArrayList<>();
        for (int i = 1000; i < 1050; i++) {
            EmployeeUpdateRequest emp = new EmployeeUpdateRequest(i + "", "luther", "Lin" + i, "luther.Lin" + i);
            emp.setOrganization(Arrays.asList("10001_1"));
            employeeList.add(emp);
        }

        EmployeeUpdateBatchRequest request = new EmployeeUpdateBatchRequest(employeeList);
        request.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message<List<EmployeeUpdateResponse>> response = client.updateEmployeeBatch(request);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());

        response.getPayload().getResults().forEach(e -> {
            Assert.assertEquals(e.getMessage(), ErrorCode.CODE_SUCCESS, e.getCode());
        });
    }

    @Test
    public void testDeleteEmployee() throws Exception {
        EmployeeDeleteRequest employeeDeleteRequest = new EmployeeDeleteRequest("2956");
        employeeDeleteRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.deleteEmployee(employeeDeleteRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true, ErrorCode.CODE_SUCCESS.equals(response.getCode()) || "E0010031".equals(response.getCode()));
    }

    @Test
    public void testDeleteEmployeeBatch() throws Exception {
        List<EmployeeDeleteRequest> employeeDeleteRequests = new ArrayList<>();
        for (int i = 1000; i < 1050; i++) {
            EmployeeDeleteRequest emp = new EmployeeDeleteRequest(i + "");
            employeeDeleteRequests.add(emp);
        }
        EmployeeDeleteBatchRequest employeeDeleteBatchRequest = new EmployeeDeleteBatchRequest(employeeDeleteRequests);
        employeeDeleteBatchRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));

        Message<List<EmployeeDeleteResponse>> response = client.deleteEmployeeBatch(employeeDeleteBatchRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());

        response.getPayload().getResults().forEach(e -> {
            Assert.assertEquals(e.getMessage(), true, ErrorCode.CODE_SUCCESS.equals(e.getCode()) || "E0010031".equals(e.getCode()));
        });
    }

    @Test
    public void testFaceSync() throws Exception {
        EmployeeFaceSyncRequest employeeFaceSyncRequest = new EmployeeFaceSyncRequest("2956", "http://test.com/2956.jpg");
        employeeFaceSyncRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.faceSync(employeeFaceSyncRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true, ErrorCode.CODE_SUCCESS.equals(response.getCode()) || "E0010031".equals(response.getCode()));
    }

    @Test
    public void testQueryVerifyInfo() throws Exception {
        VerifyInfoRequest verifyInfoRequest = new VerifyInfoRequest("3180206");
        verifyInfoRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message<VerifyInfoResponse> response = client.queryVerifyInfo(verifyInfoRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true, ErrorCode.CODE_SUCCESS.equals(response.getCode()) || "E0010041".equals(response.getCode()));
    }

    @Test
    public void testVerifyInfoByEmployee() throws Exception {
        VerifyInfoByEmployeeRequest verifyInfoByEmployeeRequest = new VerifyInfoByEmployeeRequest("3180206", "123456", 1, 10);
        verifyInfoByEmployeeRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message<VerifyInfoByEmployeeResponse> response = client.verifyInfoByEmployee(verifyInfoByEmployeeRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true, ErrorCode.CODE_SUCCESS.equals(response.getCode()) || "E0010041".equals(response.getCode()));
    }

    @Test
    public void testVerifyInfoByDevice() throws Exception {
        VerifyInfoByDeviceRequest verifyInfoByDeviceRequest = new VerifyInfoByDeviceRequest("29562", "3379163000027", 1, 10);
        verifyInfoByDeviceRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message<VerifyInfoByDeviceResponse> response = client.verifyInfoByDevice(verifyInfoByDeviceRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true, ErrorCode.CODE_SUCCESS.equals(response.getCode()) || "E0010041".equals(response.getCode()));
    }


    @Test
    public void testDeleteBiotemplate() throws Exception {
        BiotemplateRequest biotemplateRequest = new BiotemplateRequest("2956", "1");
        biotemplateRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.deleteBiotemplate(biotemplateRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true, ErrorCode.CODE_SUCCESS.equals(response.getCode()));
    }

    @Test
    public void queryEmployeeFace() throws ZKCloudSDKException {
        EmployeeFaceRequest employeeFaceRequest = new EmployeeFaceRequest("2956");
        employeeFaceRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message<EmployeeFaceResponse> response = client.queryEmployeeFace(employeeFaceRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true, ErrorCode.CODE_SUCCESS.equals(response.getCode()));
    }

    @Test
    public void testAddDevice() throws Exception {
        CreateDeviceRequest createDeviceRequest = new CreateDeviceRequest("339984000213141");
        createDeviceRequest.setTimeZone("+08:00");
        createDeviceRequest.setAlais("一楼打卡机");
        createDeviceRequest.setTimezone("Asia/Shanghai");
//        createDeviceRequest.setFpFunOn("1");
//        createDeviceRequest.setFaceFunOn("1");
//        createDeviceRequest.setPunchPhotoFunOn("1");
//        createDeviceRequest.setPunchRecordFunOn("1");
        createDeviceRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.addDevice(createDeviceRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true,
                ErrorCode.CODE_SUCCESS.equals(response.getCode()) || "E0010058".equals(response.getCode()) || "EDS00021".equals(response.getCode()));
    }

    @Test
    public void testUpdateDevice() throws Exception {
        DeviceUpdateRequest deviceUpdateRequest = new DeviceUpdateRequest("339984000213141");
        deviceUpdateRequest.setTimeZone("+07:00");
        deviceUpdateRequest.setAlais("一楼考勤机");
        deviceUpdateRequest.setTimezone("Asia/Shanghai");
//        deviceUpdateRequest.setFpFunOn("1");
//        deviceUpdateRequest.setFaceFunOn("1");
//        deviceUpdateRequest.setPunchPhotoFunOn("1");
//        deviceUpdateRequest.setPunchRecordFunOn("1");
        deviceUpdateRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.updateDevice(deviceUpdateRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true,
                ErrorCode.CODE_SUCCESS.equals(response.getCode()) || "E0010055".equals(response.getCode()) || "E0010042".equals(response.getCode()));
    }

    @Test
    public void testDeleteDevice() throws Exception {
        DeviceDeleteRequest deviceDeleteRequest = new DeviceDeleteRequest("339984000213141");
        deviceDeleteRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.deleteDevice(deviceDeleteRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true,
                ErrorCode.CODE_SUCCESS.equals(response.getCode()) || "E0010042".equals(response.getCode()) || "EDS00022".equals(response.getCode()));
    }

    @Test
    public void testQueryDevice() throws Exception {
        DeviceQueryRequest deviceQueryRequest = new DeviceQueryRequest("339984000213141", 1);
        deviceQueryRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message<List<DeviceQueryResponse>> response = client.queryDevice(deviceQueryRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());
    }

    @Test
    public void testDisableDevice() throws Exception {
        DeviceDisableRequest deviceDisableRequest = new DeviceDisableRequest("339984000213141");
        deviceDisableRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.disableDevice(deviceDisableRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true,
                ErrorCode.CODE_SUCCESS.equals(response.getCode()) || "E0010055".equals(response.getCode()) || "E0010042".equals(response.getCode()));
    }

    @Test
    public void testEnableDevice() throws Exception {
        DeviceEnableRequest deviceEnableRequest = new DeviceEnableRequest("339984000213141");
        deviceEnableRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.enableDevice(deviceEnableRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true,
                ErrorCode.CODE_SUCCESS.equals(response.getCode()) || "E0010055".equals(response.getCode()) || "E0010042".equals(response.getCode()));
    }

    @Test
    public void testRebootDevice() throws Exception {
        DeviceRebootRequest deviceRebootRequest = new DeviceRebootRequest("339984000213141");
        deviceRebootRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.rebootDevice(deviceRebootRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true,
                ErrorCode.CODE_SUCCESS.equals(response.getCode()) || "E0010055".equals(response.getCode()) || "E0010042".equals(response.getCode())
                        || "E0010074".equals(response.getCode()) || "E0010075".equals(response.getCode()));
    }

    @Test
    public void testReloadEmployeeFromDevice() throws Exception {
        DeviceReloadEmployeeRequest deviceReloadEmployeeRequest = new DeviceReloadEmployeeRequest("3379163000027");
        deviceReloadEmployeeRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.reloadEmployeeFromDevice(deviceReloadEmployeeRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true,
                ErrorCode.CODE_SUCCESS.equals(response.getCode()) || "E0010055".equals(response.getCode()) || "E0010042".equals(response.getCode())
                        || "E0010074".equals(response.getCode()) || "E0010075".equals(response.getCode()));
    }

    @Test
    public void testReloadPunchFromDevice() throws Exception {
        DeviceReloadPunchRequest deviceReloadPunchRequest = new DeviceReloadPunchRequest("3379163000027", 1492617600L, 1492790400L, "0");
        deviceReloadPunchRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.reloadPunchFromDevice(deviceReloadPunchRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true,
                ErrorCode.CODE_SUCCESS.equals(response.getCode()) || "E0010055".equals(response.getCode()) || "E0010042".equals(response.getCode())
                        || "E0010074".equals(response.getCode()) || "E0010075".equals(response.getCode()));
    }

    @Test
    public void testRefreshEmployeeToDevice() throws Exception {
        DeviceRefreshEmployeeRequest deviceRefreshEmployeeRequest = new DeviceRefreshEmployeeRequest("3379163000027", "0");
        deviceRefreshEmployeeRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.refreshEmployeeToDevice(deviceRefreshEmployeeRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true,
                ErrorCode.CODE_SUCCESS.equals(response.getCode()) || "E0010055".equals(response.getCode()) || "E0010042".equals(response.getCode())
                        || "E0010074".equals(response.getCode()) || "E0010075".equals(response.getCode()));
    }

    @Test
    public void testRegisterFp() throws Exception {
        RegisterFpRequest registerFpRequest = new RegisterFpRequest("3394172800218", "2956");
        registerFpRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message<RegisterFpResponse> response = client.registerFp(registerFpRequest);
        Assert.assertEquals(response.getMessage(), true,
                ErrorCode.CODE_SUCCESS.equals(response.getCode()) || "E0010055".equals(response.getCode()) || "E0010042".equals(response.getCode())
                        || "E0010074".equals(response.getCode()) || "E0010075".equals(response.getCode()));
    }

    @Test
    public void testCancelRegisterFp() throws Exception {
        CancelRegisterFpRequest cancelRegisterFpRequest = new CancelRegisterFpRequest("339984000213141");
        cancelRegisterFpRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.cancelRegisterFp(cancelRegisterFpRequest);
        Assert.assertEquals(response.getMessage(), true,
                ErrorCode.CODE_SUCCESS.equals(response.getCode()) || "E0010055".equals(response.getCode()) || "E0010042".equals(response.getCode())
                        || "E0010074".equals(response.getCode()) || "E0010075".equals(response.getCode()));
    }

    @Test
    public void registerBiometric() throws Exception {
        RegisterBiometricRequest registerBiometricRequest = new RegisterBiometricRequest("339984000213142", "29562", "0", "", "0");
        registerBiometricRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message<RegisterBiometricResponse> response = client.registerBiometric(registerBiometricRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true,
                ErrorCode.CODE_SUCCESS.equals(response.getCode()) || "E0010055".equals(response.getCode()) || "E0010042".equals(response.getCode())
                        || "E0010074".equals(response.getCode()) || "E0010075".equals(response.getCode()));
    }

    @Test
    public void cancelRegisterBiometric() throws Exception {
        CancelRegisterBiometricRequest cancelRegisterBiometricRequest = new CancelRegisterBiometricRequest("339984000213142");
        cancelRegisterBiometricRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.cancelRegisterBiometric(cancelRegisterBiometricRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true,
                ErrorCode.CODE_SUCCESS.equals(response.getCode()) || "E0010055".equals(response.getCode()) || "E0010042".equals(response.getCode())
                        || "E0010074".equals(response.getCode()) || "E0010075".equals(response.getCode()));
    }

    @Test
    public void commandListByPage() throws Exception {
        CommandListByPageRequest commandListByPageRequest = new CommandListByPageRequest(1607678868L);
        commandListByPageRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message<List<CommandListByPageResponse>> response = client.commandListByPage(commandListByPageRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true,
                ErrorCode.CODE_SUCCESS.equals(response.getCode()) || "E0010055".equals(response.getCode()) || "E0010042".equals(response.getCode())
                        || "E0010074".equals(response.getCode()) || "E0010075".equals(response.getCode()));
    }

    @Test
    public void testOrgBindDevice() throws Exception {
        List<String> sns = new ArrayList<String>();
        sns.add("339984000213141");
        List<String> orgCodes = new ArrayList<String>();
        orgCodes.add("10001_1");
        orgCodes.add("10001_2");
        OrgBindDeviceRequest orgBindDeviceRequest = new OrgBindDeviceRequest(sns, orgCodes);
        orgBindDeviceRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message<OrgBindDeviceResponse> response = client.orgBindDevice(orgBindDeviceRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true,
                ErrorCode.CODE_SUCCESS.equals(response.getCode()) || "E0010042".equals(response.getCode()) || "E0010021".equals(response.getCode()));
    }


    @Test
    public void testOrgUnBindDevice() throws Exception {
        List<String> sns = new ArrayList<String>();
        sns.add("339984000213141");
        List<String> orgCodes = new ArrayList<String>();
        orgCodes.add("10001_1");
        orgCodes.add("10001_2");
        OrgUnbindDeviceRequest orgUnbindDeviceRequest = new OrgUnbindDeviceRequest(sns, orgCodes);
        orgUnbindDeviceRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message<OrgUnbindDeviceResponse> response = client.orgUnBindDevice(orgUnbindDeviceRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true,
                ErrorCode.CODE_SUCCESS.equals(response.getCode()) || "E0010042".equals(response.getCode()) || "E0010021".equals(response.getCode()));
    }

    @Test
    public void testEmployeeBindDevice() throws Exception {
        List<String> sns = new ArrayList<String>();
        sns.add("339984000213141");
        List<String> employeeNos = new ArrayList<String>();
        employeeNos.add("29562");
        EmployeeBindDeviceRequest employeeBindDeviceRequest = new EmployeeBindDeviceRequest(sns, employeeNos);
        employeeBindDeviceRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message<EmployeeBindDeviceResponse> response = client.employeeBindDevice(employeeBindDeviceRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true,
                ErrorCode.CODE_SUCCESS.equals(response.getCode()) || "E0010042".equals(response.getCode()) || "E0010041".equals(response.getCode()));
    }

    @Test
    public void testEmployeeUnBindDevice() throws Exception {
        List<String> sns = new ArrayList<String>();
        sns.add("339984000213141");
        List<String> employeeNos = new ArrayList<String>();
        employeeNos.add("29562");
        EmployeeUnbindDeviceRequest employeeUnbindDeviceRequest = new EmployeeUnbindDeviceRequest(sns, employeeNos);
        employeeUnbindDeviceRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message<EmployeeUnbindDeviceResponse> response = client.employeeUnBindDevice(employeeUnbindDeviceRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true,
                ErrorCode.CODE_SUCCESS.equals(response.getCode()) || "E0010042".equals(response.getCode()) || "E0010041".equals(response.getCode()));
    }

    @Test
    public void testOpenDoor() throws Exception {
        OpenDoorRequest openDoorRequest = new OpenDoorRequest("339984000213142");
        openDoorRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.openDoor(openDoorRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true,
                ErrorCode.CODE_SUCCESS.equals(response.getCode()) || "E0010055".equals(response.getCode()) || "E0010042".equals(response.getCode())
                        || "E0010074".equals(response.getCode()) || "E0010075".equals(response.getCode()) || "E0010113".equals(response.getCode()));
    }

    @Test
    public void testUpdateDoor() throws Exception {
        DoorUpdateRequest doorUpdateRequest = new DoorUpdateRequest("339984000213142", 1, "门名称");
        doorUpdateRequest.setEnable(1);
        doorUpdateRequest.setAddress(1);
        doorUpdateRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.updateDoor(doorUpdateRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true, ErrorCode.CODE_SUCCESS.equals(response.getCode()));
    }

    @Test
    public void testQueryDoor() throws Exception {
        DoorQueryRequest doorQueryRequest = new DoorQueryRequest("6073202900002");
//        doorQueryRequest.setDoorNum(1);
        doorQueryRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message<List<DoorQueryResponse>> response = client.queryDoor(doorQueryRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true, ErrorCode.CODE_SUCCESS.equals(response.getCode()));
    }


    @Test
    public void testUpdateDoorParam() throws Exception {
        List<DoorParam> doorParamList = new ArrayList<>();
        doorParamList.add(new DoorParam("param1", "1"));
        doorParamList.add(new DoorParam("param2", "2"));
        DoorParamUpdateRequest doorQueryRequest = new DoorParamUpdateRequest("339984000213142", 1, doorParamList);
        doorQueryRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.updateDoorParam(doorQueryRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true, ErrorCode.CODE_SUCCESS.equals(response.getCode()));
    }


    @Test
    public void testQueryDoorParam() throws Exception {
        DoorParamQueryRequest doorQueryRequest = new DoorParamQueryRequest("339984000213142", 1);
        doorQueryRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message<List<DoorParamQueryResponse>> response = client.queryDoorParam(doorQueryRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true, ErrorCode.CODE_SUCCESS.equals(response.getCode()));
    }


    @Test
    public void updateDoorPassword() throws Exception {
        DoorPasswordUpdateRequest doorPasswordUpdateRequest = new DoorPasswordUpdateRequest("339984000213142", 1, "29562", 1492617600L, 1492790400L, "fbfe82e76c06ea568e3301ab17a9d4677c1481b8a4f1ca137411e10153deabc3", "c09eb7463827cda245f3a398bd453c42", "1");
        doorPasswordUpdateRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.updateDoorPassword(doorPasswordUpdateRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true, ErrorCode.CODE_SUCCESS.equals(response.getCode()));
    }


    @Test
    public void deleteDoorPassword() throws Exception {
        DoorPasswordDeleteRequest doorPasswordDeleteRequest = new DoorPasswordDeleteRequest("339984000213142", 1, "29562", "1");
        doorPasswordDeleteRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.deleteDoorPassword(doorPasswordDeleteRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true, ErrorCode.CODE_SUCCESS.equals(response.getCode()));
    }


    @Test
    public void openDoorPassword() throws Exception {
        DoorPasswordOpenRequest doorPasswordOpenRequest = new DoorPasswordOpenRequest("339984000213142", 1, "29562", "123456");
        doorPasswordOpenRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.openDoorPassword(doorPasswordOpenRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true, ErrorCode.CODE_SUCCESS.equals(response.getCode()));
    }

    @Test
    public void testUpdateDoorTimeZone() throws Exception {
        List<DoorTimeZoneDetail> list = new ArrayList<>();
        list.add(new DoorTimeZoneDetail(1, "8:00", "18:30"));
        DoorTimeZoneUpdateRequest timeZoneUpdateRequest = new DoorTimeZoneUpdateRequest(200, "星期一",  list);
        timeZoneUpdateRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.updateDoorTimeZone(timeZoneUpdateRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true, ErrorCode.CODE_SUCCESS.equals(response.getCode()));
    }

    @Test
    public void testDeleteDoorTimeZone() throws Exception {
        DoorTimeZoneDeleteRequest timeZoneDeleteRequest = new DoorTimeZoneDeleteRequest(200);
        timeZoneDeleteRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.deleteDoorTimeZone(timeZoneDeleteRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true, ErrorCode.CODE_SUCCESS.equals(response.getCode()));
    }


    @Test
    public void testUpdateDoorPermissionGroup() throws Exception {
        DoorPermissionGroupUpdateRequest doorPermissionGroupUpdateRequest = new DoorPermissionGroupUpdateRequest(200, 200);
        doorPermissionGroupUpdateRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.updateDoorPermissionGroup(doorPermissionGroupUpdateRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true, ErrorCode.CODE_SUCCESS.equals(response.getCode()));
    }


    @Test
    public void testDeleteDoorPermissionGroup() throws Exception {
        DoorPermissionGroupDeleteRequest doorPermissionGroupDeleteRequest = new DoorPermissionGroupDeleteRequest(200);
        doorPermissionGroupDeleteRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.deleteDoorPermissionGroup(doorPermissionGroupDeleteRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true, ErrorCode.CODE_SUCCESS.equals(response.getCode()));
    }


    @Test
    public void testDoorPermissionGroupAddDoor() throws Exception {
        DoorPermissionGroupAddDoorRequest doorPermissionGroupDeleteRequest = new DoorPermissionGroupAddDoorRequest(200, Arrays.asList(new DoorPermissionGroupAddDoorDevice("6073202900002", Arrays.asList(1,2,3,4))));
        doorPermissionGroupDeleteRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.doorPermissionGroupAddDoor(doorPermissionGroupDeleteRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true, ErrorCode.CODE_SUCCESS.equals(response.getCode()));
    }


    @Test
    public void testDoorPermissionGroupRemoveDoor() throws Exception {
        DoorPermissionGroupRemoveDoorRequest doorPermissionGroupRemoveDoorRequest = new DoorPermissionGroupRemoveDoorRequest(200, "6073202900002", Arrays.asList(1));
        doorPermissionGroupRemoveDoorRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.doorPermissionGroupRemoveDoor(doorPermissionGroupRemoveDoorRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true, ErrorCode.CODE_SUCCESS.equals(response.getCode()));
    }


    @Test
    public void testDoorPermissionGroupAddEmployee() throws Exception {
        DoorPermissionGroupAddEmployeeRequest doorPermissionGroupAddEmployeeRequest = new DoorPermissionGroupAddEmployeeRequest(200, Arrays.asList("3", "4 "));
        doorPermissionGroupAddEmployeeRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.doorPermissionGroupAddEmployee(doorPermissionGroupAddEmployeeRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true, ErrorCode.CODE_SUCCESS.equals(response.getCode()));
    }


    @Test
    public void testDoorPermissionGroupRemoveEmployee() throws Exception {
        DoorPermissionGroupRemoveEmployeeRequest doorPermissionGroupRemoveEmployeeRequest = new DoorPermissionGroupRemoveEmployeeRequest(200, Arrays.asList("3", "4"));
        doorPermissionGroupRemoveEmployeeRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.doorPermissionGroupRemoveEmployee(doorPermissionGroupRemoveEmployeeRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true, ErrorCode.CODE_SUCCESS.equals(response.getCode()));
    }

    @Test
    public void testDoorPermissionGroupRemoveAllEmployee() throws Exception {
        DoorPermissionGroupRemoveAllEmployeeRequest doorPermissionGroupRemoveAllEmployeeRequest = new DoorPermissionGroupRemoveAllEmployeeRequest(200);
        doorPermissionGroupRemoveAllEmployeeRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.doorPermissionGroupRemoveAllEmployee(doorPermissionGroupRemoveAllEmployeeRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true, ErrorCode.CODE_SUCCESS.equals(response.getCode()));
    }

    @Test
    public void testUpdateDoorHoliday() throws Exception {
        DoorHolidayUpdateRequest doorHolidayUpdateRequest = new DoorHolidayUpdateRequest("200", "2020-10-01", "7", "1");
        doorHolidayUpdateRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.updateDoorHoliday(doorHolidayUpdateRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true, ErrorCode.CODE_SUCCESS.equals(response.getCode()));
    }

    @Test
    public void testDeleteDoorHoliday() throws Exception {
        DoorHolidayDeleteRequest doorHolidayDeleteRequest = new DoorHolidayDeleteRequest(Arrays.asList("200"));
        doorHolidayDeleteRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.deleteDoorHoliday(doorHolidayDeleteRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true, ErrorCode.CODE_SUCCESS.equals(response.getCode()));
    }

    @Test
    public void testGetQRCode() throws Exception {
        DoorQRCodeRequest doorQRCodeRequest = new DoorQRCodeRequest("123123");
        doorQRCodeRequest.setCreateTime(1614219284L);
        doorQRCodeRequest.setValidTime(System.currentTimeMillis());
        doorQRCodeRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message<DoorQRCodeResponse> response = client.getQRCode(doorQRCodeRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true, ErrorCode.CODE_SUCCESS.equals(response.getCode()));
    }

    @Test
    public void testGetTransactionRecord() throws Exception {
        DoorTransactionRecordRequest doorTransactionRecordRequest = new DoorTransactionRecordRequest(1604160000L, 1606320000L, 1604160000L, 1606320000L, 1, 15);
        doorTransactionRecordRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message<List<DoorTransactionRecordResponse>> response = client.getTransactionRecord(doorTransactionRecordRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true, ErrorCode.CODE_SUCCESS.equals(response.getCode()));
    }


    @Test
    public void testGetPunchRecordByPage() throws Exception {
        PunchRecordByPageRequest punchRecordByPageRequest = new PunchRecordByPageRequest(1604160000L, 1606320000L, 1604160000L, 1606320000L, 1, 10);
        punchRecordByPageRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message<List<PunchRecordByPageResponse>> response = client.getPunchRecordByPage(punchRecordByPageRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true, ErrorCode.CODE_SUCCESS.equals(response.getCode()));
    }

    @Test
    public void testVerifyPunchRecord() throws Exception {
        PunchRecordVerifyRequest punchRecordRequest = new PunchRecordVerifyRequest(1604160000L, 1606320000L);
        punchRecordRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message<PunchRecordVerifyResponse> response = client.verifyPunchRecord(punchRecordRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true, ErrorCode.CODE_SUCCESS.equals(response.getCode()));
    }

    @Test
    public void testGetNewVersions() throws Exception {
        NewFwVersionsRequest newFwVersionsRequest = new NewFwVersionsRequest("设备序列号");
        newFwVersionsRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message<NewFwVersionsResponse> response = client.getNewVersions(newFwVersionsRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true, ErrorCode.CODE_SUCCESS.equals(response.getCode()));
    }

    @Test
    public void testDeviceUpgrade() throws Exception {
        DeviceUpgradeRequest deviceUpgradeRequest = new DeviceUpgradeRequest("设备序列号", "版本号");
        deviceUpgradeRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message<DeviceUpgradeResponse> response = client.deviceUpgrade(deviceUpgradeRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true, ErrorCode.CODE_SUCCESS.equals(response.getCode()));
    }

    @Test
    public void testGetUpgradeHistory() throws Exception {
        DeviceUpgradeHistoryRequest deviceUpgradeHistoryRequest = new DeviceUpgradeHistoryRequest("设备序列号");
        deviceUpgradeHistoryRequest.setCurPage(1);
        deviceUpgradeHistoryRequest.setPageSize(3);
        deviceUpgradeHistoryRequest.setTaskId("任务id");
        deviceUpgradeHistoryRequest.setBeginTime(1609323497L);
        deviceUpgradeHistoryRequest.setEndTime(1609323497L);
        deviceUpgradeHistoryRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message<List<DeviceUpgradeHistoryResponse>> response = client.getUpgradeHistory(deviceUpgradeHistoryRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true, ErrorCode.CODE_SUCCESS.equals(response.getCode()));
    }

    @Test
    public void testDeviceUpgradeBatch() throws Exception {
        List<String> list = new ArrayList<String>();
        list.add("设备序列号1");
        list.add("设备序列号2");
        DeviceUpgradeBatchRequest deviceUpgradeBatchRequest = new DeviceUpgradeBatchRequest(list,"版本号");
        deviceUpgradeBatchRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message<List<DeviceUpgradeBatchResponse>> response = client.deviceUpgradeBatch(deviceUpgradeBatchRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true, ErrorCode.CODE_SUCCESS.equals(response.getCode()));
    }

    @Test
    public void testGetSeries() throws Exception{
        FwSeriesRequest fwSeriesRequest = new FwSeriesRequest("ZK-Android-TDB03");
        fwSeriesRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message<FwSeriesResponse> response = client.getSeries(fwSeriesRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true, ErrorCode.CODE_SUCCESS.equals(response.getCode()));
    }

    @Test
    public void testUpdateFirstOpen() throws Exception {
        String[] employees = new String[]{"员工编号01","员工编号02"};
        FirstOpenUpdateRequest cardUpdateRequest = new FirstOpenUpdateRequest("10001", 1, employees, 1);
        cardUpdateRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.updateFirstOpen(cardUpdateRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());
    }

    @Test
    public void testDeleteFirstOpen() throws Exception {
        Integer[] doorNums = new Integer[]{1,2};
        FirstOpenDeleteRequest firstCardDeleteRequest = new FirstOpenDeleteRequest("10001", doorNums);
        firstCardDeleteRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.deleteFirstOpen(firstCardDeleteRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());
    }

    @Test
    public void testUpdateEmployeeGroup() throws Exception {
        String[] employees = new String[]{"员工编号01","员工编号02"};
        EmployeeGroupUpdateRequest employeeGroupUpdateRequest = new EmployeeGroupUpdateRequest(1, employees);
        employeeGroupUpdateRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.updateEmployeeGroup(employeeGroupUpdateRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());
    }

    @Test
    public void testDeleteEmployeeGroup() throws Exception {
        EmployeeGroupDeleteRequest employeeDeleteRequest = new EmployeeGroupDeleteRequest(1);
        employeeDeleteRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.deleteEmployeeGroup(employeeDeleteRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());
    }


    @Test
    public void testUpdateMultiGroup() throws Exception {
        Integer[] groups = new Integer[]{1,2};
        MultiGroupUpdateRequest multiGroupUpdateRequest = new MultiGroupUpdateRequest(1, "10001", 1,groups );
        multiGroupUpdateRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.updateMultiGroup(multiGroupUpdateRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());
    }


    @Test
    public void testDeleteMultiGroup() throws Exception {
        MultiGroupDeleteRequest multiGroupDeleteRequest = new MultiGroupDeleteRequest(1);
        multiGroupDeleteRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.deleteMultiGroup(multiGroupDeleteRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());
    }


    @Test
    public void testUpdateSuperUser() throws Exception {
        SuperUserUpdateRequest superUserUpdateRequest = new SuperUserUpdateRequest("员工编号01");
        superUserUpdateRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.updateSuperUser(superUserUpdateRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());
    }


    @Test
    public void testDeleteSuperUser() throws Exception {
        SuperUserDeleteRequest superUserDeleteRequest = new SuperUserDeleteRequest("员工编号01");
        superUserDeleteRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.deleteSuperUser(superUserDeleteRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());
    }

    @Test
    public void testCloseDoor() throws Exception {
        DoorCloseRequest doorCloseRequest = new DoorCloseRequest("设备序列号");
        doorCloseRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.closeDoor(doorCloseRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());
    }

    @Test
    public void testNormalOpen() throws Exception {
        NormalOpenRequest normalOpenRequest = new NormalOpenRequest("设备序列号");
        normalOpenRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.normalOpen(normalOpenRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());
    }

    @Test
    public void testTodayNormalOpen() throws Exception {
        TodayNormalOpenRequest todayNormalOpenRequest = new TodayNormalOpenRequest("设备序列号");
        todayNormalOpenRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.todayNormalOpen(todayNormalOpenRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());
    }

    @Test
    public void testLockGate() throws Exception {
        LockGateRequest lockGateRequest = new LockGateRequest("设备序列号");
        lockGateRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.lockGate(lockGateRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());
    }

    @Test
    public void testUpdateReader() throws Exception {
        ReaderUpdateRequest readerUpdateRequest = new ReaderUpdateRequest("设备序列号",2);
        readerUpdateRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.updateReader(readerUpdateRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());
    }

    @Test
    public void testQueryReader() throws Exception {
        ReaderQueryRequest readerQueryRequest = new ReaderQueryRequest("设备序列号");
        readerQueryRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message<List<ReaderQueryResponse>> response = client.queryReader(readerQueryRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());
    }

    @Test
    public void testUpdateReaderParam() throws Exception {
        List<ReaderParam> readerParams = new ArrayList<ReaderParam>();
        readerParams.add(new ReaderParam("name1", "value1"));
        readerParams.add(new ReaderParam("name2", "value2"));
        ReaderParamUpdateRequest readerParamUpdateRequest = new ReaderParamUpdateRequest("设备序列号", 1, readerParams);
        readerParamUpdateRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.updateReaderParam(readerParamUpdateRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());
    }


    @Test
    public void testQueryReaderParam() throws Exception {
        ReaderParamQueryRequest readerParamQueryRequest = new ReaderParamQueryRequest("设备序列号");
        readerParamQueryRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message<List<ReaderParamQueryResponse>> response = client.queryReaderParam(readerParamQueryRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());
    }

    @Test
    public void testCancelAlarm() throws Exception {
        AlarmCancelRequest alarmCancelRequest = new AlarmCancelRequest("设备序列号");
        alarmCancelRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.cancelAlarm(alarmCancelRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());
    }

    @Test
    public void testReloadRecord() throws Exception {
        ReloadDeviceRecordRequest deviceRecordlRequest = new ReloadDeviceRecordRequest("设备序列号",1492617600L, 1492790400L);
        deviceRecordlRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.reloadRecord(deviceRecordlRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());
    }


    @Test
    public void testReloadDeviceInfo() throws Exception {
        ReloadDeviceInfoRequest reloadDeviceInfoRequest = new ReloadDeviceInfoRequest("设备序列号");
        reloadDeviceInfoRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.reloadDeviceInfo(reloadDeviceInfoRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());
    }

    @Test
    public void testSyncTime() throws Exception {
        TimeSyncRequest timeSyncRequest = new TimeSyncRequest("设备序列号");
        timeSyncRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.syncTime(timeSyncRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());
    }

    @Test
    public void testUpdateLinkage() throws Exception {
        LinkageUpdateRequest linkageUpdateRequest = new LinkageUpdateRequest("设备序列号", 0, 0,0,0,0,0);
        linkageUpdateRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.updateLinkage(linkageUpdateRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());
    }

    @Test
    public void testDeleteLinkage() throws Exception {
        Integer[] linkageNums = new Integer[]{1,2,3};
        LinkageDeleteRequest linkageDeleteRequest = new LinkageDeleteRequest("设备序列号", linkageNums);
        linkageDeleteRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.deleteLinkage(linkageDeleteRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());
    }


    @Test
    public void testUpdateUserLinkage() throws Exception {
        String[] employeeNos = new String[]{"aaa","bbb"};
        UserLinkageUpdateRequest userLinkageUpdateRequest = new UserLinkageUpdateRequest("设备序列号", 0, employeeNos);
        userLinkageUpdateRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.updateUserLinkage(userLinkageUpdateRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());
    }

    @Test
    public void testDeleteUserLinkage() throws Exception {
        Integer[] linkageNums = new Integer[]{1,2,3};
        UserLinkageDeleteRequest userLinkageDeleteRequest = new UserLinkageDeleteRequest("设备序列号", linkageNums);
        userLinkageDeleteRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.deleteUserLinkage(userLinkageDeleteRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());
    }

    @Test
    public void testUpdateAntiPassBack() throws Exception {
        AntiPassBackUpdateRequest antiPassBackUpdateRequest = new AntiPassBackUpdateRequest("设备序列号", 0, 0, 0);
        antiPassBackUpdateRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.updateAntiPassBack(antiPassBackUpdateRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());
    }

    @Test
    public void testDeleteAntiPassBack() throws Exception {
        Integer[] antiPassBackNums = new Integer[]{1,2,3};
        AntiPassBackDeleteRequest antiPassBackDeleteRequest = new AntiPassBackDeleteRequest("设备序列号",antiPassBackNums);
        antiPassBackDeleteRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.deleteAntiPassBack(antiPassBackDeleteRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());
    }

    @Test
    public void testUpdateUserAntiPassBack() throws Exception {
        String[] employeeNos = new String[]{};
        UserAntiPassBackUpdateRequest userAntiPassBackUpdateRequest = new UserAntiPassBackUpdateRequest("设备序列号", 0, employeeNos);
        userAntiPassBackUpdateRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.updateUserAntiPassBack(userAntiPassBackUpdateRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());
    }

    @Test
    public void testDeleteUserAntiPassBack() throws Exception {
        Integer[] antiPassBackNums = new Integer[]{1,2,3};
        UserAntiPassBackDeleteRequest userAntiPassBackDeleteRequest = new UserAntiPassBackDeleteRequest("设备序列号",antiPassBackNums);
        userAntiPassBackDeleteRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.deleteUserAntiPassBack(userAntiPassBackDeleteRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());
    }

    @Test
    public void testUpdateInterLock() throws Exception {
        InterLockUpdateRequest interLockUpdateRequest = new InterLockUpdateRequest("设备序列号",0, 0,0);
        interLockUpdateRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.updateInterLock(interLockUpdateRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());
    }


    @Test
    public void testDeleteInterLock() throws Exception {
        Integer[] interLockNums = new Integer[]{1,2,3};
        InterLockDeleteRequest interLockDeleteRequest = new InterLockDeleteRequest("设备序列号",interLockNums);
        interLockDeleteRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.deleteInterLock(interLockDeleteRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());
    }

    @Test
    public void testUpdateUserInterLock() throws Exception {
        String[] employees = new String[]{"aaa", "bbb"};
        UserInterLockUpdateRequest userInterLockUpdateRequest = new UserInterLockUpdateRequest("设备序列号",0,employees);
        userInterLockUpdateRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.updateUserInterLock(userInterLockUpdateRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());
    }

    @Test
    public void testDeleteUserInterLock() throws Exception {
        Integer[] interLockNums = new Integer[]{1,2,3};
        UserInterLockDeleteRequest userInterLockDeleteRequest = new UserInterLockDeleteRequest("设备序列号",interLockNums);
        userInterLockDeleteRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.deleteUserInterLock(userInterLockDeleteRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());
    }

    @Test
    public void testUpdateTriggerList() throws Exception {
        List<TriggerData> triggerDatas = new ArrayList<TriggerData>();
        TriggerData triggerData1 = new TriggerData(0,1);
        TriggerData triggerData2 = new TriggerData(0,1);
        triggerDatas.add(triggerData1);
        triggerDatas.add(triggerData2);
        TriggerListUpdateRequest triggerListUpdateRequest = new TriggerListUpdateRequest("设备序列号",1, triggerDatas);
        triggerListUpdateRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.updateTriggerList(triggerListUpdateRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());
    }

    @Test
    public void testDeleteTriggerList() throws Exception {
        Integer[] triggerListNums = new Integer[]{1,2,3};
        TriggerListDeleteRequest triggerListDeleteRequest = new TriggerListDeleteRequest("设备序列号", triggerListNums);
        triggerListDeleteRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.deleteTriggerList(triggerListDeleteRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());
    }

    @Test
    public void testUpdateAuxIn() throws Exception {
        AuxInUpdateRequest auxInUpdateRequest = new AuxInUpdateRequest("设备序列号", 1);
        auxInUpdateRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.updateAuxIn(auxInUpdateRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());
    }

    @Test
    public void testQueryAuxIn() throws Exception {
        AuxInQueryRequest auxInQueryRequest = new AuxInQueryRequest("设备序列号");
        auxInQueryRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message<List<AuxInQueryResponse>> response = client.queryAuxIn(auxInQueryRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());
    }

    @Test
    public void testUpdateAuxOut() throws Exception {
        AuxOutUpdateRequest auxOutUpdateRequest = new AuxOutUpdateRequest("设备序列号", 1);
        auxOutUpdateRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message response = client.updateAuxOut(auxOutUpdateRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());
    }

    @Test
    public void testQueryAuxOut() throws Exception {
        AuxOutQueryRequest auxOutQueryRequest = new AuxOutQueryRequest("设备序列号");
        auxOutQueryRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message<List<AuxOutQueryResponse>> response = client.queryAuxOut(auxOutQueryRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), ErrorCode.CODE_SUCCESS, response.getCode());
    }

} 
