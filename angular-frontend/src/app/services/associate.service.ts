import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Associate } from '../models/associate';

@Injectable({
  providedIn: 'root'
})
export class AssociateService {

  private baseURL = "http://localhost:8080/skilltracker/getAssociates";

  constructor(private httpClient: HttpClient) { }

  getAssociateList(): Observable<Associate[]>{
    return this.httpClient.get<Associate[]>(`${this.baseURL}`);
  }

  getAssociateListBySkill(skillName:string): Observable<Associate[]>{
    return this.httpClient.get<Associate[]>(`${this.baseURL}`+"/"+skillName);
  }

}
