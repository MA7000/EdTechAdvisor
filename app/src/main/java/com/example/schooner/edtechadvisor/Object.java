package com.example.schooner.edtechadvisor;

import java.util.UUID;

/**
 * Created by Schooner on 3/24/2018.
 * this is the tool object
 */

public class Object {
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
    }

