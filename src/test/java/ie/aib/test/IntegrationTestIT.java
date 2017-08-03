package ie.aib.test;


import static org.junit.Assert.assertTrue;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

public class IntegrationTestIT {
  @Before
  public void setup() {
    System.out.print("Doing the world of setup");
  }

  @Test
  public void test() {
    System.out.print("Doing a important tests.");
    assert true;
  }

  @Test
  public void test2() throws IOException {
    HttpClient client = new DefaultHttpClient();
    HttpGet request = new HttpGet("http://localhost:8080/random");
    HttpResponse response = client.execute(request);

    response.getEntity();
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
    Optional<String> result = bufferedReader.lines().filter(it -> it.contains("randomInteger")).findAny();

    System.out.print("result = " + result);
    assertTrue(result.isPresent());
  }
}
