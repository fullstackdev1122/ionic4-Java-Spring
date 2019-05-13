import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouteReuseStrategy } from '@angular/router';

import { IonicModule, IonicRouteStrategy } from '@ionic/angular';
import { SplashScreen } from '@ionic-native/splash-screen/ngx';
import { StatusBar } from '@ionic-native/status-bar/ngx';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';

import { FCM } from '@ionic-native/fcm/ngx';
import {FormsModule} from '@angular/forms';
import { HomePage } from './home/home.page';
import { LoginPage } from './login/login.page';
import { SignupPage } from './signup/signup.page';
import { CommonModule } from '@angular/common';
import {HttpClientModule} from '@angular/common/http';
import {JwtModule} from '@auth0/angular-jwt';
import {environment} from '../environments/environment';

import { SQLitePorter } from '@ionic-native/sqlite-porter/ngx';
import { SQLite } from '@ionic-native/sqlite/ngx';

export function tokenGetter() {
  return localStorage.getItem('jwt_token');
}

@NgModule({
  declarations: [
    AppComponent,
    HomePage,
    LoginPage,
    SignupPage
  ],
  entryComponents: [],
  imports: [
    BrowserModule,
    CommonModule,
    HttpClientModule, 
    JwtModule.forRoot({
      config: {
        tokenGetter: tokenGetter,
        whitelistedDomains: environment.whitelistedDomains
      }
    }),
    FormsModule,
    IonicModule.forRoot(), 
    AppRoutingModule
  ],
  providers: [
    StatusBar,
    SplashScreen,
    FCM,
    SQLite,
    SQLitePorter,
    { provide: RouteReuseStrategy, useClass: IonicRouteStrategy }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {}
