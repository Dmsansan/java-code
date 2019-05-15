package designType.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<List<String>> fatherList = new LinkedList<>();
        List<String> childList = new ArrayList<>();
        childList.add("before add childList");
        fatherList.add(childList);
        childList.add("after add childList");

        System.out.println(fatherList);
    }
}
