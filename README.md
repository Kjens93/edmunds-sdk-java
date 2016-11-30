# Edmunds
[![Build Status](https://travis-ci.org/Kjens93/edmunds-sdk-java.svg?branch=master)](https://travis-ci.org/Kjens93/edmunds-sdk-java)
[![Coverage Status](https://coveralls.io/repos/github/Kjens93/edmunds-sdk-java/badge.svg?branch=master)](https://coveralls.io/github/Kjens93/edmunds-sdk-java?branch=master)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.kjens93.edmunds/edmunds.svg?maxAge=60)](https://maven-badges.herokuapp.com/maven-central/io.github.kjens93.edmunds/edmunds)

A Java library for accessing the Edmunds.com Vehicle API

## Installation
```xml
<dependency>
    <groupId>io.github.kjens93.edmunds</groupId>
    <artifactId>edmunds</artifactId>
    <version>LATEST</version>
</dependency>
```

## Usage
```java
class Example {
    
    private static final Edmunds edmunds = new Edmunds("<<YOUR EDMUNDS.com API KEY>>");
    
    public void get_makes() {
        
        List<Make> makes = edmunds.findAllMakes()
                                  .state(State.NEW)
                                  .year(2016)
                                  .get();
        
    }
    
    public void get_make() {
            
        Make make = edmunds.findMake("honda").get();
            
    }
    
    public void get_mmodels() {
            
        List<Model> models = edmunds.findAllModels("chevrolet")
                                    .year(2012)
                                    .category(Category.CONVERTIBLE)
                                    .state(State.USED)
                                    .get();
            
    }
    
    public void get_model() {
            
        Model model = edmunds.findModel("honda", "accord").get();
            
    }
    
    public void get_model_years() {
                
        List<Year> years = edmunds.findAllModelYears("honda", "accord").get();
            
    }
    
    public void get_model_year() {
            
        Year year = edmunds.findModelYear("honda", "accord", 2013).get();
            
    }
    
    public void get_styles() {
                    
        List<Style> styles = edmunds.findAllStyles("honda", "accord", 2016)
                                    .state(State.NEW)
                                    .get();
            
    }
    
    public void get_style() {
            
        Style style = edmunds.findStyle(12345).get();
            
    }
    
}
```