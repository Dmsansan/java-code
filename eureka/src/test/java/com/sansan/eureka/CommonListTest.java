package com.sansan.eureka;

/**
 * @author siss
 * @date 2020/6/4  14:45
 * @desc ArrayList LinkedList性能分析测试
 */
public class CommonListTest {

    public static void main(String[] args) {
        /**
         * ArrayList是基于动态数组的数据结构
         * LinkedList是基于链表的数据结构
         *
         * 结论：1、List首选ArrayList数据机构，极个别涉及到插入删除比较多的情况使用LinkedList
         *      2、在对LinkedList进行循环遍历的时候不要直接用get方法，使用Iterator迭代器进行遍历查询
         */
        System.out.println("懒得写测试代码，直接记住结论就行了");
    }
}
