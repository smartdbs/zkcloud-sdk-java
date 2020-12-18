package com.zkcloud.api.dbs;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONUtil;
import com.zkcloud.api.dbs.common.Credential;
import com.zkcloud.api.dbs.common.Message;
import com.zkcloud.api.dbs.common.constant.ErrorCode;
import com.zkcloud.api.dbs.common.profile.HttpProfile;
import com.zkcloud.api.dbs.exception.ZKCloudSDKException;
import com.zkcloud.api.dbs.model.*;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FixMethodOrder(MethodSorters.JVM)
public class DBSClientTest {

        String endpoint = "smartdbs-apigateway.zkclouds.com";
//    String endpoint = "127.0.0.1:18801";

    String appKey = "e117f9e1b70b4789aa415c0ed32d7865";
    String appSecret = "a486061fe8c148368dfff0e168650079";
    DBSClient client;

    String defaultCompanyCode = "98133515511@qq.com";
    String defaultCompanyName = "公司";
    String defaultCompanyEmail = "981335155@qq.com";
    String defaultCompanyApiUsername = "9813351551738";
    String defaultCompanyApiPassword = "b0BWzh";


    @Before
    public void before() throws Exception {
        Credential credential = new Credential(appKey, appSecret);
        client = new DBSClient(endpoint, credential);
        client.getClientProfile().getHttpProfile().setProtocol(HttpProfile.REQ_HTTP); // 非必须，默认https
        client.refreshToken();//刷新accessToken
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
    public void testGetTransactionRecord() throws Exception {
        DoorTransactionRecordRequest doorTransactionRecordRequest = new DoorTransactionRecordRequest(1604160000L, 1606320000L, 1604160000L, 1606320000L, 1, 15);
        doorTransactionRecordRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message<List<DoorTransactionRecordResponse>> response = client.getTransactionRecord(doorTransactionRecordRequest);
        System.err.println(JSONUtil.toJsonPrettyStr(response));
        Assert.assertEquals(response.getMessage(), true, ErrorCode.CODE_SUCCESS.equals(response.getCode()));
    }


    @Test
    public void testGetPunchRecord() throws Exception {
        PunchRecordRequest punchRecordRequest = new PunchRecordRequest(1604160000L, 1606320000L);
        punchRecordRequest.setApiUser(new User(defaultCompanyApiUsername, defaultCompanyApiPassword));
        Message<List<PunchRecordResponse>> response = client.getPunchRecord(punchRecordRequest);
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
} 
