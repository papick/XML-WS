import {Component,Input,OnInit } from '@angular/core';
import {NgbDateStruct,NgbDatepickerConfig} from '@ng-bootstrap/ng-bootstrap';

const equals = (one: NgbDateStruct, two: NgbDateStruct) =>
  one && two && two.year === one.year && two.month === one.month && two.day === one.day;

const before = (one: NgbDateStruct, two: NgbDateStruct) =>
  !one || !two ? false : one.year === two.year ? one.month === two.month ? one.day === two.day
    ? false : one.day < two.day : one.month < two.month : one.year < two.year;

const after = (one: NgbDateStruct, two: NgbDateStruct) =>
  !one || !two ? false : one.year === two.year ? one.month === two.month ? one.day === two.day
    ? false : one.day > two.day : one.month > two.month : one.year > two.year;

@Component({
  selector: 'datepicker',
  templateUrl: './datepicker.component.html',
  styleUrls: ['./datepicker.component.css'],
  providers: [NgbDatepickerConfig]
})
export class DatePickerComponent implements OnInit{

  hoveredDate: NgbDateStruct;

  fromDate: NgbDateStruct;
  toDate: NgbDateStruct;
  model;

  periods : any;
  constructor(private config: NgbDatepickerConfig) {

  }
    ngOnInit() {
      const minDate = new Date();
      this.config.minDate = {year: minDate.getFullYear(), month:minDate.getMonth(), day: minDate.getDay()};

      // days that don't belong to current month are not visible
      this.config.outsideDays = 'hidden';

      console.log(JSON.stringify(this.periods));
      this.config.markDisabled = (date: NgbDateStruct) => {
        let period : any;
        for( period in this.periods){
          const reservedFromDate = this.stringToDate(period.fromDate);
          const reservedToDate = this.stringToDate(period.toDate);
          if(date.year >= reservedFromDate.year && date.year <= reservedToDate.year
            && date.month >= reservedFromDate.month && date.month <= reservedToDate.month
            && date.day >= reservedFromDate.day && date.day <= reservedToDate.day
        ){
          return true;
        }
        return false;
        }
      };
    }

  onDateSelection(date: NgbDateStruct) {
    if (!this.fromDate && !this.toDate) {
      this.fromDate = date;
    } else if (this.fromDate && !this.toDate && after(date, this.fromDate)) {
      this.toDate = date;
    } else {
      this.toDate = null;
      this.fromDate = date;
    }
  }

  stringToDate(dateString)  {
    const splitted = dateString.split("/");
    const date =  {year: splitted[0], month:splitted[1], day:splitted[2]};
    return date;
  }


  isHovered = date => this.fromDate && !this.toDate && this.hoveredDate && after(date, this.fromDate) && before(date, this.hoveredDate);
  isInside = date => after(date, this.fromDate) && before(date, this.toDate);
  isFrom = date => equals(date, this.fromDate);
  isTo = date => equals(date, this.toDate);

}
