package edu.ben.backend.resource;

import edu.ben.backend.model.Review;
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

    @GetMapping(value="/getAllReviewsforUser/{userId}")
    public List<ReviewDTO> getAllReviewsForUser(@PathVariable Long userId){
      
        return reviewService.getAllReviewsForUser(userId);
    }

    @GetMapping(value="/getReview/{reviewId}")
    public ReviewDTO getAllReview(@PathVariable Long reviewId){
        return reviewService.getReview(reviewId);
    }



    @PostMapping(value = "/createReview")
    public void createReview(@RequestBody ReviewDTO reviewDTO) {
        reviewService.createReview(reviewDTO);
    }

    @PostMapping(value = "/updateReview")
    public void updateReview(@RequestBody ReviewDTO reviewDTO) {
        System.out.println("updating review!");
        reviewService.updateReview(reviewDTO);
    }

    @PutMapping(value="/updateFavorites")
    public void updateFavorites(@RequestBody ReviewDTO reviewDTO) {
        reviewService.updateFavorites(reviewDTO);
    }

    @RequestMapping("/deleteReview/{reviewId}")
        public void deleteReview(@PathVariable Long reviewId) {
            reviewService.deleteReview(reviewId);
        }


}
