package com.bsbiproject.demo.util;

import com.bsbiproject.demo.domain.JDModel;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : ConUtil.java
 * Time       : Create on 18-10-9
 * Location   : ../Home/BSBIProject/ConUtil.java
 */
public class ConUtil {

    private Connection getCon() {
        String username = "root";
        String password = "change123";
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/IRDB";

        Connection conn = null;
        try {
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public List<JDModel> getSelect() {
        String sql = "select * from jd_crawler";
        Connection conn = getCon();
        PreparedStatement pst;
        List<JDModel> list = new ArrayList<>();
        try {
            pst = (PreparedStatement) conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                JDModel model = new JDModel();
                model.setId(Integer.valueOf(rs.getString("id")));
                model.setPage(Integer.valueOf(rs.getString("page")));
                model.setTitle(rs.getString("title"));
                model.setUrl(rs.getString("url"));
                model.setPrice(rs.getString("price"));
                list.add(model);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
