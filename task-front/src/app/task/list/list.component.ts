import { Component, OnInit, inject } from '@angular/core';
import { Task } from '../../models/task';
import { TaskService } from '../services/task.service';
import { RouterModule } from '@angular/router';
import { MessageResponse } from '../../models/response';
import { Observable, map } from 'rxjs';
import { AsyncPipe } from '@angular/common';

@Component({
  selector: 'app-list',
  standalone: true,
  imports: [RouterModule, AsyncPipe],
  templateUrl: './list.component.html',
  styleUrl: './list.component.css'
})
export class ListComponent implements OnInit {

  public tasks !: Observable<Task[]>;
  private _taskSVC = inject(TaskService);



  ngOnInit(): void {
    this.getTasks()
  }

  private getTasks(){
   this.tasks =  this._taskSVC.getAll().pipe(
      map(response => response.data)
    )
   
  }
  
  public deleteTask(id : number | undefined){
    this._taskSVC.delete(id).subscribe(r=>this.getTasks())
  } 



}
