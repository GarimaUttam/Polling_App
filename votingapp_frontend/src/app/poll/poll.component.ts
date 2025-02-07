import { Component, OnInit } from '@angular/core';
import { PollService } from '../poll.service';
import { Poll } from '../poll.models';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-poll',
  imports: [NgFor],
  templateUrl: './poll.component.html',
  styleUrl: './poll.component.css'
})

export class PollComponent implements OnInit{
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

}
