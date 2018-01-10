package com.java8.practice.tree;

/**
 * Created by garychen on 2018/1/10.
 */

public class TreeBean {
    private Integer id;
    private String name;
    private Integer parentId;
    private Integer sortId;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TreeBean{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", parentId=").append(parentId);
        sb.append(", sortId=").append(sortId);
        sb.append('}');
        return sb.toString();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getSortId() {
        return sortId;
    }

    public void setSortId(Integer sortId) {
        this.sortId = sortId;
    }
}
