package cordova.plugin.materialdatetime;

import android.util.Log;
import android.widget.DatePicker;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;
import com.wdullaer.materialdatetimepicker.time.Timepoint;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
/**
 * This class echoes a string called from JavaScript.
 */
public class CordovaMaterialDateTime extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("datepicker")) {
            String title = args.getString(0);
            String color = args.getString(1);
            String oktext = args.getString(2);
            String canceltext = args.getString(3);
            String mindate = args.getString(4);
            String maxdate = args.getString(5);
            JSONArray highlitedDates = args.getJSONArray(6);
            Boolean showyearpickerbeforemonth = args.getBoolean(7);
            Boolean vibrateontouch = args.getBoolean(8);
            Boolean autodismiss = args.getBoolean(9);

            this.coolMethod(title, color, oktext, canceltext, mindate, maxdate, highlitedDates, showyearpickerbeforemonth, vibrateontouch, autodismiss,  callbackContext);
            return true;
        }else{
            if (action.equals("timepicker")){
                String title = args.getString(0);
                String color = args.getString(1);
                String oktext = args.getString(2);
                String canceltext = args.getString(3);
                JSONArray mintime = args.getJSONArray(4);
                JSONArray maxtime = args.getJSONArray(5);
                Boolean enableSeconds = args.getBoolean(6);
                Boolean enableminutes = args.getBoolean(7);
                Boolean vibrateontouch = args.getBoolean(8);
                this.Timepicker(title, color, oktext, canceltext, mintime, maxtime,enableSeconds, enableminutes, vibrateontouch,  callbackContext);
                return true;
            }
        }
        return false;
    }

   private void coolMethod(String title, String color, String oktext, String canceltext, String mindate, String maxdate, JSONArray highlitedDates, Boolean showyearpickerbeforemonth, Boolean vibrateontouch, Boolean autodismiss, CallbackContext callbackContext) {
           if (1==1) {
               Calendar now = Calendar.getInstance();
               DatePickerDialog dpd =  DatePickerDialog.newInstance(
                        new DatePickerDialog.OnDateSetListener(){
                           @Override
                           public void onDateSet(DatePickerDialog view, int year, int month, int dayOfMonth) {
                               callbackContext.success(year+"/"+month+"/"+dayOfMonth);
                               Log.d("Orignal", "Got clicked");
                           }
                       },
                       now.get(Calendar.YEAR),
                       now.get(Calendar.MONTH),
                       now.get(Calendar.DAY_OF_MONTH)
               );
               if(title != null && title.length() > 0){
                   dpd.setTitle(title);
               }
               if(color != null && color.length() > 0){
                   dpd.setAccentColor(color);
               }
               if(oktext != null && oktext.length() > 0){
                   dpd.setOkText(oktext);
               }
               if(canceltext != null && canceltext.length() > 0){
                   dpd.setCancelText(canceltext);
               }
               if(mindate != null && mindate.length() > 0){

                   try{
                       SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
                       Date date = sdf.parse(mindate);// all done
                       Calendar cal = sdf.getCalendar();
                       dpd.setMinDate(cal);
                   }catch (Exception e){
                       callbackContext.error(e.toString());
                   }
               }
               if(maxdate != null && maxdate.length() > 0){

                   try{
                       SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
                       Date date = sdf.parse(maxdate);// all done
                       Calendar cal = sdf.getCalendar();
                       dpd.setMaxDate(cal);
                   }catch (Exception e){
                       callbackContext.error(e.toString());
                   }
               }

               if(highlitedDates.length() > 0){
                    Calendar[] Final = new Calendar[highlitedDates.length()];
                   try{
                       SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);

                       for (int i = 0; i < highlitedDates.length(); i++) {
                           String datestring = highlitedDates.getString(i);
                           Date date = sdf.parse(datestring);// all done
                           Calendar cal = sdf.getCalendar();
                           Final[i]=cal;

                       }
                       dpd.setHighlightedDays(Final);
                   }catch (Exception e){
                       callbackContext.error(e.toString());
                   }
               }
                dpd.showYearPickerFirst(showyearpickerbeforemonth);
               dpd.vibrate(vibrateontouch);
               dpd.autoDismiss(autodismiss);
               /*dpd.setThemeDark(true);*/
               /*dpd.setAccentColor(Color.parseColor("#9C27B0"));*/
               dpd.show(cordova.getActivity().getFragmentManager(),"Datepickerdialog");

           } else {
               callbackContext.error("Expected one non-empty string argument.");
           }
       }

    private void Timepicker(String title, String color, String oktext, String canceltext, JSONArray mintime, JSONArray maxtime, Boolean enableSeconds, Boolean enableminutes, Boolean vibrateontouch, CallbackContext callbackContext) {
        if (1==1) {
            Calendar now = Calendar.getInstance();
            TimePickerDialog dpd =  TimePickerDialog.newInstance(
                    new TimePickerDialog.OnTimeSetListener(){
                        @Override
                        public void onTimeSet(TimePickerDialog view, int hour, int minute,int seconds) {
                            callbackContext.success(hour+":"+minute+":"+seconds);
                            Log.d("Orignal", "Got clicked");
                        }
                    },
                    now.get(Calendar.HOUR_OF_DAY),
                    now.get(Calendar.MINUTE),
                    true
            );
            if(title != null && title.length() > 0){
                dpd.setTitle(title);
            }
            if(color != null && color.length() > 0){
                dpd.setAccentColor(color);
            }
            if(oktext != null && oktext.length() > 0){
                dpd.setOkText(oktext);
            }
            if(canceltext != null && canceltext.length() > 0){
                dpd.setCancelText(canceltext);
            }
            if( mintime.length() > 0){

                try{
                    dpd.setMinTime(mintime.getInt(0),mintime.getInt(1),mintime.getInt(2));
                    //dpd.setmintime(cal);
                }catch (Exception e){
                    callbackContext.error("Error in mintime : "+e.toString());
                }
            }
            if(maxtime.length() > 0){

                try{
                    dpd.setMinTime(maxtime.getInt(0),maxtime.getInt(1),maxtime.getInt(2));
                }catch (Exception e){
                    callbackContext.error("Error in maxtime : "+e.toString());
                }
            }


            dpd.vibrate(vibrateontouch);

            /*dpd.setThemeDark(true);*/
            /*dpd.setAccentColor(Color.parseColor("#9C27B0"));*/
            dpd.show(cordova.getActivity().getFragmentManager(),"Timepickerdialog");

        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
