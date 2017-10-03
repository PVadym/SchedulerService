CREATE TABLE `jobs` (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `method` varchar(50) NOT NULL ,
  `url` varchar(255) NOT NULL ,
  `content_type` varchar(255) DEFAULT 'application/json',
  `accept` varchar(255) DEFAULT 'application/json',
  `authorization` varchar(255) ,
  `data` TEXT DEFAULT NULL,
  `type` varchar(50) DEFAULT 'http',
  `scheduled_at` varchar(255) NOT NULL ,
  `execute_times` int(11) DEFAULT 0,
  `start_time` datetime DEFAULT now(),
  `end_time` datetime DEFAULT NULL,
  `time_zone` varchar(255)  DEFAULT 'Asia/Singapore',
  `callback_url` TEXT DEFAULT NULL,
  `next_run_at` datetime DEFAULT NULL,
  `last_run_at` datetime DEFAULT NULL,
  `last_run_result_code` int(11) DEFAULT 0,
  `last_run_result_body` TEXT DEFAULT NULL,

  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

