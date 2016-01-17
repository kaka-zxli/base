package com.kaka.base.dto;

public class MsgDto extends BaseDto {

	private static final long serialVersionUID = 7316185037549744819L;

	private String masterId; // 主机ID
	private String slaveId; // 从机ID
	private String deviceType; // 设备类型
	private String serviceType; // 服务类型
	private String data; // 数据

	public String getMasterId() {
		return masterId;
	}

	public void setMasterId(String masterId) {
		this.masterId = masterId;
	}

	public String getSlaveId() {
		return slaveId;
	}

	public void setSlaveId(String slaveId) {
		this.slaveId = slaveId;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
