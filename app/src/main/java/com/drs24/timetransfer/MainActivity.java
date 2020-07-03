package com.drs24.timetransfer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        //目前時間
        Date date = new Date();

        long now = date.getTime();
        long chage = now * 10000 + 621355968000000000L;
        System.out.println(now);
        System.out.println(chage);

        Calendar calendar = Calendar.getInstance();//取得日曆
        Calendar calendar1 = Calendar.getInstance();//取得日曆
        Calendar calendar2 = Calendar.getInstance();//取得日曆

//        calendar.setTime(dNow);//當前時間丟給日曆
        calendar.add(Calendar.DAY_OF_WEEK, 0);//設置當前時間
        calendar1.add(Calendar.DAY_OF_WEEK, +7);//設置一週時間

        // 本週的第幾天
        int weekNumber = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println("本週第幾天"+ weekNumber + "");

        Date dBefore = calendar.getTime();//獲取時間
        Date dBefore1 = calendar1.getTime();//獲取前3個月時間

        Date week = getWeekStartTime();
        long weeks = week.getTime();

        Date weekss = getWeekEndTime();
        long weeks1 = weekss.getTime();

        System.out.println(sdf.format(week));
        System.out.println(sdf.format(getNextWeekMonday(7,getWeekStartTime())));
        System.out.println(sdf.format(getNextWeekMonday(14,getWeekStartTime())));
        System.out.println(sdf.format(getNextWeekMonday(21,getWeekStartTime())));
        System.out.println(sdf.format(getNextWeekMonday(28,getWeekStartTime())));

        System.out.println(getWeekEndTime());
//        System.out.println(sdf.format(dBefore));
//        System.out.println(dBeforelongtime);
//        System.out.println(dBeforelongtimechage);
        System.out.println("=="+setDateTrans(weeks));
//        System.out.println(sdf.format(week));
//        System.out.println(sdf.format(dBefore1));
//        System.out.println(longtime);
        System.out.println("=="+setDateTrans(weeks1));
    }

    /**計算時間給SERVER*/
    public static long setDateTrans(long currentTime) {
        long t1 = currentTime * 10000 + 621355968000000000L;

        return t1;
    }


    /**
     * start
     * 本週開始時間戳 - 以星期一為本週的第一天
     */
    public static Date getWeekStartTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd", Locale. getDefault());
        Calendar cal = Calendar.getInstance();

        int day_of_week = cal.get(Calendar. DAY_OF_WEEK) - 1;
        if (day_of_week == 0 ) {
            day_of_week = 7 ;
        }

        cal.add(Calendar.DATE , -day_of_week + 1 );
        return cal.getTime();
    }

    /**
     * end
     * 本週結束時間-星期日為本週的最後一天
     */
    public static Date getWeekEndTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyyMMdd", Locale. getDefault());
        Calendar cal = Calendar.getInstance();
        int day_of_week = cal.get(Calendar. DAY_OF_WEEK) - 1;
        if (day_of_week == 0 ) {
            day_of_week = 7 ;
        }

        cal.add(Calendar.DATE , -day_of_week + 7 );
        return cal.getTime();
    }

    /**下一週的時間*/
    public static Date getNextWeekMonday(int day,Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, day);
        return cal.getTime();
    }
}
