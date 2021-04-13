package com.ezequiel.worstmovie.interfaces;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class AwardsRangeDto implements Serializable {

    private List<ProducerAwardDto> min;
    private List<ProducerAwardDto> max;

    public List<ProducerAwardDto> getMin() {
        if (min == null) {
            min = new ArrayList<>();
        }
        return min;
    }

    public List<ProducerAwardDto> getMax() {
        if (max == null) {
            max = new ArrayList<>();
        }
        return max;
    }

}
