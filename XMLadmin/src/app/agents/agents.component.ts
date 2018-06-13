import {Component, OnInit} from '@angular/core';
import {AgentService} from '../../services/agentService';
import {Router} from '@angular/router';

@Component({
  selector: 'app-agents',
  templateUrl: './agents.component.html',
  styleUrls: ['./agents.component.css']
})
export class AgentsComponent implements OnInit {

  agents = [];

  constructor(private agentService: AgentService,
              private router: Router) {
    this.agentService.getAgents().subscribe(data => {
      this.agents = data;
    });
  }

  ngOnInit() {
  }

  addAgent() {
    this.router.navigateByUrl('/home/agentForm/add');
  }

  removeAgent(id) {
    this.agentService.removeAgent(id).subscribe(data => {
        location.reload();
      }
    );
  }

}
