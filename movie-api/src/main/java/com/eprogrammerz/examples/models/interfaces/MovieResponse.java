package com.eprogrammerz.examples.models.interfaces;

import com.eprogrammerz.examples.models.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by Yogen on 9/28/2017.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieResponse extends ResourceSupport {
    private Movie movie;
}
