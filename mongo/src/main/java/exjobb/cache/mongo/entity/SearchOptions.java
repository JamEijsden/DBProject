package exjobb.cache.mongo.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jaam on 2017-11-21.
 */
public class SearchOptions {
    List<String> fields = new ArrayList();
    List<KeyVal> keys = new ArrayList();
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

    public List<KeyVal> getKeys() {
        return keys;
    }

    public void setKeys(List<KeyVal> keys) {
        this.keys = keys;
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
