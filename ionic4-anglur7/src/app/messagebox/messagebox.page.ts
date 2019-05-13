import { DatabaseService, Vis } from './../services/database.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import {LoadingController, NavController, ToastController} from '@ionic/angular';
import {AuthService} from '../auth.service';
import {finalize} from 'rxjs/operators';
import { Content } from '@angular/compiler/src/render3/r3_ast';

@Component({
  selector: 'app-messagebox',
  templateUrl: './messagebox.page.html',
  styleUrls: ['./messagebox.page.scss'],
})
export class MessageboxPage implements OnInit {

  userid: string;
  private readonly userid_key = "user";
  visitor: Vis = {
    id: 0,
    v_name: '',
    email: '',
    company: '',
    arrivaldate: '',
    cardnumber: '',
    img: ''
  };
  message: string = 'I am very busy now.';
  id: number;
  constructor(private route: ActivatedRoute, private db: DatabaseService, private router: Router, private toast: ToastController,
              private readonly navCtrl: NavController,
              private readonly loadingCtrl: LoadingController,
              private readonly authService: AuthService) { 
    this.id = this.route.snapshot.params['id'];
    this.db.getVisitor(this.id).then(data => {
      this.visitor = data;
      console.log(this.visitor);
    });
  }

  ngOnInit() {
    this.userid = localStorage.getItem(this.userid_key);
  }

  async send(value: any) {
    let message = {
      userid: this.userid,
      visitorid: this.visitor.id,
      content: this.message
    }
    const loading = await this.loadingCtrl.create({
      spinner: 'bubbles',
      message: 'Just a moment ...'
    });

    loading.present();

    this.authService
      .send(message)
      .pipe(finalize(() => loading.dismiss()))
      .subscribe(
        _ => {
          this.navCtrl.navigateRoot(['home'], {replaceUrl: true});
        },
        err => this.handleError(err));
  }

  async handleError(error: any) {
    let message: string;
    if (error.status && error.status === 401) {
      message = 'Sendding failed';
    } else {
      // message = `Unexpected error: ${error.statusText}`;
      message = 'Sendding failed';
    }

    const toast = await this.toast.create({
      message,
      duration: 5000,
      position: 'bottom'
    });

    toast.present();
  }

}
