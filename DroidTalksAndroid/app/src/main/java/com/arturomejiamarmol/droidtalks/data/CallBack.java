package com.arturomejiamarmol.droidtalks.data;

/**
 * Created by Arturo Mejia on 5/24/2017.
 */

public interface CallBack<T> {
   void onFinish(T data, Object error);
}
