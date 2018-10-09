package com.bsbiproject.demo.util;

import java.util.HashSet;
import java.util.Set;

/**
 * Author     : WindAsMe
 * File       : StopWordUtil.java
 * Time       : Create on 18-10-9
 * Location   : ../Home/BSBIProject/StopWordUtil.java
 */
public class StopWordUtil {

    // Emulate the common dictionary
    public boolean stop(String s) {
        Set<String> set = new HashSet<>();
        set.add("，");
        set.add("。");
        set.add("“");
        set.add("、");
        set.add("");
        set.add("【");
        set.add("】");
        set.add("（");
        set.add("）");
        set.add("①");
        set.add("②");
        set.add("③");
        set.add("④");
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        set.add("\"");
        set.add("!");
        set.add("啊");
        set.add("x");
        set.add(" ");
        set.add("❣");
        set.add("◆");
        set.add("的");
        set.add("你");
        set.add("我");
        set.add("他");
        set.add("她");
        set.add("它");
        set.add("我们");
        set.add("你们");
        set.add("他们");
        set.add("她们");
        set.add("它们");
        set.add("一下");
        set.add("一个");
        set.add("一些");
        set.add("一何");
        set.add("一切");
        set.add("一则");
        // ....
        return set.contains(s);
    }
}
