/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package se;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ashraf
 */
public class functions {
     final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
     static  Connection conn=null ;
     static  Statement stmt=null ;
    
    void conn(String user_name,String password) throws ClassNotFoundException, SQLException
   {  
       String unicode= "?useUnicode=yes&characterEncoding=UTF-8";
       String ip =  JOptionPane.showInputDialog(null,"ip");
       final String DB_URL = "jdbc:mysql://"+ip+"/se";
       final String USER = user_name;
       final String PASS = password;

      JOptionPane.showMessageDialog(null, USER+" "+PASS);
      Class.forName("com.mysql.jdbc.Driver");
      
      conn = DriverManager.getConnection(DB_URL+unicode,USER, PASS);
      stmt = conn.createStatement();
      System.out.println("Connecting to database...");
   } 
    boolean check_time (String date ,int value) throws ParseException
  {
 //          main d=new main();
//      d.model_employee_el7dor.addRow(new Object[]{"123","shrfjdsf","4652457"});
//      //joptionpanee.showMessageDialog(null, d.jTable_employee_el7dor.getValueAt(0, 0));
       boolean flag=true;
       try{
 String untildate=date;//can take any date in current format    
SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd" );   
Calendar cal = Calendar.getInstance();    
cal.setTime( dateFormat.parse(untildate));

cal.add( Calendar.DATE, value );    
String convertedDate=dateFormat.format(cal.getTime());    
System.out.println("Date increase by one.."+convertedDate);

       }catch (Exception w){flag=false;}
return flag ;
  }
    boolean check_int(String num)
  {
      boolean flag=true ;
      try{ double int_num=Double.parseDouble(num);flag=true;
      //joptionpanee.showMessageDialog(null,num);
      }
      catch (Exception e){flag=false;}
      return flag ;
  }
    String time_now()
   {
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
 
Calendar c = Calendar.getInstance();
c.setTime(c.getTime()); // Now use today date.

String output = sdf.format(c.getTime());
System.out.println(output);
return output ;
   }
    void insert_students (String id_team , String id_student , String name, String no , String dept )
    {
        try {
            stmt.executeUpdate("insert into students values ('"+id_team+"','"+id_student+"','"+name+"',"+no+",'"+dept+"',"+"0"+")");
        } catch (SQLException ex) {
            Logger.getLogger(functions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      void update_total_degree_students (String id_team , String id_student ,String old_total ,String degree )
    {
        try {
            stmt.executeUpdate("update students set total_degress="+String.valueOf(Double.parseDouble(old_total)+Double.parseDouble(degree))
                    +" where id_team='"+id_team +"' and id_student ='"+id_student+"'");
        } catch (SQLException ex) {
            Logger.getLogger(functions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      ResultSet search_student_id_team(String id_team)
      { ResultSet rs=null ;
        try {
            stmt=conn.createStatement();
        
         
      
            rs=stmt.executeQuery("select * from students where id_team='"+id_team+"'");
        } catch (SQLException ex) {
            Logger.getLogger(functions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs ;
      }
      ResultSet search_student_id_team_students(String id_team,String id_student)
      { ResultSet rs=null ;
        try {
            stmt=conn.createStatement();
        
         
      
            rs=stmt.executeQuery("select * from students where id_team='"+id_team+"'"+" and id_student='"+id_student+"'");
            System.out.println("select * from students where id_team='"+id_team+"'"+" and id_student='"+id_student+"'");
        } catch (SQLException ex) {
            Logger.getLogger(functions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs ;
      }
       ResultSet search_student_name(String name)
      { ResultSet rs=null ;
        try {
            stmt=conn.createStatement();
        
         
      
            rs=stmt.executeQuery("select * from students where name_student like '"+name+"%'");
            
        } catch (SQLException ex) {
            Logger.getLogger(functions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs ;
      }
       
       
       
       void insert_history(String id_team , String id_student , String degree , String reason )
       {
        try {
            stmt.executeUpdate("insert into history values ('"+id_team+"','"+id_student+"',"+degree+",'"+reason+"','"+time_now()+"')");
            System.out.println("insert into history values ('"+id_team+"','"+id_student+"',"+degree+",'"+reason+"','"+time_now()+"')");
        } catch (SQLException ex) {
            Logger.getLogger(functions.class.getName()).log(Level.SEVERE, null, ex);
        }
       }
        ResultSet search_history_primary(String id_team ,String id_student , String date )
      { ResultSet rs=null ;
        try {
            stmt=conn.createStatement();
        
         
      
            rs=stmt.executeQuery("select * from history where id_team ='"+id_team +"' and id_student='"+id_student+"' and date='"+date+"'");
            System.out.println("select * from history where id_team ='"+id_team +"' and id_student='"+id_student+"' and date='"+date+"'");
        } catch (SQLException ex) {
            Logger.getLogger(functions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs ;
      }
         ResultSet search_history_id_team(String id_team  )
      { ResultSet rs=null ;
        try {
            stmt=conn.createStatement();
        
         
      
            rs=stmt.executeQuery("select * from history where id_team ='"+id_team +"'");
        
        } catch (SQLException ex) {
            Logger.getLogger(functions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs ;
      }
         ResultSet search_history_id_team_student(String id_team,String id_student  )
      { ResultSet rs=null ;
        try {
            stmt=conn.createStatement();
        
         
      
            rs= rs=stmt.executeQuery("select * from history where id_team ='"+id_team +"' and id_student='"+id_student+"'");
        
        } catch (SQLException ex) {
            Logger.getLogger(functions.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs ;
      }
}
