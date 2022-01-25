import { Injectable } from '@angular/core';
 
import { HttpClient } from '@angular/common/http';
 
import 'rxjs/add/operator/map';
 
import 'rxjs/add/operator/catch';
 
import { Observable } from 'rxjs/Observable';
 import {Employee} from './employee';

 
@Injectable()
export class AppService {
  constructor(private http: HttpClient) { }
 
getFeatures(): Observable<Employee[]> {
  try {
    return this.http.get('http://localhost:8080/employee/getEmployees') .map(res=>res) ;
  }catch (error) { 
    console.log(error);
  }  
}
saveFeature(model:Employee):Observable<any>{
try {
    return this.http.post('http://localhost:8080/employee/insertData', model) .map(res=>res) ;
  }catch (error) { 
    console.log(error);
  }  
}
getEmployee(id: number): Observable<Employee>{
  try {
    return this.http.get('http://localhost:8080/employee/getEmployee/'+id) .map(res=>res) ;
  }catch (error) { 
    console.log(error);
  } 
}

updateWorkDays(id, wDays): Observable<any>{
  try {
    return this.http.get('http://localhost:8080/employee/updateWorkDays/'+id+'/'+wDays) .map(res=>res) ;
  }catch (error) { 
    console.log(error);
  } 
}
updateVacationDays(id, vDays): Observable<any>{
  try {
    return this.http.get('http://localhost:8080/employee/updateVacationDays/'+id+'/'+vDays) .map(res=>res) ;
  }catch (error) { 
    console.log(error);
  } 
}
}
