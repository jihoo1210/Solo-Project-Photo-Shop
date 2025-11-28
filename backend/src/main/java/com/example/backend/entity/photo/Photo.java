package com.example.backend.entity.photo;

import com.example.backend.entity.User;
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

@Entity
public class Photo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @Column
    private String photoTitle;

    @Column
    private String description;

    @Column
    private Integer price;

    @Column
    private Integer discountPercentage;

    @OneToMany(mappedBy = "likePhoto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhotoLike> photoLikes;

    @OneToMany(mappedBy = "viewPhoto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhotoView> photoViews;

    @OneToMany(mappedBy = "reportPhoto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhotoReport> photoReports;

    @OneToMany(mappedBy = "favoritePhoto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PhotoFavorite> photoFavorites;

    @OneToMany(mappedBy = "purchasePhoto")
    private List<PhotoPurchase> photoPurchases;
}
