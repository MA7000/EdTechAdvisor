package com.example.schooner.edtechadvisor;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by Schooner on 3/24/2018.
 * this is the tool object
 */

public class Object implements Serializable {
        public String name;
        public String info;
        public int imageId;
        public String toolId;
//        category tag options: formative | content | administrative | management
        public String tag;

        public Object (String name, String info, int imageId, String tag) {
            this.name=name;
            this.info=info;
            this.imageId =imageId;
            this.toolId = UUID.randomUUID().toString();
            this.tag = tag;
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getToolId() {
        return toolId;
    }

    public void setToolId(String toolId) {
        this.toolId = toolId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}

