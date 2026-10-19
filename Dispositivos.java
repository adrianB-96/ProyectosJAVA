/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PassReset;

/**
 *
 * @author justh
 */
public class Dispositivos {
    private String deviceName;
    private boolean enabled;
    private String fwVersion;
    private int commType;
    private String ipAdress;
    private String gateway;
    private String subnetMask;
    private String port;
    private String sn;
    private String id;

    public Dispositivos(String deviceName, boolean enabled, String fwVersion, int commType, String ipAdress, String gateway, String subnetMask, String port, String sn, String id) {
        this.deviceName = deviceName;
        this.enabled = enabled;
        this.fwVersion = fwVersion;
        this.commType = commType;
        this.ipAdress = ipAdress;
        this.gateway = gateway;
        this.subnetMask = subnetMask;
        this.port = port;
        this.sn = sn;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Dispositivos{" + "deviceName=" + deviceName + ", enabled=" + enabled + ", fwVersion=" + fwVersion + ", commType=" + commType + ", ipAdress=" + ipAdress + ", gateway=" + gateway + ", subnetMask=" + subnetMask + ", port=" + port + ", sn=" + sn + ", id=" + id + '}';
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getFwVersion() {
        return fwVersion;
    }

    public void setFwVersion(String fwVersion) {
        this.fwVersion = fwVersion;
    }

    public int getCommType() {
        return commType;
    }

    public void setCommType(int commType) {
        this.commType = commType;
    }

    public String getIpAdress() {
        return ipAdress;
    }

    public void setIpAdress(String ipAdress) {
        this.ipAdress = ipAdress;
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }

    public String getSubnetMask() {
        return subnetMask;
    }

    public void setSubnetMask(String subnetMask) {
        this.subnetMask = subnetMask;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
