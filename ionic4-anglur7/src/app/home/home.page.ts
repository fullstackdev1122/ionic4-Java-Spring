import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AuthService} from '../auth.service';
import {JwtHelperService} from '@auth0/angular-jwt';
import {environment} from '../../environments/environment';

import { DatabaseService, Vis } from './../services/database.service';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastController } from '@ionic/angular';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss']
})
export class HomePage implements OnInit {

  private readonly jwtUsername = 'user';
  private readonly deviceId = 'device';

  user: string;
  message: string;

  visitors: Vis[] = [];
  visitor = {};

  constructor(private readonly authService: AuthService,
              jwtHelper: JwtHelperService,
              private readonly httpClient: HttpClient,
              private route: ActivatedRoute, private db: DatabaseService, private router: Router, private toast: ToastController) {

    this.authService.authUserObservable.subscribe(jwt => {
      if (jwt) {
        const decoded = jwtHelper.decodeToken(jwt);
        this.user = decoded.sub;
      } else {
        this.user = null;
      }
    });
  }

  ngOnInit() {
    this.db.getDatabaseState().subscribe(rdy => {
      if (rdy) {
        this.db.getViss().subscribe(viss => {
          this.visitors = viss;
        })
      }
    });
  }

  delete(id: number) {
    this.db.deleteVisitor(id).then(() => {
      this.router.navigateByUrl('/');
    });
  }

  logout() {
    this.authService.logout();
  }

}
