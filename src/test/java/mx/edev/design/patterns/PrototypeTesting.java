package mx.edev.design.patterns;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import mx.edev.design.patterns.creational.prototype.Movie;
import mx.edev.design.patterns.creational.prototype.Record;
import mx.edev.design.patterns.creational.prototype.Registry;
import mx.edev.design.patterns.creational.prototype.Statement;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PrototypeTesting {

    /**
     * This is a Shallow copy because the properties are pointing to the same
     * reference
     */
    @Test
    public void evaluateShallowCopy() {
        String sql = "SELECT * FROM VLS_DEALS WHERE DEA_PID_DEAL=?";
        List<String> paramenters = new ArrayList<>();
        paramenters.add("123456");
        Record record = new Record();
        Statement statement = new Statement(sql, paramenters, record);
        assertNotNull("Statement is null!!!", statement);
        System.out.println(statement);
        Statement newStatement = statement.clone();
        assertNotNull("New statement is null!!!", newStatement);
        assertNotEquals("Statements are different!", statement, newStatement);
        System.out.println(newStatement);
        assertEquals("SQL are different!", statement.getSql(), newStatement.getSql());
        assertEquals("Parameters are different!", statement.getParameters(), newStatement.getParameters());
        assertEquals("Records are different!", statement.getRecord(), newStatement.getRecord());
    }

    /**
     * Different references, even if they look the same (equals)
     */
    @Test
    public void evaluate() {
        Registry registry = new Registry();
        Movie movie = (Movie) registry.createItem("Movie");
        // movie.setTitle("Creational Patterns in Java");

        assertNotNull("Movie object not created!", movie);
        System.out.println(movie);
        System.out.println(movie.getRuntime());
        System.out.println(movie.getTitle());
        System.out.println(movie.getUrl());

        Movie anotherMovie = (Movie) registry.createItem("Movie");
        // anotherMovie.setTitle("Gang of Four");

        assertNotNull("Another movie object not created!!!", anotherMovie);
        System.out.println(anotherMovie);
        System.out.println(anotherMovie.getRuntime());
        System.out.println(anotherMovie.getTitle());
        System.out.println(anotherMovie.getUrl());

        assertEquals("Something went wrong!!!", movie, anotherMovie);

        assertNotEquals("Prototype pattern fails!!!", System.identityHashCode(movie),
                System.identityHashCode(anotherMovie));
    }
}