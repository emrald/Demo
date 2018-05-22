package com.trivediinfoway.demo;
/**
 * Created by Geoffrey Koros on 9/4/2015.
 */
public class BananaModel implements GenericModel {
    private String name;
    private String countryOfOrigin;
    private int image;

    // other stuff here

    public BananaModel(String name, String countryOfOrigin, int image){
        this.name = name;
        this.countryOfOrigin = countryOfOrigin;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getHeader(){
        return name;
    }

    public String getSubHeader(){
        return countryOfOrigin;
    }

    public String getType(){
        return Constants.BANANA;
    }

    public int getImageResource(){
        return image;
    }
}
