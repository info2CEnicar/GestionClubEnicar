import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CrudService } from '../Services/crud.service';
import { NgToastService } from 'ng-angular-popup';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  formModel={
    userName: '',
    password: ''
  }
  constructor(
    private services: CrudService ,
    private router: Router,
    private fb: FormBuilder,
  ) {

  }
  onSubmit(form: NgForm) {
    // Check if the form is valid
    if (form.valid) {
      console.log(form.value); // Check if the data is submitted correctly
      this.services.login(form.value.userName).subscribe(
        (res: any) => {
          // Check if the response contains a token
          if (res.token) {
            localStorage.setItem('token', res.token);
            this.router.navigateByUrl('/accueil');
          } else {
            // If the response does not contain a token, display an error
            console.log("Invalid response from server");
            alert('Invalid response from server');
          }
        },
        (err: any) => {
          console.log(err); // Log the error in the console
          alert('Veuillez vérifier vos coordonnées!');
        }
      );
    } else {
      // If the form is invalid, display an error message
      alert('Please fill in both username/email and password fields correctly');
    }
  }




 /* loginOrg() {
    let data = this.loginForm.value;
    console.log(data);
    let org = new Organisation(
      undefined,undefined, undefined,undefined,undefined, undefined, data.email,data.mdp, undefined,undefined, undefined);
    console.log(Organisation);
    if(

      data.email == 0 ||
      data.mdp == 0
    )
    {
      this.toast.info({
        detail: 'Error Message',
        summary: 'Remplir votre champs',
      });
    }else{
    this.services['loginOrg'](org).subscribe(

      res=>{
        console.log(res);
        let token = res.token;
        localStorage.setItem('mytoken', token);
        this.router.navigate(['accueil']);
        this.toast.success({
          detail: 'Succes Message',
          summary: 'Bienvenue',
        });

        this.router.navigate(['/accueil']);
      },
      err=>{
        console.log(err);
        this.toast.error({
          detail: 'Error Message',
          summary: 'Probléme de Serveur',
        });
      }

    )}}*/

  ngOnInit(): void {
  }

}
