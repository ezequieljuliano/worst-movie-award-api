package com.ezequiel.worstmovie.application;

import com.ezequiel.worstmovie.domain.AwardInterval;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProducerConverter {

    public void updateMinAwardsRange(List<ProducerAwardResponse> minRange, AwardInterval awardInterval) {
        awardInterval.getMin().forEach(producerInterval -> {
            ProducerAwardResponse record = new ProducerAwardResponse();
            record.setFollowingWin(producerInterval.getFollowingWin());
            record.setInterval(producerInterval.getInterval());
            record.setPreviousWin(producerInterval.getPreviousWin());
            record.setProducer(producerInterval.getProducer());
            minRange.add(record);
        });
    }

    public void updateMaxAwardsRange(List<ProducerAwardResponse> maxRange, AwardInterval awardInterval) {
        awardInterval.getMax().forEach(producerInterval -> {
            ProducerAwardResponse record = new ProducerAwardResponse();
            record.setFollowingWin(producerInterval.getFollowingWin());
            record.setInterval(producerInterval.getInterval());
            record.setPreviousWin(producerInterval.getPreviousWin());
            record.setProducer(producerInterval.getProducer());
            maxRange.add(record);
        });
    }

}
