package com.lib_im.pro.api;

import com.lib_im.pro.entity.ChatRecord;
import com.lib_im.pro.entity.Contact;
import com.lib_im.pro.entity.GroupChatRecord;
import com.lib_im.pro.entity.GroupContact;
import com.lib_im.pro.entity.GroupDetails;
import com.lib_im.pro.entity.GroupMember;
import com.lib_im.pro.entity.UserInfo;
import com.lib_im.pro.retrofit.base.BaseListResponse;
import com.lib_im.pro.rx.SimpleListCompleteObserver;
import com.lib_im.pro.rx.SimpleListObserver;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by songgx on 2017/9/26.
 * 聊天模块接口服务
 */

public interface IMListService {

    //登录
    @GET("login")
    Observable<BaseListResponse<UserInfo>> login(
            @Query("userName") String userName,
            @Query("password") String password
            );

    //查询群组列表
    @GET("group/getGroupList")
    Observable<BaseListResponse<GroupContact>> queryGroupList(
            @Query("groupType") String groupType);

    //添加成员
    @GET("")
    Observable<BaseListResponse<String>> addMember(
            @Query("otherUserID") String otherUserID,
            @Query("groupID") String groupID);

    //删除成员
    @GET("")
    Observable<BaseListResponse<String>> removeMember(
            @Query("otherUserID") String otherUserID,
            @Query("groupID") String groupID);

    //添加联系人
    @GET("")
    Observable<BaseListResponse<String>> addContact(
            @Query("userID") String userID);
    //删除联系人
    @GET("")
    Observable<BaseListResponse<String>> removeContact(
            @Query("userID") String userID);
    //同意
    @GET("")
    Observable<BaseListResponse<String>> acceptRequest(
            @Query("otherUserID") String otherUserID);
    //拒绝
    @GET("")
    Observable<BaseListResponse<String>> refuseRequest(
            @Query("otherUserID") String otherUserID);

    //查询群组未读消息记录数量
    @GET("chat/queryCount")
    Observable<BaseListResponse<GroupChatRecord>> queryGroupUnReadCount(
            @Query("list") String groupStr);

    //查询群组聊天历史纪录列表
    @GET("chat/getGroupLogs")
    Observable<BaseListResponse<GroupChatRecord>> queryGroupChatRecord(
            @Query("groupId") String groupId,
            @Query("logId") String logId,
            @Query("messageId") String messageId,
            @Query("page") int page,
            @Query("rows") int rows);

    //查询担任聊天历史纪录列表
    @GET("chat/getChatLogs")
    Observable<BaseListResponse<ChatRecord>> queryChatRecord(
            @Query("messageId") String messageId,
            @Query("fromUserId") String fromUserId,
            @Query("toUserId") String toUserId,
            @Query("page") int page,
            @Query("rows") int rows);

    //查询群成员列表
    @GET("chat/getMember")
    Observable<BaseListResponse<GroupMember>> queryGroupMember(
            @Query("ID") String ID,
            @Query("page") String page,
            @Query("rows") String rows);

    //查询群详情
    @GET("chat/getGroupDetails")
    Observable<BaseListResponse<GroupDetails>> queryGroupDetails(
            @Query("ID") String ID);

    //获取好友列表
    @GET("contact/getContactList")
    Observable<BaseListResponse<Contact>> queryFriendList(@Query("userType") String userType);

    //解散群组
    @GET("")
    Observable<BaseListResponse<String>> dismissGroup(
            @Query("groupID") String groupID);
    //退出群组
    @GET("")
    Observable<BaseListResponse<String>> exitGroup(
            @Query("groupID") String groupID);
    //模糊查找联系人
    @GET("")
    Observable<BaseListResponse<Contact>> searchFriendList(
            @Query("key") String key);
}
