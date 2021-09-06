package org.uiframework.framework.datahandler;

import org.uiframework.framework.helpers.ReadFilesFromResources;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Xml extends DataFile {

    private ReadFilesFromResources FileReader;
    private DocumentBuilderFactory DocBuilderFactory;
    private DocumentBuilder DocBuilder;
    private Document doc;
    private final String resourceFilePath;
    private final Class<?> Class;

    protected Xml(String resourceFilePath, Class<?> Class) throws Exception {
        this.resourceFilePath = resourceFilePath;
        this.Class = Class;
    }

    @Override
    public DataFile ReadData() throws Exception {

        FileReader = new ReadFilesFromResources();
        DocBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocBuilderFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocBuilder = DocBuilderFactory.newDocumentBuilder();
            doc = DocBuilder.parse(FileReader.readResourcesAsFileInputStream(resourceFilePath, Class));
            doc.getDocumentElement().normalize();
            NodeList nodeLst = doc.getDocumentElement().getChildNodes();
            Map elemen = getElementKeyValue(nodeLst);
            Map RowData = new HashMap<String, String>();

            Iterator it = elemen.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pairs = (Map.Entry) it.next();
                RowData.put(pairs.getKey(), pairs.getValue());
            }
            super.Data = (HashMap<String,String>)RowData;
        }catch (Exception e)
        {
            throw new Exception("Error : Couldn't read data form XML file: "+resourceFilePath,e);

        }
        return this;
    }

    public Map getElementKeyValue(NodeList nodeList) {
        Map elements = new HashMap();
        if (nodeList != null && nodeList.getLength() > 0) {
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i); //Take the node from the list
                if (node.getNodeType() == node.ELEMENT_NODE) {
                    NodeList valueNode = node.getChildNodes(); // get the children of the node
                    String value = (valueNode.item(0) != null) ? valueNode.item(0).getNodeValue() : "";
                    elements.put(node.getNodeName(), value);
                }
            }
        }
        return elements;

    }
}