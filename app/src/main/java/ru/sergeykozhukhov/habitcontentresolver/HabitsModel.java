package ru.sergeykozhukhov.habitcontentresolver;

import android.net.Uri;

public class HabitsModel {

    public static final String AUTHORITY = "ru.sergeykozhukhov.habitcontentprovider.provider.HabitProvider";
    public static final String URI = "content://" + AUTHORITY;

    public static final String TABLE_NAME = "habits";

    public static final class Columns {

        public static final Uri URI = Uri.parse(HabitsModel.URI + "/" + TABLE_NAME);


        public static final String URI_TYPE_HABIT_DIR = "vnd.android.cursor.dir/vnd.sergeykozhukhov.habit";
        public static final String URI_TYPE_HABIT_ITEM = "vnd.android.cursor.item/vnd.sergeykozhukhov.habit";


        public static final String ID = "id";
        public static final String TITLE = "title";
        public static final String DESCRIPTION = "description";

        public static final String[] ALL = new String[] {
                ID, TITLE, DESCRIPTION
        };
    }



}
