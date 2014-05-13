/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.CardEntity;
import entity.CardEntityManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author mark
 */
public class CardEntityUtil {

    CardEntity card;
    static Connection conn;
    static Statement st;
    Set effectSet;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new CardEntityUtil().queryAndInsert();
    }

    public CardEntityUtil() {
        effectSet = new HashSet();
    }

    void parseEffect(String str) {
        String[] tokens = str.split(";");
        for (String token : tokens) {
            if (token.trim().length() == 0) {
                continue;
            }
//            System.out.println(""+token);
            String[] pair = token.split(":");
            String key = pair[0];
            int val = Integer.parseInt(pair[1]);
//            System.out.println(key+" "+val);
            effectSet.add(key);
        }
    }

    void parseCardEffect() {
        String[] tokens = card.getEffect().split(";");
        for (String token : tokens) {
            if (token.trim().length() == 0) {
                continue;
            }
//            System.out.println(""+token);
            String[] pair = token.split(":");
            String key = pair[0];
            int val = Integer.parseInt(pair[1]);
//            System.out.println(key + " " + val);

            switch (key) {
                case "+白點":
                    card.setEffectWhite(val);
                    break;
                case "+紅點":
                    card.setEffectRed(val);
                    break;
                case "+藍點":
                    card.setEffectBlue(val);
                    break;
                case "+房屋":
                    card.setEffectHouse(val);
                    break;
                //   +白點, 米, +紅點, 琴, 石頭, 燈泡, 笑臉, +房屋, +藍點, 武器]
                case "米":
                    card.setEffectFood(val);
                    break;
                case "琴":
                    card.setEffectMusic(val);
                    break;
                case "石頭":
                    card.setEffectStone(val);
                    break;
                case "燈泡":
                    card.setEffectIdea(val);
                    break;
                case "笑臉":
                    card.setEffectSmile(val);
                    break;
                case "藍點":
                    card.setEffectBlue(val);
                    break;
                case "武器":
                    card.setEffectWeapon(val);
                    break;
                default:
                    System.out.println("***************NEED TO HANDLE => " + key);

            }

            effectSet.add(key);
        }
    }
    /*
     INSERT INTO `AGES`.`CARD_ENTITY` (
     `ID` ,
     `NAME` ,
     `AGE` ,
     `CIVIL_MILITARY` ,
     `TAG` ,
     `ACTION` ,
     `ICON_POINTS` ,
     `EFFECT` ,
     `COST` ,
     `COLOR` ,
     `CNT` ,
     `TOKEN_WHITE` ,
     `TOKEN_RED` ,
     `TOKEN_YELLOW` ,
     `TOKEN_BLUE` ,
     `EFFECT_WHITE` ,
     `EFFECT_FOOD` ,
     `EFFECT_RED` ,
     `EFFECT_MUSIC` ,
     `EFFECT_STONE` ,
     `EFFECT_IDEA` ,
     `EFFECT_SMILE` ,
     `EFFECT_HOUSE` ,
     `EFFECT_BLUE` ,
     `EFFECT_WEAPON`
     )
     VALUES (
     '1002', NULL , NULL , NULL , NULL , '', '', '', NULL , NULL , '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''
     );
     */

    public void composeSQL() {
        String s1 = "   INSERT INTO `AGES`.`CARD_ENTITY` ("
                + " `ID` ,`NAME` ,`AGE` ,`CIVIL_MILITARY` ,`TAG` ,"
                + "`ACTION` ,`ICON_POINTS` ,`EFFECT`  ,`COLOR` ,"
                + "`CNT` ,"
                + "`TOKEN_WHITE` ,`TOKEN_RED` ,`TOKEN_YELLOW` ,`TOKEN_BLUE` ,"
                + "`EFFECT_WHITE` ,`EFFECT_FOOD` ,`EFFECT_RED` ,`EFFECT_MUSIC` ,`EFFECT_STONE` ,`EFFECT_IDEA` ,`EFFECT_SMILE` ,`EFFECT_HOUSE` ,`EFFECT_BLUE` ,`EFFECT_WEAPON`) ";
        StringBuilder sb = new StringBuilder();
        sb.append(s1);
        sb.append("VALUES(");
        sb.append("'").append(card.getId()).append("',");
        sb.append("'").append(card.getName()).append("',");
        sb.append("'").append(card.getAge()).append("',");
        sb.append("'").append(card.getCivilMilitary()).append("',");
        sb.append("'").append(card.getTag()).append("',");
        sb.append("'").append(card.getAction()).append("',");
        sb.append("'").append(card.getIconPoints()).append("',");
        sb.append("'").append(card.getEffect()).append("',");
        sb.append("'").append(card.getColor()).append("',");
        sb.append("'").append(card.getCnt()).append("',");
        sb.append("'").append(card.getTokenBlue()).append("',");
        sb.append("'").append(card.getTokenRed()).append("',");
        sb.append("'").append(card.getTokenWhite()).append("',");
        sb.append("'").append(card.getTokenYellow()).append("',");
        sb.append("'").append(card.getEffectBlue()).append("',");
        sb.append("'").append(card.getEffectFood()).append("',");
        sb.append("'").append(card.getEffectHouse()).append("',");
        sb.append("'").append(card.getEffectIdea()).append("',");
        sb.append("'").append(card.getEffectMusic()).append("',");
        sb.append("'").append(card.getEffectRed()).append("',");
        sb.append("'").append(card.getEffectSmile()).append("',");
        sb.append("'").append(card.getEffectStone()).append("',");
        sb.append("'").append(card.getEffectWeapon()).append("',");
        sb.append("'").append(card.getEffectWhite()).append("'");
        
        
        
        
        
        
        sb.append(");");
        
        System.out.println(sb.toString());
        

    }

    public void queryAndInsert() {
        conn = getConnection();
        try {
            String sql = "SELECT ID,NAME,AGE, CIVIL_MILITARY, TAG, ACTION, ICON_POINTS,EFFECT,"
                    + " COLOR,CNT "
                    + " FROM  CARD "
                    + " ORDER BY ID";
            st = (Statement) conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            System.out.println("checking result...");

            int viewNum = 0;

//            int id;              //1
//            String name;         //2  
//            int age;             //3
//            String civilMilitary;//4
//            String tag;          //5
//            String action;       //6
//            String iconPoints;   //7
//            String effect;       //8
//            String color;        //9
//            int cnt;             //10
            while (rs.next()) {
                viewNum++;
                card = new CardEntity();
                card.setId(rs.getInt(1));
                card.setName(rs.getString(2));
                card.setAge(rs.getInt(3));
                card.setCivilMilitary(rs.getString(4));
                card.setTag(rs.getString(5));
                card.setAction(rs.getString(6));
                card.setIconPoints(rs.getString(7));
                card.setEffect(rs.getString(8));
                card.setColor(rs.getString(9));
                card.setCnt(rs.getInt(10));

                parseCardEffect();
//                CardEntityManager.insertCardEntity(card);

//                System.out.println(card.toString());
                composeSQL();
                

            }
            System.out.println("Effect keyword: " + effectSet);

            conn.close();

        } catch (Exception ex) {
            System.out.println("fail to query...");
            System.out.println(ex.toString());
        } finally {
        }

    }

    public void query() {
        conn = getConnection();
        try {
            String sql = "SELECT ID,NAME,AGE, CIVIL_MILITARY, TAG, ACTION, ICON_POINTS,EFFECT,"
                    + " COLOR,CNT "
                    + " FROM  CARD "
                    + " ORDER BY ID";
            st = (Statement) conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            System.out.println("checking result...");

            int viewNum = 0;

            int id;              //1
            String name;         //2  
            int age;             //3
            String civilMilitary;//4
            String tag;          //5
            String action;       //6
            String iconPoints;   //7
            String effect;       //8
            String color;        //9
            int cnt;             //10
            while (rs.next()) {
                viewNum++;
                id = rs.getInt(1);
                name = rs.getString(2);
                age = rs.getInt(3);
                civilMilitary = rs.getString(4);
                tag = rs.getString(5);
                action = rs.getString(6);
                iconPoints = rs.getString(7);
                effect = rs.getString(8);
                color = rs.getString(9);
                cnt = rs.getInt(10);

                StringBuilder sb = new StringBuilder();
                sb.append(id).append(" ");
                sb.append(name).append(" ");
                sb.append(age).append(" ");
                sb.append(civilMilitary).append(" ");
                sb.append(tag).append(" ");
                sb.append(action).append(" ");
                sb.append(iconPoints).append(" ");
                sb.append(effect).append(" ");
                sb.append(color).append(" ");
                sb.append(cnt).append(" ");
                System.out.println(sb.toString());

                parseEffect(effect);
            }
            System.out.println("Effect keyword: " + effectSet);

            conn.close();

        } catch (Exception ex) {
            System.out.println("fail to query...");
            System.out.println(ex.toString());
        } finally {
        }

    }

    public void insert(String sql) {

        conn = getConnection(); // 首先要获取连接，即连接到数据库  

        try {
//            String sql = "INSERT INTO staff(name, age, sex,address, depart, worklen,wage)"  
//                    + " VALUES ('Tom1', 32, 'M', 'china','Personnel','3','3000')";  // 插入数据的sql语句  

            st = (Statement) conn.createStatement();    // 创建用于执行静态sql语句的Statement对象  

            int count = st.executeUpdate(sql);  // 执行插入操作的sql语句，并返回插入数据的个数  

            System.out.println("向staff表中插入 " + count + " 条数据"); //输出插入操作的处理结果  

            conn.close();   //关闭数据库连接  

        } catch (SQLException e) {
            System.out.println("插入数据失败" + e.getMessage());
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
