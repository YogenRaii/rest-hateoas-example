package com.eprogrammerz.examples.repositories;

import com.eprogrammerz.examples.models.Movie;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rajkumar on 12/25/2016.
 */
@Component
public class MovieRepository {
    private static List<Movie> movies;

    static {
        movies = new ArrayList(){
            {
                add(new Movie(1200L, "Freedom Fighter", "Nelson Mandela","4/5"));
                add(new Movie(1201L, "In Search of Lost Time", "Marcel Proust","3.5/5"));
                add(new Movie(1202L, "Ulysses", "James Joyace","3/5"));
                add(new Movie(1203L, "Hamlet", "William Shakespear","4.5/5"));
            }
        };
    }

    public Movie findOneById(Long movieId){
        Movie movie = movies.stream()
                        .filter(m -> m.getId() == movieId)
                        .findAny()
                        .orElse(null);
        return movie;
    }
}
