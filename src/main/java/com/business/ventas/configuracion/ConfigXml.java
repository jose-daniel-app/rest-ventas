package com.business.ventas.configuracion;

import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;

public class ConfigXml implements ConfigProperties{

    Configurations configs = new Configurations();
    XMLConfiguration config;

    public ConfigXml(){
        try {
            config = configs.xml(System.getProperty("PATH_XML"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public String getClassName() {
        return config.getString("database.diver");
    }

    @Override
    public String getUrl() {
        return config.getString("database.url");
    }

    @Override
    public String getUserName() {
        return config.getString("database.username");
    }

    @Override
    public String getPassword() {
        return config.getString("database.password");
    }

    @Override
    public String getDialect() {
        return config.getString("database.dialect");
    }

    @Override
    public boolean getShowSql() {
        return config.getBoolean("database.show_sql");
    }
}
