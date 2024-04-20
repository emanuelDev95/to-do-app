import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Status } from '../../models/task';
import { MessageResponse } from '../../models/response';

@Injectable({
  providedIn: 'root'
})
export class StatusService {

  private http = inject(HttpClient);
  private API = 'http://localhost:8080/status';


  getAll() {
    return this.http.get<MessageResponse<Status[]>>(`${this.API}`);
  }
}
