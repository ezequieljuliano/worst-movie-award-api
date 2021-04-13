package com.ezequiel.worstmovie.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class AwardInterval implements Serializable {

    private final List<ProducerInterval> min;
    private final List<ProducerInterval> max;

}
