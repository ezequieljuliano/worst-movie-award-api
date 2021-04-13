package com.ezequiel.worstmovie.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public interface MovieDataReader {

    @Data
    @NoArgsConstructor
    class MovieProperties {
        private Long year;
        private String title;
        private String studio;
        private String producer;
        private Boolean winner;
    }

    List<MovieProperties> execute();

}
