/**
 * @license
 * Copyright (c) 2014, 2024, Oracle and/or its affiliates.
 * Licensed under The Universal Permissive License (UPL), Version 1.0
 * as shown at https://oss.oracle.com/licenses/upl/
 * @ignore
 */
import * as AccUtils from "../accUtils";
import * as ko from "knockout";
// import * as Bootstrap from "ojs/ojbootstrap";
import "oj-c/input-text";
import "ojs/ojknockout";
import "oj-c/input-number";
import 'oj-c/input-password';
import Message = require("ojs/ojmessaging");
import "oj-c/input-date-text";
class DashboardViewModel {

  value: ko.Observable<string>;
  firstname: ko.Observable<string> | ko.Observable<any>;
  salary: ko.Observable<number> | ko.Observable<any>;
  password: ko.Observable<number> | ko.Observable<any>;
  date: ko.Observable<Date> | ko.Observable<any>;
  
    constructor() {
      this.value = ko.observable("Green");
      //initialization
      this.firstname = ko.observable(null);
      this.salary = ko.observable(null);
      this.password = ko.observable(null);
      this.date = ko.observable(null);
    }

  // constructor() {

  // }

  /**
   * Optional ViewModel method invoked after the View is inserted into the
   * document DOM.  The application can put logic that requires the DOM being
   * attached here.
   * This method might be called multiple times - after the View is created
   * and inserted into the DOM and after the View is reconnected
   * after being disconnected.
   */
  // connected(): void {
  //   AccUtils.announce("Dashboard page loaded.");
  //   document.title = "Dashboard";
  //   // implement further logic if needed
  // }

  /**
   * Optional ViewModel method invoked after the View is disconnected from the DOM.
   */
  // disconnected(): void {
  //   // implement if needed
  // }

  /**
   * Optional ViewModel method invoked after transition to the new View is complete.
   * That includes any possible animation between the old and the new View.
   */
  // transitionCompleted(): void {
  //   // implement if needed
  // }
}

export = DashboardViewModel;
