create table user(
`id` bigint PRIMARY key AUTO_INCREMENT,
`name` varchar(64) default null comment '姓名'
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户表';