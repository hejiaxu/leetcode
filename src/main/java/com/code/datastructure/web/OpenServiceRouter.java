package com.web;

import java.util.HashMap;
import java.util.Map;

/**
 * Jiaxu
 * Nov 23, 2016
 * 
 */
public class OpenServiceRouter {

    private static Map<String, Object> routerMap;
    
    public static Map<String, Object> getRouterMap(){
        if(routerMap != null){
            return routerMap;
        }
        routerMap = new HashMap<String, Object>();
        routerMap.put("example", "exampleService");
        return routerMap;
    }
    
    
}
