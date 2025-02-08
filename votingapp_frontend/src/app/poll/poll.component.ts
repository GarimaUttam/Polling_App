import { Component, OnInit } from '@angular/core';
import { PollService } from '../poll.service';
import { Poll } from '../poll.models';
import { NgFor } from '@angular/common';
// import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; // Import FormsModule

@Component({
  selector: 'app-poll',
  imports: [NgFor, FormsModule],
  templateUrl: './poll.component.html',
  styleUrl: './poll.component.css'
})

export class PollComponent implements OnInit{
  newPoll: Poll = {
    question: '',
    options: [
      { optionText: '', voteCount: 0},
      { optionText: '', voteCount: 0}
    ]
  }

  polls: Poll[] = [];

  constructor(private pollService: PollService) {
  }

  ngOnInit(): void {
    this.loadPolls();
  }

  loadPolls() {
    // the data is beigng returned async from the backend
    this.pollService.getPolls().subscribe({
      next: (data) => {
        this.polls = data;
      },
      error: (error) => {
        console.error("Error fetching polls: ", error);
      }
    });
  }

  createPoll() {
    // console.log('New Poll Data:', this.newPoll); // Add this line
    this.pollService.createPoll(this.newPoll).subscribe({
      next: (createdPoll) => {
        this.polls.push(createdPoll);
        this.resetPoll();
      },
      error: (error) => {
        console.error("Error creating poll: ", error);
      }
    });
  }

  resetPoll() {
    this.newPoll = {
      question: '',
      options: [
        { optionText: '', voteCount: 0},
        { optionText: '', voteCount: 0}
      ]
  };
}




  trackByIndex(index: number): number {
    return index;
  }


}
