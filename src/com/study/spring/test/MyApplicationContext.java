package com.study.spring.test;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class MyApplicationContext {
    private ConcurrentHashMap<String, Object> inversionOfControl = new ConcurrentHashMap<>();

    // MyApplicationContext 构造器修改
    public MyApplicationContext(String beansXMLFileName) throws DocumentException, IOException {
        SAXReader saxReader = new SAXReader();
        // 获取类路径下的资源流，src下文件编译后会进classpath
        // InputStream inputStream = this.getClass().getResourceAsStream("/" + beansXMLFileName);

        Document document = saxReader.read(new File("src/" + beansXMLFileName));
        Element rootElement = document.getRootElement();
        List elements = rootElement.elements();
        // Object firstBean = elements.get(0);
        System.out.println(elements);
    }
}
