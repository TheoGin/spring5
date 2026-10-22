package com.study.spring.test;

import com.study.spring.beans.Monster;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class MyApplicationContext {

    private ConcurrentHashMap<String, Object> invesionOfControl = new ConcurrentHashMap<>();

    // MyApplicationContext 构造器修改
    public MyApplicationContext(String beansXMLFileName) throws DocumentException, IOException {

        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(new File(beansXMLFileName));
        Element rootElement = document.getRootElement();

        Element bean = rootElement.element("bean");
        String beanId = bean.attributeValue("id");
        String beanClass = bean.attributeValue("class");

        List<Element> propertys = bean.elements("property");
        /* for (Element property : propertys) {
            String name = property.attributeValue("name");
            String value = property.attributeValue("value");
            System.out.println("name: " + name + ", value: " + value);
        } */
        int monsterId = Integer.parseInt(propertys.get(0).attributeValue("value"));
        String name = propertys.get(1).attributeValue("value");
        String skill = propertys.get(2).attributeValue("value");
        System.out.println("monsterId: " + monsterId + ", name: " + name + ", skill: " + skill);

        try {
            Class<?> clazz = Class.forName(beanClass);
            Monster monster = (Monster)clazz.newInstance();
            monster.setMonsterId(monsterId);
            monster.setName(name);
            monster.setSkill(skill);
            invesionOfControl.put(beanId, monster);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Object getBean(String beanId) {
        return invesionOfControl.get(beanId);
    }
}
