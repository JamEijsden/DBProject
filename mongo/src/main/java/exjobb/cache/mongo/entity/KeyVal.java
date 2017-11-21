package exjobb.cache.mongo.entity;

/**
 * Created by Jaam on 2017-11-21.
 */
public class KeyVal {
    String key;
    String val;
    String type = "equals";



    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "KeyVal{" +
                "key='" + key + '\'' +
                ", val='" + val + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
