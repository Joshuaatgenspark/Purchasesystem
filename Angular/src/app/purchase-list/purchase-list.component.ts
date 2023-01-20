import { Component, OnInit } from '@angular/core';
import { PurchaseService } from '../purchase.service';
import { Purchase } from '../purchase';
import { Observable, Subject } from 'rxjs';

import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-purchase-list',
  templateUrl: './purchase-list.component.html',
  styleUrls: ['./purchase-list.component.css']
})
export class PurchaseListComponent implements OnInit {

 constructor(private purchaseservice: PurchaseService) { }

  get PurchaseName() {
    return this.purchaseupdateform.get('purchase_name');
  }

  get PurchaseEmail() {
    return this.purchaseupdateform.get('purchase_email');
  }

  get PurchaseBranch() {
    return this.purchaseupdateform.get('purchase_branch');
  }

  get PurchaseId() {
    return this.purchaseupdateform.get('purchase_id');
  }

  purchasesArray: any[] = [];
  dtOptions: DataTables.Settings = {};
  dtTrigger: Subject<any> = new Subject();


  purchases: Observable<Purchase[]>;
  purchase: Purchase = new Purchase();
  deleteMessage = false;
  purchaselist: any;
  isupdated = false;

  purchaseupdateform = new FormGroup({
    purchase_id: new FormControl(),
    purchase_name: new FormControl(),
    purchase_email: new FormControl(),
    purchase_branch: new FormControl()
  });


  ngOnInit() {
    this.isupdated = false;
    this.dtOptions = {
      pageLength: 6,
      stateSave: true,
      lengthMenu: [[6, 16, 20, -1], [6, 16, 20, 'All']],
      processing: true
    };
    this.purchaseservice.getPurchaseList().subscribe(data => {
    this.purchases = data;
    this.dtTrigger.next();
    });
  }

  deletePurchase(id: number) {
    this.purchaseservice.deletePurchase(id)
      .subscribe(
        data => {
          console.log(data);
          this.deleteMessage = true;
          this.purchaseservice.getPurchaseList().subscribe(data => {
            this.purchases = data;
            });
        },
        error => console.log(error));
  }


  updatePurchase(id: number) {
    this.purchaseservice.getPurchase(id)
      .subscribe(
        data => {
          this.purchaselist = data;
        },
        error => console.log(error));
  }

  updateStu(updstu) {
    this.purchase = new Purchase();
    this.purchase.purchase_id = this.PurchaseId.value;
    this.purchase.purchase_name = this.PurchaseName.value;
    this.purchase.purchase_email = this.PurchaseEmail.value;
    this.purchase.purchase_branch = this.PurchaseBranch.value;
    console.log(this.PurchaseBranch.value);


    this.purchaseservice.updatePurchase(this.purchase.purchase_id, this.purchase).subscribe(
    data => {
      this.isupdated = true;
      this.purchaseservice.getPurchaseList().subscribe(data => {
        this.purchases = data;
        });
    },
    error => console.log(error));
  }

  changeisUpdate() {
    this.isupdated = false;
  }
}
