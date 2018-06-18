package com.chrisfox.courses.model;

import java.util.ArrayList;
import java.util.List;
/*
This is just a simple way of implementing things that will not survive a server restart
Do not run this on Live server!
 */
public class SimpleCourseIdeaDAO implements CourseIdeaDAO{

    private List<CourseIdea> ideas;


    public SimpleCourseIdeaDAO() {
        ideas = new ArrayList<>();
    }

    @Override
    public boolean add(CourseIdea idea) {
        return ideas.add(idea);
    }

    @Override
    public List<CourseIdea> findAll() {
        return new ArrayList<>(ideas);
    }


    @Override
    public CourseIdea findBySlug(String slug) {
        return ideas.stream()
                .filter(idea -> idea.getSlug().equals(slug))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }
}
