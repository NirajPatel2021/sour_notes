package edu.ben.backend.model.dto;

import lombok.*;

import java.util.Comparator;

@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {

    Long id;
    Long userId;
    String content;
    Integer rating;
    Long musicId;
    Integer favorites;

    public ReviewDTO(Long userId, String content, int rating, Long musicId, int favorites) {
        this.userId = userId;
        this.content = content;
        this.rating = rating;
        this.musicId = musicId;
        this.favorites = favorites;
    }

    public ReviewDTO(String content, int rating, Long musicId, int favorites) {
        this.content = content;
        this.rating = rating;
        this.musicId = musicId;
        this.favorites = favorites;
    }




}
