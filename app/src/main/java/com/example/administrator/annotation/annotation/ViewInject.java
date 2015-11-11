package com.example.administrator.annotation.annotation;

import android.app.Activity;
import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2015/11/11.
 */
public class ViewInject {

    /**
     * findViewById
     */
    private static String METHOD_FINDVIEWBYID = "findViewById";
    /**
     * setContentView
     */
    private static String METHOD_SETCONTENTVIEW = "setContentView";

    public static void inject(Activity activity) {
        classInject(activity);
        fieldInject(activity);
    }

    private static void classInject(Activity activity) {
        Class<? extends Activity> clazz = activity.getClass();
        ContentViewInject annotation = clazz.getAnnotation(ContentViewInject.class);
        if (null != annotation) {
            int layoutId = annotation.value();
            try {
                Method method = clazz.getMethod(METHOD_SETCONTENTVIEW, int.class);
                method.invoke(activity, layoutId);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void fieldInject(Activity activity) {
        try {
            Class<? extends Activity> clazz = activity.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field f : fields) {
                Inject annotation = f.getAnnotation(Inject.class);
                if (annotation != null) {
                    int ViewId = annotation.value();
                    Log.d("ViewInject", ViewId + "");
                    Method method = clazz.getMethod(METHOD_FINDVIEWBYID, int.class);
                    Object invoke = method.invoke(activity, ViewId);
                    f.setAccessible(true);
                    f.set(activity, invoke);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
