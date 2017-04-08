package top.zz.controller.base;

import cn.shengyuan.tools.util.ResourceUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Message implements Serializable {
    private static final long serialVersionUID = 7289310002935043203L;
    private Message.Type type;
    private String content;
    private Map<String, Object> resultMap = new HashMap();

    public Message() {
    }

    public Message(Message.Type type, String content) {
        this.type = type;
        this.content = ResourceUtils.getString("message", content);
    }

    public Message(Message.Type type, String content, Object... args) {
        this.type = type;
        this.content = ResourceUtils.getString("message", content, args);
    }

    public static Message success(String content, Object... args) {
        return new Message(Message.Type.success, content, args);
    }

    public static Message warn(String content, Object... args) {
        return new Message(Message.Type.warn, content, args);
    }

    public static Message error(String content, Object... args) {
        return new Message(Message.Type.error, content, args);
    }

    public Message.Type getType() {
        return this.type;
    }

    public void setType(Message.Type type) {
        this.type = type;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Map<String, Object> getResultMap() {
        return this.resultMap;
    }

    public void setResultMap(Map<String, Object> resultMap) {
        this.resultMap = resultMap;
    }

    public Message addResult(String key, Object val) {
        if(this.resultMap == null) {
            this.resultMap = new HashMap();
        }

        this.resultMap.put(key, val);
        return this;
    }

    public Message addResultMap(Map<String, Object> resultMap) {
        if(this.resultMap == null) {
            this.resultMap = new HashMap();
        }

        if(resultMap != null) {
            this.resultMap.putAll(resultMap);
        }

        return this;
    }

    public static enum Type {
        success,
        warn,
        error;

        private Type() {
        }
    }
}