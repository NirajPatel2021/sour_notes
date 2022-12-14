package edu.ben.backend.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long id;
    @Column(name = "user_id")
    Long userId;
    @Column(name = "content")
    String content;
    @Column(name = "rating")
    Integer rating;
    @Column(name = "music_id")
    Long musicId;
    @Column(name = "favorites")
    Integer favorites;

    public Review(Long userId, String content, Integer rating, Long musicId,
                  Integer favorites) {
        this.userId = userId;
        this.content = content;
        this.rating = rating;
        this.musicId = musicId;
        this.favorites = favorites;

    }

}
