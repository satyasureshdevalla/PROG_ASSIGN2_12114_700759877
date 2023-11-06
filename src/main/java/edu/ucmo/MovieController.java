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

    //Retrieve all the movies and show
    @GetMapping
    public Collection<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }

    //Insert the new movie and show
    @PostMapping("/movie")
    public Movie addMovie(@RequestBody Movie movie){
        return movieService.saveMovie(movie);
    }

    //Update the movie and show information using title
    @PatchMapping("/movie")
    public Movie updateMovie(@RequestBody Movie movie){
        return movieService.updateMovie(movie);
    }

    //Delete the movie and show information using title
    @DeleteMapping("/movie/{title}")
    public String deleteMovieByTitle(@PathVariable String title){
        movieService.deleteMovieByTitle(title);
        return "Movie deleted successfully with title as" +title;
    }

    @GetMapping("/movie")
    public List<QueryResultObj> getMovieAndShowDetailsWithActors() {
        return movieService.getMovieAndShowDetailsWithActors();
    }
}
