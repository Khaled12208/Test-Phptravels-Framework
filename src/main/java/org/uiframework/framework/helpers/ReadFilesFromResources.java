package org.uiframework.framework.helpers;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;


public class ReadFilesFromResources {

    private Logger logger = Logger.getLogger(ReadFilesFromResources.class);
    private String TestResourceFilePath;


    public FileReader readResourcesAsFileReader(String TestResourceFile, Class<?> Class) throws Exception {

        FileReader file = null;
        try {
            file = new FileReader(BuildPath(Class, TestResourceFile));
            return file;
        } catch (Exception e) {
            logger.error("Couldn't find file in " + TestResourceFilePath);
            throw new Exception("couldn't Load File as FileReader ", e);
        }
    }

    public FileInputStream readResourcesAsFileInputStream(String TestResourceFile, Class<?> Class) throws Exception {

        FileInputStream file = null;
        try {
            file = new FileInputStream(BuildPath(Class, TestResourceFile));
            return file;

        } catch (Exception e) {
            logger.error("Couldn't find file in " + TestResourceFilePath);
            throw new Exception("couldn't Load File as Input Stream ", e);
        }
    }

    public File readResourcesAsFile(String TestResourceFile, Class<?> Class) throws Exception {


        File file = null;
        try {
            file = new File(BuildPath(Class, TestResourceFile));
            return file;
        } catch (Exception e) {
              logger.error("Couldn't find file in " + TestResourceFilePath);
               throw new Exception("couldn't Load File as File ", e);
        }

    }


    private String BuildPath(Class<?> Class, String TestResourceFile) {

        String ClassName = Class.getName();
        String[] Path = ClassName.split("\\.");
        StringBuffer sb = new StringBuffer();
        sb.append("src/test/resources/");

        for (int i = 0; i < Path.length - 1; i++) {
            sb.append(Path[i] + "/");
        }
        sb.append(TestResourceFile);
        this.TestResourceFilePath = sb.toString();

        return sb.toString();

    }


}
