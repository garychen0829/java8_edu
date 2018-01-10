package com.java8.practice.tree;

import com.alibaba.fastjson.JSON;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.*;

/**
 * Created by garychen on 2018/1/10.
 */
public class TreeBeanTest {
    List<TreeBean> treeBeans = new ArrayList<>();
    @Before
    public void setUp() throws Exception {
        TreeBean t1 = new TreeBean();
        t1.setId(1);
        t1.setName("安徽");
        t1.setParentId(0);
        t1.setSortId(2);

        TreeBean t2 = new TreeBean();
        t2.setId(2);
        t2.setName("合肥");
        t2.setParentId(1);
        t2.setSortId(2);

        TreeBean t3 = new TreeBean();
        t3.setId(3);
        t3.setName("淮南");
        t3.setParentId(1);
        t3.setSortId(1);

        TreeBean t4 = new TreeBean();
        t4.setId(4);
        t4.setName("浙江");
        t4.setParentId(0);
        t4.setSortId(1);

        TreeBean t5 = new TreeBean();
        t5.setId(5);
        t5.setName("杭州");
        t5.setParentId(4);
        t5.setSortId(1);

        TreeBean t6 = new TreeBean();
        t6.setId(6);
        t6.setName("绍兴");
        t6.setParentId(4);
        t6.setSortId(2);

        treeBeans.add(t1);
        treeBeans.add(t2);
        treeBeans.add(t3);
        treeBeans.add(t4);
        treeBeans.add(t5);
        treeBeans.add(t6);


    }

    @Test
    public void test01(){
        System.out.println(JSON.toJSONString(treeBeans));

        List<TreeNodeBean> nodes = treeBeans.stream()
                                                .map(TreeNodeBean::trans)
                                                .collect(Collectors.toList());
        System.out.println(">>>"+JSON.toJSONString(nodes));
        List<TreeNodeBean> parent = nodes.stream()
                                            .filter(TreeNodeBean::nodeIsParent)
                                            .collect(Collectors.toList());

        System.out.println("###"+JSON.toJSONString(parent));

        parent.forEach(i -> i.addChildNode(nodes));

        System.out.println("$$$"+JSON.toJSONString(parent));
    }

}