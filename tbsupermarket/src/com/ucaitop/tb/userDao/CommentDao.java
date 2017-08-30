package com.ucaitop.tb.userDao;

import java.util.List;

import com.ucaitop.tb.domain.Comment;

/**
 * 评论的持久层接口
 * @author AZTQ
 *
 */
public interface CommentDao {
	/**
	 * 查找商品所有评论的方法
	 */
	List<Comment> selectComments(String proId);
	/**
	 * 添加商品的评价 
	 */
	void insertComments(Comment commet);
	
	/**
	 * 删除评论
	 * boolean delComment(Comment comment);
	 */
}