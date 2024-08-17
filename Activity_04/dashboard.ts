import * as ko from "knockout";
import { whenDocumentReady } from "ojs/ojbootstrap";
import ArrayDataProvider = require("ojs/ojarraydataprovider");

import * as AccUtils from "../accUtils";

// import * as Bootstrap from "ojs/ojbootstrap";
import "oj-c/input-text";
import "ojs/ojknockout";
import "oj-c/input-number";
import 'oj-c/input-password';
import Message = require("ojs/ojmessaging");
import "oj-c/input-date-text";
import { ojMessage } from 'ojs/ojmessage';
import 'ojs/ojmessages';
import "oj-c/button";
import "ojs/ojtable";
import ModuleRouterAdapter = require("ojs/ojmodulerouter-adapter");
import UrlParamAdapter = require("ojs/ojurlparamadapter");
import * as ModuleAnimations from "ojs/ojmoduleanimations";
import "ojs/ojmodule-element";
import { ObservableKeySet } from "ojs/ojknockout-keyset";
import { KeySetImpl } from "ojs/ojkeyset";
import "ojs/ojknockout-keyset";
  import "ojs/ojknockout";
  import "ojs/ojlabel";
  import "oj-c/avatar";
  import "oj-c/list-item-layout";
  import "oj-c/list-view";
  import * as ModuleElementUtils from "ojs/ojmodule-element-utils";
  import "ojs/ojmodule-element";
  import "ojs/ojknockout";
  import "ojs/ojmodule";

  

  interface EmployeeData {
    id: number;
    name: string;
    title: string;
    image: string;
  }
class DashBoardViewModel {
  ModuleElementUtils;

  // firstname: ko.Observable<string> | ko.Observable<any>;
  // lastname: ko.Observable<string> | ko.Observable<any>;
  // salary: ko.Observable<string> | ko.Observable<any>;
  private readonly deptArray = JSON.parse('[{"DepartmentId" : 12 , "DepartmentName" : "OFSS(FlexCube)"}]');
  // value: ko.Observable<string>;
  // firstname: ko.Observable<string> | ko.Observable<any>;
  // salary: ko.Observable<number> | ko.Observable<any>;
  // password: ko.Observable<number> | ko.Observable<any>;
  // date: ko.Observable<Date> | ko.Observable<any>;
  readonly dataProvider = new ArrayDataProvider(this.deptArray, {
    keyAttributes: "DepartmentId",
    implicitSort: [{ attribute: "DepartmentId", direction: "ascending" }],
  });

  private readonly data: Array<EmployeeData> = [
    {
      id: 1,
      name: "Chris Black",
      title: "Oracle Cloud Infrastructure GTM Channel Director EMEA",
      image: "../images/hcm/placeholder-male-01.png",
    },
    {
      id: 2,
      name: "Christine Cooper",
      title: "Senior Principal Escalation Manager",
      image: "../images/hcm/placeholder-female-01.png",
    },
    {
      id: 3,
      name: "Chris Benalamore",
      title: "Area Business Operations Director EMEA & JAPAC",
      image: "../images/hcm/placeholder-male-03.png",
    },
    {
      id: 4,
      name: "Christopher Johnson",
      title: "Vice-President HCM Application Development",
      image: "../images/hcm/placeholder-male-04.png",
    },
    {
      id: 5,
      name: "Samire Christian",
      title: "Consulting Project Technical Manager",
      image: "../images/hcm/placeholder-male-05.png",
    },
    {
      id: 6,
      name: "Kurt Marchris",
      title: "Customer Service Analyst",
      image: "../images/hcm/placeholder-male-06.png",
    },
    {
      id: 7,
      name: "Zelda Christian Cooperman",
      title: "Senior Principal Escalation Manager",
      image: "../images/hcm/placeholder-female-02.png",
    },
  ];

  readonly selectedItems = new ObservableKeySet(); // observable bound to selection option to monitor current selections
  readonly selectedIds = ko.observable();

  getDisplayValue(set: KeySetImpl<number>) {
    return JSON.stringify(Array.from(set.values()));
  }

  // Current selection is already monitored through this.selectedItems observable.
  // To perform custom selection logic on selected elements and/or on current item, an option change callback can be used:
  handleSelectedChanged = (event: any) => {
    this.selectedIds(
      this.getDisplayValue(event.detail.value as KeySetImpl<number>)
    ); // show selected list item elements' ids
  };
  readonly listdataProvider = new ArrayDataProvider<
    EmployeeData["id"],
    EmployeeData
  >(this.data, { keyAttributes: "id" });

  constructor() {
    // this.value = ko.observable("Green");
    // initialization
    // this.firstname = ko.observable(null);
    // this.salary = ko.observable(null);
    // this.password = ko.observable(null);
    // this.date = ko.observable(null);
    this.ModuleElementUtils = ModuleElementUtils;
  }
  
}

//   public buttonAction = async(event:Event)=>{
//     let elementName = (event.currentTarget as HTMLElement).tagName;
//     // alert("You clicked on a button :" +elementName);
//     alert("Name = " +this.firstname() +", Salary ="+this.salary());
  
//     let id = parseInt(this.firstname());
//     let URL = "https://jsonplaceholder.typicode.com/users/"+id;
//     let res = await fetch(URL);
//     let jsonData = await res.json();
//     this.firstname(jsonData.name);
//     console.log(jsonData);
//   }

// constructor() {
//   // this.value = ko.observable("Green");
//   // initialization
//   // this.firstname = ko.observable(null);
//   // this.salary = ko.observable(null);
//   // this.password = ko.observable(null);
//   // this.date = ko.observable(null);
//   this.ModuleElementUtils = ModuleElementUtils;
// }

// public buttonAction = async(event:Event)=>{
//   let elementName = (event.currentTarget as HTMLElement).tagName;
//   // alert("You clicked on a button :" +elementName);
//   alert("Name = " +this.firstname() +", Salary ="+this.salary());

//   let id = parseInt(this.firstname());
//   let URL = "https://jsonplaceholder.typicode.com/users/"+id;
//   let res = await fetch(URL);
//   let jsonData = await res.json();
//   console.log(jsonData);
// } 
// }

  whenDocumentReady().then(function () {
    ko.applyBindings(new DashBoardViewModel(), document.getElementById("table"));
  });

  

export = DashBoardViewModel;