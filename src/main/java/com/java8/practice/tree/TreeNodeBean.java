package com.java8.practice.tree;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by garychen on 2018/1/10.
 */

public class TreeNodeBean extends TreeBean {
    List<TreeNodeBean> nodes;

    public List<TreeNodeBean> getNodes() {
        return nodes;
    }

    public void setNodes(List<TreeNodeBean> nodes) {
        this.nodes = nodes;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TreeNodeBean{");
        sb.append("nodes=").append(nodes);
        sb.append('}');
        return sb.toString();
    }

    /**
     * 对象赋值
     * @param bean
     * @return
     */
    public static TreeNodeBean trans(TreeBean bean){
        TreeNodeBean nodeBean = new TreeNodeBean();
        nodeBean.setId(bean.getId());
        nodeBean.setName(bean.getName());
        nodeBean.setParentId(bean.getParentId());
        nodeBean.setSortId(bean.getSortId());
        return nodeBean;
    }

    /**
     * 是否是父节点
     * @return
     */
    public boolean nodeIsParent(){
        return getParentId() == 0;
    }

    public void addChildNode(List<TreeNodeBean> n){
        if (null == nodes) {
            nodes = new LinkedList<>();
        }
        n.stream().map(i->{
            if (i.getParentId() == getId()) {
                nodes.add(i);
                i.addChildNode(n);
            }
            return i;
        }).forEach(TreeNodeBean::sortNodes);
    }

    /**
     * 排序
     */
    private void sortNodes() {
        if (null == nodes || nodes.size() == 0) {
            return;
        }
        nodes = nodes.stream()
                .map(i -> {
                    i.sortNodes();
                    return i;
                })
                .sorted(Comparator.comparing(TreeNodeBean::getSortId))
                .collect(Collectors.toList());
    }
}
