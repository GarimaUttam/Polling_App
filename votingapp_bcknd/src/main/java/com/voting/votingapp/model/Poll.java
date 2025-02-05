package com.voting.votingapp.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
//@JsonIgnoreProperties(ignoreUnknown = true)  // Ignores unknown fields
@JsonInclude(JsonInclude.Include.NON_NULL)   // Ensures null values are included in response
public class Poll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")  // Ensure ID is included in the JSON response
    private Long id;

    @JsonProperty("question")  // Ensure question is included in the JSON response
    private String question;

    @ElementCollection
    @CollectionTable(name = "poll_options", joinColumns = @JoinColumn(name = "poll_id"))
    @Column(name = "option_value")
    @JsonProperty("options")  // Maps correctly to JSON
    private List<String> options = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "poll_votes", joinColumns = @JoinColumn(name = "poll_id"))
    @Column(name = "vote_count")
    @JsonProperty("votes")  // Maps correctly to JSON
    private List<Long> votes = new ArrayList<>();
}
