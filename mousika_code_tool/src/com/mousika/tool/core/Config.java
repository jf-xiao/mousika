package com.mousika.tool.core;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.w3c.dom.Element;

import com.mousika.tool.bean.DatabaseInfo;
import com.mousika.tool.bean.TypeInfo;
import com.mousika.tool.util.XmlUtil;

/**
 * 配置文件对象
 * @author xiaojf 294825811@qq.com
 */
public class Config {
    /**
     * 获取配置文件的文件流
     * @return
     */
    private static InputStream getConfigInputStream() {
        return ClassLoader.getSystemResourceAsStream("config.xml");
    }

    /**
     * 获取数据库配置信息
     * @return
     */
    public static List<DatabaseInfo> getDatabases() {
        Element configRoot = XmlUtil.getRootElementFromStream(getConfigInputStream());
        Element dbRoot = XmlUtil.getChildElement(configRoot, "databases");
        List<Element> dbEls = XmlUtil.getElements(dbRoot, "database");

        List<DatabaseInfo> dbs = new ArrayList<DatabaseInfo>();

        for (Element element : dbEls) {
            DatabaseInfo db = new DatabaseInfo(element.getAttribute("key"), XmlUtil.getElementValue(element, "driverClass"), XmlUtil.getElementValue(element, "url"), XmlUtil.getElementValue(element,
                    "username"), XmlUtil.getElementValue(element, "password"));
            dbs.add(db);
        }
        return dbs;
    }

    /**
     * 获取数据库配置名称
     * @return
     */
    public static Vector<String> getDatabaseNames() {
        Element configRoot = XmlUtil.getRootElementFromStream(getConfigInputStream());
        Element dbRoot = XmlUtil.getChildElement(configRoot, "databases");
        List<Element> dbEls = XmlUtil.getElements(dbRoot, "database");

        Vector<String> dbs = new Vector<String>();

        for (Element element : dbEls) {
            dbs.add(element.getAttribute("key"));
        }
        return dbs;
    }

    /**
     * 根据数据库配置名称获取数据库配置信息
     * @param databaseName
     * @return
     */
    public static DatabaseInfo getDatabase(String databaseName) {
        Element configRoot = XmlUtil.getRootElementFromStream(getConfigInputStream());
        Element dbRoot = XmlUtil.getChildElement(configRoot, "databases");
        List<Element> dbEls = XmlUtil.getElements(dbRoot, "database");

        for (Element element : dbEls) {
            String key = element.getAttribute("key");
            if (databaseName.equals(key)) {
                return new DatabaseInfo(key, XmlUtil.getElementValue(element, "driverClass"), XmlUtil.getElementValue(element, "url"), XmlUtil.getElementValue(element, "username"),
                        XmlUtil.getElementValue(element, "password"));
            }
        }
        return null;
    }

    /**
     * 获取类型配置信息
     * @return
     */
    public static List<TypeInfo> getTypes() {
        Element configRoot = XmlUtil.getRootElementFromStream(getConfigInputStream());
        Element typesRoot = XmlUtil.getChildElement(configRoot, "types");
        List<Element> typeEls = XmlUtil.getElements(typesRoot, "type");
        List<TypeInfo> types = new ArrayList<TypeInfo>();

        for (Element element : typeEls) {
            types.add(new TypeInfo(element.getAttribute("key"), element.getTextContent()));
        }
        return types;
    }

    /**
     * 根据类型名称获取类型配置信息
     * @return
     */
    public static TypeInfo getType(String typeName) {
        Element configRoot = XmlUtil.getRootElementFromStream(getConfigInputStream());
        Element typesRoot = XmlUtil.getChildElement(configRoot, "types");
        List<Element> typeEls = XmlUtil.getElements(typesRoot, "type");

        for (Element element : typeEls) {
            String key = element.getAttribute("key");
            if (key.equals(typeName)) {
                return new TypeInfo(key, element.getTextContent());
            }
        }
        return null;
    }
}
