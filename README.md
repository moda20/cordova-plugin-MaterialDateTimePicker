# Cordova FancyAlertPlugin

**Based On :** 
Material DateTime : https://github.com/wdullaer/MaterialDateTimePicker


**Cordova plugin : Material DateTime** 

Platforms available : **android**


***install :***

1 ) run `cordova plugin add https://github.com/moda20/cordova-plugin-MaterialDateTimePicker.git`

2 ) use directly from the `window` available `cordova` object.

# Usage

***Example :***

```Javascript
let DatePickerargs = {
            title: 'title',
            color: '#c60808',
            oktext: 'Ok', // OK button text
            canceltext: 'No', // Cancel button text
            mindate: '', // MUST BE IN dd-MM-yyyy format
            maxdate: '', // MUST BE IN dd-MM-yyyy format
            highlitedDates: ['', ''], // DATES MUST BE IN dd-MM-yyyy format
            showyearpickerbeforemonth: false,
            vibrateontouch: true,
            autodismiss: true, // DIsmiss when choosing a date automatically
        }

        let Timepickerargs = {
            title: 'title',
            color: '#c60808',
            oktext: '', // OK button text
            canceltext: '', // Cancel button text
            /*     mintime:'', // ARRAY of HOURS, MINUTES, SECONDS [23,12,44]
                 maxtime:'', // ARRAY of HOURS, MINUTES, SECONDS [23,12,44]*/
            enableSeconds: false,
            enableminute: true,
            vibrateontouch: true,
        }

        window.cordova.plugins.CordovaMaterialDateTime.TimePicker(Timepickerargs).then(
            function (res) {
                console.log(res);
            }
        ).catch(e => {
            console.log(e);
            alert("Errored")
        })
```
***Docs :***
```
The `CordovaMaterialDateTime` has only Two method : `TimePicker` and `DatePicker`.
```

# TimePicker
**The function arguments are a single object** 


| Attribute      | Description                                                                            | Type                        |
|----------------|----------------------------------------------------------------------------------------|-----------------------------|
| title          | a title to display on top of the  timepicker                                           | String                      |
| color          | the general color for the time picker. includes the circle headed arrow and the  title | String, ex :#c60808         |
| oktext         | The text for the OK button                                                             | String                      |
| canceltext     | the text for the cancel button                                                         | String                      |
| mintime        | an array of the minimum time possible to  pick : [hours,minutes,seconds]               | Array of Int, ex [23,12,44] |
| maxtime        | an array of the maximum time possible to  pick : [hours,minutes,seconds]               | Array of Int, ex [23,12,44] |
| enableSeconds  | whether to enable or disable the seconds  picker defaults to False                     | Boolean                     |
| enableminute   | whether to enable or disable the minutes  picker defaults to False                     | Boolean                     |
| vibrateontouch | Wether to vibrate when touching the time picker  or not                                | Boolean                     |
    

The `TimePicker` function returns a promise that resolves with the time chosen. 

# DatePicker
**The function arguments are a single object** 
| Attribute                 | Description                                                                            | Type                                                               |
|---------------------------|----------------------------------------------------------------------------------------|--------------------------------------------------------------------|
| title                     | a title to display on top of the  timepicker                                           | String                                                             |
| color                     | the general color for the time picker. includes the circle headed arrow and the  title | String, ex :#c60808                                                |
| oktext                    | The text for the OK button                                                             | String                                                             |
| canceltext                | the text for the cancel button                                                         | String                                                             |
| mindate                   | an array of the minimum time possible to  pick : [hours,minutes,seconds]               | String, must be date in the`dd-MM-yyyy` format                     |
| maxdate                   | an array of the maximum time possible to  pick : [hours,minutes,seconds]               | String,  must be date in the`dd-MM-yyyy` format                    |
| highlitedDates            | Dates that are highlighted in the calendar :                                           | Array of String,[] Strings must be date in the `dd-MM-yyyy` format |
| showyearpickerbeforemonth | whether to show the year picker before the month's                                     | Boolean                                                            |
| vibrateontouch            | whether to vibrate when touching the time picker  or not                               | Boolean                                                            |
| autodismiss               | whether to dismiss the datepicker automatically  when the user chooses a date          | Boolean                                                            |

The `DatePicker` function returns a promise that resolves with the chosen date. 

```
Plugin.xml :

You may have to change the com.android.support:appcompat-v7:27.1.1 to a certain version.
Note that this version needs to be unique with all components in your app, so make sure you have it fixed.

```

# ChangeLog
 
    
# Licence 

MIT
