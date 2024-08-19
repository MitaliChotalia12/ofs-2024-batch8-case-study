/**
 * @license
 * Copyright (c) 2014, 2024, Oracle and/or its affiliates.
 * Licensed under The Universal Permissive License (UPL), Version 1.0
 * as shown at https://oss.oracle.com/licenses/upl/
 * @ignore
 */
import * as AccUtils from "../accUtils";
import * as ko from "knockout";
import "oj-c/input-text";
import "ojs/ojknockout";
import "oj-c/input-number";
import "oj-c/input-password";
import "oj-c/button";
import * as Bootstrap from 'ojs/ojbootstrap';


class IncidentsViewModel {
  name: ko.Observable<string> | ko.Observable<any>;
  email: ko.Observable<string> | ko.Observable<any>;
  mobileno: ko.Observable<string> | ko.Observable<any>;
  address: ko.Observable<string> | ko.Observable<any>;
  state: ko.Observable<string> | ko.Observable<any>;
  country: ko.Observable<string> | ko.Observable<any>;
  username: ko.Observable<string> | ko.Observable<any>;
  password: ko.Observable<string> | ko.Observable<any>;
  successMessage: ko.Observable<string>;
  errorMessage: ko.Observable<string>;

  constructor() {
    this.name = ko.observable(null);
    this.email = ko.observable(null);
    this.mobileno = ko.observable(null);
    this.address = ko.observable(null);
    this.state = ko.observable(null);
    this.country = ko.observable(null);
    this.username = ko.observable(null);
    this.password = ko.observable(null);
    this.successMessage = ko.observable("");
    this.errorMessage = ko.observable("");
  }

  register(): void {
    const requestPayload = {
      customerName: this.name(),
      customer_email: this.email(),
      customerLoginId: this.username(),
      customerPassword: this.password(),
      customerPhone: this.mobileno(),
      customerAddress: this.address(),
      customerState: this.state(),
      customerCountry: this.country()
    };  
    console.log(JSON.stringify(requestPayload))

    fetch('http://localhost:8080/inb-api/register', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(requestPayload)
    })
    .then(response => {
      // console.log(response.json())
      // if (!response.ok) {
      //   throw new Error('Network response was not ok');
      // }
      return response.json();
    })
    .then((data) => {
      console.log("Register Successful")
      // if (data.trim() === "login successfull") {
        this.successMessage("Login Successful");
        this.errorMessage(""); // Clear any previous error messages
        window.location.href = "http://localhost:8000/?ojr=dashboard";
      // } else {
      //   this.successMessage(""); // Clear any previous success messages
      //   this.errorMessage("Invalid username/password combination");
      // }
    })
    .catch(error => {
      console.error('Error during Registration', error);
      this.successMessage(""); // Clear any previous success messages
      this.errorMessage("An error occurred. Please try again.");
    });
  }

}

Bootstrap.whenDocumentReady().then(() => {
  ko.applyBindings(new IncidentsViewModel(), document.getElementById('login-container'));
});

export = IncidentsViewModel;
