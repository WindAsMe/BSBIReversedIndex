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
        set.add("i");
        set.add("you");
        set.add("we");
        set.add("us");
        set.add("he");
        set.add("she");
        set.add("the");
        set.add("are");
        set.add("there");
        set.add("these");
        set.add("those");
        set.add("them");
        set.add("of");
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
            int row = sheet.getRows();
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

    public Map<String, Integer> mapMerge(Map<String, Integer> map1, Map<String, Integer> map2) {
        return new HashMap<String, Integer>() {{
            putAll(map1);
            putAll(map2);
        }};
    }

}
