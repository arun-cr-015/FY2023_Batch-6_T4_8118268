package com.example.project.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.project.dto.ReviewDto;
import com.example.project.exception.ReviewNotExistException;
import com.example.project.model.Product;
import com.example.project.model.Review;
import com.example.project.model.UserModel;
import com.example.project.repository.ReviewRepo;

@Service
public class ReviewService {
	@Autowired
	private ReviewRepo reviewRepo;

	public ResponseEntity<Review> addReview(ReviewDto reviewDto, UserModel user, Product product) {
		Review review = new Review();
		review.setRating(reviewDto.getRating());
		review.setComment(reviewDto.getComment());
		review.setCreatedDate(new Date(System.currentTimeMillis()));
		review.setProduct(product);
		review.setUser(user);
		return new ResponseEntity<>(reviewRepo.save(review), HttpStatus.OK);
	}

	public ResponseEntity<List<Review>> showReview(Product product) {
		List<Review> reviews = reviewRepo.findAllByProduct(product);
		return new ResponseEntity<>(reviews, HttpStatus.OK);
	}

	public ResponseEntity<Review> getOneReview(long id) {
		Optional<Review> review = reviewRepo.findById(id);
		if (!review.isPresent()) {
			throw new ReviewNotExistException("Review Not found");
		}

		return new ResponseEntity<>(review.get(), HttpStatus.OK);
	}

	public ResponseEntity<Review> editReview(ReviewDto reviewDto) {
		Optional<Review> review = reviewRepo.findById(reviewDto.getId());
		if (!review.isPresent()) {
			throw new ReviewNotExistException("Review Not found");
		}
		review.get().setCreatedDate(new Date(System.currentTimeMillis()));
		review.get().setRating(reviewDto.getRating());
		review.get().setComment(reviewDto.getComment());
		return new ResponseEntity<>(reviewRepo.save(review.get()), HttpStatus.OK);

	}

	public void deleteReview(long id) {
		reviewRepo.deleteById(id);

	}

}
