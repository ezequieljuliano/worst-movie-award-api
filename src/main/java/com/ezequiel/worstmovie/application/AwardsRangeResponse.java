package com.ezequiel.worstmovie.application;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class AwardsRangeResponse implements Serializable {

    private List<ProducerAwardResponse> min;
    private List<ProducerAwardResponse> max;

    public List<ProducerAwardResponse> getMin() {
        if (min == null) {
            min = new ArrayList<>();
        }
        return min;
    }

    public List<ProducerAwardResponse> getMax() {
        if (max == null) {
            max = new ArrayList<>();
        }
        return max;
    }

}
