package com.ezequiel.worstmovie.interfaces;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class ProducerAwardDto implements Serializable {

    private String producer;
    private Long interval;
    private Long previousWin;
    private Long followingWin;

}
