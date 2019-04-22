package com.chat.vo;

import java.io.Serializable;
import java.util.List;

public class RegisterBean  implements Serializable{


    /**
     * action : post
     * application : 60a0ea30-643a-11e9-be95-4d73e497af5b
     * path : /users
     * uri : https://a1.easemob.com/1174161225178036/imapp/users
     * entities : [{"uuid":"be0f4570-64b9-11e9-a164-03dd83766022","type":"user","created":1555908453191,"modified":1555908453191,"username":"zhangsan","activated":true}]
     * timestamp : 1555908453199
     * duration : 0
     * organization : 1174161225178036
     * applicationName : imapp
     */

    private String action;
    private String application;
    private String path;
    private String uri;
    private long timestamp;
    private int duration;
    private String organization;
    private String applicationName;
    private List<EntitiesBean> entities;

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
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

    public List<EntitiesBean> getEntities() {
        return entities;
    }

    public void setEntities(List<EntitiesBean> entities) {
        this.entities = entities;
    }

    public static class EntitiesBean {
        /**
         * uuid : be0f4570-64b9-11e9-a164-03dd83766022
         * type : user
         * created : 1555908453191
         * modified : 1555908453191
         * username : zhangsan
         * activated : true
         */

        private String uuid;
        private String type;
        private long created;
        private long modified;
        private String username;
        private boolean activated;

        public String getUuid() {
            return uuid;
        }

        public void setUuid(String uuid) {
            this.uuid = uuid;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public long getCreated() {
            return created;
        }

        public void setCreated(long created) {
            this.created = created;
        }

        public long getModified() {
            return modified;
        }

        public void setModified(long modified) {
            this.modified = modified;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public boolean isActivated() {
            return activated;
        }

        public void setActivated(boolean activated) {
            this.activated = activated;
        }
    }
}
