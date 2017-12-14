package exjobb.cache.mongo.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jaam on 2017-11-21.
 */
public class SearchOptions {
    List<String> fields = new ArrayList();
    List<String> keys = new ArrayList();
    String value = "";
    Boolean stripped = true;
    String type = "equals";
    Integer page = 0;
    Integer limit = 15;

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    public List<String> getKeys() {
        return keys;
    }

    public void setKeys(List<String> keys) {
        this.keys = keys;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getStripped() {
        return stripped;
    }

    public void setStripped(Boolean stripped) {
        this.stripped = stripped;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "SearchOptions{" +
                "fields=" + fields +
                ", keys=" + keys +
                ", stripped=" + stripped +
                ", type='" + type + '\'' +
                ", page=" + page +
                ", limit=" + limit +
                '}';
    }
}
