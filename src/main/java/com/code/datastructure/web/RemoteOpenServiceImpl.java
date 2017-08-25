/**
 * 
 */
package com.web;

/**
 * Jiaxu
 * Nov 23, 2016
 * 
 */
public class RemoteOpenServiceImpl implements RemoteOpenService{

    @Override
    public String executeOpenService(String json, String method) {
        String returnJson = null;
        BaseService service = (BaseService) OpenServiceRouter.getRouterMap().get(method);
        returnJson = service.execute(json, ExampleC2s.class);
        
        return returnJson;
    }

    
}
