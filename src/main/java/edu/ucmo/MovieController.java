package edu.ucmo;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    //Retrieve all the movies in database
    @GetMapping
    public Collection<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }

    //Insert the new movie information
    @PostMapping("/movie")
    public Movie addMovie(@RequestBody Movie movie){
        return movieService.saveMovie(movie);
    }

    //Update the movie information using title(By update only title, description, and rating)
    @PatchMapping("/movie")
    public Movie updateMovie(@RequestBody Movie movie){
        return movieService.updateMovie(movie);
    }

    //Delete the movie information using title
    @DeleteMapping("/movie/{title}")
    public String deleteMovieByTitle(@PathVariable String title){
        movieService.deleteMovieByTitle(title);
        return "Movie deleted successfully with title as" +title;
    }

    //Display the movie's details includes actor
    @GetMapping("/movie")
    public List<QueryResultObj> getMovieAndShowDetailsWithActors() {
        return movieService.getMovieAndShowDetailsWithActors();
    }
}
