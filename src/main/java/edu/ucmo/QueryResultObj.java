package edu.ucmo;

import org.springframework.data.neo4j.annotation.QueryResult;
import java.util.List;

@QueryResult
public class QueryResultObj {
    private String ids;
    private String title;
    private List<String> person;

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getPerson() {
        return person;
    }

    public void setPerson(List<String> person) {
        this.person = person;
    }
}
