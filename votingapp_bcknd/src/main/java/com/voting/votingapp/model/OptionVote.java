package com.voting.votingapp.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Embeddable
public class OptionVote {
    @JsonProperty("optionText")
    private String optionText;


    @JsonProperty("voteCount")
    private Long voteCount = 0L;


    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    public Long getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Long voteCount) {
        this.voteCount = voteCount;
    }
}
