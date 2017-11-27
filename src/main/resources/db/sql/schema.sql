SET MODE MySQL;

--
-- Table structure for table `tbl_destination`
--

DROP TABLE IF EXISTS `tbl_destination`;

CREATE TABLE `tbl_destination` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `star_rating` int(11) NOT NULL,
  `country_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `IDX_DESTINATION_NAME` (`name`)
);
