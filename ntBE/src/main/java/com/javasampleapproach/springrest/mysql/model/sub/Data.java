package com.javasampleapproach.springrest.mysql.model.sub;

public class Data {
    private String landing_page;
    private Price price;

    public Data(String landing_page, Price price) {
        this.landing_page = landing_page;
        this.price = price;
    }

    public String getLanding_page() {
        return landing_page;
    }

    public void setLanding_page(String landing_page) {
        this.landing_page = landing_page;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}
