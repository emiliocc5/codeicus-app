import { Component, OnInit } from '@angular/core';
import { Log } from '../model/log';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { LogService } from '../service/log.service';

@Component({
  selector: 'app-list-log',
  templateUrl: './list-log.component.html',
  styleUrls: ['./list-log.component.scss']
})
export class ListLogComponent implements OnInit {

  logs: Observable<Log[]>;

  constructor(private router: Router,private logservice: LogService ) { }

  ngOnInit() {
    this.listar();
  }

  listar(){
    this.logs= this.logservice.listarLogs(); 
  }
}
