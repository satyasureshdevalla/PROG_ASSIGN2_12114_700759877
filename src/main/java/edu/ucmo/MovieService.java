package edu.ucmo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies(){
        return movieRepository.getAllMovies();
    }

    public Movie saveMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Movie movie){
        return movieRepository.updateMovieByTitleOrDescOrRating(movie.getTitle(),
                movie.getDescription(), movie.getRating());
    }

    public void deleteMovieByTitle(String title){
        movieRepository.deleteMovieByTitle(title);
    }

    public List<QueryResultObj> getMovieAndShowDetailsWithActors(){
        return movieRepository.getMovieAndShowDetailsWithActors();
    }
}
