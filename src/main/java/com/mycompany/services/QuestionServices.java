/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.services;

import com.mycompany.jdbcapp.JdbcUtlis;
import com.mycompany.pojo.Choice;
import com.mycompany.pojo.Question;
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
public class QuestionServices {

    public List<Question> getQuestion(int num) throws SQLException {
        List<Question> questions = new ArrayList<>();
        try (Connection conn = JdbcUtlis.getConn()) {
            CallableStatement stm = conn.prepareCall("{CALL get_questions(?)}");
            stm.setInt(1, num);
            
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                Question q = new Question(rs.getString("id"), rs.getString("content"), rs.getInt("category_id"));
                questions.add(q);
            }
        }
       
        return questions;
    }
    
    
     public List<Choice> getChoice(String questionId) throws SQLException {
        List<Choice> choices = new ArrayList<>();
        try (Connection conn = JdbcUtlis.getConn()) {
            CallableStatement stm = conn.prepareCall("{call englishdb.get_choices(?)}");
            stm.setString(1, questionId);
            
            ResultSet rs = stm.executeQuery();
            
            while (rs.next()){
                Choice c = new Choice(rs.getString("id"),rs.getString("content"),rs.getBoolean("is_correct"), rs.getString("question_id"));
                choices.add(c);
            }
        }
       
        return choices;
    }
    
}
