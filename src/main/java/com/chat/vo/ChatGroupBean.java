package com.chat.vo;

import java.io.Serializable;
import java.util.List;

public class ChatGroupBean implements Serializable {

    /**
     * action : post
     * application : 839e5470-64c4-11e9-ba61-6539625b5369
     * uri : http://a1.easemob.com/1174161225178036/openapp/chatgroups
     * entities : []
     * data : {"groupid":"80950508716033"}
     * timestamp : 1556598821777
     * duration : 0
     * organization : 1174161225178036
     * applicationName : openapp
     */

    private String action;
    private String application;
    private String uri;
    private DataBean data;
    private long timestamp;
    private int duration;
    private String organization;
    private String applicationName;
    private List<?> entities;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public List<?> getEntities() {
        return entities;
    }

    public void setEntities(List<?> entities) {
        this.entities = entities;
    }

    public static class DataBean {
        /**
         * groupid : 80950508716033
         */

        private String groupid;

        public String getGroupid() {
            return groupid;
        }

        public void setGroupid(String groupid) {
            this.groupid = groupid;
        }
    }
}
