import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  imports: [FormsModule],
  selector: 'app-my-component',
  styleUrl: './my-component.css',
  templateUrl: './my-component.html',
})
export class MyComponent {
showMessage() {
alert("Event Binding tested");
}

 appName= 'Interview Happy';

 username:string = "Karthik"; 

imageUrl='https://www.imagemine.com/tyhjeps';
}
