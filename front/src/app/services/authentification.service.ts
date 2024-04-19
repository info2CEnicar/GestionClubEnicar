import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private http: HttpClient, private router: Router) {}

  loginUser(email: string, password: string): Observable<any> {
    return this.http.post<any>('http://localhost:8080/auth/login', { email, password });
  }

  handleAuthentication(userType: string): void {
    if (userType === 'Admin') {
      this.router.navigate(['/admin']);
    } else if (userType === 'ResponsableClub') {
      this.router.navigate(['/responsable']);
    } else {
      alert('Unauthorized access');
    }
  }
}
