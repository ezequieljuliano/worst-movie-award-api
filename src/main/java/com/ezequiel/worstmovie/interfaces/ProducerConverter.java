package com.ezequiel.worstmovie.interfaces;

import com.ezequiel.worstmovie.domain.AwardInterval;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProducerConverter {

    public void updateMinAwardsRange(List<ProducerAwardDto> minRange, AwardInterval awardInterval) {
        awardInterval.getMin().forEach(producerInterval -> {
            ProducerAwardDto record = new ProducerAwardDto();
            record.setFollowingWin(producerInterval.getFollowingWin());
            record.setInterval(producerInterval.getInterval());
            record.setPreviousWin(producerInterval.getPreviousWin());
            record.setProducer(producerInterval.getProducer());
            minRange.add(record);
        });
    }

    public void updateMaxAwardsRange(List<ProducerAwardDto> maxRange, AwardInterval awardInterval) {
        awardInterval.getMax().forEach(producerInterval -> {
            ProducerAwardDto record = new ProducerAwardDto();
            record.setFollowingWin(producerInterval.getFollowingWin());
            record.setInterval(producerInterval.getInterval());
            record.setPreviousWin(producerInterval.getPreviousWin());
            record.setProducer(producerInterval.getProducer());
            maxRange.add(record);
        });
    }

}
