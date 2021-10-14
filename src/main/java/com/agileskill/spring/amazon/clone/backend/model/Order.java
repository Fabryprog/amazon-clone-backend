package com.agileskill.spring.amazon.clone.backend.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name="orders")
public class Order {
    @Id
    private Long id;

    private Date createdAt;
    private String products; //dirty solution....

    @ManyToOne
    @JoinColumn(name="idUser")
    @JsonBackReference
    private User user;

    @ManyToMany
    @JoinTable(
            name = "courier_order",
            joinColumns = { @JoinColumn(name = "idOrder") },
            inverseJoinColumns = { @JoinColumn(name = "idCourier") })
    private List<Courier> courier;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Courier> getCourier() {
        return courier;
    }

    public void setCourier(List<Courier> courier) {
        this.courier = courier;
    }

    public String toUserFriendlyString() {
        return "Order{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", products='" + products + '\'' +
                ", user=" + user +
                ", courier=" + courier +
                '}';
    }
}
