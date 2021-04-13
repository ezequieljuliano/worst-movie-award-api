package com.ezequiel.worstmovie.interfaces;

import com.ezequiel.worstmovie.domain.AwardInterval;
import com.ezequiel.worstmovie.domain.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/producers")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProducerController {

    private final ProducerService producerService;
    private final ProducerConverter producerConverter;

    @GetMapping("/awards-range")
    public ResponseEntity<AwardsRangeDto> findAwardsRange() {
        AwardsRangeDto response = new AwardsRangeDto();
        AwardInterval awardIntervals = producerService.getIntervalAwards();
        producerConverter.updateMinAwardsRange(response.getMin(), awardIntervals);
        producerConverter.updateMaxAwardsRange(response.getMax(), awardIntervals);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
