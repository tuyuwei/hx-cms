CREATE TABLE `user`
(
    `open_id`         varchar(100) NOT NULL COMMENT 'open_id',
    `skey`            varchar(100) NOT NULL COMMENT 'skey',
    `session_key`     varchar(100) NOT NULL COMMENT 'session_key',
    `city`            varchar(255) NOT NULL DEFAULT '' COMMENT '市',
    `province`        varchar(255) NOT NULL DEFAULT '' COMMENT '省',
    `country`         varchar(255) NOT NULL DEFAULT '' COMMENT '国',
    `avatar_url`      varchar(255) NOT NULL DEFAULT '' COMMENT '头像',
    `gender`          varchar(1)   NOT NULL DEFAULT '' COMMENT '性别',
    `nick_name`       varchar(255) NOT NULL DEFAULT '' COMMENT '昵称',
    `create_time`     timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `last_visit_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后登录时间',
    PRIMARY KEY (`open_id`)
) ENGINE = InnoDB
  CHARSET = utf8mb4 COMMENT = '微信用户信息';
