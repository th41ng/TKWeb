/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.jdbcapp;

import com.mycompany.pojo.Choice;
import com.mycompany.services.QuestionServices;
import com.mycompany.services.StatsServices;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class JdbcApp {

    public static void main(String[] args) throws SQLException {
        StatsServices sv = new StatsServices();
        sv.countQuestionByCate("").forEach(s -> System.out.printf("%d - %s: %d\n", s[0], s[1], s[2]));
        
//        QuestionServices s = new QuestionServices();
//        Scanner sc = new Scanner(System.in);
//        s.getQuestion(2).forEach(q->{
//                System.out.println(q);
//            try {
//                List<Choice> choices = s.getChoice(q.getId());
//                for (int i = 0; i < choices.size();i++)
//                    System.out.printf("%d. %s\n", i+1,choices.get(i));
//                
//                System.out.print("Your answer: ");
//                int idx = sc.nextByte();
//                if (choices.get(idx - 1).isCorrect()== true )
//                    System.out.print("Corret\n");
//                else
//                    System.err.print("Wrong\n");
//            } catch (SQLException ex) {
//                Logger.getLogger(JdbcApp.class.getName()).log(Level.SEVERE, null, ex);
//            }           
//        });
        
       
    }
}
