/**
 * 
 */
package com.web;

/**
 * Jiaxu
 * Nov 23, 2016
 * 
 */
public abstract class AbstractBaseService implements BaseService{

    // TODO
    public final C2s decode(String json, Class c){
        C2s c2s = null;
        return c2s;
    }
    // TODO
    public final String encode(S2c s2c){
    	String json = null;
        return json;
    }
    
    /**
     * 子类不同实现具体逻辑
     * @param c2s
     */
    public abstract S2c doService(C2s c2s);
    
    /**
     * 模版执行方法
     * @param json
     */
    public final String execute(String json, Class c){
        C2s c2s = this.decode(json, c);
        S2c s2c = doService(c2s);
        String retrunJson = this.encode(s2c);
        return retrunJson;
    }
}
