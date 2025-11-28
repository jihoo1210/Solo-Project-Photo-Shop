package com.example.backend.entity;

import com.example.backend.entity.photo.*;
import com.example.backend.entity.utility.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.security.AuthProvider;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter

@Entity(name = "users")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private AuthProvider authProvider;

    @Column
    private String email;

    @Column
    private String username;

    @Column
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

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
