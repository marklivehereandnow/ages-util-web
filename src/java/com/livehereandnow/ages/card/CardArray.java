/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livehereandnow.ages.card;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mark
 */
public class CardArray extends ArrayList<Card> {

    private String title = "---";

    public CardArray(String str) {
        title = str;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // @Override
    public String toString(int k) {
        return title + " " + toString();
    }

    /**
     * 生產
     */
    public void produce(){
         for (int k = 0; k < size(); k++) {
            get(k).produce();
        }
    }
    
    public Card getCardByName(String str) {
        //   List<Card> list=new ArrayList<>();
        for (int k = 0; k < size(); k++) {
            if (get(k).getName().equals(str)) {
                return get(k);
            }
        }
        Card NOCARD = new Card();
        NOCARD.setId(1000);
        NOCARD.setName("NOCARD");
        return NOCARD;
    }

    public List<Card> getCardListCopy(int age, String civilMilitary) {
        List<Card> list = new ArrayList<>();
        for (int k = 0; k < size(); k++) {
            if (get(k).getAge() == age && get(k).getCivilMilitary().equals(civilMilitary)) {
                list.add(get(k));
            }
        }
        return list;
    }

    public void show(int style) {
        String[] ageStr = {"A", "I", "II", "III"};
        switch (style) {
            case 1:// for CardRow
//                System.out.println("" + title);
                System.out.print("" + title + " (" + size() + ") ");

                for (int m = 0; m < size(); m++) {
                    System.out.print(m+get(m).toString(style)+" ");
                }
                break;

            case 2:// for 實驗室
                System.out.print("" + title + " ");

                for (int m = 0; m < size(); m++) {
//                    System.out.println(get(m).toString());
                    Card card = get(m);
                    StringBuilder sb = new StringBuilder();
                    sb.append("[");
                    sb.append(card.getName());
                    sb.append(" 黃點");
                    sb.append(card.getTokenYellow());
                    sb.append(" 藍點");
                    sb.append(card.getTokenBlue());

                    sb.append("]");
                    System.out.print(sb.toString());
                }
                break;
            default:
                for (int m = 0; m < size(); m++) {
                    System.out.print(get(m).toString());
                }

        }
        System.out.println("");

    }
}
