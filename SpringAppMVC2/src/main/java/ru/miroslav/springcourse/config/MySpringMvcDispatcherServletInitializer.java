package ru.miroslav.springcourse.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import sun.security.provider.ConfigFile;

public class MySpringMvcDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    //
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    // Получаем доступ к конфигурационному файлу Spring'a
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {SpringConfig.class}; // <param-value>/WEB-INF/applicationContextMVC.xml</param-value>
    }

    // Устанавливаем путь в адресной строке
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"}; // <url-pattern>/</url-pattern>
    }
}
