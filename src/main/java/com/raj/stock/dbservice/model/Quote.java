package com.raj.stock.dbservice.model;
/*   RajUser created on 10/5/2019 
inside the package - com.raj.stock.dbservice.model  */

import javax.persistence.*;

@Entity
@Table(name="quotes", catalog = "test")
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "userName")
    private  String userName;

    public Quote() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Quote(String userName, String quote) {
        this.userName = userName;
        this.quote = quote;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Column(name = "quote")
    private  String quote;
}
