/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mark
 */
@Entity
@Table(name = "CARD_ENTITY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CardEntity.findAll", query = "SELECT c FROM CardEntity c"),
    @NamedQuery(name = "CardEntity.findById", query = "SELECT c FROM CardEntity c WHERE c.id = :id"),
    @NamedQuery(name = "CardEntity.findByName", query = "SELECT c FROM CardEntity c WHERE c.name = :name"),
    @NamedQuery(name = "CardEntity.findByAge", query = "SELECT c FROM CardEntity c WHERE c.age = :age"),
    @NamedQuery(name = "CardEntity.findByCivilMilitary", query = "SELECT c FROM CardEntity c WHERE c.civilMilitary = :civilMilitary"),
    @NamedQuery(name = "CardEntity.findByTag", query = "SELECT c FROM CardEntity c WHERE c.tag = :tag"),
    @NamedQuery(name = "CardEntity.findByAction", query = "SELECT c FROM CardEntity c WHERE c.action = :action"),
    @NamedQuery(name = "CardEntity.findByIconPoints", query = "SELECT c FROM CardEntity c WHERE c.iconPoints = :iconPoints"),
    @NamedQuery(name = "CardEntity.findByEffect", query = "SELECT c FROM CardEntity c WHERE c.effect = :effect"),
    @NamedQuery(name = "CardEntity.findByCost", query = "SELECT c FROM CardEntity c WHERE c.cost = :cost"),
    @NamedQuery(name = "CardEntity.findByColor", query = "SELECT c FROM CardEntity c WHERE c.color = :color"),
    @NamedQuery(name = "CardEntity.findByCnt", query = "SELECT c FROM CardEntity c WHERE c.cnt = :cnt"),
    @NamedQuery(name = "CardEntity.findByTokenWhite", query = "SELECT c FROM CardEntity c WHERE c.tokenWhite = :tokenWhite"),
    @NamedQuery(name = "CardEntity.findByTokenRed", query = "SELECT c FROM CardEntity c WHERE c.tokenRed = :tokenRed"),
    @NamedQuery(name = "CardEntity.findByTokenYellow", query = "SELECT c FROM CardEntity c WHERE c.tokenYellow = :tokenYellow"),
    @NamedQuery(name = "CardEntity.findByTokenBlue", query = "SELECT c FROM CardEntity c WHERE c.tokenBlue = :tokenBlue"),
    @NamedQuery(name = "CardEntity.findByEffectWhite", query = "SELECT c FROM CardEntity c WHERE c.effectWhite = :effectWhite"),
    @NamedQuery(name = "CardEntity.findByEffectFood", query = "SELECT c FROM CardEntity c WHERE c.effectFood = :effectFood"),
    @NamedQuery(name = "CardEntity.findByEffectRed", query = "SELECT c FROM CardEntity c WHERE c.effectRed = :effectRed"),
    @NamedQuery(name = "CardEntity.findByEffectMusic", query = "SELECT c FROM CardEntity c WHERE c.effectMusic = :effectMusic"),
    @NamedQuery(name = "CardEntity.findByEffectStone", query = "SELECT c FROM CardEntity c WHERE c.effectStone = :effectStone"),
    @NamedQuery(name = "CardEntity.findByEffectIdea", query = "SELECT c FROM CardEntity c WHERE c.effectIdea = :effectIdea"),
    @NamedQuery(name = "CardEntity.findByEffectSmile", query = "SELECT c FROM CardEntity c WHERE c.effectSmile = :effectSmile"),
    @NamedQuery(name = "CardEntity.findByEffectHouse", query = "SELECT c FROM CardEntity c WHERE c.effectHouse = :effectHouse"),
    @NamedQuery(name = "CardEntity.findByEffectBlue", query = "SELECT c FROM CardEntity c WHERE c.effectBlue = :effectBlue"),
    @NamedQuery(name = "CardEntity.findByEffectWeapon", query = "SELECT c FROM CardEntity c WHERE c.effectWeapon = :effectWeapon")})
public class CardEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "AGE")
    private Integer age;
    @Column(name = "CIVIL_MILITARY")
    private String civilMilitary;
    @Column(name = "TAG")
    private String tag;
    @Basic(optional = false)
    @Column(name = "ACTION")
    private String action;
    @Basic(optional = false)
    @Column(name = "ICON_POINTS")
    private String iconPoints;
    @Basic(optional = false)
    @Column(name = "EFFECT")
    private String effect;
    @Column(name = "COST")
    private String cost;
    @Column(name = "COLOR")
    private String color;
    @Basic(optional = false)
    @Column(name = "CNT")
    private int cnt;
    @Basic(optional = false)
    @Column(name = "TOKEN_WHITE")
    private int tokenWhite;
    @Basic(optional = false)
    @Column(name = "TOKEN_RED")
    private int tokenRed;
    @Basic(optional = false)
    @Column(name = "TOKEN_YELLOW")
    private int tokenYellow;
    @Basic(optional = false)
    @Column(name = "TOKEN_BLUE")
    private int tokenBlue;
    @Basic(optional = false)
    @Column(name = "EFFECT_WHITE")
    private int effectWhite;
    @Basic(optional = false)
    @Column(name = "EFFECT_FOOD")
    private int effectFood;
    @Basic(optional = false)
    @Column(name = "EFFECT_RED")
    private int effectRed;
    @Basic(optional = false)
    @Column(name = "EFFECT_MUSIC")
    private int effectMusic;
    @Basic(optional = false)
    @Column(name = "EFFECT_STONE")
    private int effectStone;
    @Basic(optional = false)
    @Column(name = "EFFECT_IDEA")
    private int effectIdea;
    @Basic(optional = false)
    @Column(name = "EFFECT_SMILE")
    private int effectSmile;
    @Basic(optional = false)
    @Column(name = "EFFECT_HOUSE")
    private int effectHouse;
    @Basic(optional = false)
    @Column(name = "EFFECT_BLUE")
    private int effectBlue;
    @Basic(optional = false)
    @Column(name = "EFFECT_WEAPON")
    private int effectWeapon;

    public CardEntity() {
    }

    public CardEntity(Integer id) {
        this.id = id;
    }

    public CardEntity(Integer id, String name, Integer age, String civilMilitary, String tag, String action, String iconPoints, String effect, String cost, String color, int cnt, int tokenWhite, int tokenRed, int tokenYellow, int tokenBlue, int effectWhite, int effectFood, int effectRed, int effectMusic, int effectStone, int effectIdea, int effectSmile, int effectHouse, int effectBlue, int effectWeapon) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.civilMilitary = civilMilitary;
        this.tag = tag;
        this.action = action;
        this.iconPoints = iconPoints;
        this.effect = effect;
        this.cost = cost;
        this.color = color;
        this.cnt = cnt;
        this.tokenWhite = tokenWhite;
        this.tokenRed = tokenRed;
        this.tokenYellow = tokenYellow;
        this.tokenBlue = tokenBlue;
        this.effectWhite = effectWhite;
        this.effectFood = effectFood;
        this.effectRed = effectRed;
        this.effectMusic = effectMusic;
        this.effectStone = effectStone;
        this.effectIdea = effectIdea;
        this.effectSmile = effectSmile;
        this.effectHouse = effectHouse;
        this.effectBlue = effectBlue;
        this.effectWeapon = effectWeapon;
    }

    public CardEntity(Integer id, String action, String iconPoints, String effect, int cnt, int tokenWhite, int tokenRed, int tokenYellow, int tokenBlue, int effectWhite, int effectFood, int effectRed, int effectMusic, int effectStone, int effectIdea, int effectSmile, int effectHouse, int effectBlue, int effectWeapon) {
        this.id = id;
        this.action = action;
        this.iconPoints = iconPoints;
        this.effect = effect;
        this.cnt = cnt;
        this.tokenWhite = tokenWhite;
        this.tokenRed = tokenRed;
        this.tokenYellow = tokenYellow;
        this.tokenBlue = tokenBlue;
        this.effectWhite = effectWhite;
        this.effectFood = effectFood;
        this.effectRed = effectRed;
        this.effectMusic = effectMusic;
        this.effectStone = effectStone;
        this.effectIdea = effectIdea;
        this.effectSmile = effectSmile;
        this.effectHouse = effectHouse;
        this.effectBlue = effectBlue;
        this.effectWeapon = effectWeapon;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCivilMilitary() {
        return civilMilitary;
    }

    public void setCivilMilitary(String civilMilitary) {
        this.civilMilitary = civilMilitary;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getIconPoints() {
        return iconPoints;
    }

    public void setIconPoints(String iconPoints) {
        this.iconPoints = iconPoints;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public int getTokenWhite() {
        return tokenWhite;
    }

    public void setTokenWhite(int tokenWhite) {
        this.tokenWhite = tokenWhite;
    }

    public int getTokenRed() {
        return tokenRed;
    }

    public void setTokenRed(int tokenRed) {
        this.tokenRed = tokenRed;
    }

    public int getTokenYellow() {
        return tokenYellow;
    }

    public void setTokenYellow(int tokenYellow) {
        this.tokenYellow = tokenYellow;
    }

    public int getTokenBlue() {
        return tokenBlue;
    }

    public void setTokenBlue(int tokenBlue) {
        this.tokenBlue = tokenBlue;
    }

    public int getEffectWhite() {
        return effectWhite;
    }

    public void setEffectWhite(int effectWhite) {
        this.effectWhite = effectWhite;
    }

    public int getEffectFood() {
        return effectFood;
    }

    public void setEffectFood(int effectFood) {
        this.effectFood = effectFood;
    }

    public int getEffectRed() {
        return effectRed;
    }

    public void setEffectRed(int effectRed) {
        this.effectRed = effectRed;
    }

    public int getEffectMusic() {
        return effectMusic;
    }

    public void setEffectMusic(int effectMusic) {
        this.effectMusic = effectMusic;
    }

    public int getEffectStone() {
        return effectStone;
    }

    public void setEffectStone(int effectStone) {
        this.effectStone = effectStone;
    }

    public int getEffectIdea() {
        return effectIdea;
    }

    public void setEffectIdea(int effectIdea) {
        this.effectIdea = effectIdea;
    }

    public int getEffectSmile() {
        return effectSmile;
    }

    public void setEffectSmile(int effectSmile) {
        this.effectSmile = effectSmile;
    }

    public int getEffectHouse() {
        return effectHouse;
    }

    public void setEffectHouse(int effectHouse) {
        this.effectHouse = effectHouse;
    }

    public int getEffectBlue() {
        return effectBlue;
    }

    public void setEffectBlue(int effectBlue) {
        this.effectBlue = effectBlue;
    }

    public int getEffectWeapon() {
        return effectWeapon;
    }

    public void setEffectWeapon(int effectWeapon) {
        this.effectWeapon = effectWeapon;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CardEntity)) {
            return false;
        }
        CardEntity other = (CardEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

//    @Override
//    public String toString() {
//        return "entity.CardEntity[ id=" + id + " ]";
//    }
    @Override
    public String toString() {
        return "CardEntity{" + "id=" + id + ", name=" + name + ", age=" + age + ", civilMilitary=" + civilMilitary + ", tag=" + tag + ", action=" + action + ", iconPoints=" + iconPoints + ", effect=" + effect + ", cost=" + cost + ", color=" + color + ", cnt=" + cnt + ", tokenWhite=" + tokenWhite + ", tokenRed=" + tokenRed + ", tokenYellow=" + tokenYellow + ", tokenBlue=" + tokenBlue + ", effectWhite=" + effectWhite + ", effectFood=" + effectFood + ", effectRed=" + effectRed + ", effectMusic=" + effectMusic + ", effectStone=" + effectStone + ", effectIdea=" + effectIdea + ", effectSmile=" + effectSmile + ", effectHouse=" + effectHouse + ", effectBlue=" + effectBlue + ", effectWeapon=" + effectWeapon + '}';
    }
    
}
