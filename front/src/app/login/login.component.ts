import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { jwtDecode } from 'jwt-decode';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  loginForm: FormGroup;
  loginObj: any = {  // Define loginObj here
    email: '',
    password: ''
  };
  constructor(
    private fb: FormBuilder,
    private http: HttpClient,
    private router: Router
  ) {
    this.loginForm = this.fb.group({
      emailId: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });
  }

  onLogin() {
    if (this.loginForm.valid) {
      this.http.post('http://localhost:8080/auth/login', this.loginForm.value)
        .subscribe((res: any) => {
          if (res.result) {
            localStorage.setItem('loginToken', res.data.token);
            this.handleRedirection(res.data.token);
          } else {
            alert(res.message);
          }
        }, error => {
          alert('Login failed: ' + error.error.message);
        });
    } else {
      alert('Please enter valid email and password.');
    }
  }

  private handleRedirection(token: string) {
    try {
      const decodedToken = jwtDecode<any>(token);  // Use the imported jwt_decode function
      switch (decodedToken.role) {
        case 'Admin':
          this.router.navigateByUrl('/administration'); // Admin dashboard route
          break;
        case 'ResponsableClub':
          this.router.navigateByUrl('/organisation'); // ResponsableClub dashboard route
          break;
        default:
          this.router.navigateByUrl('/login'); // Redirect back to login or a default route
          alert('Unauthorized role');
          break;
      }
    } catch (error) {
      console.error('Error decoding token', error);
      this.router.navigateByUrl('/login');
    }
  }
}
