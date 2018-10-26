package com.business.ventas.configuracion;

public interface ConfigProperties {

    static final int XML = 1;

    static ConfigProperties getInstancia(int tipo){
        switch (tipo){
            case XML: return new ConfigXml();
            default: return null;
        }
    }

    public String getClassName();
    public String getUrl();
    public String getUserName();
    public String getPassword();
    public String getDialect();
    public boolean getShowSql();
}
