/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author mark
 */
public class TagViewSQL {

    static Connection conn;
    static Statement st;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        query();
    }

    public static void query() {
        conn = getConnection();
        try {
            String sql = "SELECT TAG,COUNT(*) CNT "
                    + " FROM  CARD "
                    + "GROUP BY TAG";
            st = (Statement) conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            System.out.println("checking result...");

            int viewNum = 0;
            String sql1 = "SELECT  ID, NAME, ACTION, ICON_POINTS, EFFECT,AGE,TAG,COLOR FROM CARD ";
            String sql3 = " ORDER BY AGE,ID";
            String sql123="";
            while (rs.next()) {
                viewNum++;
                String tag = rs.getString(1);
                int cnt = rs.getInt(2);
                sql123=sql1+" WHERE TAG='"+tag+"' "+sql3+";";
                System.out.println("CREATE VIEW V_TAG_" + viewNum + " AS " + sql123);
            }
            conn.close();

        } catch (Exception ex) {
            System.out.println("fail to query...");
            System.out.println(ex.toString());
        } finally {
        }

    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");// 加载Mysql数据驱动  

            conn = DriverManager.getConnection(
                    "jdbc:mysql://2nd2go.org:3306/AGES", "max", "Taipei2014");// 创建数据连接  

        } catch (Exception e) {
            System.out.println("数据库连接失败" + e.getMessage());
        }
        return conn; //返回所建立的数据库连接  
    }

}
