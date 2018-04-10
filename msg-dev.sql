
create table `user_info`(
  `user_id` varchar(36) not null,
  `user_avatar` varchar(64) null comment '头像url',
  `user_name` varchar(64) not null comment '登录名',
  `user_pwd` varchar(64) not null comment '密码',
  `user_status` tinyint(3) default '0' comment '0:正常,1:删除,2:锁定',
  `create_time` timestamp not null default current_timestamp comment '创建时间',
  `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`user_id`)
) comment '用户表';

create table `msg_info`(
  `msg_id` varchar(36) not null,
  `msg_desc` varchar(4000) not null comment '留言内容',
  `msg_img` varchar(4000) null comment '留言图片',
  `msg_like` int null comment'点赞数',
  `msg_status` tinyint(3) DEFAULT '0' comment '0:正常，1:删除',
  `user_id` varchar(36) not null comment '用户外键',
  `create_time` timestamp not null default current_timestamp comment '创建时间',
  `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`msg_id`)
) comment '留言板主表';

