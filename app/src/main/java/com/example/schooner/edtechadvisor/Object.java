package com.example.schooner.edtechadvisor;

/**
 * Created by Schooner on 3/24/2018.
 * this is the tool object
 */

public class Object {
        public String name;
        public String info;
        public int objectId;
//        category tag. options: formative | content | administrative | management
        public String tag;

        public Object (String name, String info, int objectId, String tag) {
            this.name=name;
            this.info=info;
            this.objectId =objectId;
            this.tag = tag;
        }
    }

