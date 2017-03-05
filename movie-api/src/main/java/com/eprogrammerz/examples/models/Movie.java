package com.eprogrammerz.examples.models;

import lombok.*;

import java.io.Serializable;

/**
 * Created by Yogen on 12/25/2016.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Movie implements Serializable {
    private static final long serialVersionUID = 2987521091221161580L;
    private long id;
    private String name;
    private String directorName;
    private String rating;
}
