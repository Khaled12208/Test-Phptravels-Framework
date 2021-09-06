package org.uiframework.framework.datahandler;

import org.apache.log4j.Logger;


public class DataFileFactory {

    Logger logger = Logger.getLogger(DataFileFactory.class);
    private  String resourceFilePath;
    private  DataFileType type;
    private  Class<?> Class;
    private  String SheetName = null;


    public DataFileFactory(Class<?> Class) {

        this.Class=Class;
    }
    public DataFileFactory DataFileType(DataFileType type)
    {
        this.type = type;
        return this;
    }
    public DataFileFactory FromResourceFile(String resourceFilePath)
    {
        this.resourceFilePath=resourceFilePath;
        return this;
    }
    public DataFileFactory WithSheetNameOf(String SheetName)
    {
        this.SheetName=SheetName;
        return this;
    }

    public DataFile Build() throws Exception {

        DataFile Object = null;
        try {
            switch (type) {
                case JSON:
                    Object= new Json(resourceFilePath, Class);
                    break;
                case EXCEL:
                    Object = new Excel(resourceFilePath, SheetName, Class);
                    break;
                case PROP:
                    Object= new Prop(resourceFilePath, Class);
                    break;
                case XML:
                    Object=  new Xml(resourceFilePath, Class);
                    break;
                default:
                    throw new NullPointerException("Couldn't identify the File Reader Type for File type : "+type);
            }
            return Object;

        } catch (Exception e) {

            throw new Exception("Couldn't read the Resource : "+resourceFilePath+" File Reader Type : "+type,e);

        }

    }

}
