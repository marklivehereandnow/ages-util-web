/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.livehereandnow.ages.card;

//import entity.*;

public class Card extends CardEntity {
//[14:07:10] maxchen20041: 作一個方法
//[14:07:31] maxchen20041: 叫做生產
//[14:07:55] maxchen20041: 讓tokenBlue=tokenBlue+tokenYellow

    /**
     *
     * [14:07:10] maxchen20041: 作一個方法, 叫做生產, 讓tokenBlue=tokenBlue+tokenYellow
     */
    
    /**
     * 
     * @param id
     * @param name
     * @param age
     * @param civilMilitary
     * @param tag
     * @param action
     * @param iconPoints
     * @param effect
     * @param color
     * @param cnt 
     */
      public Card(Integer id, String name, Integer age, String civilMilitary, String tag, String action, String iconPoints, String effect,  String color, int cnt) {
          super( id, name,  age,  civilMilitary,  tag, action,  iconPoints,  effect,  color,  cnt);
    }
      
      
      /**
       * 
       * @param tokenBlue
       * @param tokenRed
       * @param tokenWhite
       * @param tokenYellow
       * @param effectBlue
       * @param effectFood
       * @param effectHouse
       * @param effectIdea
       * @param effectMusic
       * @param effectRed
       * @param effectSmile
       * @param effectStone
       * @param effectWeapon
       * @param effectWhite 
       */
      public void setTokens(int tokenBlue, int tokenRed,int tokenWhite,int tokenYellow){
          setTokenBlue(tokenBlue);
          setTokenRed(tokenRed);
          setTokenWhite(tokenWhite);
          setTokenYellow(tokenYellow);
          
      }
    
      public void setEffects( int effectBlue,int effectFood,int effectHouse, int effectIdea,int effectMusic,int effectRed,int effectSmile,int effectStone,int effectWeapon,int effectWhite){
          
          setEffectBlue(effectBlue);
          setEffectFood(effectFood);
          setEffectHouse(effectHouse);
          setEffectIdea(effectIdea);
          setEffectMusic(effectMusic);
          setEffectRed(effectRed);
          setEffectSmile(effectSmile);
          setEffectStone(effectStone);
          setEffectWeapon(effectWeapon);
          setEffectWhite(effectWhite);
          
      }
    
      
      
    public Card(){
        super();
    }
    
    public void produce() {
        setTokenBlue(getTokenBlue()+getTokenYellow());
                //tokenBlue += tokenYellow;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("[").append(getId()).append("]{");
        sb.append(getName()).append(" ");
        sb.append(getAge()).append(" ");
        sb.append(getCivilMilitary()).append(" ");
        sb.append(getTag()).append(" ");
        sb.append(getAction()).append(" ");
        sb.append(getIconPoints()).append(" ");
        sb.append(getEffect()).append(" ");
        sb.append(getCost()).append(" ");
        sb.append(getColor()).append(" ");
        sb.append(getCnt()).append("}\n ");
        sb.append("\t").append("<");
        sb.append(getTokenBlue()).append(",");
        sb.append(getTokenRed()).append(",");
        sb.append(getTokenWhite()).append(",");
        sb.append(getTokenYellow()).append(">");
        sb.append("\t").append("<");
        sb.append(getEffectBlue()).append(",");
        sb.append(getEffectFood()).append(",");
        sb.append(getEffectHouse()).append(",");
        sb.append(getEffectIdea()).append(",");
        sb.append(getEffectMusic()).append(",");
        sb.append(getEffectRed()).append(",");
        sb.append(getEffectSmile()).append(",");
        sb.append(getEffectStone()).append(",");
        sb.append(getEffectWeapon()).append(",");
        sb.append(getEffectWhite()).append(">");
        
                
        
        return sb.toString();
    }

    
    public String toString(int style) {
        String[] ageStr = {"A", "I", "II", "III", "-"};

        switch (style) {
            case 1:// for CardNow
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                sb.append(ageStr[getAge()]);
                sb.append("");
                sb.append(getName());
                sb.append("-");
                sb.append(getTag());
                sb.append("] ");
                return sb.toString();
            default:
                return toString();
        }
    }
}
