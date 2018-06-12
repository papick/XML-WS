import {Component, OnInit} from '@angular/core';
import {AgentService} from '../../services/agentService';

@Component({
  selector: 'app-agents',
  templateUrl: './agents.component.html',
  styleUrls: ['./agents.component.css']
})
export class AgentsComponent implements OnInit {

  agents = [];

  constructor(private agentService: AgentService) {
    this.agentService.getAgents().subscribe(data => {
      this.agents = data;
    });
  }

  ngOnInit() {
  }

}
