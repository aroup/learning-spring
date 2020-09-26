package com.turing.springmvc;

import java.util.LinkedHashMap;

public class Student {
    private String firstName;
    private String lastName;
    private String Country;
    private LinkedHashMap<String, String> countryOptions;
    private String favoriteLanguage;

    public String[] getOperatingSystems() {
        return operatingSystems;
    }

    public void setOperatingSystems(String[] operatingSystems) {
        this.operatingSystems = operatingSystems;
    }

    private String[] operatingSystems;

    public LinkedHashMap<String, String> getFavoriteLanguageOptions() {
        return favoriteLanguageOptions;
    }

    private LinkedHashMap<String,String> favoriteLanguageOptions;

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public Student() {
        countryOptions = new LinkedHashMap<>();
        countryOptions.put("BR","Brazil");
        countryOptions.put("IN","India");
        countryOptions.put("DE","Germany");
        countryOptions.put("BD","Bangladesh");
        favoriteLanguageOptions = new LinkedHashMap<>();
        favoriteLanguageOptions.put("Java", "Java");
        favoriteLanguageOptions.put("C++", "C++");
        favoriteLanguageOptions.put("Ruby", "Ruby");
        favoriteLanguageOptions.put("F#", "F#");

    }

    public LinkedHashMap<String, String> getCountryOptions() {
        return countryOptions;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
