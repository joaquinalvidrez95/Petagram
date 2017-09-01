package com.joaquinalan.petagram.data;

import android.provider.BaseColumns;

/**
 * Created by joaquinalan on 06/02/2017.
 */

public class PetagramContract {
    public static final class PetTable implements BaseColumns {
        public static final String TABLE_NAME = "pet";

        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_RATING = "rating";
        public static final String COLUMN_IMAGE = "image";
    }
}
