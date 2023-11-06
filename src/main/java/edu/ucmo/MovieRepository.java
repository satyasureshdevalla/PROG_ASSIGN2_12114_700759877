package edu.ucmo;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends Neo4jRepository<Movie, String>{
    @Query("MATCH (m:Movie) Return m")
    List<Movie> getAllMovies();

    @Query("MATCH (m:Movie { title: $title }) SET m.title = $title, m.description = $description, m.rating = $rating RETURN m.ids AS ids, m.title AS title, m.description AS description, m.year AS year, m.runtime AS runtime, m.rating AS rating, m.votes AS votes, m.revenue AS revenue")
    Movie updateMovieByTitleOrDescOrRating(String title, String description, String rating);

    @Query("MATCH (m:Movie { title: $title }) DETACH DELETE m")
    void deleteMovieByTitle(String title);

    @Query("MATCH (movie:Movie)-[:ACTED_IN]-(person:Person) RETURN movie.ids AS ids, movie.title AS title, COLLECT(person.name) AS person")
    List<QueryResultObj> getMovieAndShowDetailsWithActors();

}
