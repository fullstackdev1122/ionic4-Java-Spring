import { Platform } from '@ionic/angular';
import { Injectable } from '@angular/core';
import { SQLitePorter } from '@ionic-native/sqlite-porter/ngx';
import { HttpClient } from '@angular/common/http';
import { SQLite, SQLiteObject } from '@ionic-native/sqlite/ngx';
import { BehaviorSubject, Observable } from 'rxjs';
 
export interface Vis {
  id: number,
  v_name: string,
  email: string,
  company: string,
  arrivaldate: string,
  cardnumber: string,
  img: string
}
 
@Injectable({
  providedIn: 'root'
})
export class DatabaseService {
  private database: SQLiteObject;
  private dbReady: BehaviorSubject<boolean> = new BehaviorSubject(false);
 
  visitors = new BehaviorSubject([]);
 
  constructor(private plt: Platform, private sqlitePorter: SQLitePorter, private sqlite: SQLite, private http: HttpClient) {
    this.plt.ready().then(() => {
      this.sqlite.create({
        name: 'visitors.db',
        location: 'default'
      })
      .then((db: SQLiteObject) => {
          this.database = db;
          this.seedDatabase();
      });
    });
  }
 
  seedDatabase() {
    this.http.get('assets/seed.sql', { responseType: 'text'})
    .subscribe(sql => {
      this.sqlitePorter.importSqlToDb(this.database, sql)
        .then(_ => {
          this.loadVisitors();
          this.dbReady.next(true);
        })
        .catch(e => console.error(e));
    });
  }
 
  getDatabaseState() {
    return this.dbReady.asObservable();
  }
 
  getViss(): Observable<Vis[]> {
    return this.visitors.asObservable();
  }

  loadVisitors() {
    return this.database.executeSql('SELECT * FROM visitor', []).then(data => {
      let visitors: Vis[] = [];
 
      if (data.rows.length > 0) {
        for (var i = 0; i < data.rows.length; i++) {
          visitors.push({ 
            id: data.rows.item(i).id,
            v_name: data.rows.item(i).v_name, 
            email: data.rows.item(i).email,
            company: data.rows.item(i).company,  
            arrivaldate: data.rows.item(i).arrivaldate,
            cardnumber: data.rows.item(i).cardnumber,  
            img: data.rows.item(i).img
           });
        }
      }
      this.visitors.next(visitors);
    });
  }
 
  addVisitor(v_name, email, company, arrivaldate, cardnumber, img) {
    let data = [v_name, email, company, arrivaldate, cardnumber, img];
    return this.database.executeSql('INSERT INTO visitor (v_name, email, company, arrivaldate, cardnumber, img) VALUES (?, ?, ?, ?, ?, ?)', data).then(data => {
      this.loadVisitors();
    });
  }
 
  getVisitor(id): Promise<Vis> {
    return this.database.executeSql('SELECT * FROM visitor WHERE id = ?', [id]).then(data => {
      return {
        id: data.rows.item(0).id,
        v_name: data.rows.item(0).v_name, 
        email: data.rows.item(0).email, 
        company: data.rows.item(0).company, 
        arrivaldate: data.rows.item(0).arrivaldate, 
        cardnumber: data.rows.item(0).cardnumber, 
        img: data.rows.item(0).img
      }
    });
  }
 
  deleteVisitor(id) {
    return this.database.executeSql('DELETE FROM visitor WHERE id = ?', [id]).then(_ => {
      this.loadVisitors();
    });
  }
 
  updateVisitor(vis: Vis) {
    let data = [vis.v_name, vis.email, vis.company, vis.arrivaldate, vis.cardnumber, vis.img];
    return this.database.executeSql(`UPDATE visitor SET v_name = ?, email = ?, company = ?, arrivaldate = ?, cardnumber = ?, img = ? WHERE id = ${vis.id}`, data).then(data => {
      this.loadVisitors();
    })
  }
}