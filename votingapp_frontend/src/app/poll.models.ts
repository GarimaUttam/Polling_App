export interface OptionVote {
[x: string]: any;
    optionText: string;
    voteCount: number;
}
export interface Poll {
    id?: number;
    question: string;
    options: OptionVote[];
}
