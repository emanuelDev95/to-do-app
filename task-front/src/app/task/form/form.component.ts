import { Component, Inject, OnInit, inject } from '@angular/core';
import { StatusService } from '../services/status.service';
import { TaskService } from '../services/task.service';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { JsonPipe, Location } from '@angular/common';
import { Status, Task } from '../../models/task';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-form',
  standalone: true,
  imports: [  ReactiveFormsModule, FormsModule, JsonPipe],
  templateUrl: './form.component.html',
  styleUrl: './form.component.css'
})
export class FormComponent implements OnInit {

  private _statusSVC = inject(StatusService);
  private _taskSVC = inject(TaskService);
  private fb = inject(FormBuilder);
  private location = inject(Location);
  private activatedRoute = inject(ActivatedRoute);
  private idTask !: number;

  public formTask !: FormGroup;
  public statuses !: Status[];

  ngOnInit(): void {

    this.buildForm()
    this.getAllStatus()
    this.activatedRoute.params.subscribe(params=>{
      this.idTask = params['id']
    })

    if(this.idTask){
      this.prepareForm();
    }
  }

  private buildForm(){

    this.formTask = this.fb.group({
      title:['',[Validators.required,Validators.pattern('^[a-zA-Z]+$')]],
      description:['',[Validators.required,Validators.pattern('^[a-zA-Z]+$')]],
      due:['',[Validators.required]],
      status:['',[Validators.required]]
    })

  }

  private getAllStatus(){

    this._statusSVC.getAll()
    .subscribe(r => this.statuses = r.data)

  }

  private prepareForm(){

    

    this._taskSVC.get(this.idTask).subscribe(value=>{
 
      const due = this.getDate(value.data.due)
      console.log(due)
      this.title.setValue(value.data.title);
      this.description.setValue(value.data.description)
      this.due.setValue(due)
      this.status.setValue(value.data.status.id)
    })

  }

  getDate(date : string){
    const dateTs = Date.parse(date)
    const fecha = new Date(dateTs)
    const anio = fecha.getFullYear();
    const mes = fecha.getMonth() + 1; // Los meses son base 0, por lo que sumamos 1
    let mesStr = this.formatNumberLessThanTen(mes)
    const dia = this.formatNumberLessThanTen(fecha.getDate())
    const fechaFormateada = `${anio}-${mesStr}-${dia}`;
    console.log(fechaFormateada)
    return fechaFormateada
    
  }

  private formatNumberLessThanTen(number: number){
    let numberStr = number.toString();
    if(number<10)numberStr = `0${number}`
    return numberStr
  
  }



  

  public registerTask(){
    const task = this.prepareData();

    console.log(task)

    if(this.idTask) this._taskSVC.update(this.idTask, task).subscribe(console.log);
    else this._taskSVC.save(task).subscribe(console.log)
    this.location.back()
  }



  private prepareData() : Task {
    var task : Task = {
      title : this.title.value,
      description: this.description.value,
      due: this.due.value,
      status : {
        id: this.status.value
      }
    }

    return task;
  }



  get title(){
    return this.formTask.controls['title'];
  }

  get description(){
    return this.formTask.controls['description'];
  }


  get due(){
    return this.formTask.controls['due'];
  }


  get status(){
    return this.formTask.controls['status'];
  }


}
