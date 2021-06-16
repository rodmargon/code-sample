package com.myorganization.myservice.model.response;

import org.springframework.boot.info.BuildProperties;

import javax.servlet.ServletContext;
import java.time.Instant;

public class ServiceStatusResponse {

    private static final String UNKNOWN_PROPERTY = "unknown";

    private final Instant systemTime;

    private final String serverInfo;

    private final int apiMajorVersion;

    private final int apiMinorVersion;

    private final String groupId;

    private final String artifactId;

    private final String version;

    private final Instant buildTime;

    public ServiceStatusResponse(ServletContext servletContext, BuildProperties buildProperties){
        systemTime = Instant.now();
        serverInfo = servletContext.getServerInfo();
        apiMajorVersion = servletContext.getMajorVersion();
        apiMinorVersion = servletContext.getMinorVersion();
        groupId = buildProperties != null ? buildProperties.getGroup() : UNKNOWN_PROPERTY;
        artifactId = buildProperties != null ? buildProperties.getArtifact() : UNKNOWN_PROPERTY;
        version = buildProperties != null ? buildProperties.getVersion() : UNKNOWN_PROPERTY;
        buildTime = buildProperties != null ? buildProperties.getTime() : null;
    }

    public String getServerInfo(){
        return serverInfo;
    }

    public int getApiMajorVersion(){
        return apiMajorVersion;
    }

    public int getApiMinorVersion(){
        return apiMinorVersion;
    }

    public Instant getSystemTime(){
        return systemTime;
    }

    public String getGroupId(){
        return groupId;
    }

    public String getArtifactId(){
        return artifactId;
    }

    public String getVersion(){
        return version;
    }

    public Instant getBuildTime(){
        return buildTime;
    }

}


