package com.example.vms2_final;

import com.google.firebase.firestore.Exclude;
import com.google.firebase.firestore.ServerTimestamp;

import java.io.Serializable;
import java.util.Date;

public class Visitors_class implements Serializable {

    private  String name, vehical, purpose, email,no_of_vistiors ;
    private @ServerTimestamp Date timestamp;
    @Exclude private String id;

    public Visitors_class()
    {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Visitors_class(String name, String vehical, String purpose, String email, String no_of_vistiors, Date timestamp) {
        this.name = name;
        this.vehical = vehical;
        this.purpose = purpose;
        this.email = email;
        this.no_of_vistiors = no_of_vistiors;
        this.timestamp = timestamp;
    }

    public String getName() {
        return name;
    }

    public String getVehical() {
        return vehical;
    }

    public String getPurpose() {
        return purpose;
    }

    public String getEmail() {
        return email;
    }

    public String getNo_of_vistiors() {
        return no_of_vistiors;
    }

    public Date getTimestamp() {
        return timestamp;
    }


}
