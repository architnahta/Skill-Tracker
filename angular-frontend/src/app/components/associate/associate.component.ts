import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Associate } from 'src/app/models/associate';
import { Skills } from 'src/app/models/skills';
import { AssociateService } from 'src/app/services/associate.service';

@Component({
  selector: 'app-associate',
  templateUrl: './associate.component.html',
  styleUrls: ['./associate.component.css']
})
export class AssociateComponent implements OnInit {

  associates: Associate[];
  skills: Skills[] | undefined;
  show:Boolean;
  pattern:string;
  name:string;
  id:string;
  constructor(private associateService: AssociateService,
    private router: Router) { 
      this.show=false;
    }

  ngOnInit(): void {
    this.getAssociates();
  }

  private getAssociates(){
    this.associateService.getAssociateList().subscribe(data => {
      this.associates = data;
      this.skills=[];
    });
  }

  public getAssociateByPattern(){
    if(this.pattern != ""){
      this.associateService.getAssociateListBySkill(this.pattern).subscribe( foundCompanies => {
        this.associates = foundCompanies;
      });
    } else {
      this.getAssociates();
    }
  }


}
