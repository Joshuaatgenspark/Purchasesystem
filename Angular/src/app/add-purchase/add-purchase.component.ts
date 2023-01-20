import { Component, OnInit } from '@angular/core';
import { PurchaseService } from '../purchase.service';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import { Purchase } from '../purchase';
@Component({
  selector: 'app-add-purchase',
  templateUrl: './add-purchase.component.html',
  styleUrls: ['./add-purchase.component.css']
})
export class AddPurchaseComponent implements OnInit {

  constructor(private purchaseservice: PurchaseService) { }

  get PurchaseName() {
    return this.purchasesaveform.get('purchase_name');
  }

  get PurchaseEmail() {
    return this.purchasesaveform.get('purchase_email');
  }

  get PurchaseBranch() {
    return this.purchasesaveform.get('purchase_branch');
  }

  purchase: Purchase = new Purchase();
  submitted = false;

  purchasesaveform = new FormGroup({
    purchase_name: new FormControl('' , [Validators.required , Validators.minLength(5) ] ),
    purchase_email: new FormControl('', [Validators.required, Validators.email]),
    purchase_branch: new FormControl()
  });

  ngOnInit() {
    this.submitted = false;
  }

  savePurchase(savePurchase) {
    this.purchase = new Purchase();
    this.purchase.purchase_name = this.PurchaseName.value;
    this.purchase.purchase_email = this.PurchaseEmail.value;
    this.purchase.purchase_branch = this.PurchaseBranch.value;
    this.submitted = true;
    this.save();
  }



  save() {
    this.purchaseservice.createPurchase(this.purchase)
      .subscribe(data => console.log(data), error => console.log(error));
    this.purchase = new Purchase();
  }

  addPurchaseForm() {
    this.submitted = false;
    this.purchasesaveform.reset();
  }
}
