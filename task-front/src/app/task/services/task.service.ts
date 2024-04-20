import { MessageResponse } from '../../models/response';
import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Task } from '../../models/task';


@Injectable({
  providedIn: 'root'
})
export class TaskService {

  private http = inject(HttpClient);
  private API = 'http://localhost:8080/tasks';


  getAll() {
    return this.http.get<MessageResponse<Task[]>>(`${this.API}`);
  }

  save(task : Task ){
    return this.http.post<MessageResponse<Task>>(`${this.API}`, task);
  }

  get(id : number){
    return  this.http.get<MessageResponse<Task>>(`${this.API}/${id}`);
  }

  update(id : number, task : Task){
    return this.http.put<MessageResponse<Task>>(`${this.API}/${id}`, task)
  }

  delete(id : number | undefined){
    return  this.http.delete<MessageResponse<void>>(`${this.API}/${id}`);
  }
}

