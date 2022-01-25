import { Component } from '@angular/core';
import {AppService} from './app.service';
import {Employee} from './employee';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Feature Request';  
  results : any;
  model= new Employee();
  wDays:number;
  vDays:number;
  message :any;
  constructor(public appService : AppService ){
    this.getFeatures();
  }
  
  getFeatures(){
    this.appService.getFeatures().subscribe(res=>{
      this.results = res;
     // console.log(this.results);
    });
  }
  getEmployee(id){
    this.appService.getEmployee(id).subscribe(res=>{
      this.model = res;
    });
  }
  updateWorkDays(id){
    this.appService.updateWorkDays(id,this.wDays).subscribe(res=>{
      this.message = res;
      this.getFeatures();
    });
  }
  updateVacationDays(id){
    this.appService.updateVacationDays(id,this.vDays).subscribe(res=>{
      this.message = res;
      this.getFeatures();
    });
  }
}
