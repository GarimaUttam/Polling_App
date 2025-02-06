package com.voting.votingapp.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class OptionVote {
    @JsonProperty("voteOption")
    private String voteOption;

    @JsonProperty("voteCount")
    private Long voteCount = 0L;

}
