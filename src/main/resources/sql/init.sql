use abner;

--  用户基础信息
create table if not exists  `user_base` (
  `user_id` varchar(32) not null comment '用户id',
  `user_role` tinyint(2) unsigned not null default '2' comment '2 正常用户 3 禁言用户 4 虚拟用户 5 运营',
  `register_source` tinyint(4) unsigned not null default '0' comment '注册来源：1 手机号 2 邮箱 3 用户名 4 qq 5 微信 6 腾讯微博 7 新浪微博',
  `user_name` varchar(32) not null default '' comment '用户账号，必须唯一',
  `nick_name` varchar(32) not null default '' comment '用户昵称',
  `gender` tinyint(1) unsigned not null default '0' comment '用户性别 0-female 1-male',
  `birthday` bigint(20) unsigned not null default '0' comment '用户生日',
  `signature` varchar(255) not null default '' comment '用户个人签名',
  `mobile` varchar(16) not null default '' comment '手机号码(唯一)',
  `mobile_bind_time` int(11) unsigned not null default '0' comment '手机号码绑定时间',
  `email` varchar(100) not null default '' comment '邮箱(唯一)',
  `email_bind_time` int(11) unsigned not null default '0' comment '邮箱绑定时间',
  `face` varchar(255) not null default '' comment '头像',
  `face200` varchar(255) not null default '' comment '头像 200x200x80',
  `srcface` varchar(255) not null default '' comment '原图头像',
  `create_time` int(11) unsigned not null comment '创建时间',
  `update_time` int(11) unsigned not null comment '修改时间',
  `push_token` varchar(50) not null comment '用户设备push_token',
  primary key (`user_id`)
) engine=innodb default charset=utf8mb4 comment='用户基础信息表'
;

-- 用户扩展信息
create table if not exists `user_extra` (
  `user_id` varchar(32) not null comment '用户id',
  `vendor` varchar(64) not null default '' comment '手机厂商：apple|htc|samsung，很少用',
  `client_name` varchar(50) not null default '' comment '客户端名称，如hjskang',
  `client_version` varchar(50) not null default '' comment '客户端版本号，如7.0.1',
  `os_name` varchar(16) not null default '' comment '设备号:android|ios',
  `os_version` varchar(16) not null default '' comment '系统版本号:2.2|2.3|4.0|5.1',
  `device_name` varchar(32) not null default '' comment '设备型号，如:iphone6s、u880、u8800',
  `device_id` varchar(128) not null default '' comment '设备id',
  `idfa` varchar(50) not null default '' comment '苹果设备的idfa',
  `idfv` varchar(50) not null default '' comment '苹果设备的idfv',
  `market` varchar(20) not null default '' comment '来源',
  `create_time` int(11) unsigned not null default '0' comment '添加时间',
  `update_time` int(11) unsigned not null default '0' comment '更新时间',
  `extend1` varchar(100) not null default '' comment '扩展字段1',
  `extend2` varchar(100) not null default '' comment '扩展字段2',
  `extend3` varchar(100) not null default '' comment '扩展字段3',
  primary key (`user_id`)
) engine=innodb default charset=utf8mb4 comment='用户额外信息表'
;

-- 用户授权表
create table if not exists `user_auth` (
  `id` bigint(20) not null auto_increment,
  `user_id` varchar(32) not null comment '用户id',
  `identity_type` tinyint(4) unsigned not null default '1' comment '1手机号 2邮箱 3用户名 4qq 5微信 6腾讯微博 7新浪微博',
  `identifier` varchar(50) not null default '' comment '手机号 邮箱 用户名或第三方应用的唯一标识',
  `certificate` varchar(20) not null default '' comment '密码凭证(站内的保存密码，站外的不保存或保存token)',
  `create_time` int(11) unsigned not null default '0' comment '绑定时间',
  `update_time` int(11) unsigned not null default '0' comment '更新绑定时间',
  primary key (`id`),
  unique key `only` (`user_id`,`identity_type`),
  key `idx_user_auth_uid` (`user_id`) using btree
) engine=innodb default charset=utf8mb4 comment='用户授权表'
;

-- 用户位置信息
create table if not exists `user_location` (
  `user_id` varchar(32) not null comment '用户id',
  `curr_nation` varchar(10) not null default '' comment '所在地国',
  `curr_province` varchar(10) not null default '' comment '所在地省',
  `curr_city` varchar(10) not null default '' comment '所在地市',
  `curr_district` varchar(20) not null default '' comment '所在地地区',
  `location` varchar(255) not null default '' comment '具体地址',
  `longitude` decimal(10,6) default null comment '经度',
  `latitude` decimal(10,6) default null comment '纬度',
  `update_time` int(11) unsigned default '0' comment '修改时间',
  primary key (`user_id`)
) engine=innodb default charset=utf8mb4 comment='用户定位表'
;
