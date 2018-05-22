package com.trivediinfoway.demo;

import java.util.ArrayList;

/**
 * Created by TI A1 on 12-04-2018.
 */

public class Match {
    String id;
    String type;
    String srs;
    String mchDesc;
    String mnum;
    String vcity;
    String vcountry;
    String grnd;
    String inngCnt;
    String datapath;
    String state;
    String Tm;
    String Tme;
    ArrayList<Tm> tmList;

    public ArrayList<com.trivediinfoway.demo.Tme> getTmeList() {
        return tmeList;
    }

    public void setTmeList(ArrayList<com.trivediinfoway.demo.Tme> tmeList) {
        this.tmeList = tmeList;
    }

    ArrayList<Tme> tmeList;

    public ArrayList<com.trivediinfoway.demo.Tm> getTmList() {
        return tmList;
    }

    public void setTmList(ArrayList<com.trivediinfoway.demo.Tm> tmList) {
        this.tmList = tmList;
    }

    public ArrayList<com.trivediinfoway.demo.state> getStateList() {
        return stateList;
    }

    public void setStateList(ArrayList<com.trivediinfoway.demo.state> stateList) {
        this.stateList = stateList;
    }

    public ArrayList<state> stateList;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTm() {
        return Tm;
    }

    public void setTm(String tm) {
        Tm = tm;
    }

    public String getTme() {
        return Tme;
    }

    public void setTme(String tme) {
        Tme = tme;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSrs() {
        return srs;
    }

    public void setSrs(String srs) {
        this.srs = srs;
    }

    public String getMchDesc() {
        return mchDesc;
    }

    public void setMchDesc(String mchDesc) {
        this.mchDesc = mchDesc;
    }

    public String getMnum() {
        return mnum;
    }

    public void setMnum(String mnum) {
        this.mnum = mnum;
    }

    public String getVcity() {
        return vcity;
    }

    public void setVcity(String vcity) {
        this.vcity = vcity;
    }

    public String getVcountry() {
        return vcountry;
    }

    public void setVcountry(String vcountry) {
        this.vcountry = vcountry;
    }

    public String getGrnd() {
        return grnd;
    }

    public void setGrnd(String grnd) {
        this.grnd = grnd;
    }

    public String getInngCnt() {
        return inngCnt;
    }

    public void setInngCnt(String inngCnt) {
        this.inngCnt = inngCnt;
    }

    public String getDatapath() {
        return datapath;
    }

    public void setDatapath(String datapath) {
        this.datapath = datapath;
    }
}
