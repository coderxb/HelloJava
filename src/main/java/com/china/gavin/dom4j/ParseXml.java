package com.china.gavin.dom4j;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class ParseXml {

    public static String getXmlInfo() {
        StringBuilder xmlInfo = new StringBuilder();
        xmlInfo.append("<Sessions xmlns:i=\"http://www.w3.org/2001/XMLSchemainstance\">");

        xmlInfo.append("<Session>").append("<ExtendedStatus/>");
        xmlInfo.append("<Id>440a7d4c-fcca-4c75-97eb-89db34143b97</Id>").append("<KeepAlivePeriod>72</KeepAlivePeriod>");
        xmlInfo.append("<LastKAReceived>2012-04-17T17:55:31.332Z</LastKAReceived>");
        xmlInfo.append("<LastStateChange>2012-03-26T19:58:49.894Z</LastStateChange>");
        xmlInfo.append("<Status>0</Status>");
        xmlInfo.append("<WakeableIn>-1</WakeableIn>").append("</Session>");

        xmlInfo.append("<Session>").append("<ExtendedStatus/>");
        xmlInfo.append("<Id>e42044f5-125d-4411-ae3b-63635df7e254</Id>").append("<KeepAlivePeriod>72</KeepAlivePeriod>");
        xmlInfo.append("<LastKAReceived>2012-04-17T17:55:31.332Z</LastKAReceived>");
        xmlInfo.append("<LastStateChange>2012-03-26T19:58:14.714Z</LastStateChange>");
        xmlInfo.append("<Status>1</Status>");
        xmlInfo.append("<WakeableIn>-1</WakeableIn>").append("</Session>");

        xmlInfo.append("<Session>").append("<ExtendedStatus/>");
        xmlInfo.append("<Id>473ea7f2-ccd3-0ebd-c360-f0dc2ab44a39</Id>").append("<KeepAlivePeriod>900</KeepAlivePeriod>");
        xmlInfo.append("<LastKAReceived>2013-08-06T11:45:18.315Z</LastKAReceived>");
        xmlInfo.append("<LastStateChange>2013-08-06T11:30:17.805Z</LastStateChange>");
        xmlInfo.append("<LastWakeAttempt>0001-01-01T00:00:00.000Z</LastWakeAttempt>");
        xmlInfo.append("<Status>1</Status>");
        xmlInfo.append("<WakeableIn>-1</WakeableIn>").append("</Session>");

        xmlInfo.append("</Sessions>");

        return xmlInfo.toString();
    }

    public static String getXmlInfoNull() {
        StringBuilder xmlInfo = new StringBuilder();
        xmlInfo.append("<Sessions xmlns:i=\"http://www.w3.org/2001/XMLSchema-instance\"/>");
        return xmlInfo.toString();
    }

    public static void main(String[] args) {
        String xmlInfo = getXmlInfo();
        Document doc = null;

        try {
            List<WakeSession> sessions = new ArrayList<WakeSession>();
            doc = DocumentHelper.parseText(xmlInfo);
            Element rootNode = doc.getRootElement();
            System.out.println(rootNode.getName());

            /**
             * Dependency List mode read xml information.
             */
            List<?> sessionList = rootNode.elements();
            System.out.println(sessionList.size());
            for (Object o : sessionList) {
                Element el = (Element) o;
                WakeSession session = new WakeSession();
                if (el.element("Id") != null) {
                    session.setId(el.element("Id").getText());
                }
                if (el.element("KeepAlivePeriod") != null) {
                    session.setKeepAlivePeriod(el.element("KeepAlivePeriod").getText());
                }
                if (el.element("LastKAReceived") != null) {
                    session.setLastKAReceived(el.element("LastKAReceived").getText());
                }
                if (el.element("LastStateChange") != null) {
                    session.setLastStateChange(el.element("LastStateChange").getText());
                }
                if (el.element("LastWakeAttempt") != null) {
                    session.setLastWakeAttemp(el.element("LastWakeAttempt").getText());
                }
                if (el.element("Status") != null) {
                    session.setStatus(el.element("Status").getText());
                }
                if (el.element("WakeableIn") != null) {
                    session.setWakeableIn(el.element("WakeableIn").getText());
                }
                sessions.add(session);
            }

            /**
             * Dependency Iterator mode read xml information.
             */
            for (Iterator<?> iterator = rootNode.elementIterator(); iterator.hasNext();) {
                WakeSession session = new WakeSession();
                Element el = (Element) iterator.next();
                if (el.element("Id") != null) {
                    session.setId(el.element("Id").getText());
                }
                if (el.element("KeepAlivePeriod") != null) {
                    session.setKeepAlivePeriod(el.element("KeepAlivePeriod").getText());
                }
                if (el.element("LastKAReceived") != null) {
                    session.setLastKAReceived(el.element("LastKAReceived").getText());
                }
                if (el.element("LastStateChange") != null) {
                    session.setLastStateChange(el.element("LastStateChange").getText());
                }
                if (el.element("LastWakeAttempt") != null) {
                    session.setLastWakeAttemp(el.element("LastWakeAttempt").getText());
                }
                if (el.element("Status") != null) {
                    session.setStatus(el.element("Status").getText());
                }
                if (el.element("WakeableIn") != null) {
                    session.setWakeableIn(el.element("WakeableIn").getText());
                }
                sessions.add(session);
            }

            for (WakeSession wakeSession : sessions) {
                System.out.println(wakeSession);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }
}
