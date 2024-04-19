import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../services/authentification.service'; // Adjust the path as necessary
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  loginObj : any = {
    "email": "",
    "password": ""
  }
  constructor(private http: HttpClient, private router: Router){

  }

  onLogin() {
    this.http.post('https://freeapi.miniprojectideas.com/api/User/Login', this.loginObj)
      .subscribe((res:any) => {
        if(res.result){
          localStorage.setItem('loginToken', res.data.token);
          alert('login success');
          this.router.navigateByUrl
        } else {
          alert(res.message);
        }
      });
  }
}
