CREATE TABLE distribute_transaction(
    id bigint(20) NOT NULL AUTO_INCREMENT,
    tx_id BIGINT(20) NOT NULL  COMMENT '事物ID',
    tx_content varchar(1024) NOT NULL COMMENT '事物内容',
    tx_status TINYINT(4) NOT NULL COMMENT '事物状态',
    tx_start_time BIGINT(20) NOT NULL  COMMENT '事物开始时间',
    tx_end_time BIGINT(20) NOT NULL COMMENT '事物结束时间',
    PRIMARY KEY (`id`),
    KEY `idx_tx_id_status` (`tx_id`,`tx_status`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='事物状态表'
