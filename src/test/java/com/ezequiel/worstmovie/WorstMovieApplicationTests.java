package com.ezequiel.worstmovie;

import com.ezequiel.worstmovie.interfaces.AwardsRangeDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WorstMovieApplicationTests {

    private static final String HOST = "http://localhost:";
    private static final String PRODUCERS_RESOURCE = "/worstmovie-api/v1/producers";

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testAwardsRange() {
        ResponseEntity<AwardsRangeDto> responseEntity = restTemplate.getForEntity(HOST + port + PRODUCERS_RESOURCE + "/awards-range", AwardsRangeDto.class);
        Assert.assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        Assert.assertNotNull(responseEntity.getBody());
        Assert.assertNotNull(responseEntity.getBody().getMax());
        Assert.assertNotNull(responseEntity.getBody().getMin());
    }

}
