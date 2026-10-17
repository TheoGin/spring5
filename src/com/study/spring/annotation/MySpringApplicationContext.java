package com.study.spring.annotation;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

public class MySpringApplicationContext {
    private final ConcurrentHashMap<String, Object> ioc = new ConcurrentHashMap<>();
    private Class configClass;

    public MySpringApplicationContext(Class configClass) {
        this.configClass = configClass;

        ComponentScan componentScan = (ComponentScan) this.configClass.getAnnotation(ComponentScan.class);
        String path = componentScan.value();
        System.out.println("扫描的包：" + path);
        path = path.replace(".", "/");

        ClassLoader classLoader = this.configClass.getClassLoader();
        URL resource = classLoader.getResource(path);

        path = path.replace("/", ".");
        File file = new File(resource.getFile());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                String fileName = f.getName();
                if (fileName.endsWith(".class")) {
                    fileName = fileName.replace(".class", "");
                    String className = path + "." + fileName;
                    try {
                        Class<?> clazz = classLoader.loadClass(className);
                        if (clazz.isAnnotationPresent(Controller.class)
                                || clazz.isAnnotationPresent(Service.class)
                                || clazz.isAnnotationPresent(Repository.class)
                                || clazz.isAnnotationPresent(Component.class)
                        ) {

                            if (clazz.isAnnotationPresent(Controller.class)) {
                                Controller annotation = clazz.getAnnotation(Controller.class);
                                if (!"".equals(annotation.value())) {
                                    fileName = annotation.value();
                                }
                            }
                            ioc.put(StringUtils.uncapitalize(fileName), clazz.newInstance());
                        }
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (InstantiationException e) {
                        throw new RuntimeException(e);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        }
    }

    public Object getBean(String name) {
        return ioc.get(name);
    }
}
