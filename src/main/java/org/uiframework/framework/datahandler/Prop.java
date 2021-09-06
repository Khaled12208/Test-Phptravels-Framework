package org.uiframework.framework.datahandler;

import org.uiframework.framework.helpers.ReadFilesFromResources;


import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

public class Prop extends DataFile {

    private ReadFilesFromResources FileReader;
    private  Properties prop;
    private final String resourceFilePath;
    private final Class<?> Class;

    public Prop(String resourceFilePath, Class<?> Class) {

        this.resourceFilePath=resourceFilePath;
        this.Class=Class;
        super.Type=DataFileType.PROP;


    }

    @Override
    public DataFile ReadData() throws Exception {
        this.prop = new Properties();
        this.FileReader= new ReadFilesFromResources();
        super.Data= new HashMap<>() ;
        try {
            prop.load(FileReader.readResourcesAsFileInputStream(resourceFilePath, Class));
            Set<Object> keys = prop.keySet();
            HashMap RowData = new HashMap<String, String>();

            for (Object k : keys) {
                String key = (String) k;
                RowData.put(key, prop.getProperty(key));

            }
            super.Data = RowData;
        }catch (Exception e)
        {
            throw new Exception("Error : Couldn't Load Properties File: "+resourceFilePath,e);
        }
        return this;
    }


}
