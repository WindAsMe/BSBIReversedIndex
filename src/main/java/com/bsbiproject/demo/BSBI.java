package com.bsbiproject.demo;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Author     : WindAsMe
 * File       : BSBI.java
 * Time       : Create on 18-9-29
 * Location   : ../Home/BSBIProject/BSBI.java
 */
public class BSBI {

    // Emulate the common dictionary
    private Set<String> set;

    BSBI() {
        this.set = new HashSet<>();
        set.add("a");
        set.add("an");
        set.add("am");
        set.add("are");
        set.add("and");
        set.add("i");
        set.add("it");
        set.add("is");
        set.add("you");
        set.add("we");
        set.add("us");
        set.add("he");
        set.add("she");
        set.add("to");
        set.add("the");
        set.add("there");
        set.add("these");
        set.add("those");
        set.add("them");
        set.add("that");
        set.add("of");
        set.add("for");
        set.add("from");
        set.add("in");
        set.add("on");
        set.add("under");
    }


    // Read the context of Excel
    public void readExcel(List<String> titles, List<String> contexts, int start, int end) throws BiffException, IOException {
        File file = new File("/home/zhongrui/IdeaProjects/BSBIProject/src/main/java/com/bsbiproject/demo/data_xlsx.xls");
        Workbook workbook = Workbook.getWorkbook(file);
        Sheet sheet = workbook.getSheet(0);
        if (sheet != null) {
            for (int i = start; i < end; i++) {
                titles.add(trim(sheet.getCell(1, i).getContents()));
                contexts.add(trim(sheet.getCell(2, i).getContents()));
            }
        }
        workbook.close();
    }


    // trim the String
    private String trim(String s) {
        s = s.toLowerCase();
        s = s.replace('\'', ' ');
        s = s.replace(':', ' ');
        s = s.replace(',', ' ');
        s = s.replace('.', ' ');
        s = s.replace('-', ' ');
        s = s.replace('[', ' ');
        s = s.replace(']', ' ');
        s = s.replace('(', ' ');
        s = s.replace(')', ' ');
        s = s.replace('“', ' ');
        s = s.replace('‘', ' ');
        s = s.replace('-', ' ');
        return s;
    }

    // Merge the titles Tuple map and contexts Tuple map
    public Map<String, List<Tuple>> mapTupleMerge(Map<String, List<Tuple>> map1, Map<String, List<Tuple>> map2) {
        for (Map.Entry<String, List<Tuple>> entry : map2.entrySet()) {
            if (map1.get(entry.getKey()) != null) {
                List<Tuple> list = map1.get(entry.getKey());
                list.addAll(entry.getValue());
                map1.put(entry.getKey(), list);
            } else
                map1.put(entry.getKey(), entry.getValue());
        }
        return map1;
    }

    // Create map both of map1 and map2
    public void createMap(List<String> list, Map<String, Integer> map1, Map<String, List<Tuple>> map2, int time, int flag) {
        for (int i = 0; i < list.size(); i++) {
            String s = String.format("%s ", list.get(i));
            char[] chars = s.toCharArray();
            StringBuilder builder = new StringBuilder();
            for (char c : chars) {
                if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <='Z'))
                    builder.append(c);
                else {
                    if (set.contains(builder.toString()) || builder.length() < 2)
                        builder.delete(0, builder.length());
                    else {
                        if (map1.containsKey(builder.toString()))
                            map1.put(builder.toString(), map1.get(builder.toString()) + 1);
                        else
                            map1.put(builder.toString(), 1);
                        if (map2.containsKey(builder.toString())) {
                            List<Tuple> tuples = map2.get(builder.toString());
                            tuples.add(new Tuple(time * 10 + i + 2, flag));
                            map2.put(builder.toString(), tuples);
                        } else {
                            List<Tuple> tuples = new ArrayList<>();
                            tuples.add(new Tuple(time * 10 + i + 2, flag));
                            map2.put(builder.toString(), tuples);
                        }
                        builder.delete(0, builder.length());
                    }
                }
            }
        }
    }

    // 1. Compare the frequency
    // 2. Compare the String
    public List<Map.Entry<String, List<Tuple>>> createReversedIndex(Map<String, List<Tuple>> map) {
        List<Map.Entry<String, List<Tuple>>> entries = new ArrayList<>(map.entrySet());
        entries.sort((o1, o2) -> {
            if (o1.getValue().size() != o2.getValue().size())
                return o1.getValue().size() - o2.getValue().size();
            else
                return o1.getKey().compareTo(o2.getKey());
        });
        return entries;
    }

}
