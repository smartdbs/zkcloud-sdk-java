package com.zkcloud.api.dbs;

import cn.hutool.core.date.DateUtil;
import cn.hutool.crypto.SecureUtil;
import com.google.gson.reflect.TypeToken;
import com.zkcloud.api.dbs.common.AbstractClient;
import com.zkcloud.api.dbs.common.Credential;
import com.zkcloud.api.dbs.common.Message;
import com.zkcloud.api.dbs.common.MessagePayload;
import com.zkcloud.api.dbs.common.constant.ErrorCode;
import com.zkcloud.api.dbs.common.constant.PathConstant;
import com.zkcloud.api.dbs.common.http.HttpConnection;
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
import com.zkcloud.api.dbs.model.DoorParamQueryRequest;
import com.zkcloud.api.dbs.model.DoorParamQueryResponse;
import com.zkcloud.api.dbs.model.DoorParamUpdateRequest;
import com.zkcloud.api.dbs.model.DoorPasswordDeleteRequest;
import com.zkcloud.api.dbs.model.DoorPasswordOpenRequest;
import com.zkcloud.api.dbs.model.DoorPasswordUpdateRequest;
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
import com.zkcloud.api.dbs.model.FirstOpenDeleteRequest;
import com.zkcloud.api.dbs.model.FirstOpenUpdateRequest;
import com.zkcloud.api.dbs.model.FwSeriesRequest;
import com.zkcloud.api.dbs.model.FwSeriesResponse;
import com.zkcloud.api.dbs.model.GetTokenResponse;
import com.zkcloud.api.dbs.model.InterLockDeleteRequest;
import com.zkcloud.api.dbs.model.InterLockUpdateRequest;
import com.zkcloud.api.dbs.model.LinkageDeleteRequest;
import com.zkcloud.api.dbs.model.LinkageUpdateRequest;
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
import com.zkcloud.api.dbs.model.ReloadDeviceInfoRequest;
import com.zkcloud.api.dbs.model.ReloadDeviceRecordRequest;
import com.zkcloud.api.dbs.model.SuperUserDeleteRequest;
import com.zkcloud.api.dbs.model.SuperUserUpdateRequest;
import com.zkcloud.api.dbs.model.TimeSyncRequest;
import com.zkcloud.api.dbs.model.TodayNormalOpenRequest;
import com.zkcloud.api.dbs.model.TriggerListDeleteRequest;
import com.zkcloud.api.dbs.model.TriggerListUpdateRequest;
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
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import okhttp3.Response;

/**
 * DBS接口连接应用
 */
public class DBSClient extends AbstractClient {

    /**
     * 接口地址
     */
    private static String endpoint = "api.dbs.zkclouds.com";

    public DBSClient(Credential credential) {
        this(endpoint, credential);
    }

    public DBSClient(String endpoint, Credential credential) {
        super(endpoint, credential);
    }

    /**
     * 获取
     *
     * @return 获取accessToken v2.0
     * @throws ZKCloudSDKException
     */
    public GetTokenResponse getToken() throws ZKCloudSDKException {
        try {
            long timestamp = DateUtil.currentSeconds();
            String sign = SecureUtil.md5(this.credential.getAppKey() + timestamp + credential.getAppSecret());
            String url = getBaseUrl() + PathConstant.GET_TOKEN_V2 + "?appKey=%s&timestamp=%s&sign=%s";
            Response response = new HttpConnection().postRequest(String.format(url, credential.getAppKey(), timestamp, sign), "");
            GetTokenResponse getTokenResponse = gson.fromJson(response.body().string(), GetTokenResponse.class);
            return getTokenResponse;
        } catch (IOException e) {
            throw new ZKCloudSDKException(e.getMessage());
        }
    }

    /**
     * 刷新accessToken v2.0
     *
     * @return
     * @throws ZKCloudSDKException
     */
    public DBSClient refreshToken() throws ZKCloudSDKException {
        GetTokenResponse response = getToken();
        if (!ErrorCode.CODE_SUCCESS.equals(response.getCode())) {
            throw new ZKCloudSDKException(response.getMessage(), response.getCode(), response.getMid());
        }

        credential.setAccessToken(response.getAccessToken());
        credential.setExpiresIn(response.getExpiresIn());

        return this;
    }

    /**
     * 创建公司
     *
     * @param company
     * @return
     * @throws ZKCloudSDKException
     */
    public Message<CreateCompanyResponse> createCompany(CompanyRequest company) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/hr/company/create", company);
        Type type = new TypeToken<Message<CreateCompanyResponse>>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 修改公司信息
     *
     * @param company
     * @return
     * @throws ZKCloudSDKException
     */
    public Message<CreateCompanyResponse> updateCompany(CompanyRequest company) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/hr/company/update", company);
        Type type = new TypeToken<Message<CreateCompanyResponse>>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 同步组织架构信息
     *
     * @param org
     * @return
     * @throws ZKCloudSDKException
     */
    public Message updateOrg(OrgUpdateRequest org) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/hr/organization/sync", org);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 同步组织架构信息
     *
     * @param orgList
     * @return
     * @throws ZKCloudSDKException
     */
    public Message<List<OrgUpdateResponse>> updateOrgBatch(OrgUpdateBatchRequest orgList) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/hr/organizations/sync", orgList);
        Type type = new TypeToken<Message<List<OrgUpdateResponse>>>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 删除组织架构
     *
     * @param org
     * @return
     * @throws ZKCloudSDKException
     */
    public Message deleteOrg(OrgDeleteRequest org) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/hr/organization/delete", org);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 删除组织架构(批量)
     *
     * @param orgList
     * @return
     * @throws ZKCloudSDKException
     */
    public Message<List<OrgUpdateResponse>> deleteOrgBatch(OrgDeleteBatchRequest orgList) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/hr/organizations/delete", orgList);
        Type type = new TypeToken<Message<List<OrgUpdateResponse>>>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 员工信息同步
     *
     * @param employee
     * @return
     * @throws ZKCloudSDKException
     */
    public Message updateEmployee(EmployeeUpdateRequest employee) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/hr/employee/sync", employee);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 员工信息同步(批量)
     *
     * @param employeeList
     * @return
     * @throws ZKCloudSDKException
     */
    public Message<List<EmployeeUpdateResponse>> updateEmployeeBatch(EmployeeUpdateBatchRequest employeeList) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/hr/employees/sync", employeeList);
        Type type = new TypeToken<Message<List<EmployeeUpdateResponse>>>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 删除员工信息
     *
     * @param employeeDeleteRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message deleteEmployee(EmployeeDeleteRequest employeeDeleteRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/hr/employee/delete", employeeDeleteRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 删除员工信息(批量)
     *
     * @param employeeDeleteBatchRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message<List<EmployeeDeleteResponse>> deleteEmployeeBatch(EmployeeDeleteBatchRequest employeeDeleteBatchRequest)
            throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/hr/employees/delete", employeeDeleteBatchRequest);
        Type type = new TypeToken<Message<List<EmployeeDeleteResponse>>>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 人脸照片同步
     *
     * @param employeeFaceSyncRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message faceSync(EmployeeFaceSyncRequest employeeFaceSyncRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/hr/employee/face/sync", employeeFaceSyncRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 查询员工核验信息
     *
     * @param verifyInfoRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message<VerifyInfoResponse> queryVerifyInfo(VerifyInfoRequest verifyInfoRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/hr/employee/verifyInfo/query", verifyInfoRequest);
        Type type = new TypeToken<Message<VerifyInfoResponse>>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 查询员工所在设备的核验信息
     *
     * @param verifyInfoByEmployeeRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message<VerifyInfoByEmployeeResponse> verifyInfoByEmployee(VerifyInfoByEmployeeRequest verifyInfoByEmployeeRequest) throws ZKCloudSDKException {
        MessagePayload messagePayload = new MessagePayload();
        messagePayload.setPageSize(verifyInfoByEmployeeRequest.getPageSize());
        messagePayload.setCurPage(verifyInfoByEmployeeRequest.getCurPage());
        String response = baseRequest("/v1.0/hr/employee/verifyInfo/queryByEmployee", verifyInfoByEmployeeRequest, messagePayload);
        Type type = new TypeToken<Message<List<VerifyInfoByEmployeeResponse>>>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 查询设备上的员工核验信息
     *
     * @param verifyInfoByDeviceRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message<VerifyInfoByDeviceResponse> verifyInfoByDevice(VerifyInfoByDeviceRequest verifyInfoByDeviceRequest) throws ZKCloudSDKException {
        MessagePayload messagePayload = new MessagePayload();
        messagePayload.setPageSize(verifyInfoByDeviceRequest.getPageSize());
        messagePayload.setCurPage(verifyInfoByDeviceRequest.getCurPage());
        String response = baseRequest("/v1.0/hr/employee/verifyInfo/queryVerifyBySn", verifyInfoByDeviceRequest, messagePayload);
        Type type = new TypeToken<Message<List<VerifyInfoByDeviceResponse>>>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 删除员工生物模板信息
     *
     * @param biotemplateRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message deleteBiotemplate(BiotemplateRequest biotemplateRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/hr/employee/biotemplate/delete", biotemplateRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 查询员工人脸照片
     *
     * @param employeeFaceRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message<EmployeeFaceResponse> queryEmployeeFace(EmployeeFaceRequest employeeFaceRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/hr/employee/face/query", employeeFaceRequest);
        Type type = new TypeToken<Message<EmployeeFaceResponse>>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 添加设备
     *
     * @param createDeviceRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message addDevice(CreateDeviceRequest createDeviceRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/add", createDeviceRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 修改设备
     *
     * @param deviceUpdateRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message updateDevice(DeviceUpdateRequest deviceUpdateRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/modify", deviceUpdateRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 删除设备
     *
     * @param deviceDeleteRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message deleteDevice(DeviceDeleteRequest deviceDeleteRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/delete", deviceDeleteRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 查询设备信息
     *
     * @param deviceQueryRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message<List<DeviceQueryResponse>> queryDevice(DeviceQueryRequest deviceQueryRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/query", deviceQueryRequest);
        Type type = new TypeToken<Message<List<DeviceQueryResponse>>>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 禁用设备
     *
     * @param deviceDisableRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message disableDevice(DeviceDisableRequest deviceDisableRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/disable", deviceDisableRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 启用设备
     *
     * @param deviceEnableRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message enableDevice(DeviceEnableRequest deviceEnableRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/enable", deviceEnableRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 重启设备
     *
     * @param deviceRebootRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message rebootDevice(DeviceRebootRequest deviceRebootRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/reboot", deviceRebootRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 重新上传人员信息
     *
     * @param deviceReloadEmployeeRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message reloadEmployeeFromDevice(DeviceReloadEmployeeRequest deviceReloadEmployeeRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/reloadEmployeeInfo", deviceReloadEmployeeRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 重新上传考勤记录
     *
     * @param deviceReloadPunchRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message reloadPunchFromDevice(DeviceReloadPunchRequest deviceReloadPunchRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/reloadPunchRecord", deviceReloadPunchRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 同步所有人员到设备
     *
     * @param deviceRefreshEmployeeRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message refreshEmployeeToDevice(DeviceRefreshEmployeeRequest deviceRefreshEmployeeRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/hr/employee/device/refreshEmployeeInfo", deviceRefreshEmployeeRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 远程指纹登记(弃用)
     * 改用 registerBiometric(登记生物特征)
     *
     * @param fpRequest
     * @return
     * @throws ZKCloudSDKException
     */
    @Deprecated
    public Message<RegisterFpResponse> registerFp(RegisterFpRequest fpRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/registerFp", fpRequest);
        Type type = new TypeToken<Message<RegisterFpResponse>>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 取消远程指纹登记(弃用)
     * 改用 cancelRegisterBiometric(取消登记生物特征)
     *
     * @param cancelRegisterFpRequest
     * @return
     * @throws ZKCloudSDKException
     */
    @Deprecated
    public Message cancelRegisterFp(CancelRegisterFpRequest cancelRegisterFpRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/cancelRegisterFp", cancelRegisterFpRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 登记生物特征
     *
     * @param registerBiometricRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message<RegisterBiometricResponse> registerBiometric(RegisterBiometricRequest registerBiometricRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/registerBiometric", registerBiometricRequest);
        Type type = new TypeToken<Message<RegisterBiometricResponse>>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 取消登记生物特征
     *
     * @param cancelRegisterBiometricRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message cancelRegisterBiometric(CancelRegisterBiometricRequest cancelRegisterBiometricRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/cancelRegisterBiometric", cancelRegisterBiometricRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 分页查询设备命令
     *
     * @param commandListByPageRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message<List<CommandListByPageResponse>> commandListByPage(CommandListByPageRequest commandListByPageRequest) throws ZKCloudSDKException {

        MessagePayload messagePayload = new MessagePayload();
        messagePayload.setPageSize(commandListByPageRequest.getPageSize());
        messagePayload.setCurPage(commandListByPageRequest.getCurPage());

        String response = baseRequest("/v1.0/device/commandListByPage", commandListByPageRequest, messagePayload);
        Type type = new TypeToken<Message<List<CommandListByPageResponse>>>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 组织设备关系绑定
     *
     * @param orgBindDeviceRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message<OrgBindDeviceResponse> orgBindDevice(OrgBindDeviceRequest orgBindDeviceRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/hr/organization/bindDevice", orgBindDeviceRequest);
        Type type = new TypeToken<Message<OrgBindDeviceResponse>>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 组织设备关系解绑
     *
     * @param orgUnbindDeviceRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message<OrgUnbindDeviceResponse> orgUnBindDevice(OrgUnbindDeviceRequest orgUnbindDeviceRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/hr/organization/unbindDevice", orgUnbindDeviceRequest);
        Type type = new TypeToken<Message<OrgUnbindDeviceResponse>>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 人员设备关系绑定
     *
     * @param employeeBindDeviceRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message<EmployeeBindDeviceResponse> employeeBindDevice(EmployeeBindDeviceRequest employeeBindDeviceRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/hr/employee/bindDevice", employeeBindDeviceRequest);
        Type type = new TypeToken<Message<EmployeeBindDeviceResponse>>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 人员设备关系解绑
     *
     * @param employeeUnbindDeviceRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message<EmployeeUnbindDeviceResponse> employeeUnBindDevice(EmployeeUnbindDeviceRequest employeeUnbindDeviceRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/hr/employee/unbindDevice", employeeUnbindDeviceRequest);
        Type type = new TypeToken<Message<EmployeeUnbindDeviceResponse>>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 远程开门
     *
     * @param openDoorRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message openDoor(OpenDoorRequest openDoorRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/openDoor", openDoorRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 修改门信息
     *
     * @param doorUpdateRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message updateDoor(DoorUpdateRequest doorUpdateRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/door/update", doorUpdateRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 查询门信息
     *
     * @param doorQueryRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message<List<DoorQueryResponse>> queryDoor(DoorQueryRequest doorQueryRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/door/query", doorQueryRequest);
        Type type = new TypeToken<Message<List<DoorQueryResponse>>>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 修改门参数
     *
     * @param doorParamUpdateRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message updateDoorParam(DoorParamUpdateRequest doorParamUpdateRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/doorParam/update", doorParamUpdateRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 查询门参数
     *
     * @param doorParamQueryRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message<List<DoorParamQueryResponse>> queryDoorParam(DoorParamQueryRequest doorParamQueryRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/doorParam/query", doorParamQueryRequest);
        Type type = new TypeToken<Message<List<DoorParamQueryResponse>>>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 下发开门密码
     * @param doorPasswordUpdateRequest
     * @return
     * @throws ZKCloudSDKException
     */
    @Deprecated
    public Message updateDoorPassword(DoorPasswordUpdateRequest doorPasswordUpdateRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/doorPassword/update", doorPasswordUpdateRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 删除开门密码
     * @param doorPasswordDeleteRequest
     * @return
     * @throws ZKCloudSDKException
     */
    @Deprecated
    public Message deleteDoorPassword(DoorPasswordDeleteRequest doorPasswordDeleteRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/doorPassword/delete", doorPasswordDeleteRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 密码远程开门
     * @param doorPasswordOpenRequest
     * @return
     * @throws ZKCloudSDKException
     */
    @Deprecated
    public Message openDoorPassword (DoorPasswordOpenRequest doorPasswordOpenRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/doorPassword/open", doorPasswordOpenRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 更新门禁时间段
     *
     * @param doorTimeZoneRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message updateDoorTimeZone(DoorTimeZoneUpdateRequest doorTimeZoneRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/timezone/update", doorTimeZoneRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 删除门禁时间段
     *
     * @param doorTimeZoneDeleteRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message deleteDoorTimeZone(DoorTimeZoneDeleteRequest doorTimeZoneDeleteRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/timezone/delete", doorTimeZoneDeleteRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 更新门禁权限组
     *
     * @param doorPermissionGroupUpdateRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message updateDoorPermissionGroup(DoorPermissionGroupUpdateRequest doorPermissionGroupUpdateRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/permissionGroup/update", doorPermissionGroupUpdateRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 删除门禁权限组
     *
     * @param doorPermissionGroupDeleteRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message deleteDoorPermissionGroup(DoorPermissionGroupDeleteRequest doorPermissionGroupDeleteRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/permissionGroup/delete", doorPermissionGroupDeleteRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 门禁权限组分配门
     *
     * @param doorPermissionGroupAddDoorRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message doorPermissionGroupAddDoor(DoorPermissionGroupAddDoorRequest doorPermissionGroupAddDoorRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/permissionGroup/addDoor", doorPermissionGroupAddDoorRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 门禁权限组移除门
     *
     * @param doorPermissionGroupRemoveDoorRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message doorPermissionGroupRemoveDoor(DoorPermissionGroupRemoveDoorRequest doorPermissionGroupRemoveDoorRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/permissionGroup/removeDoor", doorPermissionGroupRemoveDoorRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 门禁权限组分配人
     *
     * @param doorPermissionGroupAddEmployeeRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message doorPermissionGroupAddEmployee(DoorPermissionGroupAddEmployeeRequest doorPermissionGroupAddEmployeeRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/permissionGroup/addEmp", doorPermissionGroupAddEmployeeRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 门禁权限组移除人
     *
     * @param doorPermissionGroupRemoveEmployeeRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message doorPermissionGroupRemoveEmployee(DoorPermissionGroupRemoveEmployeeRequest doorPermissionGroupRemoveEmployeeRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/permissionGroup/removeEmp", doorPermissionGroupRemoveEmployeeRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 门禁权限组移除全部人
     *
     * @param doorPermissionGroupRemoveAllEmployeeRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message doorPermissionGroupRemoveAllEmployee(DoorPermissionGroupRemoveAllEmployeeRequest doorPermissionGroupRemoveAllEmployeeRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/permissionGroup/removeAllEmp", doorPermissionGroupRemoveAllEmployeeRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }


    /**
     * 更新门禁节假日
     *
     * @param doorHolidayUpdateRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message updateDoorHoliday(DoorHolidayUpdateRequest doorHolidayUpdateRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/holiday/update", doorHolidayUpdateRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 删除门禁节假日
     *
     * @param doorHolidayDeleteRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message deleteDoorHoliday(DoorHolidayDeleteRequest doorHolidayDeleteRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/holiday/delete", doorHolidayDeleteRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 获取门禁二维码
     *
     * @param doorQRCodeRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message getQRCode(DoorQRCodeRequest doorQRCodeRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/QRCode/obtain", doorQRCodeRequest);
        Type type = new TypeToken<Message<DoorQRCodeResponse>>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 分页获取门禁事件记录
     *
     * @param doorTransactionRecordRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message<List<DoorTransactionRecordResponse>> getTransactionRecord(DoorTransactionRecordRequest doorTransactionRecordRequest) throws ZKCloudSDKException {
        MessagePayload messagePayload = new MessagePayload();
        messagePayload.setPageSize(doorTransactionRecordRequest.getPageSize());
        messagePayload.setCurPage(doorTransactionRecordRequest.getCurPage());
        String response = baseRequest("/v1.0/device/event/accTransaction/getByPage", doorTransactionRecordRequest, messagePayload);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 分页获取设备打卡记录
     *
     * @param punchRecordByPageRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message<List<PunchRecordByPageResponse>> getPunchRecordByPage(PunchRecordByPageRequest punchRecordByPageRequest) throws ZKCloudSDKException {
        MessagePayload messagePayload = new MessagePayload();
        messagePayload.setPageSize(punchRecordByPageRequest.getPageSize());
        messagePayload.setCurPage(punchRecordByPageRequest.getCurPage());
        String response = baseRequest("/v1.0/device/event/punchRecord/getByPage", punchRecordByPageRequest, messagePayload);
        Type type = new TypeToken<Message<List<PunchRecordByPageResponse>>>() {
        }.getType();
        return gson.fromJson(response, type);
    }


    /**
     * 打卡记录校对
     *
     * @param punchRecordVerifyRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message<PunchRecordVerifyResponse> verifyPunchRecord(PunchRecordVerifyRequest punchRecordVerifyRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/event/punchRecord/verify", punchRecordVerifyRequest);
        Type type = new TypeToken<Message<PunchRecordVerifyResponse>>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * getNewVersions
     * 查询升级版本列表
     * @param newFwVersionsRequest
     * @return com.zkcloud.api.dbs.common.Message<com.zkcloud.api.dbs.model.NewFwVersionsResponse>
     * @throws
     * @author miller.li
     * @date 2020/12/31 10:32
     * @since 1.0.0
     */
    public Message<NewFwVersionsResponse> getNewVersions(NewFwVersionsRequest newFwVersionsRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/ufo/device/newest", newFwVersionsRequest);
        Type type = new TypeToken<Message<NewFwVersionsResponse>>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * deviceUpgrade
     * 升级固件
     * @param deviceUpgradeRequest
     * @return com.zkcloud.api.dbs.common.Message<com.zkcloud.api.dbs.model.DeviceUpgradeResponse>
     * @throws
     * @author miller.li
     * @date 2020/12/31 14:14
     * @since 1.0.0
     */
    public Message<DeviceUpgradeResponse> deviceUpgrade(DeviceUpgradeRequest deviceUpgradeRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/ufo/device/upgrade", deviceUpgradeRequest);
        Type type = new TypeToken<Message<DeviceUpgradeResponse>>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * getUpgradeHistory
     * 查询设备升级历史
     * @param deviceUpgradeHistoryRequest
     * @return com.zkcloud.api.dbs.common.Message<java.util.List < com.zkcloud.api.dbs.model.DeviceUpgradeHistoryResponse>>
     * @throws
     * @author miller.li
     * @date 2021/1/7 9:17
     * @since 1.0.0
     */
    public Message<List<DeviceUpgradeHistoryResponse>> getUpgradeHistory(DeviceUpgradeHistoryRequest deviceUpgradeHistoryRequest) throws ZKCloudSDKException {
        MessagePayload messagePayload = new MessagePayload();
        messagePayload.setPageSize(deviceUpgradeHistoryRequest.getPageSize());
        messagePayload.setCurPage(deviceUpgradeHistoryRequest.getCurPage());
        String response = baseRequest("/v1.0/ufo/device/queryUpgradeHistory", deviceUpgradeHistoryRequest, messagePayload);
        Type type = new TypeToken<Message<List<DeviceUpgradeHistoryResponse>>>() {
        }.getType();
        return gson.fromJson(response, type);
    }
    
    /**
     * deviceUpgradeBatch
     *  批量升级
     * @param deviceUpgradeBatchRequest
     * @return com.zkcloud.api.dbs.common.Message<java.util.List < com.zkcloud.api.dbs.model.DeviceUpgradeBatchResponse>>
     * @throws
     * @author miller.li
     * @date 2021/1/7 9:19
     * @since 1.0.0
     */
    @Deprecated
    public Message<List<DeviceUpgradeBatchResponse>> deviceUpgradeBatch(DeviceUpgradeBatchRequest deviceUpgradeBatchRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/ufo/devices/upgrade", deviceUpgradeBatchRequest);
        Type type = new TypeToken<Message<List<DeviceUpgradeBatchResponse>>>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * getSeries
     * 固件系列版本
     * @param fwSeriesRequest
     * @return com.zkcloud.api.dbs.common.Message<com.zkcloud.api.dbs.model.FwSeriesResponse>
     * @throws
     * @author miller.li
     * @date 2021/1/7 9:20
     * @since 1.0.0
     */
    @Deprecated
    public Message<FwSeriesResponse> getSeries(FwSeriesRequest fwSeriesRequest) throws ZKCloudSDKException{
        String response = baseRequest("/v1.0/ufo/device/querySeries", fwSeriesRequest);
        Type type = new TypeToken<Message<FwSeriesResponse>>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * 更新首人常开
     *
     * @param firstCardUpdateRequest
     * @return
     * @throws ZKCloudSDKException
     */
    public Message updateFirstOpen(FirstOpenUpdateRequest firstCardUpdateRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/firstOpen/update", firstCardUpdateRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * deleteFirstCard
     * 删除首人常开
     * @param firstCardDeleteRequest
     * @return com.zkcloud.api.dbs.common.Message
     * @throws
     * @author miller.li
     * @date 2021/7/5 14:24
     * @since 1.0.0
     */
    public Message deleteFirstOpen(FirstOpenDeleteRequest firstCardDeleteRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/firstOpen/delete", firstCardDeleteRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }


    /**
     * updateEmployeeGroup
     * 更新多人开门人员组
     * @param employeeGroupUpdateRequest
     * @return com.zkcloud.api.dbs.common.Message
     * @throws
     * @author miller.li
     * @date 2021/7/5 14:24
     * @since 1.0.0
     */
    public Message updateEmployeeGroup(EmployeeGroupUpdateRequest employeeGroupUpdateRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/employeeGroup/update", employeeGroupUpdateRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }


    /**
     * deleteEmployeeGroup
     * 删除多人开门人员组
     * @param employeeGroupDeleteRequest
     * @return com.zkcloud.api.dbs.common.Message
     * @throws
     * @author miller.li
     * @date 2021/7/5 14:45
     * @since 1.0.0
     */
    public Message deleteEmployeeGroup(EmployeeGroupDeleteRequest employeeGroupDeleteRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/employeeGroup/delete", employeeGroupDeleteRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }


    /**
     * updateEmployeeGroup
     * 更新多人开门人员组
     * @param multiGroupUpdateRequest
     * @return com.zkcloud.api.dbs.common.Message
     * @throws
     * @author miller.li
     * @date 2021/7/5 14:24
     * @since 1.0.0
     */
    public Message updateMultiGroup(MultiGroupUpdateRequest multiGroupUpdateRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/multiGroup/update", multiGroupUpdateRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * deleteMultiGroup
     * 删除多人开门
     * @param multiGroupDeleteRequest
     * @return com.zkcloud.api.dbs.common.Message
     * @throws
     * @author miller.li
     * @date 2021/7/5 15:24
     * @since 1.0.0
     */
    public Message deleteMultiGroup(MultiGroupDeleteRequest multiGroupDeleteRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/multiGroup/delete", multiGroupDeleteRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }


    /**
     * updateSuperUser
     * 更新超级用户权限
     * @param superUserUpdateRequest
     * @return com.zkcloud.api.dbs.common.Message
     * @throws
     * @author miller.li
     * @date 2021/7/5 15:46
     * @since 1.0.0
     */
    public Message updateSuperUser(SuperUserUpdateRequest superUserUpdateRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/superUser/update", superUserUpdateRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * deleteSuperUser
     * 删除超级用户权限
     * @param superUserDeleteRequest
     * @return com.zkcloud.api.dbs.common.Message
     * @throws
     * @author miller.li
     * @date 2021/7/5 16:23
     * @since 1.0.0
     */
    public Message deleteSuperUser(SuperUserDeleteRequest superUserDeleteRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/superUser/delete", superUserDeleteRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * closeDoor
     * 远程关门
     * @param doorCloseRequest
     * @return com.zkcloud.api.dbs.common.Message
     * @throws
     * @author miller.li
     * @date 2021/7/5 16:40
     * @since 1.0.0
     */
    public Message closeDoor(DoorCloseRequest doorCloseRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/closeDoor", doorCloseRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * closeDoor
     * 远程常开
     * @param normalOpenRequest
     * @return com.zkcloud.api.dbs.common.Message
     * @throws
     * @author miller.li
     * @date 2021/7/5 16:46
     * @since 1.0.0
     */
    public Message normalOpen(NormalOpenRequest normalOpenRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/normalOpen", normalOpenRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * normalOpen
     * 控制当天常开
     * @param todayNormalOpenRequest
     * @return com.zkcloud.api.dbs.common.Message
     * @throws
     * @author miller.li
     * @date 2021/7/5 16:53
     * @since 1.0.0
     */
    public Message todayNormalOpen(TodayNormalOpenRequest todayNormalOpenRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/todayNormalOpen", todayNormalOpenRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * lockGate
     * 远程锁定
     * @param lockGateRequest
     * @return com.zkcloud.api.dbs.common.Message
     * @throws
     * @author miller.li
     * @date 2021/7/5 17:00
     * @since 1.0.0
     */
    public Message lockGate(LockGateRequest lockGateRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/lockGate", lockGateRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }


    /**
     * updateReader
     * 修改读头信息
     * @param readerUpdateRequest
     * @return com.zkcloud.api.dbs.common.Message
     * @throws
     * @author miller.li
     * @date 2021/7/5 17:18
     * @since 1.0.0
     */
    public Message updateReader(ReaderUpdateRequest readerUpdateRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/reader/update", readerUpdateRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * queryReader
     * 查询读头信息
     * @param readerQueryRequest
     * @return com.zkcloud.api.dbs.common.Message<java.util.List < com.zkcloud.api.dbs.model.ReaderQueryResponse>>
     * @throws
     * @author miller.li
     * @date 2021/7/5 18:03
     * @since 1.0.0
     */
    public Message<List<ReaderQueryResponse>> queryReader(ReaderQueryRequest readerQueryRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/reader/query", readerQueryRequest);
        Type type = new TypeToken<Message<List<ReaderQueryResponse>>>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * updateReaderParam
     * 修改读头参数（废弃）
     * @param readerParamUpdateRequest
     * @return com.zkcloud.api.dbs.common.Message
     * @throws
     * @author miller.li
     * @date 2021/7/5 18:25
     * @since 1.0.0
     */
    @Deprecated
    public Message updateReaderParam(ReaderParamUpdateRequest readerParamUpdateRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/readerParam/update", readerParamUpdateRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * queryReaderParam
     * 查询读头参数
     * @param readerParamQueryRequest
     * @return com.zkcloud.api.dbs.common.Message
     * @throws
     * @author miller.li
     * @date 2021/7/6 9:42
     * @since 1.0.0
     */
    @Deprecated
    public Message<List<ReaderParamQueryResponse>> queryReaderParam(ReaderParamQueryRequest readerParamQueryRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/readerParam/query", readerParamQueryRequest);
        Type type = new TypeToken<Message<List<ReaderParamQueryResponse>>>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * cancelAlarm
     * 取消报警
     * @param alarmCancelRequest
     * @return com.zkcloud.api.dbs.common.Message
     * @throws
     * @author miller.li
     * @date 2021/7/6 11:49
     * @since 1.0.0
     */
    public Message cancelAlarm(AlarmCancelRequest alarmCancelRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/cancelAlarm", alarmCancelRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }


    /**
     * reloadRecord
     * 重新上传设备记录
     * @param reloadDeviceRecordRequest
     * @return com.zkcloud.api.dbs.common.Message
     * @throws
     * @author miller.li
     * @date 2021/7/6 13:48
     * @since 1.0.0
     */
    public Message reloadRecord(ReloadDeviceRecordRequest reloadDeviceRecordRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/reloadRecord", reloadDeviceRecordRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * reloadRecord
     * 重新上传设备信息(废弃)
     * @param reloadDeviceInfoRequest
     * @return com.zkcloud.api.dbs.common.Message
     * @throws
     * @author miller.li
     * @date 2021/7/6 14:13
     * @since 1.0.0
     */
    @Deprecated
    public Message reloadDeviceInfo(ReloadDeviceInfoRequest reloadDeviceInfoRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/reloadDeviceInfo", reloadDeviceInfoRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * syncTime
     * 同步服务器时间到设备
     * @param timeSyncRequest
     * @return com.zkcloud.api.dbs.common.Message
     * @throws
     * @author miller.li
     * @date 2021/7/7 16:41
     * @since 1.0.0
     */
    public Message syncTime(TimeSyncRequest timeSyncRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/syncTime", timeSyncRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * linkageUpdate
     * 更新联动信息
     * @param linkageUpdateRequest
     * @return com.zkcloud.api.dbs.common.Message
     * @throws
     * @author miller.li
     * @date 2021/8/2 15:27
     * @since 1.0.0
     */
    public Message updateLinkage(LinkageUpdateRequest linkageUpdateRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/linkage/update", linkageUpdateRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * deleteLinkage
     * 删除联动信息
     * @param linkageDeleteRequest
     * @return com.zkcloud.api.dbs.common.Message
     * @throws
     * @author miller.li
     * @date 2021/8/2 15:34
     * @since 1.0.0
     */
    public Message deleteLinkage(LinkageDeleteRequest linkageDeleteRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/linkage/delete", linkageDeleteRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * updateUserLinkage
     * 更新用户联动信息
     * @param userLinkageUpdateRequest
     * @return com.zkcloud.api.dbs.common.Message
     * @throws
     * @author miller.li
     * @date 2021/8/2 15:46
     * @since 1.0.0
     */
    public Message updateUserLinkage(UserLinkageUpdateRequest userLinkageUpdateRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/userLinkage/update", userLinkageUpdateRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * deleteUserLinkage
     * 删除用户联动信息
     * @param userLinkageDeleteRequest
     * @return com.zkcloud.api.dbs.common.Message
     * @throws
     * @author miller.li
     * @date 2021/8/2 15:55
     * @since 1.0.0
     */
    public Message deleteUserLinkage(UserLinkageDeleteRequest userLinkageDeleteRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/userLinkage/delete", userLinkageDeleteRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * updateAntiPassBack
     * 更新反潜信息
     * @param antiPassBackUpdateRequest
     * @return com.zkcloud.api.dbs.common.Message
     * @throws
     * @author miller.li
     * @date 2021/8/2 16:14
     * @since 1.0.0
     */
    public Message updateAntiPassBack(AntiPassBackUpdateRequest antiPassBackUpdateRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/antiPassBack/update", antiPassBackUpdateRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * deleteAntiPassBack
     * 删除反潜信息
     * @param antiPassBackDeleteRequest
     * @return com.zkcloud.api.dbs.common.Message
     * @throws
     * @author miller.li
     * @date 2021/8/2 16:21
     * @since 1.0.0
     */
    public Message deleteAntiPassBack(AntiPassBackDeleteRequest antiPassBackDeleteRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/antiPassBack/delete", antiPassBackDeleteRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }


    /**
     * updateUserAntiPassBack
     * 更新用户反潜信息
     * @param userAntiPassBackUpdateRequest
     * @return com.zkcloud.api.dbs.common.Message
     * @throws
     * @author miller.li
     * @date 2021/8/2 16:34
     * @since 1.0.0
     */
    public Message updateUserAntiPassBack(UserAntiPassBackUpdateRequest userAntiPassBackUpdateRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/userAntiPassBack/update", userAntiPassBackUpdateRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }
    
    /**
     * deleteAntiPassBack
     *  删除用户反潜信息
     * @param userAntiPassBackDeleteRequest
     * @return com.zkcloud.api.dbs.common.Message
     * @throws
     * @author miller.li
     * @date 2021/8/2 16:40
     * @since 1.0.0
     */
    public Message deleteUserAntiPassBack(UserAntiPassBackDeleteRequest userAntiPassBackDeleteRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/userAntiPassBack/delete", userAntiPassBackDeleteRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * updateInterLock
     * 更新互锁信息
     * @param interLockUpdateRequest
     * @return com.zkcloud.api.dbs.common.Message
     * @throws
     * @author miller.li
     * @date 2021/8/2 16:54
     * @since 1.0.0
     */
    public Message updateInterLock(InterLockUpdateRequest interLockUpdateRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/interLock/update", interLockUpdateRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * deleteInterLock
     * 删除互锁信息
     * @param interLockDeleteRequest
     * @return com.zkcloud.api.dbs.common.Message
     * @throws
     * @author miller.li
     * @date 2021/8/2 17:00
     * @since 1.0.0
     */
    public Message deleteInterLock(InterLockDeleteRequest interLockDeleteRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/interLock/delete", interLockDeleteRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * updateUserInterLock
     * 更新用户互锁信息
     * @param userInterLockUpdateRequest
     * @return com.zkcloud.api.dbs.common.Message
     * @throws
     * @author miller.li
     * @date 2021/8/2 17:06
     * @since 1.0.0
     */
    public Message updateUserInterLock(UserInterLockUpdateRequest userInterLockUpdateRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/userInterLock/update", userInterLockUpdateRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }
    
    /**
     * deleteUserInterLock
     * 删除用户互锁信息
     * @param userInterLockDeleteRequest
     * @return com.zkcloud.api.dbs.common.Message
     * @throws
     * @author miller.li
     * @date 2021/8/2 17:13
     * @since 1.0.0
     */
    public Message deleteUserInterLock(UserInterLockDeleteRequest userInterLockDeleteRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/userInterLock/delete", userInterLockDeleteRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * updateTriggerList
     * 更新触发点集合
     * @param triggerListUpdateRequest
     * @return com.zkcloud.api.dbs.common.Message
     * @throws
     * @author miller.li
     * @date 2021/8/2 17:29
     * @since 1.0.0
     */
    public Message updateTriggerList(TriggerListUpdateRequest triggerListUpdateRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/triggerList/update", triggerListUpdateRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * deleteTriggerList
     * 删除触发点集合
     * @param triggerListDeleteRequest
     * @return com.zkcloud.api.dbs.common.Message
     * @throws
     * @author miller.li
     * @date 2021/8/2 17:36
     * @since 1.0.0
     */
    public Message deleteTriggerList(TriggerListDeleteRequest triggerListDeleteRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/triggerList/delete", triggerListDeleteRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * updateAuxIn
     * 修改辅助输入信息
     * @param auxInUpdateRequest
     * @return com.zkcloud.api.dbs.common.Message
     * @throws
     * @author miller.li
     * @date 2021/8/2 17:59
     * @since 1.0.0
     */
    public Message updateAuxIn(AuxInUpdateRequest auxInUpdateRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/auxIn/update", auxInUpdateRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * queryAuxIn
     * 查询辅助输入信息
     * @param auxInQueryRequest
     * @return com.zkcloud.api.dbs.common.Message<com.zkcloud.api.dbs.model.AuxInQueryResponse>
     * @throws
     * @author miller.li
     * @date 2021/8/3 9:26
     * @since 1.0.0
     */
    public Message<List<AuxInQueryResponse>> queryAuxIn(AuxInQueryRequest auxInQueryRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/auxIn/query", auxInQueryRequest);
        Type type = new TypeToken<Message<List<AuxInQueryResponse>>>() {
        }.getType();
        return gson.fromJson(response, type);
    }
    
    /**
     * updateAuxOut
     * 修改辅助输出信息
     * @param auxOutUpdateRequest
     * @return com.zkcloud.api.dbs.common.Message
     * @throws
     * @author miller.li
     * @date 2021/8/3 9:54
     * @since 1.0.0
     */
    public Message updateAuxOut(AuxOutUpdateRequest auxOutUpdateRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/auxOut/update", auxOutUpdateRequest);
        Type type = new TypeToken<Message>() {
        }.getType();
        return gson.fromJson(response, type);
    }

    /**
     * queryAuxOut
     * 查询辅助输出信息
     * @param auxOutQueryRequest
     * @return com.zkcloud.api.dbs.common.Message<com.zkcloud.api.dbs.model.AuxOutQueryResponse>
     * @throws
     * @author miller.li
     * @date 2021/8/3 10:08
     * @since 1.0.0
     */
    public Message<List<AuxOutQueryResponse>> queryAuxOut(AuxOutQueryRequest auxOutQueryRequest) throws ZKCloudSDKException {
        String response = baseRequest("/v1.0/device/auxOut/query", auxOutQueryRequest);
        Type type = new TypeToken<Message<List<AuxOutQueryResponse>>>() {
        }.getType();
        return gson.fromJson(response, type);
    }


}
