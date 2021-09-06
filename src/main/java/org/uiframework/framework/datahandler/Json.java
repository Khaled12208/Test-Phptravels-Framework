package org.uiframework.framework.datahandler;



import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.uiframework.framework.helpers.ReadFilesFromResources;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;


public class Json extends DataFile{

    private ReadFilesFromResources FileReader;
    private JSONParser jsonParser;
    private  JSONArray array;
    private final String resourceFilePath;
    private final  Class<?> Class;

    public Json(String resourceFilePath, Class<?> Class)  {
        this.resourceFilePath=resourceFilePath;
        this.Class=Class;
        super.Type=DataFileType.JSON;

    }

    @Override
    public DataFile ReadData() throws Exception {
        FileReader=new ReadFilesFromResources();
        jsonParser=new JSONParser();
        array = new JSONArray();

        try {
            Object obj = jsonParser.parse(FileReader.readResourcesAsFileReader(resourceFilePath, Class));
            JSONObject JsonObj = (JSONObject) obj;
            array.add(obj);
            Set<?> KeyValues = JsonObj.keySet();
            Iterator iterate_value = KeyValues.iterator();
            super.Data = new HashMap<>();
            HashMap RowData = new HashMap<String, String>();

            while (iterate_value.hasNext()) {
                Object Next = iterate_value.next();
                RowData.put(Next.toString(), JsonObj.get(Next.toString()).toString());
            }
            super.Data = RowData;
        }
        catch (Exception e)
        {
            throw new Exception("Error : Couldn't Parse JSON File: "+resourceFilePath,e);
        }
        return this;
    }


}
