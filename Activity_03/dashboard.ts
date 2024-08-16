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
import "oj-c/button";
import Message = require("ojs/ojmessaging");
import "oj-c/input-date-text";
import "oj-c/button";
import 'oj-c/message-banner';
import 'ojs/ojformlayout';
import MutableArrayDataProvider = require("ojs/ojmutablearraydataprovider");
import { CMessageBannerElement, MessageBannerItem } from "oj-c/message-banner";
import "oj-c/progress-bar";

type DemoMessageBannerItem = MessageBannerItem & {
  id: string;
};

class DashboardViewModel {

  value: ko.Observable<string>;
  firstname: ko.Observable<string> | ko.Observable<any>;
  salary: ko.Observable<number> | ko.Observable<any>;
  password: ko.Observable<number> | ko.Observable<any>;
  date: ko.Observable<Date> | ko.Observable<any>;
  button2Text: string;
  activatedButton: ko.Observable<string>;

  readonly personalInformationMessages: MutableArrayDataProvider<string, DemoMessageBannerItem>;
  private counter: number;

  readonly closePersonalInformationMessage = (
    event: CMessageBannerElement.ojClose<string, DemoMessageBannerItem>
  ) => {
    // remove the message from the data to close it
    let data = this.personalInformationMessages.data.slice();
    const closeMessageKey = event.detail.key;

    data = data.filter((message) => (message as any).id !== closeMessageKey);
    this.personalInformationMessages.data = data;
  };

  readonly updatePersonalInfo = () => {
    // remove the message from the data to close it
    let data = this.personalInformationMessages.data.slice();
    data.push({
      id: `message-${++this.counter}`,
      severity: 'confirmation',
      summary: 'Updated personal information',
      detail: 'The provided personal information of the employee has been updated in the database.'
    });
    this.personalInformationMessages.data = data;
  };
  private readonly step = ko.observable(0);
  readonly progressValue = ko.pureComputed(() => {
    return Math.min(this.step(), 100);
  });
    constructor() {
      window.setInterval(() => {
        this.step((this.step() + 1) % 200);
      }, 10);
      this.value = ko.observable("Green");
      //initialization
      this.firstname = ko.observable(null);
      this.salary = ko.observable(null);
      this.password = ko.observable(null);
      this.date = ko.observable(null);
      this.button2Text = "Button Text 2";
      this.activatedButton = ko.observable("(None activated yet)");

      const initialPersonalSectionData = [
        {
          id: 'message',
          severity: 'confirmation',
          summary: 'Updated personal information',
          detail:
            'The provided personal information of the employee has been updated in the database.',
          timestamp: new Date().toISOString()
        }
      ];
      this.personalInformationMessages = new MutableArrayDataProvider(initialPersonalSectionData, {
        keyAttributes: 'id'
      });
      this.counter = 0;
    }

    
    public buttonAction = (event: Event) => {
      this.activatedButton((event.currentTarget as HTMLElement).id);
      return true;
    };
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
