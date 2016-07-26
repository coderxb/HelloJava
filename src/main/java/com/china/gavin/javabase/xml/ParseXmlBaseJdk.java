package com.china.gavin.javabase.xml;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class ParseXmlBaseJdk {

    public static Document getDocument(String xmlStr) {
        Document doc = null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            StringReader reader = new StringReader(xmlStr);
            InputSource is = new InputSource(reader);
            doc = db.parse(is);
            return doc;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 
     * getStringXml Method.
     * <p>
     * If necessary, describe how it does and how to use it.
     * </P>
     * @return
     */
    public static String getStringXml() {
        StringBuilder sb = new StringBuilder();
        sb.append("<Session xmlns:i=\"http://www.w3.org/2001/XMLSchema-instance\"><ExtendedStatus/>");
        sb.append("<Id>ea31224a-cd7c-4e0d-7afd-dec7f05b70fc</Id>");
        sb.append("<KeepAlivePeriod>360</KeepAlivePeriod>");
        sb.append("<LastKAReceived>0001-01-01T00:00:00.000Z</LastKAReceived>");
        sb.append("<LastStateChange>2013-09-09T02:16:41.857Z</LastStateChange>");
        sb.append("<LastWakeAttempt>0001-01-01T00:00:00.000Z</LastWakeAttempt>");
        sb.append("<Status>0</Status>");
        sb.append("<WakeableIn>-1</WakeableIn></Session>");
        return sb.toString();
    }

    public static String getStringListXml() {
        StringBuilder sb = new StringBuilder();
        sb.append("<Sessions xmlns:i=\"http://www.w3.org/2001/XMLSchema-instance\"><Session><ExtendedStatus i:nil=\"true\"/>");
        sb.append("<Id>96e9fb1e-934a-4b0f-c48c-e0ba143551c8</Id>");
        sb.append("<KeepAlivePeriod>30</KeepAlivePeriod>");
        sb.append("<LastKAReceived>2013-11-01T09:50:23.275Z</LastKAReceived>");
        sb.append("<LastStateChange>2013-11-01T09:50:23.275Z</LastStateChange>");
        sb.append("<LastWakeAttempt i:nil=\"true\"/>");
        sb.append("<Status>1</Status>");
        sb.append("<WakeableIn>-1</WakeableIn></Session></Sessions>");
        return sb.toString();
    }

    public static List<WakeSession> handleReadUpdatesResponseBody(String respBody) {
        List<WakeSession> sessions = new ArrayList<WakeSession>();

        Document doc = null;
        doc = getDocument(respBody);
        Element root = doc.getDocumentElement();
        NodeList nodeList = root.getElementsByTagName("Session");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element el = (Element) nodeList.item(i);
            WakeSession session = new WakeSession();
            if (el.getElementsByTagName("Id").getLength() >= 1) {
                session.setId(el.getElementsByTagName("Id").item(0).getFirstChild().getNodeValue());
            }
            if (el.getElementsByTagName("ExtendedStatus").getLength() >= 1) {
                if (el.getElementsByTagName("ExtendedStatus").item(0).getFirstChild() != null) {
                    session.setKeepAlivePeriod(el.getElementsByTagName("ExtendedStatus").item(0).getFirstChild().getNodeValue());
                }
            }
            if (el.getElementsByTagName("KeepAlivePeriod").getLength() >= 1) {
                session.setKeepAlivePeriod(el.getElementsByTagName("KeepAlivePeriod").item(0).getFirstChild().getNodeValue());
            }
            if (el.getElementsByTagName("LastKAReceived").getLength() >= 1) {
                session.setLastKAReceived(el.getElementsByTagName("LastKAReceived").item(0).getFirstChild().getNodeValue());
            }
            if (el.getElementsByTagName("LastStateChange").getLength() >= 1) {
                session.setLastStateChange(el.getElementsByTagName("LastStateChange").item(0).getFirstChild().getNodeValue());
            }
            if (el.getElementsByTagName("LastWakeAttempt").getLength() >= 1) {
                if (el.getElementsByTagName("LastWakeAttempt").item(0).getFirstChild() != null) {
                    session.setLastWakeAttemp(el.getElementsByTagName("LastWakeAttempt").item(0).getFirstChild().getNodeValue());
                }
            }
            if (el.getElementsByTagName("Status").getLength() >= 1) {
                if (el.getElementsByTagName("Status").item(0).getFirstChild() != null) {
                    session.setStatus(WakeSessionStatus.getEnum(Integer.valueOf(el.getElementsByTagName("Status").item(0).getFirstChild().getNodeValue().trim())));
                }

            }
            if (el.getElementsByTagName("WakeableIn").getLength() >= 1) {
                session.setWakeableIn(el.getElementsByTagName("WakeableIn").item(0).getFirstChild().getNodeValue());
            }
            sessions.add(session);
        }
        return sessions;
    }

    public static void main(String[] args) {
        // String xmlStr = getStringXml();
        // Document doc = getDocument(xmlStr);
        // Node node = doc.getFirstChild();
        // System.out.println(node.getNodeName());
        // Element el = doc.getDocumentElement();
        // if (el.getElementsByTagName("sssss").getLength() >= 1) {
        // System.out.println(el.getElementsByTagName("sssss").item(0).getNodeName());
        // }
        // System.out.println(el.getElementsByTagName("KeepAlivePeriod").getLength());
        //
        // System.out.println(el.getElementsByTagName("Id").item(0).getNodeName());

        // for (int i = 0; i < nodeList.getLength(); i++) {
        // Element el = (Element) nodeList.item(i);
        // if (el.hasChildNodes()) {
        // System.out.println("Node Name = " + el.getNodeName() + ", Node Value = "
        // + el.getFirstChild().getNodeValue());
        // }
        // }

        List<WakeSession> sessions = handleReadUpdatesResponseBody(getStringListXml());
        for (WakeSession ses : sessions) {
            System.out.println(ses.toString());
        }
    }

}

