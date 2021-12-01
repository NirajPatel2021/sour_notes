package edu.ben.backend.resource;

import edu.ben.backend.model.dto.ReviewDTO;
import edu.ben.backend.service.ReviewService;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value = "api/review", produces = "application/json")
public class ReviewResource {

    private final ReviewService reviewService;

    public ReviewResource(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping(value="/getAllReviewsForSong/{musicId}")
    public List<ReviewDTO> getAllReviewsForSongOrAlbum(@PathVariable Long musicId){

        return reviewService.getAllReviewsForSongOrAlbum(musicId);
    }
}
