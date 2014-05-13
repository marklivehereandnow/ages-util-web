/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import com.livehereandnow.ages.card.CardEntity;
import com.livehereandnow.ages.card.Card;
import com.livehereandnow.ages.card.CardArray;
import com.livehereandnow.ages.card.CardBank;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author mark
 */
public class CardEntityManager {

    private static final String PERSISTENCE_UNIT_NAME = "agesPU";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        System.out.println("*******************");
        System.out.println("*ages-util-web*");
        System.out.println("*******************");
//        do1();
//        cleanCardEntity();
        prepareCardBank();
//        do4();
    }

    public static void do5() {
//    CardArray cardArray=new CardArray("AllCards");
//     CardBank cb=new           
        CardArray cardArray = CardBank.getInstance().getAllCards();
        cardArray.setTitle("All Cards");
        cardArray.show(1);
    }

    public static void do4() {
        CardArray allCards = new CardArray("AllCards");
//        run:
//Card{id=1, name=亞歷山大大帝, age=0, civilMilitary=內政, tag=領袖, action=acting..., iconPoints=icon.., cost=cost..., color=color, cnt=1}
//[EL Info]: 2014-05-11 18:33:02.573--ServerSession(17792118)--EclipseLink, version: Eclipse Persistence Services - 2.5.1.v20130918-f2b9fc5
//[EL Info]: connection: 2014-05-11 18:33:03.899--ServerSession(17792118)--file:/home/mark/0509/ages-cards/build/classes/_agesPU login successful
//        allCards.add(new Card(1002, "亞歷山大圖書館", 0, "內政", "奇蹟", "你可以額外保留一張內政牌一張軍事牌", "", "1;2;2;1", "紫色", 1));
//        allCards.add(new Card(1015, "巨人像", 0, "內政", "奇蹟", "殖民時獲得獎勵+1", "", "3;3", "紫色", 1));
//        allCards.add(new Card(1026, "空中花園", 0, "內政", "奇蹟", "", "", "2;2;2", "紫色", 1));
//        allCards.add(new Card(1031, "金字塔", 0, "內政", "奇蹟", "", "", "3;2;1", "紫色", 1));
//        allCards.add(new Card(1010, "哲學", 0, "內政", "實驗室", "", "", "0;3", "灰色", 1));
//        allCards.add(new Card(1001, "專制", 0, "內政", "政府", "", "", "0", "橙色", 1));
//        allCards.add(new Card(1018, "戰士", 0, "內政", "步兵", "", "", "2", "紅色", 1));
//        allCards.add(new Card(1032, "青銅", 0, "內政", "礦山", "", "", "0;2", "棕色", 1));
//        allCards.add(new Card(1011, "宗教", 0, "內政", "神廟", "", "", "3", "灰色", 1));
//        allCards.add(new Card(1013, "富饒之土", 0, "內政", "行動", "少花費一個資源建造一個農場或礦場", "", "0", "黃色", 1));
//        allCards.add(new Card(1014, "工程天才", 0, "內政", "行動", "本輪完成奇蹟的一步建設時少花費兩個資源", "", "0", "黃色", 1));
//        allCards.add(new Card(1017, "建築工地", 0, "內政", "行動", "建築一座新的城市建築少花費一個資源", "", "0", "黃色", 1));
//        allCards.add(new Card(1024, "愛國主義", 0, "內政", "行動", "本輪獲得一個額外的軍事行動和一個額外的資源用於建造軍隊", "", "0", "黃色", 1));
//        allCards.add(new Card(1027, "藝術作品", 0, "內政", "行動", "獲得六點文化分數", "", "0", "黃色", 1));
//        allCards.add(new Card(1028, "節儉", 0, "內政", "行動", "以正常價格增加一個人口後,獲得一個食物", "", "0", "黃色", 1));
//        allCards.add(new Card(1033, "革新思想", 0, "內政", "行動", "", "", "0", "黃色", 1));
//        allCards.add(new Card(1007, "農業", 0, "內政", "農場", "", "", "0;2", "棕色", 1));
//        allCards.add(new Card(1003, "亞歷山大大帝", 0, "內政", "領袖", "每個軍事單位的力量加一", "", "0", "綠色", 1));
//        allCards.add(new Card(1004, "亞里士多得", 0, "內政", "領袖", "每從排列獲得一張科技牌,就獲得一個科技點數", "", "0", "綠色", 1));
//        allCards.add(new Card(1009, "凱薩", 0, "內政", "領袖", "軍事力量+1 軍事行動 MA+1", "", "0", "綠色", 1));
//        allCards.add(new Card(1020, "摩西", 0, "內政", "領袖", "增加人口時少消耗一個食物", "", "0", "綠色", 1));
//        allCards.add(new Card(1023, "漢摩拉比", 0, "內政", "領袖", "內政行動CA+1 軍事行動MA-1", "", "0", "綠色", 1));
//        allCards.add(new Card(1029, "荷馬", 0, "內政", "領袖", "每輪獲得一個額外資源用於建造軍隊,每個戰士每輪獲得一點文化(最多為兩點)", "", "0", "綠色", 1));
//        allCards.add(new Card(1005, "人口的發展", 0, "軍事", "事件", "每個文明免費獲得一個人口", "", "0", "深綠色", 1));
//        allCards.add(new Card(1006, "軍事的發展", 0, "軍事", "事件", "每名玩家可以免費將一名閒置工人升級為軍事部隊", "", "0", "深綠色", 1));
//        allCards.add(new Card(1008, "農業的發展", 0, "軍事", "事件", "每個文明生產兩個食物", "", "0", "深綠色", 1));
//        allCards.add(new Card(1012, "宗教的發展", 0, "軍事", "事件", "每個玩家可以使用一個限制的工人免費修建寺廟", "", "0", "深綠色", 1));
//        allCards.add(new Card(1016, "市場的發展", 0, "軍事", "事件", "每個文明生產兩個食物或兩個資源(玩家自行決定)", "", "0", "深綠色", 1));
//        allCards.add(new Card(1019, "手工業的發展", 0, "軍事", "事件", "每個文明生產兩個資源", "", "0", "深綠色", 1));
//        allCards.add(new Card(1021, "政治的發展", 0, "軍事", "事件", "每個玩家可抽取三張軍事牌,當前玩家本輪不需要棄掉軍事牌", "", "0", "深綠色", 1));
//        allCards.add(new Card(1022, "無事件", 0, "軍事", "事件", "什麼都沒有發生", "", "0", "深綠色", 1));
//        allCards.add(new Card(1025, "科技的發展", 0, "軍事", "事件", "每個文明獲得兩點科技點數", "", "0", "深綠色", 1));
//        allCards.add(new Card(1030, "貿易的發展", 0, "軍事", "事件", "每個文明獲得一個科技點數,生產一個食物和一個資源", "", "0", "深綠色", 1));
//        allCards.add(new Card(1075, "法典", 1, "內政", "內政", "", "", "6", "藍色", 1));
//        allCards.add(new Card(1068, "戲劇", 1, "內政", "劇院", "", "", "4;4", "灰色", 2));
//        allCards.add(new Card(1068, "戲劇", 1, "內政", "劇院", "", "", "4;4", "灰色", 2));
//        allCards.add(new Card(1048, "印刷術", 1, "內政", "圖書館", "", "", "3;4", "灰色", 2));
//        allCards.add(new Card(1048, "印刷術", 1, "內政", "圖書館", "", "", "3;4", "灰色", 2));
//        allCards.add(new Card(1036, "萬里長城", 1, "內政", "奇蹟", "", "", "2;2;3;2", "紫色", 1));
//        allCards.add(new Card(1047, "卡羅琳娜大學", 1, "內政", "奇蹟", "", "", "3;3;3", "紫色", 1));
//        allCards.add(new Card(1057, "聖彼得大教堂", 1, "內政", "奇蹟", "", "", "4;4", "紫色", 1));
//        allCards.add(new Card(1076, "泰姬陵", 1, "內政", "奇蹟", "", "", "2;4;2", "紫色", 1));
//        allCards.add(new Card(1078, "煉金術", 1, "內政", "實驗室", "", "", "4;6", "灰色", 2));
//        allCards.add(new Card(1078, "煉金術", 1, "內政", "實驗室", "", "", "4;6", "灰色", 2));
//        allCards.add(new Card(1082, "石工學", 1, "內政", "建築", "", "", "3", "藍色", 1));
//        allCards.add(new Card(1052, "君主制", 1, "內政", "政府", "", "", "9;3", "橙色", 1));
//        allCards.add(new Card(1085, "神權政治", 1, "內政", "政府", "", "", "7;2", "橙色", 1));
//        allCards.add(new Card(1044, "劍士", 1, "內政", "步兵", "", "", "3;3", "紅色", 2));
//        allCards.add(new Card(1044, "劍士", 1, "內政", "步兵", "", "", "3;3", "紅色", 2));
//        allCards.add(new Card(1043, "製圖術", 1, "內政", "殖民", "", "", "4", "藍色", 1));
//        allCards.add(new Card(1099, "鐵礦", 1, "內政", "礦山", "", "", "5;5", "棕色", 2));
//        allCards.add(new Card(1099, "鐵礦", 1, "內政", "礦山", "", "", "5;5", "棕色", 2));
//        allCards.add(new Card(1084, "神學", 1, "內政", "神廟", "", "", "2;5", "灰色", 2));
//        allCards.add(new Card(1084, "神學", 1, "內政", "神廟", "", "", "2;5", "灰色", 2));
//        allCards.add(new Card(1053, "河蟹娛樂", 1, "內政", "競技場", "", "", "3;4", "灰色", 2));
//        allCards.add(new Card(1053, "河蟹娛樂", 1, "內政", "競技場", "", "", "3;4", "灰色", 2));
//        allCards.add(new Card(1038, "豐收", 1, "內政", "行動", "", "", "0", "黃色", 1));
//        allCards.add(new Card(1061, "富饒之土", 1, "內政", "行動", "", "", "0", "黃色", 2));
//        allCards.add(new Card(1061, "富饒之土", 1, "內政", "行動", "", "", "0", "黃色", 2));
//        allCards.add(new Card(1063, "工程天才", 1, "內政", "行動", "", "", "0", "黃色", 1));
//        allCards.add(new Card(1065, "建築工地", 1, "內政", "行動", "", "", "0", "黃色", 2));
//        allCards.add(new Card(1065, "建築工地", 1, "內政", "行動", "", "", "0", "黃色", 2));
//        allCards.add(new Card(1079, "愛國主義", 1, "內政", "行動", "", "", "0", "黃色", 1));
//        allCards.add(new Card(1083, "礦藏", 1, "內政", "行動", "", "", "0", "黃色", 1));
//        allCards.add(new Card(1089, "突破", 1, "內政", "行動", "", "", "0", "黃色", 1));
//        allCards.add(new Card(1092, "藝術作品", 1, "內政", "行動", "", "", "0", "黃色", 1));
//        allCards.add(new Card(1093, "節儉", 1, "內政", "行動", "", "", "0", "黃色", 1));
//        allCards.add(new Card(1100, "革新思想", 1, "內政", "行動", "", "", "0", "黃色", 1));
//        allCards.add(new Card(1103, "高效升級", 1, "內政", "行動", "", "", "0", "黃色", 2));
//        allCards.add(new Card(1103, "高效升級", 1, "內政", "行動", "", "", "0", "黃色", 2));
//        allCards.add(new Card(1041, "戰爭機構", 1, "內政", "軍事", "", "", "4", "藍色", 1));
//        allCards.add(new Card(1077, "灌溉", 1, "內政", "農場", "", "", "3;4", "棕色", 2));
//        allCards.add(new Card(1077, "灌溉", 1, "內政", "農場", "", "", "3;4", "棕色", 2));
//        allCards.add(new Card(1055, "哥倫布", 1, "內政", "領袖", "", "", "0", "綠色", 1));
//        allCards.add(new Card(1056, "聖女貞德", 1, "內政", "領袖", "", "", "0", "綠色", 1));
//        allCards.add(new Card(1064, "巴巴羅薩", 1, "內政", "領袖", "", "", "0", "綠色", 1));
//        allCards.add(new Card(1069, "成吉思汗", 1, "內政", "領袖", "", "", "0", "綠色", 1));
//        allCards.add(new Card(1091, "米開朗基羅", 1, "內政", "領袖", "", "", "0", "綠色", 1));
//        allCards.add(new Card(1097, "達文西", 1, "內政", "領袖", "", "", "0", "綠色", 1));
//        allCards.add(new Card(1102, "騎士", 1, "內政", "騎兵", "", "", "4;3", "紅色", 2));
//        allCards.add(new Card(1102, "騎士", 1, "內政", "騎兵", "", "", "4;3", "紅色", 2));
//        allCards.add(new Card(1046, "十字軍東征", 1, "軍事", "事件", "", "", "0", "深綠色", 1));
//        allCards.add(new Card(1051, "叛亂", 1, "軍事", "事件", "", "", "0", "深綠色", 1));
//        allCards.add(new Card(1060, "好收成", 1, "軍事", "事件", "", "", "0", "深綠色", 1));
//        allCards.add(new Card(1067, "恐怖地區", 1, "軍事", "事件", "", "", "0", "深綠色", 1));
//        allCards.add(new Card(1071, "文化的影響", 1, "軍事", "事件", "", "", "0", "深綠色", 1));
//        allCards.add(new Card(1072, "新的礦藏", 1, "軍事", "事件", "", "", "0", "深綠色", 1));
//        allCards.add(new Card(1081, "瘟疫", 1, "軍事", "事件", "", "", "0", "深綠色", 1));
//        allCards.add(new Card(1087, "科技突破", 1, "軍事", "事件", "", "", "0", "深綠色", 1));
//        allCards.add(new Card(1088, "移民", 1, "軍事", "事件", "", "", "0", "深綠色", 1));
//        allCards.add(new Card(1094, "蠻族入侵", 1, "軍事", "事件", "", "", "0", "深綠色", 1));
//        allCards.add(new Card(1096, "邊境衝突", 1, "軍事", "事件", "", "", "0", "深綠色", 1));
//        allCards.add(new Card(1101, "領土糾紛", 1, "軍事", "事件", "", "", "0", "深綠色", 1));
//        allCards.add(new Card(1104, "鼠疫", 1, "軍事", "事件", "", "", "0", "深綠色", 1));
//        allCards.add(new Card(1257, "突襲", 1, "軍事", "事件", "", "", "0", "淺綠色", 1));
//        allCards.add(new Card(1059, "奴役", 1, "軍事", "侵略", "", "", "0", "深棕色", 2));
//        allCards.add(new Card(1059, "奴役", 1, "軍事", "侵略", "", "", "0", "深棕色", 2));
//        allCards.add(new Card(1070, "掠奪", 1, "軍事", "侵略", "", "", "0", "深棕色", 2));
//        allCards.add(new Card(1070, "掠奪", 1, "軍事", "侵略", "", "", "0", "深棕色", 2));
//        allCards.add(new Card(1090, "突襲", 1, "軍事", "侵略", "", "", "0", "深棕色", 2));
//        allCards.add(new Card(1090, "突襲", 1, "軍事", "侵略", "", "", "0", "深棕色", 2));
//        allCards.add(new Card(1037, "中世紀軍隊", 1, "軍事", "戰術", "", "", "0", "深紅色", 3));
//        allCards.add(new Card(1037, "中世紀軍隊", 1, "軍事", "戰術", "", "", "0", "深紅色", 3));
//        allCards.add(new Card(1037, "中世紀軍隊", 1, "軍事", "戰術", "", "", "0", "深紅色", 3));
//        allCards.add(new Card(1040, "兵陣", 1, "軍事", "戰術", "", "", "0", "深紅色", 3));
//        allCards.add(new Card(1040, "兵陣", 1, "軍事", "戰術", "", "", "0", "深紅色", 3));
//        allCards.add(new Card(1040, "兵陣", 1, "軍事", "戰術", "", "", "0", "深紅色", 3));
//        allCards.add(new Card(1042, "軍團", 1, "軍事", "戰術", "", "", "0", "深紅色", 3));
//        allCards.add(new Card(1042, "軍團", 1, "軍事", "戰術", "", "", "0", "深紅色", 3));
//        allCards.add(new Card(1042, "軍團", 1, "軍事", "戰術", "", "", "0", "深紅色", 3));
//        allCards.add(new Card(1073, "方陣", 1, "軍事", "戰術", "", "", "0", "深紅色", 2));
//        allCards.add(new Card(1073, "方陣", 1, "軍事", "戰術", "", "", "0", "深紅色", 2));
//        allCards.add(new Card(1095, "輕騎兵", 1, "軍事", "戰術", "", "", "0", "深紅色", 2));
//        allCards.add(new Card(1095, "輕騎兵", 1, "軍事", "戰術", "", "", "0", "深紅色", 2));
//        allCards.add(new Card(1098, "重騎兵", 1, "軍事", "戰術", "", "", "0", "深紅色", 2));
//        allCards.add(new Card(1098, "重騎兵", 1, "軍事", "戰術", "", "", "0", "深紅色", 2));
//        allCards.add(new Card(1058, "防禦卡", 1, "軍事", "獎勵", "", "", "0", "雙色", 6));
//        allCards.add(new Card(1058, "防禦卡", 1, "軍事", "獎勵", "", "", "0", "雙色", 6));
//        allCards.add(new Card(1058, "防禦卡", 1, "軍事", "獎勵", "", "", "0", "雙色", 6));
//        allCards.add(new Card(1058, "防禦卡", 1, "軍事", "獎勵", "", "", "0", "雙色", 6));
//        allCards.add(new Card(1058, "防禦卡", 1, "軍事", "獎勵", "", "", "0", "雙色", 6));
//        allCards.add(new Card(1058, "防禦卡", 1, "軍事", "獎勵", "", "", "0", "雙色", 6));
//        allCards.add(new Card(1039, "兵家必爭之地", 1, "軍事", "領土", "", "", "0", "淺綠色", 1));
//        allCards.add(new Card(1049, "歷史悠久之地", 1, "軍事", "領土", "", "", "0", "淺綠色", 1));
//        allCards.add(new Card(1062, "富饒肥沃之地", 1, "軍事", "領土", "", "", "0", "淺綠色", 1));
//        allCards.add(new Card(1074, "有人居住之地", 1, "軍事", "領土", "", "", "0", "淺綠色", 1));
//        allCards.add(new Card(1080, "物資豐富之地", 1, "軍事", "領土", "", "", "0", "淺綠色", 1));
//        allCards.add(new Card(1086, "科技先進之地", 1, "軍事", "領土", "", "", "0", "淺綠色", 1));
//        allCards.add(new Card(1117, "司法系統", 2, "內政", "內政", "", "", "7", "藍色", 1));
//        allCards.add(new Card(1144, "歌劇", 2, "內政", "劇院", "", "", "7;9", "灰色", 2));
//        allCards.add(new Card(1144, "歌劇", 2, "內政", "劇院", "", "", "7;9", "灰色", 2));
//        allCards.add(new Card(1140, "新聞業", 2, "內政", "圖書館", "", "", "6;8", "灰色", 2));
//        allCards.add(new Card(1140, "新聞業", 2, "內政", "圖書館", "", "", "6;8", "灰色", 2));
//        allCards.add(new Card(1109, "克里姆林宮", 2, "內政", "奇蹟", "", "", "0", "紫色", 1));
//        allCards.add(new Card(1123, "艾菲爾鐵塔", 2, "內政", "奇蹟", "", "", "0", "紫色", 1));
//        allCards.add(new Card(1147, "洲際鐵路", 2, "內政", "奇蹟", "", "", "0", "紫色", 1));
//        allCards.add(new Card(1176, "遠洋客運", 2, "內政", "奇蹟", "", "", "0", "紫色", 1));
//        allCards.add(new Card(1158, "科學方法", 2, "內政", "實驗室", "", "", "6;8", "灰色", 2));
//        allCards.add(new Card(1158, "科學方法", 2, "內政", "實驗室", "", "", "6;8", "灰色", 2));
//        allCards.add(new Card(1131, "建築學", 2, "內政", "建築", "", "", "6", "藍色", 1));
//        allCards.add(new Card(1110, "共和制", 2, "內政", "政府", "", "", "14;4", "橙色", 1));
//        allCards.add(new Card(1118, "君主立憲制", 2, "內政", "政府", "", "", "12;5", "橙色", 1));
//        allCards.add(new Card(1148, "火槍兵", 2, "內政", "步兵", "", "", "5;5", "紅色", 1));
//        allCards.add(new Card(1170, "航海術", 2, "內政", "殖民", "", "", "6", "藍色", 1));
//        allCards.add(new Card(1149, "火砲", 2, "內政", "炮兵", "", "", "7;5", "紅色", 2));
//        allCards.add(new Card(1149, "火砲", 2, "內政", "炮兵", "", "", "7;5", "紅色", 2));
//        allCards.add(new Card(1150, "煤礦", 2, "內政", "礦山", "", "", "7;8", "棕色", 1));
//        allCards.add(new Card(1166, "組織化宗教", 2, "內政", "神廟", "", "", "4;7", "灰色", 2));
//        allCards.add(new Card(1166, "組織化宗教", 2, "內政", "神廟", "", "", "4;7", "灰色", 2));
//        allCards.add(new Card(1120, "團隊競技", 2, "內政", "競技場", "", "", "5;6", "灰色", 1));
//        allCards.add(new Card(1107, "豐收", 2, "內政", "行動", "", "", "0", "黃色", 1));
//        allCards.add(new Card(1125, "富饒之土", 2, "內政", "行動", "", "", "0", "黃色", 2));
//        allCards.add(new Card(1125, "富饒之土", 2, "內政", "行動", "", "", "0", "黃色", 2));
//        allCards.add(new Card(1127, "工程天才", 2, "內政", "行動", "", "", "0", "黃色", 1));
//        allCards.add(new Card(1132, "建築工地", 2, "內政", "行動", "", "", "0", "黃色", 2));
//        allCards.add(new Card(1132, "建築工地", 2, "內政", "行動", "", "", "0", "黃色", 2));
//        allCards.add(new Card(1145, "民族主義浪潮", 2, "內政", "行動", "", "", "0", "黃色", 1));
//        allCards.add(new Card(1151, "愛國主義", 2, "內政", "行動", "", "", "0", "黃色", 2));
//        allCards.add(new Card(1151, "愛國主義", 2, "內政", "行動", "", "", "0", "黃色", 2));
//        allCards.add(new Card(1156, "礦藏", 2, "內政", "行動", "", "", "0", "黃色", 2));
//        allCards.add(new Card(1156, "礦藏", 2, "內政", "行動", "", "", "0", "黃色", 2));
//        allCards.add(new Card(1164, "突破", 2, "內政", "行動", "", "", "0", "黃色", 1));
//        allCards.add(new Card(1171, "藝術作品", 2, "內政", "行動", "", "", "0", "黃色", 1));
//        allCards.add(new Card(1172, "節儉", 2, "內政", "行動", "", "", "0", "黃色", 1));
//        allCards.add(new Card(1182, "革新思想", 2, "內政", "行動", "", "", "0", "黃色", 1));
//        allCards.add(new Card(1184, "高效升級", 2, "內政", "行動", "", "", "0", "黃色", 1));
//        allCards.add(new Card(1134, "戰略", 2, "內政", "軍事", "", "", "8", "藍色", 1));
//        allCards.add(new Card(1177, "選種培育", 2, "內政", "農場", "", "", "5;6", "棕色", 1));
//        allCards.add(new Card(1128, "巴哈", 2, "內政", "領袖", "", "", "0", "綠色", 1));
//        allCards.add(new Card(1130, "庫克船長", 2, "內政", "領袖", "", "", "0", "綠色", 1));
//        allCards.add(new Card(1135, "拿破崙", 2, "內政", "領袖", "", "", "0", "綠色", 1));
//        allCards.add(new Card(1152, "牛頓", 2, "內政", "領袖", "", "", "0", "綠色", 1));
//        allCards.add(new Card(1168, "羅伯斯比爾", 2, "內政", "領袖", "", "", "0", "綠色", 1));
//        allCards.add(new Card(1173, "莎士比亞", 2, "內政", "領袖", "", "", "0", "綠色", 1));
//        allCards.add(new Card(1155, "胸甲騎兵", 2, "內政", "騎兵", "", "", "6;5", "紅色", 1));
//        allCards.add(new Card(1108, "破碎的偶像", 2, "軍事", "事件", "", "", "0", "深綠色", 1));
//        allCards.add(new Card(1113, "冷戰", 2, "軍事", "事件", "", "", "0", "深綠色", 1));
//        allCards.add(new Card(1129, "市民暴動", 2, "軍事", "事件", "", "", "0", "深綠色", 1));
//        allCards.add(new Card(1133, "恐怖主義", 2, "軍事", "事件", "", "", "0", "深綠色", 1));
//        allCards.add(new Card(1141, "時間的洪流", 2, "軍事", "事件", "", "", "0", "深綠色", 1));
//        allCards.add(new Card(1146, "民族的自豪", 2, "軍事", "事件", "", "", "0", "深綠色", 1));
//        allCards.add(new Card(1154, "獨立宣言", 2, "軍事", "事件", "", "", "0", "深綠色", 1));
//        allCards.add(new Card(1162, "科普教育", 2, "軍事", "事件", "", "", "0", "深綠色", 1));
//        allCards.add(new Card(1163, "移民出境", 2, "軍事", "事件", "", "", "0", "深綠色", 1));
//        allCards.add(new Card(1167, "經濟發展", 2, "軍事", "事件", "", "", "0", "深綠色", 1));
//        allCards.add(new Card(1169, "罪惡之都", 2, "軍事", "事件", "", "", "0", "深綠色", 1));
//        allCards.add(new Card(1181, "難民", 2, "軍事", "事件", "", "", "0", "深綠色", 1));
//        allCards.add(new Card(1114, "刺殺", 2, "軍事", "侵略", "", "", "0", "深棕色", 1));
//        allCards.add(new Card(1119, "吞併", 2, "軍事", "侵略", "", "", "0", "深棕色", 1));
//        allCards.add(new Card(1137, "掠奪", 2, "軍事", "侵略", "", "", "0", "深棕色", 2));
//        allCards.add(new Card(1137, "掠奪", 2, "軍事", "侵略", "", "", "0", "深棕色", 2));
//        allCards.add(new Card(1157, "破壞", 2, "軍事", "侵略", "", "", "0", "深棕色", 1));
//        allCards.add(new Card(1165, "突襲", 2, "軍事", "侵略", "", "", "0", "深棕色", 2));
//        allCards.add(new Card(1165, "突襲", 2, "軍事", "侵略", "", "", "0", "深棕色", 2));
//        allCards.add(new Card(1178, "間諜", 2, "軍事", "侵略", "", "", "0", "深棕色", 2));
//        allCards.add(new Card(1178, "間諜", 2, "軍事", "侵略", "", "", "0", "深棕色", 2));
//        allCards.add(new Card(1139, "文化戰爭", 2, "軍事", "戰爭", "", "", "0", "黑色", 1));
//        allCards.add(new Card(1160, "科技戰爭", 2, "軍事", "戰爭", "", "", "0", "黑色", 1));
//        allCards.add(new Card(1175, "資源戰爭", 2, "軍事", "戰爭", "", "", "0", "黑色", 1));
//        allCards.add(new Card(1183, "領土戰爭", 2, "軍事", "戰爭", "", "", "0", "黑色", 1));
//        allCards.add(new Card(1116, "古典陣型", 2, "軍事", "戰術", "", "", "0", "深紅色", 1));
//        allCards.add(new Card(1136, "拿破崙陣型", 2, "軍事", "戰術", "", "", "0", "深紅色", 1));
//        allCards.add(new Card(1143, "機動部隊", 2, "軍事", "戰術", "", "", "0", "深紅色", 1));
//        allCards.add(new Card(1174, "西班牙陣型", 2, "軍事", "戰術", "", "", "0", "深紅色", 2));
//        allCards.add(new Card(1174, "西班牙陣型", 2, "軍事", "戰術", "", "", "0", "深紅色", 2));
//        allCards.add(new Card(1179, "防禦工事", 2, "軍事", "戰術", "", "", "0", "深紅色", 1));
//        allCards.add(new Card(1180, "防禦陣型", 2, "軍事", "戰術", "", "", "0", "深紅色", 2));
//        allCards.add(new Card(1180, "防禦陣型", 2, "軍事", "戰術", "", "", "0", "深紅色", 2));
//        allCards.add(new Card(1124, "防禦卡", 2, "軍事", "獎勵", "", "", "0", "雙色", 7));
//        allCards.add(new Card(1124, "防禦卡", 2, "軍事", "獎勵", "", "", "0", "雙色", 7));
//        allCards.add(new Card(1124, "防禦卡", 2, "軍事", "獎勵", "", "", "0", "雙色", 7));
//        allCards.add(new Card(1124, "防禦卡", 2, "軍事", "獎勵", "", "", "0", "雙色", 7));
//        allCards.add(new Card(1124, "防禦卡", 2, "軍事", "獎勵", "", "", "0", "雙色", 7));
//        allCards.add(new Card(1124, "防禦卡", 2, "軍事", "獎勵", "", "", "0", "雙色", 7));
//        allCards.add(new Card(1124, "防禦卡", 2, "軍事", "獎勵", "", "", "0", "雙色", 7));
//        allCards.add(new Card(1111, "兵家必爭之地", 2, "軍事", "領土", "", "", "0", "淺綠色", 1));
//        allCards.add(new Card(1115, "歷史悠久之地", 2, "軍事", "領土", "", "", "0", "淺綠色", 1));
//        allCards.add(new Card(1126, "富饒肥沃之地", 2, "軍事", "領土", "", "", "0", "淺綠色", 1));
//        allCards.add(new Card(1142, "有人居住之地", 2, "軍事", "領土", "", "", "0", "淺綠色", 1));
//        allCards.add(new Card(1153, "物資豐富之地", 2, "軍事", "領土", "", "", "0", "淺綠色", 1));
//        allCards.add(new Card(1161, "科技領先之地", 2, "軍事", "領土", "", "", "0", "淺綠色", 1));
//        allCards.add(new Card(1190, "公共服務", 3, "內政", "內政", "", "", "10", "藍色", 1));
//        allCards.add(new Card(1233, "電影", 3, "內政", "劇院", "", "", "10;12", "灰色", 2));
//        allCards.add(new Card(1233, "電影", 3, "內政", "劇院", "", "", "10;12", "灰色", 2));
//        allCards.add(new Card(1206, "多媒體", 3, "內政", "圖書館", "", "", "9;11", "灰色", 2));
//        allCards.add(new Card(1206, "多媒體", 3, "內政", "圖書館", "", "", "9;11", "灰色", 2));
//        allCards.add(new Card(1201, "因特網", 3, "內政", "奇蹟", "", "", "0", "紫色", 1));
//        allCards.add(new Card(1209, "好萊烏", 3, "內政", "奇蹟", "", "", "0", "紫色", 1));
//        allCards.add(new Card(1217, "快餐連鎖", 3, "內政", "奇蹟", "", "", "0", "紫色", 1));
//        allCards.add(new Card(1238, "空間飛行", 3, "內政", "奇蹟", "", "", "0", "紫色", 1));
//        allCards.add(new Card(1245, "計算機", 3, "內政", "實驗室", "", "", "8;10", "灰色", 2));
//        allCards.add(new Card(1245, "計算機", 3, "內政", "實驗室", "", "", "8;10", "灰色", 2));
//        allCards.add(new Card(1213, "工程學", 3, "內政", "建築", "", "", "9", "藍色", 1));
//        allCards.add(new Card(1191, "共產主義", 3, "內政", "政府", "", "", "17;6", "橙色", 1));
//        allCards.add(new Card(1199, "原教旨主義", 3, "內政", "政府", "", "", "19;7", "橙色", 1));
//        allCards.add(new Card(1227, "民主制", 3, "內政", "政府", "", "", "21;8", "橙色", 1));
//        allCards.add(new Card(1231, "現代化步兵", 3, "內政", "步兵", "", "", "7;7", "紅色", 1));
//        allCards.add(new Card(1197, "衛星", 3, "內政", "殖民", "", "", "8", "藍色", 1));
//        allCards.add(new Card(1228, "火箭", 3, "內政", "炮兵", "", "", "9;7", "紅色", 2));
//        allCards.add(new Card(1228, "火箭", 3, "內政", "炮兵", "", "", "9;7", "紅色", 2));
//        allCards.add(new Card(1234, "石油", 3, "內政", "礦山", "", "", "9;11", "棕色", 1));
//        allCards.add(new Card(1237, "空軍", 3, "內政", "空軍", "", "", "0", "紅色", 1));
//        allCards.add(new Card(1242, "職業競技", 3, "內政", "競技場", "", "", "7;8", "灰色", 1));
//        allCards.add(new Card(1188, "豐收", 3, "內政", "行動", "", "", "0", "黃色", 1));
//        allCards.add(new Card(1193, "軍事建設", 3, "內政", "行動", "", "", "0", "黃色", 1));
//        allCards.add(new Card(1212, "工程天才", 3, "內政", "行動", "", "", "0", "黃色", 1));
//        allCards.add(new Card(1215, "建築工地", 3, "內政", "行動", "", "", "0", "黃色", 1));
//        allCards.add(new Card(1230, "愛國主義", 3, "內政", "行動", "", "", "0", "黃色", 1));
//        allCards.add(new Card(1235, "礦床", 3, "內政", "行動", "", "", "0", "黃色", 1));
//        allCards.add(new Card(1243, "藝術作品", 3, "內政", "行動", "", "", "0", "黃色", 1));
//        allCards.add(new Card(1244, "藝術捐獻", 3, "內政", "行動", "", "", "0", "黃色", 1));
//        allCards.add(new Card(1247, "革命性理念", 3, "內政", "行動", "", "", "0", "黃色", 1));
//        allCards.add(new Card(1248, "高效升級", 3, "內政", "行動", "", "", "0", "黃色", 1));
//        allCards.add(new Card(1194, "軍事倫理", 3, "內政", "軍事", "", "", "12", "藍色", 1));
//        allCards.add(new Card(1223, "機械化農業", 3, "內政", "農場", "", "", "7;8", "棕色", 1));
//        allCards.add(new Card(1185, "F14", 3, "內政", "領袖", "", "", "0", "綠色", 1));
//        allCards.add(new Card(1186, "邱吉爾", 3, "內政", "領袖", "", "", "0", "綠色", 1));
//        allCards.add(new Card(1204, "甘地", 3, "內政", "領袖", "", "", "0", "綠色", 1));
//        allCards.add(new Card(1210, "尼古拉特斯拉", 3, "內政", "領袖", "", "", "0", "綠色", 1));
//        allCards.add(new Card(1229, "愛因斯坦", 3, "內政", "領袖", "", "", "0", "綠色", 1));
//        allCards.add(new Card(1241, "約翰藍儂", 3, "內政", "領袖", "", "", "0", "綠色", 1));
//        allCards.add(new Card(1205, "坦克", 3, "內政", "騎兵", "", "", "9;7", "紅色", 1));
//        allCards.add(new Card(1189, "人口的影響", 3, "軍事", "事件", "", "", "0", "深綠色", 1));
//        allCards.add(new Card(1195, "軍力的影響", 3, "軍事", "事件", "", "", "0", "深綠色", 1));
//        allCards.add(new Card(1196, "農業的影響", 3, "軍事", "事件", "", "", "0", "深綠色", 1));
//        allCards.add(new Card(1198, "歷史進程的影響", 3, "軍事", "事件", "", "", "0", "深綠色", 1));
//        allCards.add(new Card(1207, "奇蹟的影響", 3, "軍事", "事件", "", "", "0", "深綠色", 1));
//        allCards.add(new Card(1211, "工業的影響", 3, "軍事", "事件", "", "", "0", "深綠色", 1));
//        allCards.add(new Card(1214, "幸福的影響", 3, "軍事", "事件", "", "", "0", "深綠色", 1));
//        allCards.add(new Card(1216, "建築的影響", 3, "軍事", "事件", "", "", "0", "深綠色", 1));
//        allCards.add(new Card(1219, "技術的影響", 3, "軍事", "事件", "", "", "0", "深綠色", 1));
//        allCards.add(new Card(1221, "政府的影響", 3, "軍事", "事件", "", "", "0", "深綠色", 1));
//        allCards.add(new Card(1226, "殖民地的影響", 3, "軍事", "事件", "", "", "0", "深綠色", 1));
//        allCards.add(new Card(1236, "科學的影響", 3, "軍事", "事件", "", "", "0", "深綠色", 1));
//        allCards.add(new Card(1240, "競爭力的影響", 3, "軍事", "事件", "", "", "0", "深綠色", 1));
//        allCards.add(new Card(1220, "掠奪", 3, "軍事", "侵略", "", "", "0", "深棕色", 1));
//        allCards.add(new Card(1225, "武裝入侵", 3, "軍事", "侵略", "", "", "0", "深棕色", 3));
//        allCards.add(new Card(1225, "武裝入侵", 3, "軍事", "侵略", "", "", "0", "深棕色", 3));
//        allCards.add(new Card(1225, "武裝入侵", 3, "軍事", "侵略", "", "", "0", "深棕色", 3));
//        allCards.add(new Card(1239, "突襲", 3, "軍事", "侵略", "", "", "0", "深棕色", 2));
//        allCards.add(new Card(1239, "突襲", 3, "軍事", "侵略", "", "", "0", "深棕色", 2));
//        allCards.add(new Card(1203, "聖戰", 3, "軍事", "戰爭", "", "", "0", "黑色", 1));
//        allCards.add(new Card(1222, "文化戰爭", 3, "軍事", "戰爭", "", "", "0", "黑色", 2));
//        allCards.add(new Card(1222, "文化戰爭", 3, "軍事", "戰爭", "", "", "0", "黑色", 2));
//        allCards.add(new Card(1218, "戰壕", 3, "軍事", "戰術", "", "", "0", "深紅色", 1));
//        allCards.add(new Card(1224, "機械化部隊", 3, "軍事", "戰術", "", "", "0", "深紅色", 1));
//        allCards.add(new Card(1232, "現代化軍隊", 3, "軍事", "戰術", "", "", "0", "深紅色", 1));
//        allCards.add(new Card(1246, "閃電戰", 3, "軍事", "戰術", "", "", "0", "深紅色", 1));
//        allCards.add(new Card(1208, "防禦卡", 3, "軍事", "獎勵", "", "", "0", "雙色", 6));
//        allCards.add(new Card(1208, "防禦卡", 3, "軍事", "獎勵", "", "", "0", "雙色", 6));
//        allCards.add(new Card(1208, "防禦卡", 3, "軍事", "獎勵", "", "", "0", "雙色", 6));
//        allCards.add(new Card(1208, "防禦卡", 3, "軍事", "獎勵", "", "", "0", "雙色", 6));
//        allCards.add(new Card(1208, "防禦卡", 3, "軍事", "獎勵", "", "", "0", "雙色", 6));
//        allCards.add(new Card(1208, "防禦卡", 3, "軍事", "獎勵", "", "", "0", "雙色", 6));
////BUILD SUCCESSFUL (total time: 3 seconds)
        allCards.show(0);
    }

    public static void insertCardEntity(CardEntity card) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
//        em.getTransaction().
        System.out.println("going to insert " + card);
        em.persist(card);
        em.getTransaction().commit();

        em.close();
    }

    public static void do1() {

        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        Query q = em.createQuery("select t from CardEntity t ");
        List<CardEntity> list = q.getResultList();
        for (CardEntity cards : list) {
            System.out.println(cards.toString());
        }
        System.out.println("\n###################");

        // create new todo
//    em.getTransaction().begin();
//    GameLive game = new GameLive();
//    game.setId(2);
//    game.setCardRow("1,2,3");
//    game.setP1Hand("4");
//    game.setP2Hand("5");
//    
//    em.persist(game);
//    em.getTransaction().commit();
//
//    em.close();
    }

    public static void cleanCardEntity() {

        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        Query q = em.createQuery("select t from CardEntity t ");//SELECT c FROM CardEntity c
        List<CardEntity> list = q.getResultList();

        System.out.println("\n################### before");

        for (CardEntity cards : list) {
            System.out.println(cards.toString());
        }

        // create new todo
        em.getTransaction().begin();

        for (CardEntity cards : list) {
//            System.out.println(cards.toString());
            em.remove(cards);
        }

        em.getTransaction().commit();

        System.out.println("\n################### after");
        Query q2 = em.createQuery("select t from CardEntity t ");
        List<CardEntity> list2 = q2.getResultList();

        for (CardEntity cards : list2) {
            System.out.println(cards.toString());
        }

//
//    em.close();
    }

    public static void prepareCardBank() {
        System.out.println("prepare CardBank from db CardEntity");
        //    public CardEntity(Integer id, String name, Integer age, String civilMilitary, String tag, 
        //String action, String iconPoints, String effect, String cost, String color, int cnt, 
        //int tokenWhite, int tokenRed, int tokenYellow, int tokenBlue, 
        //int effectWhite, int effectFood, int effectRed, int effectMusic, int effectStone, 
        //int effectIdea, int effectSmile, int effectHouse, int effectBlue, int effectWeapon) {

//        String str = "cards.add(new Card(1, \"亞歷山大大帝\", 0, 內政, 領袖, 綠色, \"領袖\", \"每一個紅色科技牌上的黃點，軍力+1\", \"0\"));";
        Card c1;
        c1 = new Card(1, "亞歷山大大帝", 0, "內政", "領袖", "acting...", "icon..", "effect", "color", 777);
        c1.setTokens(1, 2, 3, 4);
        c1.setEffects(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("" + c1);

        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
//        Query q = em.createQuery("select t from CardEntity t order by  t.age,t.civilMilitary,t.tag, t.id");
        Query q = em.createQuery("select t from CardEntity t ");
        List<CardEntity> list = q.getResultList();
        for (CardEntity card : list) {
            for (int cardNumber = 0; cardNumber < card.getCnt(); cardNumber++) {

                StringBuilder sb = new StringBuilder();
                sb.append("c1=new Card(");
                sb.append(card.getId());
                sb.append(",\"");
                sb.append(card.getName());
                sb.append("\",");
                sb.append(card.getAge());
                sb.append(",\"");
                sb.append(card.getCivilMilitary());
                sb.append("\",\"");
                sb.append(card.getTag());
                sb.append("\",\"");
                sb.append(card.getAction());
                sb.append("\",\"");
                sb.append(card.getIconPoints());
                sb.append("\",\"");
                sb.append(card.getEffect());
                sb.append("\",\"");
                sb.append(card.getColor());
                sb.append("\",");
                sb.append(card.getCnt());
                sb.append(");\n");

//        c1.setTokenEffect(1, 2,3,4,1, 2,3,4,5,6,7,8,9,10      );
                sb.append("c1.setTokens(");
                sb.append(card.getTokenBlue()).append(",");
                sb.append(card.getTokenRed()).append(",");
                sb.append(card.getTokenWhite()).append(",");
                sb.append(card.getTokenYellow()).append(");\n");

                sb.append("c1.setEffects(");
                sb.append(card.getEffectBlue()).append(",");
                sb.append(card.getEffectFood()).append(",");
                sb.append(card.getEffectHouse()).append(",");
                sb.append(card.getEffectIdea()).append(",");
                sb.append(card.getEffectMusic()).append(",");
                sb.append(card.getEffectRed()).append(",");
                sb.append(card.getEffectSmile()).append(",");
                sb.append(card.getEffectStone()).append(",");
                sb.append(card.getEffectWeapon()).append(",");
                sb.append(card.getEffectWhite()).append(");\n");

                sb.append("allCards.add(c1);");

                System.out.println(sb.toString());

                //DEBUG
//                return;
            }
        }
    }

    public static void do3() {
//        String str = "cards.add(new Card(1, \"亞歷山大大帝\", 0, 內政, 領袖, 綠色, \"領袖\", \"每一個紅色科技牌上的黃點，軍力+1\", \"0\"));";

        Card c1 = new Card(1, "亞歷山大大帝", 0, "內政", "領袖", "acting...", "icon..", "EFFECT", "color", 1);
        System.out.println("" + c1);

        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        Query q = em.createQuery("select t from Card t order by  t.age,t.civilMilitary,t.tag, t.id");
        List<Card> list = q.getResultList();
        for (Card card : list) {
            for (int cardNumber = 0; cardNumber < card.getCnt(); cardNumber++) {

                StringBuilder sb = new StringBuilder();
                sb.append("allCards.add(new Card(");
                sb.append(card.getId());
                sb.append(",\"");
                sb.append(card.getName());
                sb.append("\",");
                sb.append(card.getAge());
                sb.append(",\"");
                sb.append(card.getCivilMilitary());
                sb.append("\",\"");
                sb.append(card.getTag());
                sb.append("\",\"");
                sb.append(card.getAction());
                sb.append("\",\"");
                sb.append(card.getIconPoints());
                sb.append("\",\"");
                sb.append(card.getCost());
                sb.append("\",\"");
                sb.append(card.getColor());
                sb.append("\",");
                sb.append(card.getCnt());
                sb.append("));");

                System.out.println(sb.toString());
            }
        }
    }
}
