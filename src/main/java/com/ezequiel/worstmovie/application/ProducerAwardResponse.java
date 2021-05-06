package com.ezequiel.worstmovie.application;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ProducerAwardResponse implements Serializable {

    private String producer;
    private Long interval;
    private Long previousWin;
    private Long followingWin;

}
