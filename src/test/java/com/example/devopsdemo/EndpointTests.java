package com.example.devopsdemo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import java.net.*;
import java.net.http.*;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
class EndpointTests {
 @LocalServerPort int port;
 @Test void helloAndHealth() throws Exception {
  var client=HttpClient.newHttpClient();
  var hello=client.send(HttpRequest.newBuilder(URI.create("http://localhost:"+port+"/hello")).build(),HttpResponse.BodyHandlers.ofString());
  assertEquals(200,hello.statusCode());assertEquals("DevOps demo application is running!",hello.body());
  assertEquals(200,client.send(HttpRequest.newBuilder(URI.create("http://localhost:"+port+"/health")).build(),HttpResponse.BodyHandlers.ofString()).statusCode());
 }
}
