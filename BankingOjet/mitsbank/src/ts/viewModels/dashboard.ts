/**
 * @license
 * Copyright (c) 2014, 2024, Oracle and/or its affiliates.
 * Licensed under The Universal Permissive License (UPL), Version 1.0
 * as shown at https://oss.oracle.com/licenses/upl/
 * @ignore
 */
import * as ko from 'knockout';
import * as AccUtils from '../accUtils';
import "oj-c/input-text";
import 'oj-c/input-password';
import 'oj-c/form-layout';

class DashboardViewModel {
  username: ko.Observable<string>;
  password: ko.Observable<string>;
  successMessage: ko.Observable<string>;
  errorMessage: ko.Observable<string>;

  constructor() {
    this.username = ko.observable('');
    this.password = ko.observable('');
    this.successMessage = ko.observable("");
    this.errorMessage = ko.observable("");
    // this.messages = ko.observableArray([]);
  }

  login(): void {
    const requestPayload = {
      customerLoginId: this.username(),
      customerPassword: this.password()
    };  
    console.log(JSON.stringify(requestPayload))

    fetch('http://localhost:8080/inb-api/login', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(requestPayload)
    })
    .then(response => {
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      return response.text();
    })
    .then((data) => {
      console.log(data)
      if (data.trim() === "login successfull") {
        this.successMessage("Login Successful");
        this.errorMessage(""); // Clear any previous error messages
        // window.location.href = "http://127.0.0.1:5501/customer_home_page/customer_home_page.html";
      } else {
        this.successMessage(""); // Clear any previous success messages
        this.errorMessage("Invalid username/password combination");
      }
    })
    .catch(error => {
      console.error('Error during login:', error);
      this.successMessage(""); // Clear any previous success messages
      this.errorMessage("An error occurred. Please try again.");
    });
  }
}

export = DashboardViewModel;
