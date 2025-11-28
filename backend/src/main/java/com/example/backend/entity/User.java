package com.example.backend.entity;

import com.example.backend.entity.photo.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @Column
    private String username;

    @Column
    private String password;

    @OneToMany
    private List<Photo> photos;

    @OneToMany(mappedBy = "likeUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhotoLike> photoLikes;

    @OneToMany(mappedBy = "viewUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhotoView> photoViews;

    @OneToMany(mappedBy = "reportUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhotoReport> photoReports;

    @OneToMany(mappedBy = "favoriteUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhotoFavorite> photoFavorites;

    @OneToMany(mappedBy = "purchaseUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhotoPurchase> photoPurchases;
}
