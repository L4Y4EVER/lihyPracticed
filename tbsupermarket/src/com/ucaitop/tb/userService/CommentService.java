package com.ucaitop.tb.userService;

import java.util.List;

import com.ucaitop.tb.domain.Comment;
import com.ucaitop.tb.domain.Product;
import com.ucaitop.tb.domain.User;

/**
 * 评论的服务层接口
 * @author AZTQ
 *
 */
public interface CommentService {

	 /**
	  * 查找商品所有评论的方法
	  */
	List<Comment> findComments(String proid);
	
	/**
	 * 添加商品的评价 这里也可以直接传递关于用户的id以及商品的id
	 */
	void addComment(Comment comment,User user,Product product);
	
	/**
	 * 删除评论
	 * boolean removeComment(Comment comment);
	 */
	
}
