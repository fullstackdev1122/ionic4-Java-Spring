import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes, RouteReuseStrategy } from '@angular/router';
import { HomePage } from './home/home.page';
import { AuthGuard } from './auth.guard';
import { SignupPage } from './signup/signup.page';
import { LoginPage } from './login/login.page';
import { IonicRouteStrategy } from '@ionic/angular';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomePage, canActivate: [AuthGuard] },
  { path: 'second/:price', loadChildren: './second/second.module#SecondPageModule' },
  { path: 'signup', component: SignupPage },
  { path: 'login', component: LoginPage },
  { path: 'messagebox/:id', loadChildren: './messagebox/messagebox.module#MessageboxPageModule' },
  { path: '**', redirectTo: '/home'}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes,
       { preloadingStrategy: PreloadAllModules, useHash: true })
  ],
  providers: [
    {provide: RouteReuseStrategy, useClass: IonicRouteStrategy}
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
