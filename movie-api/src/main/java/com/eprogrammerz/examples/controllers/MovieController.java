package com.eprogrammerz.examples.controllers;

import com.eprogrammerz.examples.models.interfaces.MovieResponse;
import com.eprogrammerz.examples.repositories.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by rajkumar on 12/25/2016.
 */
@RestController
@Slf4j
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @GetMapping(value = "/movies/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<MovieResponse> getMovie(@PathVariable("id") Long id) {
        log.trace("getBook({})", id);

        return movieRepository.findOneById(id)
                .map(movie -> {
                    MovieResponse response = new MovieResponse(movie);
                    response.add(linkTo(methodOn(MovieController.class).getMovie(id)).withSelfRel());
                    return new ResponseEntity<>(response, HttpStatus.OK);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
