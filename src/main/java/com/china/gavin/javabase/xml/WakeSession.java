package com.china.gavin.javabase.xml;

/**
 * WakeSession Class.
 */
public class WakeSession {

    /**
     * SessionId Attribute.
     */
    private String id;
    /**
     * ExtendedStatus Attribute.
     */
    private String extendedStatus;
    /**
     * keepAlivePeriod Attribute.
     */
    private String keepAlivePeriod;
    /**
     * LastKAReceived Attribute.
     */
    private String lastKAReceived;
    /**
     * LastStateChange Attribute.
     */
    private String lastStateChange;
    /**
     * LastWakeAttemp Attribute.
     */
    private String lastWakeAttemp;
    /**
     * Wake Status Attribute.
     */
    private WakeSessionStatus status;
    /**
     * WakeableIn Attribute.
     */
    private String wakeableIn;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getExtendedStatus() {
        return extendedStatus;
    }

    public void setExtendedStatus(String extendedStatus) {
        this.extendedStatus = extendedStatus;
    }

    public String getKeepAlivePeriod() {
        return keepAlivePeriod;
    }

    public void setKeepAlivePeriod(String keepAlivePeriod) {
        this.keepAlivePeriod = keepAlivePeriod;
    }

    public String getLastKAReceived() {
        return lastKAReceived;
    }

    public void setLastKAReceived(String lastKAReceived) {
        this.lastKAReceived = lastKAReceived;
    }

    public String getLastStateChange() {
        return lastStateChange;
    }

    public void setLastStateChange(String lastStateChange) {
        this.lastStateChange = lastStateChange;
    }

    public String getLastWakeAttemp() {
        return lastWakeAttemp;
    }

    public void setLastWakeAttemp(String lastWakeAttemp) {
        this.lastWakeAttemp = lastWakeAttemp;
    }

    public WakeSessionStatus getStatus() {
        return status;
    }

    public void setStatus(WakeSessionStatus status) {
        this.status = status;
    }

    public String getWakeableIn() {
        return wakeableIn;
    }

    public void setWakeableIn(String wakeableIn) {
        this.wakeableIn = wakeableIn;
    }

    @Override
    public String toString() {
        return "WakeSession [id=" + id + ", extendedStatus=" + extendedStatus + ", keepAlivePeriod=" + keepAlivePeriod
            + ", lastKAReceived=" + lastKAReceived + ", lastStateChange=" + lastStateChange + ", lastWakeAttemp="
            + lastWakeAttemp + ", status=" + status + ", wakeableIn=" + wakeableIn + "]";
    }
}
