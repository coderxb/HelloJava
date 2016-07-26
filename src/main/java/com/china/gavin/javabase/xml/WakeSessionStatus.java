package com.china.gavin.javabase.xml;

/**
 * Define common variables commonly used in the system.
 */
public enum WakeSessionStatus {

    UNKNOWN(0), SLEEPING(1), UNUSED_0(2), UNWAKEABLE(3);

    /**
     * WakeSessionStatus Construct
     * @param value
     */
    private WakeSessionStatus(int value) {
        // TODO do something
    }

    /**
     * value Method.
     * <p>
     * Obtain WakeSessionStatus ordinal.
     * </P>
     * @return int
     */
    public int value() {
        return ordinal();
    }

    /**
     * getEnum Method.
     * <p>
     * With value obtain WakeSessionStatus.
     * </P>
     * @param value
     * @return WakeSessionStatus
     */
    public static WakeSessionStatus getEnum(int value) {
        switch (value) {
            case 0:
                return UNKNOWN;
            case 1:
                return SLEEPING;
            case 3:
                return UNWAKEABLE;
            default:
                return null;
        }
    }
}
