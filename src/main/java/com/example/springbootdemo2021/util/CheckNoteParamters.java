/*
 * 文  件  名：CheckNoteParamters.java
 * 版        权：Copyright 2012-2014 Huawei Tech.Co.Ltd. All Rights Reserved.
 * 描        述：
 * 修  改  人：wWX180488
 * 修改时间：2013-12-17
 * 修改内容：新增
 */
package com.example.springbootdemo2021.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.huawei.bme.commons.om.log.DebugLog;
import com.huawei.iread.portal.constants.StatusConstant;
import com.huawei.iread.portal.content.type.ChapterItem;
import com.huawei.iread.portal.oscache.cache.PortalCacheManager;
import com.huawei.iread.terminal.tools.ServiceUtil;

/**
 * 笔记参数验证类
 * 
 * @author wWX180488
 * @version CMR21 2013-12-17
 * @since V100R001C01LCMR21
 */
public class CheckNoteParamters
{
    /**
     * 数字校验正则表达式
     */
    private static final String REG_NUM = "^[0-9]\\d*$";

    /**
     * 
     * 笔记验证参数
     * 
     * @author wWX180488
     * @param request servlet请求
     * @param response servlet响应
     * @param log 日记对象
     * @param contentId 书籍id
     * @param noteId 笔记id
     * @param noteContent 笔记内容
     * @param quote 引文
     * @param chapterId 章节id
     * @param content 笔记
     * @throws ServletException servlet异常
     * @throws IOException io 异常
     */
    public static boolean checkUserNote(HttpServletRequest request, DebugLog log, String contentId, String noteId,
        String noteContent, String quote, String chapterId, String content, String msisdn, String path)
        throws ServletException, IOException
    {
        if (StringUtils.isEmpty(msisdn))
        {
            log.error("msisdn is null");
            List<String> ls = new ArrayList<String>();
            ls.add("msisdn");
            ls.add("null");
            request.setAttribute(ServiceUtil.RESULT_ERR_INFO, StrUtil.getErrorInfo(ls));
            return false;
        }
        if (StringUtils.isEmpty(path))
        {
            log.error("path is null");
            List<String> ls = new ArrayList<String>();
            ls.add("path");
            ls.add("null");
            request.setAttribute(ServiceUtil.RESULT_ERR_INFO, StrUtil.getErrorInfo(ls));
            return false;
        }
        if (StringUtils.isEmpty(contentId))
        {
            log.error("contentId is null");
            List<String> ls = new ArrayList<String>();
            ls.add("contentId");
            ls.add("null");
            request.setAttribute(ServiceUtil.RESULT_ERR_INFO, StrUtil.getErrorInfo(ls));
            return false;
        }
        if (StringUtils.isEmpty(noteId))
        {
            log.error("noteId is null");
            List<String> ls = new ArrayList<String>();
            ls.add("noteId");
            ls.add("null");
            request.setAttribute(ServiceUtil.RESULT_ERR_INFO, StrUtil.getErrorInfo(ls));
            return false;
        }
        if (StringUtils.isEmpty(noteContent) && StringUtils.isEmpty(quote))
        {
            log.error("noteContent and quote are null");
            List<String> ls = new ArrayList<String>();
            ls.add("noteContent");
            ls.add("null");
            ls.add("quote");
            ls.add("null");
            request.setAttribute(ServiceUtil.RESULT_ERR_INFO, StrUtil.getErrorInfo(ls));
            return false;
        }
        
        // 当请求报文章节id不为空的情况下，查询章节是否存在
        if (StringUtils.isNotEmpty(chapterId))
        {
            ChapterItem item = PortalCacheManager.getChapterInfo(contentId, chapterId);
            if (item == null)
            {
                log.error("chapterid is not exist");
                List<String> ls = new ArrayList<String>();
                ls.add("chapterId");
                ls.add("not exist");
                request.setAttribute(ServiceUtil.RESULT_ERR_INFO, StrUtil.getErrorInfo(ls));
                return false;
            }
        }
        return true;
    }
    
    /**
     * 
     * <一句话功能简述>3865 添加笔记校验
     * 
     * @author zhengyunjie
     * @version [版本号, 2017年8月17日]
     * @param request
     * @param log
     * @param contentId
     * @param noteId
     * @param noteContent
     * @param quote
     * @param chapterId
     * @param content
     * @param msisdn
     * @param path
     * @return
     * @throws ServletException
     * @throws IOException
     * @see [类、类#方法、类#成员]
     */
    public static boolean newCheckUserNote(HttpServletRequest request, DebugLog log, String contentId, String noteId,String quote,
        String chapterId, String content, String msisdn, String path, String noteType, String endParagraphPosition)
        throws ServletException, IOException
    {
        if (log.isDebugEnable())
        {
            String[][] appinfo = {{"msisdn", msisdn}, {"path", path}, {"contentId", contentId}, {"noteId", noteId},
                {"noteType", noteType}, {"chapterId", chapterId}};
            log.debug("Enter CheckNoteParamters.newCheckUserNote()", appinfo);
        }
        if (StringUtils.isEmpty(msisdn))
        {
            log.error("msisdn is null");
            return false;
        }
        if (StringUtils.isEmpty(path))
        {
            log.error("path is null");
            return false;
        }
        if (StringUtils.isEmpty(contentId))
        {
            log.error("contentId is null");
            return false;
        }
        if (StringUtils.isEmpty(noteId))
        {
            log.error("noteId is null");
            return false;
        }
        // 当请求报文章节id不为空的情况下，查询章节是否存在
        if (StringUtils.isNotEmpty(chapterId))
        {
            ChapterItem item =
                PortalCacheManager.getChapterInfo(contentId, chapterId);
            if (item == null)
            {
                log.error("chapterItem is not exist");
                return false;
            }
        }
        // 当noteType不为null、0、1、2
        if (!(StringUtils.isEmpty(noteType) || StringUtils.equals(noteType, StatusConstant.NOTE_TYPE_PRI)
            || StringUtils.equals(noteType, StatusConstant.NOTE_TYPE_PUB)
            || StringUtils.equals(noteType, StatusConstant.NOTE_TYPE_MARK)))
        {
            log.error("noteType is error");
            return false;
        }
        return true;
    }
    
    /**
     * TODO 添加方法注释
     *
     * @author yeyanchen
     * @param request
     * @param log
     * @param contentId
     * @param noteId
     * @param quote
     * @param chapterId
     * @param content
     * @param msisdn
     * @param path
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public static boolean checkParameter(HttpServletRequest request, DebugLog log, String contentId, String noteId,
        String quote, String chapterId, String msisdn, String path, String returnFlag)
        throws ServletException, IOException
    {
        if (log.isDebugEnable())
        {
            String[][] appinfo = {{"msisdn", msisdn}, {"path", path}, {"contentId", contentId}, {"noteId", noteId},
                {"quote", quote}, {"chapterId", chapterId}, {"returnFlag", returnFlag}};
            log.debug("Enter CheckNoteParamters.checkParameter()", appinfo);
        }
        if (StringUtils.isEmpty(msisdn))
        {
            log.error("msisdn is null");
            return false;
        }
        if (StringUtils.isEmpty(path))
        {
            log.error("path is null");
            return false;
        }
        if (StringUtils.isEmpty(contentId))
        {
            log.error("contentId is null");
            return false;
        }
        if (StringUtils.isEmpty(noteId))
        {
            log.error("noteId is null");
            return false;
        }
        if (StringUtils.isEmpty(quote))
        {
            log.error("quote is null");
            return false;
        }
        
        if (StringUtils.isEmpty(chapterId))
        {
            log.error("chapterId is null");
            return false;
        }
        
        if (!(StringUtils.equals(returnFlag, StatusConstant.NORETURN)
            || StringUtils.equals(returnFlag, StatusConstant.RETURN)))
        {
            log.error("returnFlag only is 0 or 1");
            return false;
        }
        return true;
    }
    
    /**
     * 
     * <一句话功能简述>3865 读者在个人主页查看我的笔记详情
     * 
     * @author zhangpeng
     * @version 2017-8-18
     * @param request
     * @param log
     * @param msisdn
     * @param path
     * @param count
     * @param start
     * @param protocol
     * @return
     * @throws ServletException
     * @throws IOException
     * @see [类、类#方法、类#成员]
     */
    public static boolean newCheckGetMyNoteList(HttpServletRequest request, DebugLog log, String protocol,
        String identityId, String path, String start, String count)
        throws ServletException, IOException
    {
        if (StringUtils.isEmpty(identityId))
        {
            log.error("identityId is null");
            return false;
        }
        if (StringUtils.isEmpty(path))
        {
            log.error("path is null");
            return false;
        }
        if (StringUtils.isEmpty(start))
        {
            log.error("start is null");
            return false;
        }
        if (StringUtils.isEmpty(count))
        {
            log.error("count is null");
            return false;
        }
        if (StringUtils.isEmpty(protocol))
        {
            log.error("protocol is null");
            return false;
        }
        return true;
    }
    
    /**
     * 
     * <一句话功能简述>3865 读者在个人主页查看我的笔记校验
     * 
     * @author zhangpeng
     * @version 2017-8-22
     * @param request
     * @param log
     * @param msisdn
     * @param path
     * @param noteId
     * @param protocol
     * @return
     * @throws ServletException
     * @throws IOException
     * @see [类、类#方法、类#成员]
     */
    public static boolean newCheckGetNotesInfo(HttpServletRequest request, DebugLog log, String protocol, String path,
        String msisdn, String noteId)
        throws ServletException, IOException
    {
        if (StringUtils.isEmpty(msisdn))
        {
            log.error("msisdn is null");
            return false;
        }
        if (StringUtils.isEmpty(noteId))
        {
            log.error("noteId is null");
            return false;
        }
        if (StringUtils.isEmpty(protocol))
        {
            log.error("protocol is null");
            return false;
        }
        if (StringUtils.isEmpty(path))
        {
            log.error("path is null");
            return false;
        }
        return true;
    }
    
    /**
     * 
     * BR004182,回复公开笔记参数校验
     *
     * @author DuanJie
     * @param log
     * @param noteId
     * @param replyContent
     * @param noteMsisdn
     * @param contentId
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public static boolean checkUserNoteReply(DebugLog log, String noteId, String replyContent,
        String noteMsisdn, String contentId)
        throws ServletException, IOException
    {
        if (StringUtils.isEmpty(noteId))
        {
            log.error("noteId is null");
            return false;
        }
        if (StringUtils.isEmpty(replyContent))
        {
            log.error("replyContent is null");
            return false;
        }
        if (StringUtils.isEmpty(noteMsisdn))
        {
            log.error("noteMsisdn is null");
            return false;
        }
        if (StringUtils.isEmpty(contentId))
        {
            log.error("contentId is null");
            return false;
        }
        return true;
    }
    
    /**
     * 
     * BR004182,删除公开笔记的回复 参数校验
     *
     * @author DuanJie
     * @param log
     * @param noteId
     * @param contentId
     * @param noteMsisdn
     * @param replyId
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public static boolean newCheckDeleteNoteReply(DebugLog log, String noteId, String contentId,
        String noteMsisdn, String replyId)
        throws ServletException, IOException
    {
        if (StringUtils.isEmpty(noteId))
        {
            log.error("noteId is null");
            return false;
        }
        if (StringUtils.isEmpty(contentId))
        {
            log.error("contentId is null");
            return false;
        }
        if (StringUtils.isEmpty(noteMsisdn))
        {
            log.error("noteMsisdn is null");
            return false;
        }
        if (StringUtils.isEmpty(replyId))
        {
            log.error("replyId is null");
            return false;
        }
        return true;
    }
    
    /**
     * 校验必传参数--点赞或取消点赞 jinxiaxia
     * @param noteId
     * @param path
     * @param contentId
     * @param noteMsisdn
     * @param optType
     * @return
     */
    public static boolean checkAbetOrCancelNoteRequestParameters(DebugLog log, String noteId, String path,
        String contentId, String noteMsisdn, String optType)
    {
        if (StringUtils.isEmpty(noteMsisdn))
        {
            log.error("noteMsisdn is null");
            return false;
        }
        if (StringUtils.isEmpty(path))
        {
            log.error("path is null");
            return false;
        }
        if (StringUtils.isEmpty(noteId))
        {
            log.error("noteId is null");
            return false;
        }
        if (StringUtils.isEmpty(contentId))
        {
            log.error("contentId is null");
            return false;
        }
        if (StringUtils.isEmpty(optType))
        {
            log.error("optType is null");
            return false;
        }        
        return true;
    }
    
    /**
     * 
     * BR004182 查看我的点赞回复列表 校验
     * 
     * @author zhujiangang
     * @version 2017-9-18
     * @param request
     * @param log
     * @param identityId
     * @param path
     * @return
     * @throws ServletException
     * @throws IOException
     * @see [类、类#方法、类#成员]
     */
    public static boolean checkGetMyReplyNoteList(DebugLog log, String identityId, String path)
        throws ServletException, IOException
    {
        if (log.isDebugEnable())
        {
            String[][] appinfo = {{"identityId", identityId}, {"path", path}};
            log.debug("Enter CheckNoteParamters.checkGetMyReplyNoteList()", appinfo);
        }
        if (StringUtils.isEmpty(identityId))
        {
            log.error("msisdn is null");
            return false;
        }
        if (StringUtils.isEmpty(path))
        {
            log.error("path is null");
            return false;
        }
        return true;
    }

    /**
     * 校验kindle直接分享参数
     *
     * @param log
     * @param contentId
     * @param quote
     * @param chapterId
     * @param msisdn
     * @param path
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public static boolean checkKindleNote(DebugLog log, String contentId, String quote,
        String chapterId, String msisdn, String path)
        throws ServletException, IOException
    {
        if (log.isDebugEnable())
        {
            String[][] appinfo = {{"msisdn", msisdn}, {"path", path}, {"contentId", contentId},
                {"chapterId", chapterId}};
            log.debug("Enter CheckNoteParamters.checkKindleNote()", appinfo);
        }
        if (StringUtils.isEmpty(msisdn))
        {
            log.error("msisdn is null");
            return false;
        }
        if (StringUtils.isEmpty(path))
        {
            log.error("path is null");
            return false;
        }
        if (StringUtils.isEmpty(contentId))
        {
            log.error("contentId is null");
            return false;
        }
        if (StringUtils.isEmpty(quote))
        {
            log.error("quote is null");
            return false;
        }
        // 当请求报文章节id不为空的情况下，查询章节是否存在
        if (StringUtils.isNotEmpty(chapterId))
        {
            ChapterItem item =
                PortalCacheManager.getChapterInfo(contentId, chapterId);
            if (item == null)
            {
                log.error("chapterItem is not exist");
                return false;
            }
        }
        else
        {
            log.error("chapterId is null");
            return false;
        }
        return true;
    }

    /**
     *
     * 漫画吐槽参数校验
     *
     * @author zhangtao
     * @param log
     * @param contentId
     * @param chapterId
     * @param positon
     * @param content
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public static boolean checkAddCartoonBarrage(DebugLog log, String contentId, String chapterId, String positon, String content)
        throws ServletException, IOException
    {
        if (StringUtils.isEmpty(contentId) || !contentId.matches(REG_NUM))
        {
            log.error("contentId is null");
            return false;
        }
        if (StringUtils.isEmpty(chapterId) || !chapterId.matches(REG_NUM))
        {
            log.error("chapterId is null");
            return false;
        }
        if (StringUtils.isEmpty(positon) || !positon.matches(REG_NUM))
        {
            log.error("positon is null");
            return false;
        }
        if (StringUtils.isEmpty(content))
        {
            log.error("content is null");
            return false;
        }
        return true;
    }

    /**
     *
     * 播放吐槽参数校验
     *
     * @author zhangtao
     * @param log
     * @param contentId
     * @param chapterId
     * @param position
     * @param count
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public static boolean checkGetCartoonBarrage(DebugLog log, String contentId, String chapterId, String position, String count)
        throws ServletException, IOException
    {
        if (StringUtils.isEmpty(contentId) || !contentId.matches(REG_NUM))
        {
            log.error("contentId is null");
            return false;
        }
        if (StringUtils.isEmpty(chapterId) || !chapterId.matches(REG_NUM))
        {
            log.error("chapterId is null");
            return false;
        }
        if (StringUtils.isEmpty(position) || !position.matches(REG_NUM))
        {
            log.error("positon is null");
            return false;
        }
        if (StringUtils.isEmpty(count) || !count.matches(REG_NUM))
        {
            log.error("count is null");
            return false;
        }
        return true;
    }
}
