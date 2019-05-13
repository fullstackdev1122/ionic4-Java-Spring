import { Injectable } from '@angular/core';
import {Observable, ReplaySubject, BehaviorSubject} from 'rxjs';
import {HttpClient, HttpErrorResponse } from '@angular/common/http';
import {JwtHelperService} from '@auth0/angular-jwt';
import {tap} from 'rxjs/operators';
import {environment} from '../environments/environment';
import {NavController} from '@ionic/angular';

export class Response {
  token: string;
  userid: string;
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private readonly jwtTokenName = 'jwt_token';
  private readonly deviceid = "device";
  private readonly userid = "user";
  
  public username: string;

  private authUser = new ReplaySubject<any>(1);
  public authUserObservable = this.authUser.asObservable();

  constructor(private readonly httpClient: HttpClient,
              private readonly navCtrl: NavController,
              private readonly jwtHelper: JwtHelperService) {
  }

  hasAccess(): Promise<boolean> {
    const jwt = localStorage.getItem(this.jwtTokenName);

    if (jwt && !this.jwtHelper.isTokenExpired(jwt)) {

      return new Promise((resolve, _) => {

        this.httpClient.get(`${environment.serverURL}/authenticate`)
          .subscribe(() => {
              this.authUser.next(jwt);
              resolve(true);
            },
            err => {
              this.logout();
              resolve(false);
            });
      });

      // OR
      // this.authUser.next(jwt);
      // Promise.resolve(true);
    } else {
      this.logout();
      return Promise.resolve(false);
    }
  }

  login(values: any): Observable<string> {
    this.username = values.username;
    return this.httpClient.post(`${environment.serverURL}/login`, values, {responseType: 'text'})
      .pipe(tap(jwt => this.handleJwtResponse(jwt)));
  }

  send(values: any): Observable<string> {
    return this.httpClient.post(`${environment.serverURL}/send`, values, {responseType: 'text'})
      .pipe(tap(res => this.responseMessage(res)));
  }

  responseMessage(res: any): string {
    return res;
  }

  logout() {
    localStorage.removeItem(this.jwtTokenName);
    this.authUser.next(null);
    this.navCtrl.navigateRoot('login', {replaceUrl: true});
  }

  signup(values: any): Observable<string> {
    this.username = values.username;
    return this.httpClient.post(`${environment.serverURL}/signup`, values, {responseType: 'text'})
      .pipe(tap(jwt => {
        if (jwt !== 'EXISTS') {
          return this.handleJwtResponse(jwt);
        }
        return jwt;
      }));
  }

  private handleJwtResponse(jwt: string): string {
    localStorage.setItem(this.jwtTokenName, jwt);
    localStorage.setItem(this.userid, this.username);
    let deviceid = localStorage.getItem(this.deviceid);
    let value = {
      userid: this.username,
      deviceid: deviceid
    }
    this.httpClient.post(`${environment.serverURL}/register/`, value, {responseType: 'text'}).subscribe(
      err => console.log(err)
    );

    this.authUser.next(jwt);
    
    return jwt;
  }
}
