package com.example.socketdemo;


import org.apache.log4j.Logger;

import javax.websocket.Endpoint;
import javax.websocket.server.ServerApplicationConfig;
import javax.websocket.server.ServerEndpointConfig;
import java.util.HashSet;
import java.util.Set;


/**
 * @author 12589
 */
public class ServerConfig implements ServerApplicationConfig {
    private Logger log=Logger.getLogger(ServerConfig.class);
    @Override
    public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> set) {
        log.info("getServerEndPointClasses");
        return null;
    }

    @Override
    public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> set) {
        log.info("getEndPointConfigs");
        return null;
    }
}
