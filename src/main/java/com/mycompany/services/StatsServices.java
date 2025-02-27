/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.services;

import com.mycompany.jdbcapp.JdbcUtlis;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class StatsServices {

    public List<Object[]> countQuestionByCate(String kw) throws SQLException {

        List<Object[]> results = new ArrayList<>();
        try (Connection conn = JdbcUtlis.getConn()) {
            CallableStatement stm = conn.prepareCall("{Call count_question_by_cate(?)}");
            stm.setString(1, kw);
            
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Object[] r = {rs.getInt("id"), rs.getString("name"), rs.getInt("quantity")};
                results.add(r);
            }
        }
        return results;
    }
}
