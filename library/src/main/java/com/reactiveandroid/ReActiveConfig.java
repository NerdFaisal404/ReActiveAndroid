package com.reactiveandroid;

import android.content.Context;
import android.support.annotation.NonNull;

import com.reactiveandroid.database.DatabaseConfig;

import java.util.HashMap;
import java.util.Map;

public class ReActiveConfig {

    public final Context context;
    public final Map<Class<?>, DatabaseConfig> databaseConfigMap;

    public ReActiveConfig(Context context, Map<Class<?>, DatabaseConfig> databaseConfigMap) {
        this.context = context;
        this.databaseConfigMap = databaseConfigMap;
    }

    public static class Builder {

        private final Context context;
        private final Map<Class<?>, DatabaseConfig> databaseConfigMap;

        public Builder(@NonNull Context context) {
            this.context = context.getApplicationContext();
            this.databaseConfigMap = new HashMap<>();
        }

        public Builder addDatabaseConfig(@NonNull DatabaseConfig databaseConfig) {
            databaseConfigMap.put(databaseConfig.databaseClass, databaseConfig);
            return this;
        }

        public ReActiveConfig build() {
            return new ReActiveConfig(context, databaseConfigMap);
        }

    }

}