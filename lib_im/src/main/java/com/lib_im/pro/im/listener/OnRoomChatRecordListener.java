package com.lib_im.pro.im.listener;

/**
 * Created by songgx on 2016/8/23.
 * 历史消息刷新接口
 */
public interface OnRoomChatRecordListener<T> {

    /**
     * @param t 类型
     * @descript 群组历史消息回调
     */
    void onRoomChatRecorder(T t);
}
