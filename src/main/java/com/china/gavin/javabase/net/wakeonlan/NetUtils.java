package com.china.gavin.javabase.net.wakeonlan;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class NetUtils {

    /**
     * 
     * getLocalMacAddress method.
     * <p>
     * Obtain the local PC's MAC address.
     * </P>
     * @return
     * @throws SocketException
     */
    public static String getLocalMacAddress() throws SocketException {
        String macAddress = null;
        Enumeration<NetworkInterface> netInters = NetworkInterface.getNetworkInterfaces();
        while (netInters.hasMoreElements()) {
            NetworkInterface netInter = netInters.nextElement();
            byte[] bytes = netInter.getHardwareAddress();
            if (netInter.isUp() && netInter != null && bytes != null && bytes.length == 6) {
                StringBuffer mac = new StringBuffer();
                for (byte b : bytes) {
                    // With 11110000 for the bitwise AND to read the current byte High 4
                    mac.append(Integer.toHexString((b & 240) >> 4));
                    // With 00001111 for the bitwise AND to read the current byte low 4
                    mac.append(Integer.toHexString(b & 15));
                    mac.append("-");
                }
                mac.deleteCharAt(mac.length() - 1);
                macAddress = mac.toString().toUpperCase();
            }
        }
        return macAddress;
    }

    public static String getMacAddressByIp(String remotePcIp) {
        String str = null;
        String macAddress = null;
        try {
            Process pp = Runtime.getRuntime().exec("nbtstat -A " + remotePcIp);
            InputStreamReader ir = new InputStreamReader(pp.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);
            for (int i = 1; i < 100; i++) {
                str = input.readLine();
                if (str != null) {
                    if (str.indexOf("MAC Address") > 1) {
                        macAddress = str.substring(str.indexOf("MAC Address") + 14, str.length());
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return macAddress;
    }

    public static byte[] hexStringToByte(String hex) {
        int len = (hex.length() / 2);
        byte[] result = new byte[len];
        char[] achar = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
        }
        return result;
    }

    private static byte toByte(char c) {
        byte b = (byte) "0123456789ABCDEF".indexOf(c);
        return b;
    }

    public static void main(String[] args) {
        try {
            System.out.println(NetUtils.getLocalMacAddress());
            System.out.print(NetUtils.getMacAddressByIp("10.100.13.72"));
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
