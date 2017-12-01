package cn.working.entity;

import java.util.Date;

/**
 * Created by 王 on 2017/11/24.
 */
public class Working {
    private int id;
    private String title;
    private String content;
    private Date date;
    private int type;

    public Working() {
    }

    public Working(String title, String content, int type) {
        this.title = title;
        this.content = content;
        this.type = type;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
