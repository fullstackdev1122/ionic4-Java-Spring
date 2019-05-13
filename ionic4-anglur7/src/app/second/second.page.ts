import { Component, OnInit } from '@angular/core';

import { DatabaseService, Vis } from './../services/database.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastController } from '@ionic/angular';

@Component({
  selector: 'app-second',
  templateUrl: './second.page.html',
  styleUrls: ['./second.page.scss'],
})
export class SecondPage implements OnInit {

  // visitor: object = {
  //   v_name: '',
  //   email: '',
  //   company: '',
  //   arrivaldate: '',
  //   cardnumber: '',
  //   img: ''
  // };

  constructor(private route: ActivatedRoute, private db: DatabaseService) {
    this.info = this.route.snapshot.params['price'];
    this.data = JSON.parse(this.info);
    this.name = this.data['name'];
    this.email = this.data['email'];
    this.message = this.data['message'];
    this.visitors = this.data['visitors'];
    this.visitor_name = this.visitors.name;
    this.visitor_email = this.visitors.email;
    this.visitor_company = this.visitors.company;
    this.visitor_date = this.visitors.arrivalDate;
    this.visitor_cardnumber = this.visitors.cardnumber;
   }

  info: any = '';
  data: any;
  name: any = '';
  email: any = '';
  message: any = '';
  visitors: any;
  visitor_name: any = '';
  visitor_email: any = '';
  visitor_company: any = '';
  visitor_date: any = '';
  visitor_cardnumber: any = '';
  img: string = 'https://pbs.twimg.com/profile_images/858987821394210817/oMccbXv6_bigger.jpg';

  ngOnInit() {
  }

  addVisitor() {
    this.db.addVisitor(this.visitor_name, this.visitor_email ,this.visitor_company, this.visitor_date, this.visitor_cardnumber, this.img)
    .then(_ => {
      console.log("new date saved");
    });
  }


}
