package com.its.demo.entities;

import java.util.Date;

public class Yundiao {
    private String id;

    private String workId;

    private String linecode;

    private String name;

    private String description;

    private String regionId;

    private String ctUserId;

    private String vpcId;

    private String localCidr;

    private String portType;

    private Integer bandwidth;

    private String location;

    private String vlan;

    private String deviceType;

    private String deviceId;

    private String localGatewayIp;

    private String remoteCidr;

    private String remoteGatewayIp;

    private String interfaceName;

    private String routemode;

    private String bgpasn;

    private String aslocal;

    private Integer lineType;

    private String privateLineId;

    private String ipVersion;

    private String cloudCdaId;

    private Integer srcVtepVlan;

    private String srcVtepIp;

    private Integer srcVxlanVni;

    private String srcGateway;

    private Date addTime;

    private Date modTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId == null ? null : workId.trim();
    }

    public String getLinecode() {
        return linecode;
    }

    public void setLinecode(String linecode) {
        this.linecode = linecode == null ? null : linecode.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId == null ? null : regionId.trim();
    }

    public String getCtUserId() {
        return ctUserId;
    }

    public void setCtUserId(String ctUserId) {
        this.ctUserId = ctUserId == null ? null : ctUserId.trim();
    }

    public String getVpcId() {
        return vpcId;
    }

    public void setVpcId(String vpcId) {
        this.vpcId = vpcId == null ? null : vpcId.trim();
    }

    public String getLocalCidr() {
        return localCidr;
    }

    public void setLocalCidr(String localCidr) {
        this.localCidr = localCidr == null ? null : localCidr.trim();
    }

    public String getPortType() {
        return portType;
    }

    public void setPortType(String portType) {
        this.portType = portType == null ? null : portType.trim();
    }

    public Integer getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(Integer bandwidth) {
        this.bandwidth = bandwidth;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getVlan() {
        return vlan;
    }

    public void setVlan(String vlan) {
        this.vlan = vlan == null ? null : vlan.trim();
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType == null ? null : deviceType.trim();
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public String getLocalGatewayIp() {
        return localGatewayIp;
    }

    public void setLocalGatewayIp(String localGatewayIp) {
        this.localGatewayIp = localGatewayIp == null ? null : localGatewayIp.trim();
    }

    public String getRemoteCidr() {
        return remoteCidr;
    }

    public void setRemoteCidr(String remoteCidr) {
        this.remoteCidr = remoteCidr == null ? null : remoteCidr.trim();
    }

    public String getRemoteGatewayIp() {
        return remoteGatewayIp;
    }

    public void setRemoteGatewayIp(String remoteGatewayIp) {
        this.remoteGatewayIp = remoteGatewayIp == null ? null : remoteGatewayIp.trim();
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName == null ? null : interfaceName.trim();
    }

    public String getRoutemode() {
        return routemode;
    }

    public void setRoutemode(String routemode) {
        this.routemode = routemode == null ? null : routemode.trim();
    }

    public String getBgpasn() {
        return bgpasn;
    }

    public void setBgpasn(String bgpasn) {
        this.bgpasn = bgpasn == null ? null : bgpasn.trim();
    }

    public String getAslocal() {
        return aslocal;
    }

    public void setAslocal(String aslocal) {
        this.aslocal = aslocal == null ? null : aslocal.trim();
    }

    public Integer getLineType() {
        return lineType;
    }

    public void setLineType(Integer lineType) {
        this.lineType = lineType;
    }

    public String getPrivateLineId() {
        return privateLineId;
    }

    public void setPrivateLineId(String privateLineId) {
        this.privateLineId = privateLineId == null ? null : privateLineId.trim();
    }

    public String getIpVersion() {
        return ipVersion;
    }

    public void setIpVersion(String ipVersion) {
        this.ipVersion = ipVersion == null ? null : ipVersion.trim();
    }

    public String getCloudCdaId() {
        return cloudCdaId;
    }

    public void setCloudCdaId(String cloudCdaId) {
        this.cloudCdaId = cloudCdaId == null ? null : cloudCdaId.trim();
    }

    public Integer getSrcVtepVlan() {
        return srcVtepVlan;
    }

    public void setSrcVtepVlan(Integer srcVtepVlan) {
        this.srcVtepVlan = srcVtepVlan;
    }

    public String getSrcVtepIp() {
        return srcVtepIp;
    }

    public void setSrcVtepIp(String srcVtepIp) {
        this.srcVtepIp = srcVtepIp == null ? null : srcVtepIp.trim();
    }

    public Integer getSrcVxlanVni() {
        return srcVxlanVni;
    }

    public void setSrcVxlanVni(Integer srcVxlanVni) {
        this.srcVxlanVni = srcVxlanVni;
    }

    public String getSrcGateway() {
        return srcGateway;
    }

    public void setSrcGateway(String srcGateway) {
        this.srcGateway = srcGateway == null ? null : srcGateway.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getModTime() {
        return modTime;
    }

    public void setModTime(Date modTime) {
        this.modTime = modTime;
    }
}